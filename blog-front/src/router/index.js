import Vue from 'vue'
import VueRouter from 'vue-router'
import Article from "../views/blog/home/ArticlesList";

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'home',
        component: () => import('@/views/Home.vue'),
        redirect:'blog/articleslist',
        children: [{path: 'blog',
            name: 'blog',
            component: () => import('@/views/blog/BlogHome.vue'),

            children: [{
                path: 'articleslist',
                name: 'articleslist',
                component: () => import('../views/blog/home/ArticlesList.vue')
            },

            ],
        },
        ]


    },

    {
        path: '/login',
        name: 'login',
        component: () => import(/* webpackChunkName: "about" */ '../views/login/Login.vue')
    },

]

const router = new VueRouter({

    mode: 'history',
    base: process.env.BASE_URL,
    routes

})

export default router
