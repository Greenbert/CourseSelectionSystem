import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Menu from '../views/Menu.vue'
import menuItems from '../components/menuItems.vue'
import login from '../components/login.vue'
import chooseClass from '../components/chooseClass.vue'
import admin from '../components/admin.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
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
    path: '/menu',
    name: 'menu',
    component: Menu,
    children: [
      {
        path: '/items',
        name: 'menuItems',
        component: menuItems
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: login,
  },
  {
    path: '/chooseClass',
    name: 'chooseClass',
    component: chooseClass,
  },
  {
    path: '/admin',
    name: 'admin',
    component: admin,
  },
  
  
]

const router = new VueRouter({
  routes
})

export default router
