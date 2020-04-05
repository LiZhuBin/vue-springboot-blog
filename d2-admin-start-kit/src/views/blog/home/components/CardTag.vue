<template>
  <el-card :body-style="{ padding: '8px 18px' }">

    <div slot="header" class="me-tag-header">
      <span>最热标签</span>

    </div>

    <ul class="me-tag-list">
      <li class="me-tag-item" v-for="t in tags" :key="t.name">
        <!--type="primary"-->
        <el-button @click="tag(t)" size="mini" type="primary" round plain>{{t}}</el-button>
      </li>
    </ul>
  </el-card>

</template>

<script>
  export default {
    name: 'CardTag',
    props: {
      tags: Array
    },
    data() {
      return {

      }
    },
    mounted() {

    },
    methods: {

        // this.$api.label.getLabels(this.$qs.stringify(),{
        //   headers:{
        //     'Content-Type':'application/x-www-form-urlencoded'
        //   }
        // })

      tag(name) {

        this.$router.push({path: `/blog/home/label/${name}`})


      }}
  }
</script>

<style scoped>

  .me-tag-header {
    font-weight: 600;
  }

  .me-tag-more {
    font-size: 14px;
    color: #78b6f7;
  }

  .me-tag-list {
    list-style-type: none;
  }

  .me-tag-item {
    display: inline-block;
    padding: 4px;
    font-size: 14px;
    color: #5FB878;
  }

  .me-tag-item a:hover {
    text-decoration: underline;
  }
</style>
