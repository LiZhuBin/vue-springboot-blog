<template>
    <div>
        <PageHeader :headerName="headName"></PageHeader>
        <div class="label-articles" v-for="article in articles" :key="article" @click="view(article.id)">
            <el-timeline>
                <el-timeline-item :timestamp=article.articleCreateTime placement="top" @click="go(d=article.id)">
                    <el-card>
                        <h4>{{article.articleTitle}}</h4>
                        <p><i class="el-icon-view"></i>&nbsp;{{article.articleReadCount}}</p>
                    </el-card>
                </el-timeline-item>

            </el-timeline>
        </div>
    </div>
</template>

<script>
    import PageHeader from "../../../../components/detail/PageHeader";

    export default {
        name: "Archive",
        props: {},

        watch: {
            '$route': function (to, from) {

                this.init()
            }
        },
        created() {

            this.init();
        },
        data() {
            return {
                headName: "",
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
        components: {
            PageHeader
        },
        methods: {
            init() {
                this.headName = this.$route.params.classifyName;
                let param = {
                    "accountId": this.$store.state.accountData.id
                };
                this.$http({
                    method: 'post',
                    url: 'articles/_classify/' + this.$route.params.classifyName,
                    data: this.$qs.stringify(param)
                })
                    .then((response) => {
                        this.articles = response.data.data;
                    })
                    .catch((error) => {
                    })
            },
            view(id) {
                this.$router.push({path: `/blog/home/article/${id}`})
            }
            ,
        }
    }

</script>

<style scoped>

</style>
