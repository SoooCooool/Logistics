import { createRouter, createWebHistory } from 'vue-router'
import UserView from '../views/UserView.vue'
import OrderView from '../views/OrderView.vue'
import EmployeeView from '../views/EmployeeView.vue'
import AdministratorView from '../views/AdministratorView.vue'
// import TransferView from '../views/TransferView.vue'
import VehicleView from '../views/VehicleView.vue'
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
    name: 'UserView',
    component: UserView
  },
  {
    path: '/orders',
    name: 'OrderView',
    component: OrderView
  },
  {
    path: '/employee',
    name: 'EmployeeView',
    component: EmployeeView
  },
  {
    path: '/administrator',
    name: 'AdministratorView',
    component: AdministratorView
  },
  // {
  //   path: '/transfer',
  //   name: 'TransferView',
  //   component: TransferView
  // },
  {
    path: '/vehicle',
    name: 'VehicleView',
    component: VehicleView
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
