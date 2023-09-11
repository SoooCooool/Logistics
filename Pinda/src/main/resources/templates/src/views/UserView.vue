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
    <el-table v-loading="data.isLoading" :data="data.userList" stripe style="width: 100%">
      <el-table-column prop="userId" label="ID" width="100" align="center"/>
      <el-table-column label="头像" width="65" align="center">
        <template #default="scope">
          <div style="display: flex">
            <el-avatar
                :src="scope.row.url"
            />
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="userName" width="200" label="用户名" align="center"/>
      <el-table-column width="165" label="注册日期">
        <template #default="scope">
            <span style="margin-left: 10px">{{ formatDate(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="phoneNumber" label="电话号" width="250" align="center"/>
      <el-table-column prop="amount" label="余额" width="90" header-align="center" align="center">
        <template #default="scope">
          <span >{{ scope.row.amount.toFixed(2) }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="sex" label="性别" align="center" width="60"/>
      <el-table-column fixed="right" label="操作" width="300" >
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)"
          >编辑
          </el-button
          >
          <el-button link type="primary" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
// @ is an alias to /src


import {inject, onMounted, reactive} from "vue";

export default {
  name: 'userView',
  components: {},
  setup() {
    onMounted(() => {
      getUserList();
    })

    const axios = inject('axios');
    const data = reactive({
      search: '',
      userList: [],
      isLoading:true
    });

    const getUserList = function () {
      const config = {
        method: 'get',
        url: 'api/user/list',
        headers: {}
      };

      axios(config)
          .then(function (response) {
            data.userList=response.data.extend.userList;
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
