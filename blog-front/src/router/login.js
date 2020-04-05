export default   {
    path: '/login',
    name: 'login',
    meta: {
        isLogin: false
    },
    component: () => import(/* webpackChunkName: "about" */ '../views/login/Login.vue')
}