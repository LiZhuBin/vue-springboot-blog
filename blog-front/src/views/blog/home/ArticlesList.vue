<template>
    <div  >

        <ArticleItem v-for="article in data.slice(0, 10)"  :key="article" :data="article"></ArticleItem>
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
        mounted() {
            this.articlesInit();
        },
        methods:{
            articlesInit(){
                this.$api.article.recentArticles(this.$store.state.accountData.id)
                    .then((response)=>{
                        this.data = response.data.data;

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