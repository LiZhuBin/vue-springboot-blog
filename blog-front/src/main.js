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

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
