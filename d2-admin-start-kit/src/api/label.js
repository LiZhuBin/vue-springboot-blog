import axios from 'axios'
const label = {

    getLabels(params){

        return axios.get('labels',{params:params})
    },


};
export default label;
