import axios from 'axios'
const article = {
    recentArticles(accountId) {
        return axios.get('articles/account-id/' + accountId);
    },
    articleDetail(articleId){
        return axios.get('articles/'+articleId);
    },
    classifies(accountId){
      return axios.get('articles/_classify',{params:{'accountId':accountId}})
    }
};
export default article;
