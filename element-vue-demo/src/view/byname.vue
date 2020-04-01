<template>  
<div>       
        <div class="add-box">
          <el-button @click="jumpToList()" type="info" size="small" >返回</el-button>
        </div>

          <el-table :data="students" border="1" stripe   height="550px">

            <el-table-column fixed="" prop="id" label="ID" width="180"/>
            <el-table-column prop="name" label="姓名" width="180"/>
            <el-table-column prop="sex" label="性别" width="100"/>       
            <el-table-column prop="grade" label="年级" width="100"/>   
            <el-table-column prop="school" label="学院" width="180"/>
            <el-table-column prop="major" label="专业" width="180"/>
            <el-table-column prop="hobby" label="爱好" width="180"/>
            <el-table-column  label="操作" width="200"> 
              <template slot-scope="scope">                
                <el-button type="primary" plain="" @click="passid(scope.row.id)" size="small" icon="el-icon-edit">编辑</el-button>
                <el-button type="danger" plain="" @click="deleteStudent(scope.row.id)" size="small" icon="el-icon-delete">删除</el-button>
              </template>
          </el-table-column>
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
    jumpToList() {
      this.$router.push('/student/studentList')
    },
    findbyname(name)
    {
        
         this.$axios
        .get('api/student/findbyname?name='+name)
        .then(res => {
          this.students=res.data
      })
      .catch(err => {
        alert("查找失败");
        console.log(err);
      });
    },
   deleteStudent(id){
      this.$axios
        .get('api/student/deletebyid?id='+id)
        .then(res => {
          alert("删除成功")
          this.jumpToList();
      })
      .catch(err => {
          alert("删除失败")
          console.log(err);
      });
    },
    jumpToAddPage() {
      this.$router.push({name: 'studentAddForm', params: {type: 'add'}})
    },
    jumpTocheckPage() {
      this.$router.push({name: 'check'})
    },
    passid(id) {
       this.$router.push({name: 'update', params: {id:id}})
    },
  },
  mounted() {
    if (this.$route.params.name != undefined) {
      this.findbyname(this.$route.params.name)
    }
  }
}
</script>
<style scoped>
.add-box{
  float: left;
  margin-right: 20px;
}
.table-center {
  padding-left: 15%;
}
</style>