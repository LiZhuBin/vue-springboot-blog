<template>
    <el-card :body-style="{ padding: '8px 18px' }">
        <el-tabs v-model="activeName" active-name="first">
            <el-tab-pane label="最热文章" name="first">
                <HotArticles :articles ="hotArticles"></HotArticles>
            </el-tab-pane>
            <el-tab-pane label="最新文章" name="second" >
                <NewArticles :articles="newArticles"></NewArticles>

            </el-tab-pane>
        </el-tabs>
    </el-card>

</template>

<script>
    import NewArticles from "./NewArticles";
    import HotArticles from "./HotArticles";
    export default {
        name: 'CardArticle',
        props: {

            hotArticles: {
                type: Array,
                required: true
            },
            newArticles:{
                type: Array,
                required: true
            }


        },
        mounted() {

        },
        data() {
            return {
                cardHeader:"最新文章",
            }
        },
        components:{
            NewArticles,
            HotArticles
        }

    }
</script>

<style scoped>

</style>
