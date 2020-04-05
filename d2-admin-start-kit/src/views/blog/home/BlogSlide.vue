<template>
    <el-scrollbar >
        <div>
        <card-me :account="account" :account-sumary="accountSumary"></card-me>
        <card-article :hotArticles="articles.hotArticles" :newArticles="articles.newArticles" ></card-article>
        </div>

    </el-scrollbar>
</template>

<script>
    import CardMe from "./components/CardMe";

    import CardArticle from "./components/CardArticle";

    export default {
        name: "BlogSlide",
        components:{
            CardMe,

            CardArticle
        },
        data(){
            return{

                    "account": {

                    },
                    "articles": {
                        "newArticles": [
                        ],
                        "hotArticles": [

                        ]
                    },

                "accountSumary": {},
                }
        },
        mounted() {
            this.init();
        },
        methods:{
            init(){

                this.$api.account.getAccount(this.$store.state.accountData.id)
                .then((response)=>{
                    this.account = response.data.data.account;
                    this.articles = response.data.data.articles;

                    this.accountSumary = response.data.data.accountSumary;
                })
              .catch((error)=>{
                alert(error)
              })
            }
        }
    }
</script>

<style scoped>

</style>
