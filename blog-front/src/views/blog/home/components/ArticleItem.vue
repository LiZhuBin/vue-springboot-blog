<template>


    <el-card class="me-area" :body-style="{ padding: '16px' }">


        <div class="me-article-header">

            <a @click="view(id)" class="me-article-title">{{data.article.article_title}}</a>
            <el-button v-if="weight > 0" class="me-article-icon" type="text">置顶</el-button>
            <span class="me-pull-right me-article-count">
	    	<i class="me-icon-comment"></i>&nbsp;{{commentCounts}}
	    </span>
            <span class="me-pull-right me-article-count">
	    	<i class="el-icon-view"></i>&nbsp;{{viewCounts}}
	    </span>
        </div>


        <el-image v-bind:src="data.article.article_picture"></el-image>

        <div class="lables-list">

            <el-tag v-for="label in data.labels" :key="label.id" size="mini" type="success">{{label.label_name}}
            </el-tag>
        </div>
        <div class="article-author">

            <el-avatar  :size="50" :src="data.account.account_head"></el-avatar>
            {{data.account.account_name}}



        </div>

        <i class="article-date">{{data.article.article_create_time }}</i>&nbsp;


    </el-card>


</template>

<script>


    export default {
        name: 'ArticleItem',
        props: {
            data: {
                "account": {
                    "account_head": "https://source.unsplash.com/user/erondu/100x100",
                    "account_name": "Wendy Wilkinson"
                },
                "article": {
                    "article_read_count": 6,
                    "account_id": 1,
                    "article_detail": "vitae erat vel pede blandit congue. In scelerisque scelerisque dui.",
                    "article_create_time": "2020-07-29 08:38:24",
                    "article_detail_type": 1,
                    "article_picture": "https://source.unsplash.com/random/900x300",
                    "id": 5,
                    "article_title": "velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat,"
                },
                "labels": [
                    {
                        "id": 48,
                        "label_name": "生活"
                    },
                    {
                        "id": 70,
                        "label_name": "生活"
                    }
                ]

            }
        },
        data() {
            return {}
        },
        mounted() {

        },
        methods: {

            view(id) {
                this.$router.push({path: `/view/${id}`})
            },

        }
    }
</script>

<style scoped>

    .me-article-header {
        /*padding: 10px 18px;*/
        padding-bottom: 10px;
    }

    .me-article-title {
        font-weight: 600;
    }

    .me-article-icon {
        padding: 3px 8px;
    }

    .me-article-count {
        color: #a6a6a6;
        padding-left: 14px;
        font-size: 13px;

    }

    .me-pull-right {
        float: right;
    }


    .article-author {
        float: left;
    }

    .article-date {
        text-align: right;
        float: right;
    }

    .el-tag {
        margin-left: 10px;

        /*float:right;*/
    }

    .lables-list {
        text-align: right;
    }
</style>
