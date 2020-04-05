<template>
    <div >
    <card-tag :tags="labels"></card-tag>

    <card-archive :articleDate = "accountSumary.articleDate"></card-archive>
        <card-classify :classify="classifies"></card-classify>
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
                "labels":[],
                "classifies":[],
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
                        this.accountSumary = response.data.data.accountSumary;
                    })
              this.$api.label.getLabels({'accountId':this.$store.state.accountData.id})
                .then((response)=>{

                  this.labels= response.data.data;

                })
                .catch((error)=>{
                  alert(error)
                })
              this.$api.article.classifies(this.$store.state.accountData.id)
              .then((response)=>{
                this.classifies = response.data.data;
              })
            }

        }
    }
</script>

<style scoped>

</style>
