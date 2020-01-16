import axios from 'axios'
const label = {

    getLabels(param){
        return axios.post('labels',{param:param});
    }
};
export default label;