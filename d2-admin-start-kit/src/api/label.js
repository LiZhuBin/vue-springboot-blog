import axios from 'axios'
const label = {

    getLabels(params){

        return axios.get('labels',{params:params})
    },
    getLabelsByArticleId(id){
      return axios.get('labels/articleId/'+id);
    }

};
export default label;
