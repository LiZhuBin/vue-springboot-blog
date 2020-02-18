<template>
    <div >
    <card-tag :tags="accountSumary.labels"></card-tag>

    <card-archive :articleDate = "accountSumary.articleDate"></card-archive>
        <card-classify :classify="accountSumary.classify"></card-classify>
    <card-resource :resource="accountSumary.resource"></card-resource>
    </div>
</template>

<script>
    import CardArchive from "./components/CardArchive";
    import CardTag from "./components/CardTag";
    import CardResource from "./components/CardResource";
    import CardClassify from "./components/CardClassify";
    export default {
        name: "BlogRightSlide",
        components:{
            CardArchive,
            CardTag,
            CardResource,
            CardClassify
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

                "accountSumary": {
                    "accountId": 1,
                    "classify": [
                        {
                            "num": 1,
                            "name": "前端"
                        },
                        {
                            "num": 1,
                            "name": "工具"
                        }
                    ],
                    "classifyNum": 2,
                    "articleNum": 40,
                    "labelNum": 1,
                    "readNum": 44,
                    "articleDate": [
                        {
                            "month": 1,
                            "year": 2020,
                            "num": 1
                        },
                        {
                            "month": 2,
                            "year": 2020,
                            "num": 1
                        }
                    ],
                    "id": "5e39aaeba3d8424345f8f72a",
                    "labels": [
                        {
                            "num": 1,
                            "name": "picgo"
                        },
                        {
                            "num": 1,
                            "name": "markdown"
                        }
                    ]
                },
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
                        this.accountSumary = response.data.data.accountSumary;
                    })
            }
        }
    }
</script>

<style scoped>

</style>