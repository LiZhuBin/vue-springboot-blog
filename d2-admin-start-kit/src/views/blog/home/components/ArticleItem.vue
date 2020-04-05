<template>


    <el-card class="me-article-card" :body-style="{ padding: '16px' }" >

    <div @click="view(article.id)" >
        <div class="me-article-header" >

            <a  class="me-article-title" >{{article.articleTitle}}</a>

            <span class="me-pull-right me-article-count">
	    	<i class="me-icon-comment"></i>&nbsp;
	    </span>
            <span class="me-pull-right me-article-count">
	    	<i class="el-icon-view"></i>&nbsp;{{article.articleReadCount}}
	    </span>
        </div>


        <el-image v-bind:src="article.articlePicture" ></el-image>

        <div class="lables-list">

            <el-tag v-for="label in labels" :key="label" size="mini" type="success">{{label}}
            </el-tag>
        </div>
        <div class="article-author">

            <el-avatar  :size="40" :src="account.accountHead"></el-avatar>
            {{account.accountName}}



        </div>


        <i class="article-date">{{article.articleCreateTime }}</i>&nbsp;

    </div>
    </el-card>


</template>

<script>



    export default {
        name: 'ArticleItem',
        props: {

            "article": {
                "accountId": 1,
                "articleTitle": "urna convallis erat, eget tincidunt dui augue eu tellus. Phasellus",
                "articleCreateTime": "2020-02-23 03:09:51",
                "articleReadCount": 14,
                "articleDetailType": 1,
                "articlePicture": "https://images.unsplash.com/photo-1578559882096-8db60729f4b6?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=300&ixlib=rb-1.2.1&q=80&w=900",
                "id": 2,
                "articleDetail": "molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est,"
            },
            "account": {
                "accountCompany": "A Company",
                "accountBirthDate": "2019-01-08 01:51:53",
                "accountName": "彬",
                "accountSign": "我的标签我做主",
                "accountHead": "https://images.unsplash.com/photo-1578539046812-74308e093283?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=400&ixlib=rb-1.2.1&q=80&w=400",
                "communicationId": 1,
                "accountSite": "Gonnosnò",
                "id": 1,
                "accountPassword": "NOL53HNU8LZ",
                "accountCreateDate": "2019-03-01 01:07:17"
            },
            "labels": [

            ],
        },
        data() {
            return {}
        },
        mounted() {

        },
        methods: {

            view(id) {
                this.$router.push({path: `/blog/home/article/${id}`})
            },

        }
    }
</script>

<style scoped>
    .me-article-card{
        height: 300px;
        padding-bottom: 10px;
    }
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
    .bottom{
      position:absolute;
      bottom:0;
      width:100%;
      height:30px;
      line-height:30px;
      background-color: rgba(200,200,200,0.4);
    }
</style>
