<template>
  <div>
    <div>上传图片</div>



    <el-form-item label="选择图片">
      <div class="upload">

        <!-- 图片展示 -->
        <div class="cha" v-show="(imgUrl)">
          <!-- 删除icon -->
          <div class="del"><i class="el-icon-delete" @click="delImg"></i></div>
          <img :src="imgUrl">
          <!-- 放大icon -->
          <div class="layer"><i @click="isEnlargeImage = true" class="el-icon-view"></i></div>
        </div>
        <!-- 图片上传控件 -->
        <div class="load" v-show="(!imgUrl)">
          <input type="file" name="" id="form" @change="uploadIMG">
        </div>

        <!-- 图片预览弹框 -->
        <el-dialog :visible.sync="isEnlargeImage" size="large"  :append-to-body="true" top="8%" width="60%">
          <img @click="isEnlargeImage = false" style="width:100%;" :src="imgUrl">
        </el-dialog>

      </div>
    </el-form-item>
  </div>
</template>

<script>
  export default {
    props: ["uploadUrl"],
    data() {
      return {

        picavalue: "",
        imgUrl: null,
        isEnlargeImage: false,

      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      uploadIMG(e) {
        let files = e.target.files || e.dataTransfer.files;
        if (!files.length) return;
        this.picavalue = files[0];
        console.log(this.picavalue.size / 1024);
        if (this.picavalue.size / 1024 > 5000) {
          this.$message({
            message: "图片过大不支持上传",
            type: "warning"
          });
        } else {
          this.imgPreview(this.picavalue);
        }
      },
      //获取图片
      imgPreview(file, callback) {
        let self = this;
        //判断支不支持FileReader
        if (!file || !window.FileReader) return;
        if (/^image/.test(file.type)) {
          //创建一个reader
          let reader = new FileReader();

          //将图片转成base64格式
          reader.readAsDataURL(file);
          //读取成功后的回调
          reader.onloadend = function() {
            let result = this.result;
            let img = new Image();
            img.src = result;
            img.onload = function() {
              let data = self.compress(img);
              self.imgUrl = result;

              let blob = self.dataURItoBlob(data);

              var formData = new FormData();

              formData.append("multipartFile", blob);

              // let config = {
              //   headers: { "Content-Type": "application/json" }
              // };
              // 发送请求;
              this.$http.post('resources/images/个人信息/测试/aaa', {"multipartFile":formData,"accountId":this.$store.state.accountData.id,"way":"images"}, config)
                .then(res => {
                alert("dd")
              })
              .catch((error)=>{
                alert(error)
              });
            };
          };
        }
      },
      // 压缩图片
      compress(img) {
        let canvas = document.createElement("canvas");
        let ctx = canvas.getContext("2d");
        let initSize = img.src.length;
        let width = img.width;
        let height = img.height;
        canvas.width = width;
        canvas.height = height;
        // 铺底色
        ctx.fillStyle = "#fff";
        ctx.fillRect(0, 0, canvas.width, canvas.height);
        ctx.drawImage(img, 0, 0, width, height);

        //进行最小压缩
        let ndata = canvas.toDataURL("image/jpeg", 0.1);
        // console.log("*******压缩后的图片大小*******");
        // console.log(ndata)
        // console.log(ndata.length);
        return ndata;
      },
      // base64转成bolb对象
      dataURItoBlob(base64Data) {
        var byteString;
        if (base64Data.split(",")[0].indexOf("base64") >= 0)
          byteString = atob(base64Data.split(",")[1]);
        else byteString = unescape(base64Data.split(",")[1]);
        var mimeString = base64Data
          .split(",")[0]
          .split(":")[1]
          .split(";")[0];
        var ia = new Uint8Array(byteString.length);
        for (var i = 0; i < byteString.length; i++) {
          ia[i] = byteString.charCodeAt(i);
        }
        return new Blob([ia], { type: mimeString });
      },
      //删除事件
      delImg() {
        this.imgUrl = null;
      }
    }
  };
</script>

<style scoped>
  .upload {
    position: relative;
    width: 200px;
    height: 220px
  }
     .cha {
       position: absolute;
       top: 0;
       left: 0;
       width: 100%;
       height: 100%;
       border-radius: 6px;
       border: 1px dashed #cccccc;
       overflow: hidden;
       box-sizing: border-box
     }
  .layer {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 2;
    width: 100%;
    height: 200px;
    background-color: rgba(0, 0, 0, 0.3);
    text-align: center;
    line-height: 200px;
    opacity: 0;
    color: #ffffff;
    border: none;
  }
  .del {
    position: absolute;
    bottom: 0;
    right: 0;
    opacity: 0;
    z-index: 2;
    border: none;
  }
  img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 200px;
    border: none;
  }

    .cha:hover .layer,
    .cha:hover .del {
      opacity: 1;
    }

    .load {
      position: absolute;
      top: 0;
      left: 0;
      width: 200px;
      height: 200px;
      border: 1px dashed #cccccc
    }
  input {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    opacity: 0;
  }

  .load::before {
    content: "";
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translateY(-50%);
    width: 1px;
    height: 80%;
    border-right: 1px solid #cccccc;
  }
  .load:after {
    content: "";
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translateX(-50%);
    width: 80%;
    height: 1px;
    border-top: 1px solid #cccccc;
  }

</style>
