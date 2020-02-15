export default {
    path: '/blog',
    name: 'blog',
    component: () => import('../views/blog/Index'),
    redirect: 'blog/home/articleslist',
    children:[{
        path:'home',
        name:'home',
        component: () => import('../views/blog/home/BlogHome.vue'),
        children: [{
            path: 'articleslist',
            name: 'articleslist',
            component: () => import('../views/blog/home/ArticlesList.vue')
        },
            {path: 'article/:id', name: 'article', component: () => import ('../views/blog/home/article/Article.vue')},
            {path: 'label/:labelName', name: 'label', component: () => import('../views/blog/home/label/Label.vue')},
            {path:'resources/images',name:'resources',component:()=>import('../views/blog/home/resources/images/Index.vue')},
            {
                path: 'archive/:year/:month',
                name: 'archive',
                component: () => import('../views/blog/home/archive/Archive.vue')
            },
            {
                path: 'classify/:classifyName',
                name: 'classify',
                component: () => import('../views/blog/home/classify/Classify')
            },

        ],

    },
        {
            path:'manage',
            name:'manage',
            component:()=>import('../views/blog/manage/Home.vue'),
            redirect:'manage/blog-manage',
            children:[
                {path: 'my-blog',name: 'my-blog',component:()=>import('../views/blog/manage/blog-manage/my-blog/index')},
                {path:'blog-manage',name:'blog-manage',component:()=>import('../views/blog/manage/blog-manage/BlogManageHome.vue')},
                {path:'write-article',name:'write-article',component:()=>import('../views/blog/manage/blog-manage/write-article/index.vue')},
                {path:'info-manage',name:'info-manage',component:()=>import('../views/blog/manage/info-manage/InfoManage')}
            ],
        }
    ],



}