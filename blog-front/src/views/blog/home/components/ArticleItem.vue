<template>
    <div>

  <el-card class="me-area" :body-style="{ padding: '16px' }" >



    <div class="me-article-header" >

      <a @click="view(id)" class="me-article-title">{{article.article_title}}</a>
      <el-button v-if="weight > 0" class="me-article-icon" type="text">置顶</el-button>
      <span class="me-pull-right me-article-count">
	    	<i class="me-icon-comment"></i>&nbsp;{{commentCounts}}
	    </span>
      <span class="me-pull-right me-article-count">
	    	<i class="el-icon-view"></i>&nbsp;{{viewCounts}}
	    </span>
    </div>



            <el-image v-bind:src="article.article_picture"></el-image>


          <el-tag v-for="t in tags" :key="t.tagname" size="mini" type="success">{{t.tagname}}</el-tag>

          <div>

              <el-avatar  :size="50" :src="article.account_head" ></el-avatar>

                <i class="el-icon-time">{{article.article_create_time }}</i>&nbsp;
            </div>





  </el-card>


    </div>
</template>

<script>


  export default {
    name: 'ArticleItem',
    props: {
        "article":
            {
                "article_title": "nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et",
                "account_head": "https://source.unsplash.com/user/erondu/100x100",
                "article_detail": "nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas.",
                "article_create_time": "2020-12-03 07:56:01",
                "account_id": 1,
                "article_detail_type": 0,
                "label_id": 7,
                "id": 1,
                "article_picture": "https://source.unsplash.com/random/900x300",
                "article_read_count": 9,
                "account_name": "Wendy Wilkinson"
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
      height: 20px;
  }

  .el-tag {
    margin-left: 6px;
  }

</style>
