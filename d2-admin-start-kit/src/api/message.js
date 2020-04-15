import axios from 'axios'
const message ={
  openLMsg(param){
    return axios.get('messages',{params:param});
  },
  insertMsg(param){
    return axios(
      {method:'POST',url:'messages',headers:
                       {
                         'Content-Type': 'application/json'
                       }
                       ,dataType:"json",data:param}
    )
  }

};
export default message;
