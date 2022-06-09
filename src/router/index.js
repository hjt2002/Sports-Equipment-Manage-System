import { createRouter, createWebHistory } from 'vue-router'

import login from '../views/login.vue'
import register from '../views/register.vue'
import ml from '../views/mainLook.vue'
import admin from '../views/adminLook.vue'

//用户
import look_All from '../components/user/look_All.vue'
import borrow from '../components/user/borrow.vue'
import return_e from "@/components/user/return_e.vue";
import search from "@/components/user/search.vue";

//管理员
import user_look from '../components/admin/user_look.vue'
import look_All_admin from '../components/admin/look_All_admin.vue'
import in_equip from "@/components/admin/in_equip";
import search_admin from "@/components/admin/search_admin";




const routes = [
  {
    //用户登录主界面
    path: '/main',
    name: 'ml',
    component: ml,

  },
  {
    //管理员登录主界面
    path: '/admin',
    name: 'admin',
    component: admin,

  },
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/register',
    name: 'register',
    component: register
  },
  {
    //浏览器材界面
    path: '/look_All',
    name: 'look_All',
    component: look_All,

  },
  {
    //b
    path: '/borrow',
    name: 'borrow',
    component: borrow,

  },
  {
    //r
    path: '/return_e',
    name: 'return_e',
    component: return_e,

  },
  {
    //
    path: '/look_All_admin',
    name: 'look_All_admin',
    component: look_All_admin,

  },
  {
    //浏览用户界面
    path: '/user_look',
    name: 'user_look',
    component: user_look,

  },

  {
    //
    path: '/in_equip',
    name: 'in_equip',
    component: in_equip,

  },

  {
    //
    path: '/search_admin',
    name: 'search_admin',
    component: search_admin,

  },
  {
    //
    path: '/search',
    name: 'search',
    component: search,

  },




]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

