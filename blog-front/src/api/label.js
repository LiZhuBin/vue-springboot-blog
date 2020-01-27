import axios from 'axios'
const label = {

    getLabels(param){
        return axios.post('labels',{param:param});
    },
    getArticleByLabelId(id){
        return axios.get('labels/'+id)
    }
};
export default label;