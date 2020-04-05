import axios from 'axios'
const resource = {
    byClassify(way,classify,params){
        return axios.get('resources/'+way+'/'+classify,{params:params});
    },
  byDescription(way,classify,description,params){
      return axios.get('resources/'+way+'/'+classify+'/'+description,{params:params})
  }
}

export default resource;
