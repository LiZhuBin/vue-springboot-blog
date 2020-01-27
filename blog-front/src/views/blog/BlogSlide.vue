<template>
    <div >
        <card-me :account="account"></card-me>
        <card-article :hotArticles="articles.hotArticles" :newArticles="articles.newArticles"></card-article>
        <card-tag :tags="labels"></card-tag>

        <card-archive></card-archive>
        <card-resource></card-resource>

    </div>
</template>

<script>
    import CardMe from "./home/components/CardMe";
    import CardArchive from "./home/components/CardArchive";
    import CardTag from "./home/components/CardTag";
    import CardResource from "./home/components/CardResource";
    import CardArticle from "./home/components/CardArticle";

    export default {
        name: "Slide",
        components:{
            CardMe,
            CardArchive,
            CardTag,
            CardResource,
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
                    "labels": [
                    ]
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
                    this.labels = response.data.data.labels;
                })
            }
        }
    }
</script>

<style scoped>

</style>