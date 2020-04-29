import axios from 'axios'
const article = {
    recentArticles(accountId) {
        return axios.get('articles/account-id/' + accountId);
    },
    articleDetail(articleId){
        return axios.get('articles/'+articleId);
    },
    getArticle(articleId){
      return axios.get('articles/'+articleId);
    },
    classifies(accountId){
      return axios.get('articles/_classify',{params:{'accountId':accountId}})
    },
    articleComments(param){
      return axios.get('comments',{params:param})
    },
    delectArticle(accountId){
      return axios.delete("articles/"+accountId)
    },
    insertComment(param){
      return axios(
        {method:'POST',url:'comments',headers:
            {
              'Content-Type': 'application/json'
            }
          ,dataType:"json",data:param}
      )
    },
  insertReply(param){
    return axios(
      {method:'POST',url:'replies',headers:
          {
            'Content-Type': 'application/json'
          }
        ,dataType:"json",data:param}
    )
  }
};
export default article;
