import axios from 'axios'
const resource = {
    byClassify(way,classify,params){
        return axios.get('resources/'+way+'/'+classify,{params:params});
    },
  byDescription(way,classify,description,params){
      return axios.get('resources/'+way+'/'+classify+'/'+description,{params:params})
  },
  classifies(params){
      return axios.get('resources',{params:params})
  },

}

export default resource;
