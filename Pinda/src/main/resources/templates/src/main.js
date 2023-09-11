import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
/*引入css*/
import '@/assets/css/global.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
/*国际化*/
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
/*引入ECharts*/
import * as echarts from "echarts"
/* 引入 Element Plus Icons Vue 组件库*/
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
/*引入axios*/
import axios from 'axios'

const app = createApp(App)

// 注册 Element Plus 插件
app.use(ElementPlus, { locale: zhCn })

// 加载 Element Plus Icons Vue 组件库，并注册为全局组件
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

// 注册 Vue Router 和 Vuex 插件
app.use(router).use(store)

// 引入 echarts 库
app.use(echarts)

// 将axios作为全局属性添加到Vue应用程序中
app.provide('axios', axios);

// 挂载 Vue 3 应用程序
app.mount('#app')

