
import axios from 'axios'
const account = {
    checkAccount(param) {
        return axios.get('accounts/actions/check', {params:param});

    },
    getAccount(id){
        return axios.get('accounts/'+id)
    }
};
export default account;