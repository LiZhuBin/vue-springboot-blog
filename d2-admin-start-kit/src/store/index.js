import Vue from 'vue'
import Vuex from 'vuex'

import d2admin from './modules/d2admin'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    accountData:{
      "id": 1,
      "name":"彬"
    },
    myData:{

    },
    isLogin: false,
  },

  // 设置属性状态
  mutations: {
    //保存登录状态
    userStatus(state, flag) {
      state.isLogin = flag
    },
  },

  // 应用mutations
  actions: {
    //获取登录状态
    userLogin({commit}, flag) {
      commit("userStatus", flag)
    },
  },
  modules: {
    d2admin
  }
})
