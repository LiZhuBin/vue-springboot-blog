import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({

    state: {
        accountData:{
            "id": 0,
            "accountHead": "",
            "accountSign": "",
            "communicationId": 0,
            "accountName": "",
            "accountCreateDate": "",
            "accountBirthDate": "dd",
            "accountCompany": "",
            "accountSite": ""
        }
    },
    mutations: {},
    actions: {},
    modules: {

    }



})
