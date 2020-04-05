<template>
  <div>

    <page-header :header-name="this.$route.params.description"></page-header>

    <div class="demo-image__lazy">
      <div v-for="group in imgGroups" :key="group.id" >
        <VideoPlayer :url=group.url></VideoPlayer>
        <div>


      </div>
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
        this.$api.resource.byDescription("video",this.$route.params.classify,this.$route.params.description,{'accountId':this.$store.state.accountData.id})
          .then((response)=>{

            this.imgGroups= response.data.data;
          })
          .catch((error)=>{
          alert(error)
          })

      },


    }
  }

</script>

<style scoped>

</style>
