import Vue from 'vue'
import VueRouter from 'vue-router'
import home from "./home";
import login from "./login"
import register from "./register";
import blog from "./blog";

import developer from "./developer";

Vue.use(VueRouter)

const routes = [
    home,
    login,
    register,
    blog,
    developer,
    {
        path: '*',
        redirect: '/404',
        hidden: true
    }






]

const router = new VueRouter({

    mode: 'history',
    base: process.env.BASE_URL,
    routes

})

export default router
