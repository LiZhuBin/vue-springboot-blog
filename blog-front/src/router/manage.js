export default     {
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
}