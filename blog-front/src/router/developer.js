export default   {
    path:'/developer',
    name:'developer',
    redirect:'developer/admin-mongo',
    component:()=>import('../views/developer/Home'),
    children:[
        {path:'admin-mongo',name:'admin-mongo',component:()=>import('../views/developer/admin-mongo/Index')},
        {path:'druid',name:'druid',component:()=>import('../views/developer/druid/Index')},
        {path:'rabbitmq',name:'rabbitmq',component:()=>import('../views/developer/rabbitmq/Index')},
    ]
}