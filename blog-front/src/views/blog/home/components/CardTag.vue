<template>
  <el-card :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-tag-header">
      <span>最热标签</span>

    </div>

    <ul class="me-tag-list">
      <li class="me-tag-item" v-for="t in tags" :key="t.id">
        <!--type="primary"-->
        <el-button @click="tag(t.id)" size="mini" type="primary" round plain>{{t.label_name}}</el-button>
      </li>
    </ul>
  </el-card>

</template>

<script>
  export default {
    name: 'CardTag',
    props: {
      // tags: Array
    },
    data() {
      return {
        tags:[ {
          "id": 38,
          "label_name": "生ff活"
        }]
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init(){
        var data = this.$qs.stringify({way:"account",id:1});
        this.$http({
          url: 'labels',
          data: data,
          method: 'post',

        })
        // this.$api.label.getLabels(this.$qs.stringify(),{
        //   headers:{
        //     'Content-Type':'application/x-www-form-urlencoded'
        //   }
        // })
                .then((response)=>{
                  this.tags = response.data.data;
                })
      },
      tag(id) {
        this.$router.push({path: `/tag/${id}`})


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
