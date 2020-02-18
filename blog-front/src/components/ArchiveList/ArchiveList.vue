<template>
    <div>

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


    export default {
        name: "ArchiveList",
        props: {
            articles: {
                request:Array
            }
        },


        created() {

            this.init();
        },

        data() {
            return {

            }
        },
        components: {
        },
        methods: {

            view(id) {
                this.$router.push({path: `/blog/home/article/${id}`})
            }

        }
    }

</script>

<style scoped>

</style>