export default   {
    path:'/developer',
    name:'developer',
    redirect:'developer/admin-mongo',
    component:()=>import('../views/developer/Home'),
    children:[
        {path:'admin-mongo',name:'admin-mongo',component:()=>import('../views/developer/admin-mongo/index')},
    ]
}