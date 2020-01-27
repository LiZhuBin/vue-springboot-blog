<template>
<div>
<PageHeader></PageHeader>
    <el-main>
        <el-image :src="article.articlePicture"></el-image>
        <div class="me-view-card">
            <h1 class="me-view-title">{{article.articleTitle}}</h1>
            <div class="me-view-time">{{article.articleCreateTime}}</div>
            <div class="me-view-author">
                <a class="me-view-author">
                    <el-avatar class="me-view-picture" :src="account.account_head"></el-avatar>
                </a>

                <div class="me-view-info">
                    <span>{{account.account_name}}</span>
                    <div class="me-view-meta">
                        <span>{{article.createDate | format}}</span>
                        <span>阅读   {{article.articleReadCount}}</span>
                        <span>评论   {{article.commentCounts}}</span>
                    </div>

                </div>
<!--                <el-button-->
<!--                        v-if="this.article.author.id == this.$store.state.id"-->
<!--                        @click="editArticle()"-->
<!--                        style="position: absolute;left: 60%;"-->
<!--                        size="mini"-->
<!--                        round-->
<!--                        icon="el-icon-edit">编辑</el-button>-->
            </div>
            <el-divider></el-divider>
            <div class="me-view-container" >
                {{article.articleDetail}}
<!--                <markdown-editor :editor=article.editor></markdown-editor>-->
            </div>

            <div class="me-view-end">
                <el-alert
                        title="文章End..."
                        type="success"
                        center
                        :closable="false">
                </el-alert>
            </div>

<!--            <div class="me-view-tag">-->
<!--                标签：-->
<!--                &lt;!&ndash;<el-tag v-for="t in article.tags" :key="t.id" class="me-view-tag-item" size="mini" type="success">{{t.tagname}}</el-tag>&ndash;&gt;-->
<!--                <el-button @click="tagOrCategory('tag', t.id)" size="mini" type="primary" v-for="t in article.tags" :key="t.id" round plain>{{t.tagname}}</el-button>-->
<!--            </div>-->

<!--            <div class="me-view-tag">-->
<!--                文章分类：-->
<!--                &lt;!&ndash;<span style="font-weight: 600">{{article.category.categoryname}}</span>&ndash;&gt;-->
<!--                <el-button @click="tagOrCategory('category', article.category.id)" size="mini" type="primary" round plain>{{article.category.categoryname}}</el-button>-->
<!--            </div>-->

<!--            <div class="me-view-comment">-->
<!--                <div class="me-view-comment-write">-->
<!--                    <el-row :gutter="20">-->
<!--                        <el-col :span="2">-->
<!--                            <a class="">-->
<!--                                <img class="me-view-picture" :src="avatar">-->
<!--                            </a>-->
<!--                        </el-col>-->
<!--                        <el-col :span="22">-->
<!--                            <el-input-->
<!--                                    type="textarea"-->
<!--                                    :autosize="{ minRows: 2}"-->
<!--                                    placeholder="你的评论..."-->
<!--                                    class="me-view-comment-text"-->
<!--                                    v-model="comment.content"-->
<!--                                    resize="none">-->
<!--                            </el-input>-->
<!--                        </el-col>-->
<!--                    </el-row>-->

<!--                    <el-row :gutter="20">-->
<!--                        <el-col :span="2" :offset="22">-->
<!--                            <el-button type="text" @click="publishComment()">评论</el-button>-->
<!--                        </el-col>-->
<!--                    </el-row>-->
<!--                </div>-->

<!--                <div class="me-view-comment-title">-->
<!--                    <span>{{article.commentCounts}} 条评论</span>-->
<!--                </div>-->

<!--                <commment-item-->
<!--                        v-for="(c,index) in comments"-->
<!--                        :comment="c"-->
<!--                        :articleId="article.id"-->
<!--                        :index="index"-->
<!--                        :rootCommentCounts="comments.length"-->
<!--                        @commentCountsIncrement="commentCountsIncrement"-->
<!--                        :key="c.id">-->
<!--                </commment-item>-->

<!--            </div>-->

        </div>
    </el-main>

</div>
</template>

<script>
    import PageHeader from "../../../components/detail/PageHeader";
    export default {
        name: "Article",

        watch: {
            '$route': function (to, from) {
                // console.log(to)
                // console.log(from)
                // 我这里还是用了Vuex，不过应该不影响理解
                this.$store.dispatch('updateActiveTemplateId', this.$route.params.templateId)
                // 通过更新Vuex中的store的数据，让数据发生变化
                this.init()
            }
        },
        created() {
            this.init();
        },

        methods:{

          init(){

            this.$api.article.articleDetail(this.$route.params.id)
              .then((response)=>{
                  this.article = response.data.data.article;
                  this.account = response.data.data.account;
                  this.labels = response.data.data.labels;
              })
              .catch((error)=>{
              })
          },

        },
        components:{
          PageHeader,
        },
        data() {
            return {

                "article": {
                    "id": 1,
                    "articleReadCount": 9,
                    "articleCreateTime": "2020-12-03 07:56:01",
                    "articleTitle": "nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et",
                    "articlePicture": "https://source.unsplash.com/random/900x300",
                    "accountId": 1,
                    "articleDetail": "nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas.",
                    "articleDetailType": 0
                },
                "account": {
                    "account_head": "https://source.unsplash.com/user/erondu/100x100",
                    "account_name": "Wendy Wilkinson"
                },
                "labels": [
                    {
                        "id": 38,
                        "label_name": "生活"
                    }
                ],
                comments: [],
                comment: {
                    article: {},
                    content: ''
                }
            }
        },
    }
</script>

<style scoped>
    .me-view-body {
        margin: 100px auto 140px;
    }
    .me-view-time{
        float: right;
    }
    .me-view-container {
        margin-top: 50px;
        width: 700px;
    }

    .el-main {
        overflow: hidden;
    }

    .me-view-title {
        font-size: 34px;
        font-weight: 700;
        line-height: 1.3;
    }

    .me-view-author {
        /*margin: 30px 0;*/
        margin-top: 30px;
        vertical-align: middle;
    }

    .me-view-picture {
        width: 40px;
        height: 40px;
        border: 1px solid #ddd;
        border-radius: 50%;
        vertical-align: middle;
        background-color: #5fb878;
    }

    .me-view-info {
        display: inline-block;
        vertical-align: middle;
        margin-left: 8px;
    }

    .me-view-meta {
        font-size: 12px;
        color: #969696;
    }

    .me-view-end {
        margin-top: 20px;
    }

    .me-view-tag {
        margin-top: 20px;
        padding-left: 6px;
        border-left: 4px solid #c5cac3;
    }

    .me-view-tag-item {
        margin: 0 4px;
    }

    .me-view-comment {
        margin-top: 60px;
    }

    .me-view-comment-title {
        font-weight: 600;
        border-bottom: 1px solid #f0f0f0;
        padding-bottom: 20px;
    }

    .me-view-comment-write {
        margin-top: 20px;
    }

    .me-view-comment-text {
        font-size: 16px;
    }

    .v-show-content {
        padding: 8px 25px 15px 0px !important;
    }

    .v-note-wrapper .v-note-panel {
        box-shadow: none !important;
    }

    .v-note-wrapper .v-note-panel .v-note-show .v-show-content, .v-note-wrapper .v-note-panel .v-note-show .v-show-content-html {
        background: #fff !important;
    }

</style>