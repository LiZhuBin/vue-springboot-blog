import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import qs from 'qs'
import api from './api/api'

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
// axios 配置
axios.defaults.timeout = 8000;
axios.defaults.baseURL = "http://localhost:9877/v1/";
Vue.config.productionTip = false;
Vue.prototype.$qs = qs;
Vue.use(ElementUI);
Vue.prototype.$http = axios;

Vue.prototype.$api = api;

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
