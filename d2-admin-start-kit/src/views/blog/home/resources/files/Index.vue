<template>
  <div>

    <page-header :header-name="this.$route.params.description"></page-header>

    <div class="demo-image__lazy">

      <div v-for="group in imgGroups" :key="group.id" >

        <a href="https://bingos-1258635419.cos.ap-guangzhou.myqcloud.com/vue_springboot_blog/1/files/test/word/test-word1.doc" target="_blank" rel="nofollow">{{group.name}}</a>




      </div>
    </div>
  </div>
</template>

<script>
  import PageHeader from "../../../../../components/detail/PageHeader";
  import VideoPlayer from "../../../../../components/video/VideoPlayer";
  export default {
    name: "Index",
    data(){
      return{
        imgGroups:[],

      }
    },
    props:{

    },
    mounted() {
      this.init();
    },
    components:{
      PageHeader,
      VideoPlayer
    },
    methods:{

      init(){
        this.$api.resource.byDescription("file",this.$route.params.classify,this.$route.params.description,{'accountId':this.$store.state.accountData.id})
          .then((response)=>{

            this.imgGroups= response.data.data;
          })
          .catch((error)=>{
            alert(error)
          })

      },

      //下载模板
      downloadTemplate(){
        this.axios.get('/QuestionBank/templateDownload',{responseType: 'blob'}).then((data)=>{
          console.log(data)
          let blob = new Blob([data.data],{ type: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document;charset=utf-8'});
          let objectUrl = URL.createObjectURL(blob);
          window.location.href = objectUrl;
        })
      }
    }
  }

</script>

<style scoped>

</style>
