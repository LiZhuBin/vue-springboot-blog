<template>
    <el-card :body-style="{ padding: '8px 18px' }">
        <el-collapse  >
            <el-collapse-item title="图片" name="1"    >
              <div v-for="image in resource.images">
                <el-link @click="go('images',image)">
                  {{image}}
                </el-link>
                <!--                <div>{{image.name}}</div>-->
              </div>

            </el-collapse-item>
            <el-collapse-item title="视频" name="2"   >
              <div v-for="video in resource.videos">
                <el-link @click="go('videos',video)">
                    {{video}}
                </el-link>
              </div>
            </el-collapse-item>
            <el-collapse-item title="文件" name="3"   >
              <div v-for="file in resource.files">
                <el-link @click="go('files',file)">
                    {{file}}
                </el-link>
              </div>
            </el-collapse-item>

        </el-collapse>




        <div slot="header" class="me-category-header">
            <span>{{cardHeader}}</span>
        </div>


    </el-card>
</template>

<script>
    export default {
        name: "CardResource",
        props:{

        },
        created() {

        },
      mounted() {
          this.init();
      },
      data(){
            return{
                resource:{},
                cardHeader:"资源",
            }
        },
        methods:{
            go(way,classify){
                this.$router.push('/blog/home/resources/'+way+'/'+classify);
            },
          init(){
              this.$api.resource.classifies({'accountId':this.$store.state.accountData.id})
            .then((response)=>{
              this.resource = response.data.data;
            })
            .catch((error)=>{

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
