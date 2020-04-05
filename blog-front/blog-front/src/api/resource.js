import axios from 'axios'
const resource = {
    imagesByClassify(classify,params){
        return axios.get('resources/images/'+classify,{params:params});
    }}
export default resource;