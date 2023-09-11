import { createRouter, createWebHistory } from 'vue-router'
import userView from '../views/UserView.vue'
import DataView from "@/views/DataView";
import GoodsView from "@/views/GoodsView";
import UploadImage from "@/components/Upload/UploadImage";
import addGoodsView from "@/views/AddGoodsView.vue";
import MapView from "@/views/MapView";
import LoginView from "@/views/LoginView";
import SettingView from "@/views/SettingView";

const routes = [
  {
    path: '/',
    name: 'LoginView',
    component: LoginView
  },
  {
    path: '/user',
    name: 'userView',
    component: userView
  },
  {
    path: '/data',
    name: 'dataView',
    component: DataView
  },
  {
    path: '/map',
    name: 'mapView',
    component: MapView
  },
  {
    path: '/goods',
    name:'goodsView',
    component: GoodsView
  },
  {
    path: '/setting',
    name:'settingView',
    component: SettingView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/addGoodsView',
    name: 'addGoodsView',
    component: addGoodsView
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
