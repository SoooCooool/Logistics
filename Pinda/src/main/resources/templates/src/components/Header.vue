<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px;margin-top: 15px; margin-right: 20px; font-weight: bold; font-size: larger">
      <el-dropdown trigger="click">
        <span class="el-dropdown-link">
          <el-icon style="margin-right: 10px"><User /></el-icon>admin
          <el-icon>
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item @click="this.checkout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown></div>
  </div>
</template>

<script>
  export default {
    name: "Header",
    setup() {

    },
    methods: {
      checkout() {
        // console.log("check out...");
        this.$router.push({ path: '/' });
      },
    },
  }
</script>

<style scoped>
</style>