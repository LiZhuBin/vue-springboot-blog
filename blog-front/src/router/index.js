import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
<<<<<<< HEAD
    {
        path: '/',
        name: 'home',
        component: Home
    },

    {path: '/login', name: 'login', component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')},
=======
  {
    path: '/',
    name: 'home',
    component: Home
  },

  {path:'/login',name: 'login', component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')},
>>>>>>> 1fbb1ac11604c5850c9236f6ff98ecf83269e4f4

]

const router = new VueRouter({
<<<<<<< HEAD
    mode: 'history',
    base: process.env.BASE_URL,
    routes
=======
  mode: 'history',
  base: process.env.BASE_URL,
  routes
>>>>>>> 1fbb1ac11604c5850c9236f6ff98ecf83269e4f4
})

export default router
