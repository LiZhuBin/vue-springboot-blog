import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Article from "../views/home/ArticlesList";

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'home',
        component: Home,
        redirect:'articles/list',
        children:[{path:'articles/list',name:'articleslist',component:()=>import('../views/home/ArticlesList.vue')},

        ],

    },

    {path: '/login', name: 'login', component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')},

]

const router = new VueRouter({

  mode: 'history',
  base: process.env.BASE_URL,
  routes

})

export default router
