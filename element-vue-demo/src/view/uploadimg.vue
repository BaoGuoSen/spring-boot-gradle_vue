
<template>
  <el-upload
  class="avatar-uploader"
  action="http://127.0.0.1:8080/file/upload"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload">
  <img v-if="imgeUrl" :src="imgeUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
</el-upload>
</template>
<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #9c5900;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>

<script>
  export default {
    data() {
      return {
        imgeUrl: ''
      };
    },
    methods: {
       handleAvatarSuccess(res, file) {
        this.imgeUrl = URL.createObjectURL(file.raw);
        
        alert(this.imgeUrl)
        this.uploadimgurl(this.$route.params.id,this.imgeUrl)
    },
   uploadimgurl(id,imgeurl){
      this.$axios.get("api/student/uploadimgurl?id="+id+"&&ImgUrl="+imgeurl)
      .then(res => {        
        
      })
      .catch(err => {
          console.log(err);
      });
    },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
    }
  }
</script>