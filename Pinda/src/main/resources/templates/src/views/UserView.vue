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
    <el-table v-loading="data.isLoading" :data="data.userList" stripe style="width: 100%">
      <el-table-column prop="userid" width="200" label="用户id" align="center"/>
      <el-table-column prop="name" width="200" label="用户名" align="center"/>
      <el-table-column prop="createdtime" width="200" label="创建时间" align="center"/>
      <el-table-column prop="modifiedtime" width="200" label="修改时间" align="center"/>
      <el-table-column prop="phonenumber" label="电话号" width="250" align="center"/>
      <el-table-column prop="location" label="地址" width="250" align="center"/>
      <el-table-column fixed="right" label="操作" width="300" >
        <template #default="scope">
          <el-button @click="edit(scope.row)" style="margin-right: 16px" type="warning" >
            <el-icon><Edit /></el-icon>编辑</el-button>
          <el-button @click="deleteUser(scope.row)" style="margin-right: 16px" type="danger">
            <el-icon><Delete /></el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <el-dialog v-model="data.userupdateFormVisible" title="编辑" width="25%">
    <el-form :model="User" label-width="120px">
      <el-form-item label="更改用户名">
        <el-input v-model="data.name" />
      </el-form-item>
      <el-form-item label="更改地址">
        <el-input v-model="data.location" />
      </el-form-item>
      <el-form-item label="更改电话号">
        <el-input v-model="data.phonenumber" />
      </el-form-item>
      <el-form-item label="更改密码">
        <el-input v-model="data.password" />
      </el-form-item>
      <el-form-item>
        <el-button @click="data.userupdateFormVisible = false">关闭</el-button>
        <el-button type="primary"
                   @click="updateUser()">
<!--                   @click="data.userupdateFormVisible = false;uploaduser(oneGoods.goodsId,oneGoods.url);data.newImageUrl=null;hasBeenUpdated">-->
          确认提交并更改
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
  <el-dialog v-model="data.useraddFormVisible" title="添加" width="25%">
    <el-form :model="User" label-width="120px">
      <el-form-item label="用户名">
        <el-input v-model="data.name" rules="[{ required: true, message: '请输入用户id', trigger: 'blur' }]"/>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="data.location" rules="[{ required: true, message: '请输入用户id', trigger: 'blur' }]"/>
      </el-form-item>
      <el-form-item label="电话号">
        <el-input v-model="data.phonenumber" rules="[{ required: true, message: '请输入用户id', trigger: 'blur' }]"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="data.password" rules="[{ required: true, message: '请输入用户id', trigger: 'blur' }]"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="data.userupdateFormVisible = false">关闭</el-button>
        <el-button type="primary"
                   @click="addUser()">
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
  name: 'UserView',
  components: {},
  setup() {
    onMounted(() => {
      getUserList();
    })

    const axios = inject('axios');
    const data = reactive({
      userupdateFormVisible: false,
      search: '',
      userList: [],
      isLoading:true,
      useraddFormVisible: false,
      userid:'',
      phonenumber:'',
      password:'',
      location:'',
      name:'',
    });

    const getUserList = function () {
      const config = {
        method: 'get',
        url: 'api/user/queryAll',
        headers: {}
      };

      axios(config)
          .then(function (response) {
            data.userList=response.data.data;
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
      getUserList,
      formatDate
    }
  },
  methods: {
    clear(){
      this.data.search=null;
      this.getUserList()
    },
    querysome(){
      const _this = this
      axios.get('api/user/searchUser?search='+ _this.data.search).then(function (response) {
        _this.data.userList=response.data.data;
        _this.data.isLoading = false;
      })
          .catch(function (error) {
            console.log(error);
          });
    },
    //删除操作
    deleteUser (row) {
      this.$confirm('确认删除编号为:'+row.userid+"的用户吗?", '提示', {
        'confirmButtonText': '确定',
        'cancelButtonText': '取消',
        'type': 'warning'
      }).then(() => {
        const _this = this
        axios.get('api/user/deleteById/'+row.userid).then(function(resp){
          _this.$message.success('用户删除成功！')
          _this.getUserList()
        })
      })
    },

    edit(row){
      console.log(row);
      this.data.userupdateFormVisible = true;
      this.data.userid=row.userid;
      this.data.name=row.name;
      this.data.location=row.location;
      this.data.phonenumber=row.phonenumber;
      this.data.password=row.password;
      console.log(this.data);
    },

    // 修改操作)
    updateUser () {

      const _this = this
      // console.log(_this.data);
      const js = JSON.stringify({
        "userid": this.data.userid,
        "name": this.data.name,
        "phonenumber": this.data.phonenumber,
        "location": this.data.location,
        "password": this.data.password
      });
      // console.log(js);
      axios.post('/api/user/update',js,
          {headers: {'Content-Type': 'application/json'}}).then(function(res){
        _this.$message.success('用户修改成功！')
        _this.data.userupdateFormVisible = false
        _this.getUserList();
      })
    },

    add(){
      this.data.name=null;
      this.data.password=null;
      this.data.location=null;
      this.data.phonenumber = null;
      this.data.useraddFormVisible = true;

    },

    addUser(){

      const _this = this
      console.log(_this.data);
      const js = JSON.stringify({
        "userid": this.data.userid,
        "name": this.data.name,
        "phonenumber": this.data.phonenumber,
        "location": this.data.location,
        "password": this.data.password
      });
      console.log(js);
      axios.post('/api/log/register',js,
          {headers: {'Content-Type': 'application/json'}}).then(function(res){
        _this.$message.success('用户添加成功！')
        _this.data.useraddFormVisible = false
        _this.getUserList();
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