<template>

  <div>
    <el-menu
        default-active=""
        class="el-menu-vertical-demo"
        :default-openeds="['1']"
        :router=true
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon>
            <DataLine/>
          </el-icon>
          数据概览
        </template>
        <el-menu-item index="/data">
          <el-icon>
            <PieChart/>
          </el-icon>
          可视化数据
        </el-menu-item>
        <el-menu-item index="/map">
          <el-icon>
            <MapLocation />
          </el-icon>
          业务地图
        </el-menu-item>
        <el-menu-item index="/user">
          <el-icon>
            <User/>
          </el-icon>
          用户
        </el-menu-item>
        <el-menu-item index="/goods">
          <el-icon>
            <Box/>
          </el-icon>
          商品
        </el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/addGoodsView">
        <el-icon>
          <document/>
        </el-icon>
        <span>添加商品</span>
      </el-menu-item>
      <el-menu-item index="4" route="/setting">
        <el-icon>
          <setting/>
        </el-icon>
        <span>设置</span>
      </el-menu-item>
      <el-menu-item index="5" route="/about">
        <el-icon>
          <InfoFilled />
        </el-icon>
        <span>关于</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "Aside",
  methods: {
    router() {
      return router
    }
  }
}
</script>

<style scoped>

</style>