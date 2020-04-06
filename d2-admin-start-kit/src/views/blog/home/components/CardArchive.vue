<template>

  <el-card :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-category-header">
      {{headName}}
    </div>

    <ul class="me-category-list">
      <li v-for="a in articleDate" @click="view(a.year, a.month)"  class="me-category-item"><a>{{`${a.year}年${a.month}月`}}</a>
      </li>
    </ul>
  </el-card>

</template>

<script>
  export default {
    name: "CardArchive",

    data(){
      return{
        headName:"时间 ",
        articleDate:[]
      }
    },
  mounted() {
      this.init()
  },
    methods: {
      view(year, month) {
        this.$router.push({path: `/blog/home/archive/${year}/${month}`})
      },


    init(){
        this.$api.archive.archives(this.$store.state.accountData.id)
      .then((response)=>{
        this.articleDate = response.data.data
      })
    }
    }
  }
</script>

<style scoped>

  .me-category-header {
    font-weight: 600;
  }

  .me-category-list {
    list-style-type: none;
  }

  .me-category-item {
    display: inline-block;
    width: 40%;
    padding: 4px;
    font-size: 14px;
    color: #5FB878;
  }

  .me-category-item a:hover {
    text-decoration: underline;
  }

</style>
