<template>
  <div>
    <!--    增加按钮和搜索框-->
    <div style="margin: 10px 5px">
      <el-button type="primary">新增</el-button>
      <el-button>其他</el-button>
    </div>

    <div style="margin: 10px 5px">
      <el-input v-model="data.search" style="width: 30%;" placeholder="请输入关键字"/>
      <el-button style="margin-left: 10px" type="primary">查找</el-button>
    </div>
    <!--表格-->
    <el-table v-loading="data.isLoading" :data="data.vehicleList" stripe style="width: 100%">
      <el-table-column prop="vehicleid" width="200" label="车辆id" align="center"/>
      <el-table-column prop="transferbelong" width="200" label="车辆归属站" align="center"/>
      <el-table-column prop="driverid" width="200" label="司机id" align="center"/>
      <el-table-column fixed="right" label="操作" width="300" >
        <template #default="scope">
          <el-button @click="data.userupdateFormVisible = true;" style="margin-right: 16px" type="warning">
            <el-icon><Edit /></el-icon>编辑</el-button>
          <el-button link type="primary" size="small" @click="editDialogEdit(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!--  <el-dialog v-model="data.userupdateFormVisible" title="编辑" width="25%">-->
  <!--    <el-form :model="user" label-width="120px">-->
  <!--      <el-form-item label="更改用户名">-->
  <!--        <el-input v-model="data.name"/>-->
  <!--      </el-form-item>-->
  <!--      <el-form-item label="更改地址">-->
  <!--        <el-input v-model="data.location"/>-->
  <!--      </el-form-item>-->
  <!--      <el-form-item>-->
  <!--        <el-button @click="data.userupdateFormVisible = false">关闭</el-button>-->
  <!--        <el-button type="primary"-->
  <!--                   @click="data.userupdateFormVisible = false;uploaduser(oneGoods.goodsId,oneGoods.url);data.newImageUrl=null;hasBeenUpdated">-->
  <!--          确认提交并更改-->
  <!--        </el-button>-->
  <!--      </el-form-item>-->
  <!--    </el-form>-->
  <!--  </el-dialog>-->
</template>

<script>
// @ is an alias to /src


import {inject, onMounted, reactive} from "vue";

export default {
  name: 'VehicleView',
  components: {},
  setup() {
    onMounted(() => {
      getVehicleList();
    })

    const axios = inject('axios');
    const data = reactive({
      //userupdateFormVisible: false,
      search: '',
      vehicleList: [],
      isLoading:true
    });

    const getVehicleList = function () {
      const config = {
        method: 'get',
        url: 'api/vehicle/queryAll',
        headers: {}
      };

      axios(config)
          .then(function (response) {
            data.vehicleList=response.data.data;
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
      getVehicleList,
      formatDate
    }

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