
import axios from 'axios'
const account = {
    checkAccount(param) {
        return axios.post('accounts/actions/check', param);
    },
    getAccount(id){
        return axios.get('accounts/'+id)
    }
};
export default account;
