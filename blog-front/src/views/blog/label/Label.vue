<template>
    <div>
<PageHeader></PageHeader>
        <div class="label-articles">
            <el-timeline v-for="article in articles" :key="article">
                <el-timeline-item :timestamp=article.articleCreateTime placement="top">
                    <el-card>
                        <h4>{{article.articleTitle}}</h4>
                        <p>	<i class="el-icon-view"></i>&nbsp;{{article.articleReadCount}}</p>
                    </el-card>
                </el-timeline-item>

            </el-timeline>
        </div>
    </div>
</template>

<script>
    import PageHeader from "../../../components/detail/PageHeader";
    export default {
        name: "Label",
        props:{

        },
        watch: {
            '$route': function (to, from) {

                this.$store.dispatch('updateActiveTemplateId', this.$route.params.templateId)

                this.init()
            }
        },
        created() {
            this.init();
        },
        data(){
            return{
                "articles": [
                    {
                        "id": 46,
                        "articleCreateTime": "2019-10-13 18:30:53",
                        "articleReadCount": 1,
                        "articleTitle": "at, nisi. Cum sociis natoque penatibus et magnis dis parturient",
                        "articlePicture": "https://source.unsplash.com/random/900x300",
                        "accountId": 1
                    }
                ]
            }
        },
        components:{
            PageHeader
        },
        methods:{
            init(){
                this.$api.label.getArticleByLabelId(this.$route.params.id)
                .then((response)=>{
                    this.articles = response.data.data;
                })
            }
        }
    }

</script>

<style scoped>

</style>