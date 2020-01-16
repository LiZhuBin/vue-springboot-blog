
import axios from 'axios'
const account = {
    checkAccount(param) {
        return axios.get('account/actions/check', {params:param});

    },
    
};
export default account;