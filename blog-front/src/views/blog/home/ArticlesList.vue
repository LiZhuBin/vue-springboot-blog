<template>
    <div  >
        <ArticleItem v-for="article in articles.slice(0, 10)"  :key="article" :article="article"></ArticleItem>
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
                articles:[]
            }
        },
        mounted() {
            this.articlesInit();
        },
        methods:{
            articlesInit(){
                this.$api.article.recentArticles(this.$store.state.accountData.id)
                    .then((response)=>{
                        this.articles = response.data.data;
                    })
            }
        },
        components:{
            ArticleItem
        }
    }
</script>

<style scoped>

</style>