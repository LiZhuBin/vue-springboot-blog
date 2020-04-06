import axios from 'axios'
const archive = {
  archives(accountId){
    return axios.get('archives',{params:{'accountId':accountId}})
  },
  archivesDetail(year,month,params){
    return axios.post('archives/'+year+'/'+month,params)
  }
}
export default archive;
