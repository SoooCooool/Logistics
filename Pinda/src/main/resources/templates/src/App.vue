<template>
<!--  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  &lt;!&ndash;会把路由到的页面替换到<router-view/>&ndash;&gt;
  <router-view/>-->
  <div>
  <!--头部：Header组件-->

    <Header v-show="$route.name!=='LoginView'&&$route.name!=='LogonView'"/>

    <!--  主体  -->
    <div style="display: flex">
      <!--   侧边栏   -->
      <Aside v-show="$route.name!=='LoginView'&&$route.name!=='LogonView'"/>
      <!--   内容区域：路由到HomeView   -->
      <router-view style="flex: 1"/>

    </div>

  </div>
  <el-backtop :right="100" :bottom="100" />

</template>

<script>
  import Header from "@/components/Header";
  import Aside from "@/components/Aside";
  import userView from "@/views/UserView.vue";
  import DataView from "@/views/DataView";
  export default {
    name: "Layout",
    components:{
      userView,
      DataView,
      Header,
      Aside
    }
  }
</script>
<style>

</style>
