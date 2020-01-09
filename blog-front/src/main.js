import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
Vue.use(ElementUI);
new Vue({
<<<<<<< HEAD
    router,
    store,
    render: h => h(App)
=======
  router,
  store,
  render: h => h(App)
>>>>>>> 1fbb1ac11604c5850c9236f6ff98ecf83269e4f4
}).$mount('#app')
