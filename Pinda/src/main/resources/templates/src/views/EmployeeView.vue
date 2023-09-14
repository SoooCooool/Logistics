<template>
  <div>
    <!--    增加按钮和搜索框-->
    <div style="margin: 10px 5px">
      <el-button type="primary" @click="add()">新增</el-button>
      <el-button>其他</el-button>
    </div>

    <div style="margin: 10px 5px">
      <el-input v-model="data.search" style="width: 30%;" placeholder="请输入关键字" @keyup.enter.native="querysome()" clearable/>
      <el-button style="margin-left: 10px" type="primary" @click="querysome()">查找</el-button>
      <el-button style="margin-left: 10px" type="primary" @click="clear()">清除</el-button>
    </div>
    <!--表格-->
    <el-table v-loading="data.isLoading" :data="data.employeeList" stripe style="width: 100%">
      <el-table-column prop="employeeid" width="200" label="员工id" align="center"/>
      <el-table-column prop="name" width="200" label="姓名" align="center"/>
      <el-table-column prop="phonenumber" width="200" label="手机号" align="center"/>
      <el-table-column prop="createdtime" width="200" label="创建时间" align="center"/>
      <el-table-column prop="modifiedtime" width="200" label="修改时间" align="center"/>
      <el-table-column prop="occupation" width="200" label="职业" align="center"/>
      <el-table-column fixed="right" label="操作" width="300" >
        <template #default="scope">
          <el-button @click="edit(scope.row)" style="margin-right: 16px" type="warning" >
            <el-icon><Edit /></el-icon>编辑</el-button>
          <el-button @click="deleteVehicle(scope.row)" style="margin-right: 16px" type="danger">
            <el-icon><Delete /></el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <el-dialog v-model="data.employeeupdateFormVisible" title="编辑" width="25%">
    <el-form :model="Employee" label-width="120px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model.trim="input" v-model="data.name"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phonenumber">
        <el-input v-model="data.phonenumber"/>
      </el-form-item>
      <el-form-item label="职业" prop="occupation">
        <el-input v-model="data.occupation"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="data.password"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="data.employeeupdateFormVisible = false">关闭</el-button>
        <el-button type="primary"
                   @click="updateEmployee()">
          确认提交并更改
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
  <el-dialog v-model="data.employeeaddFormVisible" title="添加" width="25%">
    <el-form :model="Employee" label-width="120px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="data.name"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phonenumber">
        <el-input v-model="data.phonenumber"/>
      </el-form-item>
      <el-form-item label="职业" prop="occupation">
        <el-input v-model="data.occupation"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="data.password"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="data.employeeaddFormVisible = false">关闭</el-button>
        <el-button type="primary"
                   @click="addEmployee()">
          确认提交并添加
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

</template>

<script>
// @ is an alias to /src


import {inject, onMounted, reactive} from "vue";
import axios from "axios";
export default {
  name: 'EmployeeView',
  components: {},
  setup() {
    onMounted(() => {
      getEmployeeList();
    })

    const axios = inject('axios');
    const data = reactive({
      employeeupdateFormVisible: false,
      search: '',
      employeeList: [],
      isLoading:true,
      employeeaddFormVisible: false,
      phonenumber:'',
      name:'',
      employeeid:'',
      occupation:'',
      password:'',

    });

    const getEmployeeList = function () {
      const config = {
        method: 'get',
        url: 'api/employee/queryAll',
        headers: {}
      };

      axios(config)
          .then(function (response) {
            data.employeeList=response.data.data;
            data.isLoading = false;
          })
          .catch(function (error) {
            console.log(error);
          });
    }

    //时间戳转换为日期
    const formatDate = (timestamp) => {
      if (timestamp) {
        return new Date(timestamp).toLocaleDateString();
      }
    };


    return {
      data,
      getEmployeeList,
      formatDate
    }

  },
  methods: {
    clear(){
      this.data.search=null;
      this.getEmployeeList()
    },
    querysome(){
      const _this = this
      axios.get('api/employee/searchEmployee?search='+ _this.data.search).then(function (response) {
        _this.data.employeeList=response.data.data;
        _this.data.isLoading = false;
      })
          .catch(function (error) {
            console.log(error);
          });
    },
    //删除操作
    deleteVehicle (row) {
      this.$confirm('确认删除编号为:'+row.employeeid+"的雇员吗?", '提示', {
        'confirmButtonText': '确定',
        'cancelButtonText': '取消',
        'type': 'warning'
      }).then(() => {
        const _this = this
        axios.get('api/employee/deleteById/'+row.employeeid).then(function(resp){
          _this.$message.success('雇员删除成功！')
          _this.getEmployeeList()
        })
      })
    },

    edit(row){
      console.log(row);
      this.data.employeeupdateFormVisible = true;
      this.data.employeeid=row.employeeid;
      this.data.name=row.name;
      this.data.occupation=row.occupation;
      this.data.phonenumber=row.phonenumber;
      this.data.password=row.password;
      console.log(this.data);
    },

    // 修改操作)
    updateEmployee () {
      if (
          this.data.name.trim() === '' ||
          this.data.phonenumber.trim() === '' ||
          this.data.occupation.trim() === '' ||
          this.data.password.trim() === ''
      ) {
        alert('请输入完整的信息');
        return;
      }

      const _this = this
      // console.log(_this.data);
      const js = JSON.stringify({
        "employeeid": this.data.employeeid,
        "name": this.data.name,
        "password": this.data.password,
        "occupation": this.data.occupation,
        "phonenumber": this.data.phonenumber
      });
      // console.log(js);
      axios.post('/api/employee/update',js,
          {headers: {'Content-Type': 'application/json'}}).then(function(res){
        _this.$message.success('雇员信息修改成功！')
        _this.data.employeeupdateFormVisible = false
        _this.getEmployeeList();
      })
    },

    add(){
      this.data.password=null;
      this.data.name=null;
      this.data.occupation=null
      this.data.phonenumber=null;
      this.data.employeeaddFormVisible = true;
    },

    addEmployee(){
      if (
          this.data.name.trim() === '' ||
          this.data.phonenumber.trim() === '' ||
          this.data.occupation.trim() === '' ||
          this.data.password.trim() === ''
      ) {
        alert('请输入完整的信息');
        return;
      }

      const _this = this
      console.log(_this.data);
      const js = JSON.stringify({
        "name": this.data.name,
        "occupation": this.data.occupation,
        "phonenumber": this.data.phonenumber,
        "password": this.data.password

      });
      console.log(js);
      axios.post('/api/employee/addEmployee',js,
          {headers: {'Content-Type': 'application/json'}}).then(function(res){
        _this.$message.success('雇员添加成功！')
        _this.data.employeeaddFormVisible = false;
        _this.getEmployeeList();
      })
    },
  }
}

</script>

<style scoped>
.home {
  display: flex;
  justify-content: center;
}

.el-table__header th div {
  text-align: center;
}

.cell-right-aligned {
  text-align: right;
}
</style>