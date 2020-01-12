import axios from 'axios'
const article = {
    recentArticles(accountId) {
        return axios.get('articles/account-id/' + accountId);
    }
};
export default article;