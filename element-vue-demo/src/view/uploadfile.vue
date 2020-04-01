<template>
<div>
  <el-upload
  class="upload-demo"
  action="http://127.0.0.1:8080/file/upload2"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
   :on-success="handleAvatarSuccess"
  :before-remove="beforeRemove"
  multiple
  :limit="3"
  :on-exceed="handleExceed"
  :file-list="fileList"
  :show-file-list="true">
  <el-button size="small" type="primary">点击上传</el-button>
  
</el-upload>

</div>
</template>
<script>
  export default {
    data() {
      return {
        fileList: {},
         FileUrl: '',
      };
    },
    methods: {
       handleAvatarSuccess(res, file) {
        this.FileUrl = URL.createObjectURL(file.raw);
        alert(this.FileUrl)
        this.uploadfileurl(this.$route.params.id,this.FileUrl)
    },
   uploadfileurl(id,fileurl){
      this.$axios.get("api/student/uploadfileurl?id="+id+"&&FileUrl="+fileurl)
      .then(res => {        
        this.getAllStudent()
      })
      .catch(err => {
          console.log(err);
      });
    },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        alert("?")
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      }
    }
  }
</script>