import { createRouter, createWebHistory } from 'vue-router'
import UserView from '../views/UserView.vue'
import OrderView from '../views/OrderView.vue'
import EmployeeView from '../views/EmployeeView.vue'
import AdministratorView from '../views/AdministratorView.vue'
import UsersetView from "@/views/UsersetView.vue"
import UserorderView from "@/views/UserorderView.vue"
import EmployeesetView from '../views/EmployeesetView.vue'
import AdminsetView from '../views/AdminsetView.vue'
import TransferView from "@/views/TransferView.vue"
import VehicleView from '../views/VehicleView.vue'
import DataView from "@/views/DataView"
import LoginView from "@/views/LoginView.vue"
import LogonView from "@/views/LogonView.vue";

import {vShow} from "vue";
import store from "@/store";

const routes = [
  {
    path: '/logon',
    name: 'LogonView',
    component: LogonView
  },
  {
    path: '/',
    name: 'LoginView',
    component: LoginView,
  },
  {
    path: '/user',
    name: 'UserView',
    component: UserView
  },
  {
    path: '/orders',
    name: 'OrderView',
    component: OrderView,

  },
  {
    path: '/employee',
    name: 'EmployeeView',
    component: EmployeeView,
  },
  {
    path: '/administrator',
    name: 'AdministratorView',
    component: AdministratorView
  },
  {
    path: '/transfer',
    name: 'TransferView',
    component: TransferView
  },
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
    path: '/userset',
    name: 'usersetView',
    component: UsersetView
  },
  {
    path: '/employeeset',
    name: 'employeesetView',
    component: EmployeesetView
  },
]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
