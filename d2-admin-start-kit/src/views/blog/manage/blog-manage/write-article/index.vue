<template>
<div>
        <PageHeader header-name="写博客"></PageHeader>
    <el-card>
        <el-form ref="form"  label-width="80px" prop="name"  >
            <el-form-item label="标题">
                <el-input v-model="textContent" ></el-input>
            </el-form-item>
            <el-form-item label="标签">
                <TagSelect ref="tag"></TagSelect>
            </el-form-item>
          <el-form-item label="分类">
            <el-select v-model="classify_value" clearable placeholder="请选择">
              <el-option
                v-for="c in classifies"
                :key="c"
                :label="c"
                :value="c">
              </el-option>
            </el-select>
          </el-form-item>
            <el-form-item label="内容">
                <el-tabs :tab-position="tabPosition"  v-model="type_select">
                    <el-tab-pane label="markdown" name="0">、
                        <mavon-editor :ishljs = "true" v-model="articleContent0"></mavon-editor>
                    </el-tab-pane>
                    <el-tab-pane label="富文本" name="1" >
                        <Tinymce v-model="articleContent1"></Tinymce>
                    </el-tab-pane>

                </el-tabs>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">立即创建</el-button>
                <el-button @click="resetForm('form')">重置</el-button>
            </el-form-item>
        </el-form>




    </el-card>
</div>
</template>

<script>
        import PageHeader from "../../../../../components/detail/PageHeader";
        import Tinymce from "../../../../../components/Tinymce/index"
        import TagSelect from "./TagSelect";
    export default {
        name: "WriteArticle",
        components:{
            PageHeader,
            Tinymce,
            TagSelect
        },
        data(){
            return{
                classify_value:'',
                tabPosition: 'top',
                classifies:[],
                textType:0 ,//0 -markdown;1 -富文体
                textContent:'',
                type_select:0,
                articleContent0:'',
                articleContent1:'',
            }
        },
      mounted() {
          this.init();
      },
      methods:{
          init(){

            this.$api.article.classifies(this.$store.state.accountData.id)
            .then((response)=>{
              this.classifies = response.data.data;
            })
            .catch((error)=>{
              alert(error)
            })

          },

            submitForm(formName) {

              var content;
              if(this.type_select==1){
                content = this.articleContent1;
              }else{
                content = this.articleContent0;
              }
              let param = {
                "accountId": this.$store.state.accountData.id,
                "articleTitle":this.textContent,
                "articleClassify":this.classify_value,
                "articleDetailType":this.type_select,
                "articleDetail":content
              };

              this.$http({
                method: 'post',
                url: 'articles' ,
                data: this.$qs.stringify({accountId: 3})
              })
                .then((response) => {
                  this.articles = response.data.data;
                  alert(this.articles)
                })
                .catch((error) => {
                  alert(error)
                })

            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>
