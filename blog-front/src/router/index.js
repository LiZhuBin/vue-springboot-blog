import Vue from 'vue'
import VueRouter from 'vue-router'
import Article from "../views/blog/home/ArticlesList";

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'home',

        redirect:'blog/articleslist'},
    {path: '/blog',
        name: 'blog',
        component: () => import('../views/blog/BlogHome.vue'),
        redirect:'blog/articleslist',
        children: [{
            path: 'articleslist',
            name: 'articleslist',
            component: () => import('../views/blog/home/ArticlesList.vue')
        },
            {path:'article/:id',name: 'article',component:()=>import ('../views/blog/article/Article.vue')},
            {path:'label/:labelName',name:'label',component:()=>import('../views/blog/label/Label.vue')},
            {path:'archive/:year/:month',name:'archive',component:()=>import('../views/blog/archive/Archive.vue')},
            {path:'classify/:classifyName',name:'classify',component:()=>import('../views/blog/classify/Classify')},
        ],

    },
    {
        path:'/manage',
        name:'manage',
        component:()=>import('../views/manage/Home.vue'),
        redirect:'manage/blog-manage',
        children:[
            {path: 'my-blog',name: 'my-blog',component:()=>import('../views/manage/blog-manage/my-blog/index')},
            {path:'blog-manage',name:'blog-manage',component:()=>import('../views/manage/blog-manage/BlogManageHome.vue')},
            {path:'write-article',name:'write-article',component:()=>import('../views/manage/blog-manage/write-article/index.vue')},
            {path:'info-manage',name:'info-manage',component:()=>import('../views/manage/info-manage/InfoManage')}
        ],
    },
    {
        path:'/developer',
        name:'developer',
        redirect:'developer/admin-mongo',
        component:()=>import('../views/developer/Home'),
        children:[
            {path:'admin-mongo',name:'admin-mongo',component:()=>import('../views/developer/admin-mongo/index')},
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
