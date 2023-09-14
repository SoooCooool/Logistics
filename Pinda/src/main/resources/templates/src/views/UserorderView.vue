<template>
  <div>
    <!--    增加按钮和搜索框-->

    <div style="margin: 10px 5px">
      <el-input v-model="data.search" style="width: 30%;" placeholder="请输入关键字" @keyup.enter.native="querysome()" clearable/>
      <el-button style="margin-left: 10px" type="primary" @click="querysome()">查找</el-button>
      <el-button style="margin-left: 10px" type="primary" @click="clear()">清除</el-button>
    </div>
    <!--表格-->
    <el-table v-loading="data.isLoading" :data="data.ordersList" stripe style="width: 100%">
      <el-table-column prop="orderid" width="100" label="订单id" align="center"/>
      <el-table-column prop="userid" width="100" label="用户id" align="center"/>
      <el-table-column prop="modifiedpersonid" width="100" label="修改人id" align="center"/>
      <el-table-column prop="createdtime" width="100" label="创建时间" align="center"/>
      <el-table-column prop="modifiedtime" width="100" label="修改时间" align="center"/>
      <el-table-column prop="startlocation" width="100" label="起始地址" align="center"/>
      <el-table-column prop="destination" width="100" label="目的地" align="center"/>
      <el-table-column prop="amount" width="50" label="金额" align="center"/>
      <el-table-column prop="kind" width="50" label="物品种类" align="center"/>
      <el-table-column prop="starttime" width="100" label="开始时间" align="center"/>
      <el-table-column prop="arrivetransfertime" width="100" label="到达时间" align="center"/>
      <el-table-column prop="finaltime" width="100" label="签收时间" align="center"/>
      <el-table-column prop="presentlocation" label="当前地址" width="100" align="center"/>
      <el-table-column prop="presentstate" label="当前状态" width="100" align="center"/>
      <el-table-column prop="weight" label="物品重量" width="50" align="center"/>
    </el-table>
  </div>



</template>

<script>
// @ is an alias to /src


import {inject, onMounted, reactive} from "vue";
import axios from "axios";
import store from "@/store";

export default {
  name: 'OrderView',
  components: {},
  setup() {
    onMounted(() => {
      getOrdersList();
    })

    const axios = inject('axios');
    const data = reactive({
      ordersaddFormVisible: false,
      search: '',
      ordersList: [],
      orderid: '',
      userid: '',
      employeeid: '',
      startlocation: '',
      destination: '',
      amount: '',
      kind: '',
      weight: '',
      isLoading:true
    });

    const getOrdersList = function () {
      const config = {
        method: 'get',
        url: 'api/orders/queryAll',
        headers: {}
      };

      axios(config)
          .then(function (response) {
            data.ordersList=response.data.data;
            data.isLoading = false;
          })
          .catch(function (error){
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
      getOrdersList,
      formatDate
    }

  },

  methods: {
    clear(){
      this.data.search=null;
      this.getOrdersList()
    },
    querysome(){
      const _this = this
      axios.get('api/orders/searchOrders?search='+ _this.data.search).then(function (response) {
        _this.data.ordersList=response.data.data;
        _this.data.isLoading = false;
      })
          .catch(function (error) {
            console.log(error);
          });
    },
    //删除操作
    deleteOrders (row) {
      this.$confirm('确认删除编号为:'+row.orderid+"的订单吗?", '提示', {
        'confirmButtonText': '确定',
        'cancelButtonText': '取消',
        'type': 'warning'
      }).then(() => {
        const _this = this
        axios.get('api/orders/deleteById/'+row.orderid).then(function(resp){
          _this.$message.success('订单删除成功！')
          _this.getOrdersList()
        })
      })
    },

    next(row){
      this.$confirm("确认下一步执行编号为:"+row.orderid+"的订单吗?", '提示', {
        'confirmButtonText': '确定',
        'cancelButtonText': '取消',
        'type': 'warning'
      }).then(() => {
        const _this = this
        // console.log(_this.data);
        const js = JSON.stringify({
          "orderid": row.orderid,
          "userid": row.userid,
          "employeeid": store.state.userid,
          "destination": row.destination,
          "startlocation": row.startlocation,
          "amount": row.amount,
          "kind": row.kind,
          "weight": row.weight
        });
        axios.post('api/orders/next',js,{headers: {'Content-Type': 'application/json'}}).then(function(resp){
          _this.$message.success('已完成！')
          _this.getOrdersList()
        })
      })
    },



    add(){
      this.data.orderid=null,
          this.data.userid=null,
          this.data.employeeid=null,
          this.data.startlocation=null,
          this.data.destination=null,
          this.data.amount=null,
          this.data.kind=null,
          this.data.weight=null,
          this.data.ordersaddFormVisible = true;
    },

    addOrders(){


      const _this = this
      console.log(_this.data);
      const js = JSON.stringify({
        "orderid": this.data.orderid,
        "userid": this.data.userid,
        "employeeid": this.data.employeeid,
        "destination": this.data.destination,
        "startlocation": this.data.startlocation,
        "amount": this.data.amount,
        "kind": this.data.kind,
        "weight": this.data.weight
      });
      console.log(js);
      axios.post('/api/orders/add',js,
          {headers: {'Content-Type': 'application/json'}}).then(function(res){
        _this.$message.success('订单添加成功！')
        _this.data.ordersaddFormVisible = false
        _this.getOrdersList();
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