import axios from 'axios'
const article = {
    recentArticles(accountId) {
        return axios.get('articles/account-id/' + accountId);
    },
    articleDetail(articleId){
        return axios.get('articles/'+articleId);
    }
};
export default article;