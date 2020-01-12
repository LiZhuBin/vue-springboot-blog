<template>
    <div>

  <el-card class="me-area" :body-style="{ padding: '16px' }" >



    <div class="me-article-header" >

      <a @click="view(id)" class="me-article-title">{{article.articleTitle}}</a>
      <el-button v-if="weight > 0" class="me-article-icon" type="text">置顶</el-button>
      <span class="me-pull-right me-article-count">
	    	<i class="me-icon-comment"></i>&nbsp;{{commentCounts}}
	    </span>
      <span class="me-pull-right me-article-count">
	    	<i class="el-icon-view"></i>&nbsp;{{viewCounts}}
	    </span>
    </div>

<!--        <div class="me-artile-description">-->
<!--          {{article.articleDetail}}-->
<!--        </div>-->

            <el-image v-bind:src="article.articlePicture"></el-image>
            <span class="me-article-author">
                <i class="me-icon-author"></i>&nbsp;{{article.id}}
            </span>

<!--          <el-tag v-for="t in tags" :key="t.tagname" size="mini" type="success">{{t.tagname}}</el-tag>-->

<!--          <span class="me-pull-right me-article-count">-->
<!--                <i class="el-icon-time"></i>&nbsp;{{createDate | format}}-->
<!--            </span>-->





  </el-card>


    </div>
</template>

<script>


  export default {
    name: 'ArticleItem',
    props: {
        "article":
            {
                "id": 1,
                "articleDetail": "nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas.",
                "labelId": 7,
                "articleReadCount": 9,
                "articleCreateTime": "2020-12-03 07:56:01",
                "articleTitle": "nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et",
                "articlePicture": "https://source.unsplash.com/user/jackie/likes/1600x900",
                "articleDetailType": 0,
                "accountId": 1
            }
    },
    data() {
      return {

      }
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

  .me-artile-description {
    font-size: 13px;
    line-height: 24px;
    margin-bottom: 10px;
  }

  .me-article-author {
    color: #a6a6a6;
    padding-right: 18px;
    font-size: 13px;
  }

  .el-tag {
    margin-left: 6px;
  }

</style>
