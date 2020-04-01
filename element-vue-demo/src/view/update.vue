<template>
  <el-form ref="studentForm" :model="studentForm"  label-width="100px" style="width:300px;margin-left:40%">
  
     <el-form-item label="ID">
      <el-input v-model="studentForm.id" style="width:240px;" disabled></el-input>
    </el-form-item>

    <el-form-item label="姓名">
      <el-input v-model="studentForm.name" style="width:240px;" ></el-input>
    </el-form-item>

    <el-form-item label="性别">
      <el-select v-model="studentForm.sex" placeholder="请选性别" style="width:240px;">
        <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="年级">
      <el-input-number v-model="studentForm.grade" style="width:240px;"></el-input-number>
    </el-form-item>

    <el-form-item label="学院">
      <el-select v-model="studentForm.school" placeholder="请选择学院" style="width:240px;">
        <el-option label="人工智能学院" value="人工智能学院"></el-option>
        <el-option label="管理学院" value="管理学院"></el-option>
      </el-select>
    </el-form-item>

     <el-form-item label="专业">
      <el-input v-model="studentForm.major" style="width:240px;" ></el-input>
    </el-form-item>

  <el-form-item label="爱好">
    <el-input v-model="studentForm.hobby" style="width:240px;" ></el-input>
    
  </el-form-item>

<div style="margin-left:20%">
    <el-radio-group v-model="studentForm.hobby" style="width:400px;">
      <el-radio label="足球" border=""></el-radio>
      <el-radio label="篮球" border=""></el-radio>
      <el-radio label="游泳" border=""></el-radio>
    </el-radio-group>
</div>

     <el-form-item label="入学时间">
    <el-date-picker
      v-model="studentForm.date"
      type="date"
      placeholder="选择日期">
    </el-date-picker>
  </el-form-item>
  
    <el-form-item>
      <br>
      <el-button type="primary" @click="submit()">修改</el-button>
      <el-button @click="jumpToList">返回</el-button>
    </el-form-item>
  
   
  </el-form>
</template>
<script>
export default {
    data() {
    return {

      studentForm: {},
      
      };
  },    
  methods: {
    submit() {
      this.update()
    },
     update() {
      this.$axios
        .post('api/student/updatebyid', this.studentForm)
        .then(res => {
    
            this.jumpToList()
            alert("修改成功")
        })
        .catch(err => {
          alert("修改失败");
          console.log(err);
        })
    },
    check(id) {
      this.$axios
        .get("api/student/findbyid?id="+id)
        .then(res => {
          this.studentForm=res.data
      })
      .catch(err => {
        alert("失败");
        console.log(err);
      });
    },
    jumpToList() {
      this.$router.push('/student/studentList')
    }
  },
  mounted() {
    if (this.$route.params.id != undefined) {
      this.check(this.$route.params.id)
    }
}
}
</script>
<style scoped>
.add-box{
    padding-left:20px;
    padding-top:20px;
    display: inline;
}
</style>