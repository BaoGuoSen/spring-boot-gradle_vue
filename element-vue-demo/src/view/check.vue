<template>
  <el-form ref="studentForm" :model="studentForm" :rules="rules" label-width="100px" style="width:300px;margin-left:40%">
    
    <el-upload
  class="avatar-uploader"
  action="http://127.0.0.1:8080/file/upload2"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload">
  <img v-if="imageUrl" :src="imageUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
  </el-upload>

     <el-form-item label="ID" prop="id">
      <el-input v-model="studentForm.id" placeholder="请输入要查询的id" style="width:240px;" ></el-input>
    </el-form-item>
    
    <el-form-item label="姓名">
      <el-input v-model="studentForm.name" style="width:240px;" disabled></el-input>
    </el-form-item>

    <el-form-item label="性别">
      <el-select v-model="studentForm.sex" style="width:240px;" disabled>
        <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="年级">
      <el-input-number v-model="studentForm.grade" style="width:240px;" disabled></el-input-number>
    </el-form-item>

    <el-form-item label="学院">
      <el-select v-model="studentForm.school" style="width:240px;" disabled>
        <el-option label="人工智能学院" value="人工智能学院"></el-option>
        <el-option label="管理学院" value="管理学院"></el-option>
      </el-select>
    </el-form-item>

     <el-form-item label="专业">
      <el-input v-model="studentForm.major" style="width:240px;" disabled></el-input>
    </el-form-item>

  <el-form-item label="爱好">
    <el-input v-model="studentForm.hobby" style="width:240px;" disabled></el-input>
    
  </el-form-item>

   <el-form-item label="入学时间">
    <el-date-picker
      v-model="studentForm.date"
      type="date"
      placeholder="选择日期" disabled>
    </el-date-picker>
  </el-form-item>

    <el-form-item>
      <br>
      <el-button type="primary" @click="check(studentForm.id)">查询</el-button>
      <el-button @click="jumpToList()">返回</el-button>
    </el-form-item>

   
  </el-form>
</template>
<script>
export default {
    data() {
    return {
      studentForm: {},
      imageUrl:'',
      rules: {
          id: [
            { required: true, message: '请输入ID', trigger: 'blur' },
            { min: 3, max: 3, message: '长度为 3 个字符', trigger: 'blur' }
          ],
        }
      };
  },    
  methods: {
    submit(id) {
      this.check(id)
    },
   
    jumpToList() {
      this.$router.push('/student/studentList')
    },
   check(id) {
    
      this.$axios
        .get('api/student/findbyid?id='+id)
        .then(res => {
          this.studentForm=res.data
          this.imageUrl=this.studentForm.imgUrl
         
      })
      .catch(err => {
        alert("查找失败");
        console.log(err);
      });
    },
},
}
</script>
<style scoped>
.add-box{
    padding-left:20px;
    padding-top:20px;
    display: inline;
}

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