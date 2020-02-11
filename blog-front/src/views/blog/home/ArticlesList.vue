<template>
    <div  >
        <div v-for="info in data.slice(0, 5)"  :key="info" >
        <ArticleItem :article="info.article" :labels="info.labels" :account="info.account"></ArticleItem>
        </div>
        <el-pagination
                background
                layout="prev, pager, next"
                :total="1000">
        </el-pagination>

    </div>

</template>

<script>
    import ArticleItem from "./components/ArticleItem";
    export default {
        name: "Article",

        data(){
            return{
                data:[],

            }
        },
        created() {
            this.articlesInit();
        },
        methods:{
            articlesInit(){
                this.$api.article.recentArticles(this.$store.state.accountData.id)
                    .then((response)=>{
                        this.data = response.data.data;

                    })

            },

        },
        components:{
            ArticleItem
        }
    }
</script>

<style scoped>

</style>