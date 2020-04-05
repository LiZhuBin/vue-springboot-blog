import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Qs from 'qs'
import api from './api/api'
import mavonEditor from 'mavon-editor'
import marked from 'marked'

import 'mavon-editor/dist/css/index.css'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// axios 配置
axios.defaults.timeout = 8000;
axios.defaults.baseURL = "http://localhost:9877/v1/";
Vue.config.productionTip = false;
Vue.prototype.$qs = Qs;

Vue.use(ElementUI);
Vue.use(mavonEditor);
Vue.prototype.$http = axios;

Vue.prototype.$api = api;
router.beforeEach((to, from, next) => {

    //获取用户登录成功后储存的登录标志
    let getFlag = localStorage.getItem("Flag");

    //如果登录标志存在且为isLogin，即用户已登录
    if(getFlag === "isLogin"){

        //设置vuex登录状态为已登录
        store.state.isLogin = true
        next()

        //如果已登录，还想想进入登录注册界面，则定向回首页
        if (!to.meta.isLogin) {
            //iViewUi友好提示
            iView.Message.error('请先退出登录')
            next({
                path: '/home'
            })
        }

        //如果登录标志不存在，即未登录
    }else{

        //用户想进入需要登录的页面，则定向回登录界面
        if(to.meta.isLogin){
            next({
                path: '/login',
            })
            //iViewUi友好提示
            iView.Message.info('请先登录')
            //用户进入无需登录的界面，则跳转继续
        }else{
            next()
        }

    }

});

router.afterEach(route => {
    window.scroll(0, 0);
});
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
