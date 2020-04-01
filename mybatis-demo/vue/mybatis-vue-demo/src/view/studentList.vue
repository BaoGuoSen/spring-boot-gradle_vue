<template>
    <div>
        <div class="add-box">
          <el-button @click="jumpToAddPage()" type="primary" size="small">新增</el-button>
        </div>
        <el-table :data="students" class='table-center'>
          <el-table-column prop="uId" label="ID" width="180"/>
          <el-table-column prop="name" label="姓名" width="180"/>
          <el-table-column prop="sex" label="性别" width="180"/>
          <el-table-column prop="age" label="年龄" width="180"/>
        </el-table>
    </div>
</template>
<script>
export default {
  data() {
    return {
      students: [],
    }
  },
  methods: {
    getAllStudent(){
      this.$axios.get("api/student/findAllStudents")
      .then(res => {
          this.students = res.data;
      })
      .catch(err => {
          console.log(err);
      });
    },
    
    jumpToAddPage() {
      this.$router.push({name: 'studentAddForm', params: {type: 'add'}})
    },
  },
  mounted() {
    this.getAllStudent()
  }
}
</script>
<style scoped>
.add-box{
  float: right;
  margin-right: 200px;
}
.table-center {
  padding-left: 25%;
}
</style>