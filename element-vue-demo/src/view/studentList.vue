<template>
    <div>
        <div class="add-box">
          <el-button @click="jumpToAddPage()" type="primary" size="small" icon="el-icon-circle-plus-outline">新增</el-button>
          <el-button @click="jumpTocheckPage()" type="primary" icon="el-icon-search" size="small">id查询</el-button>
          <el-input v-model="checkname" placeholder="请输入姓名" style="width:200px" maxlength="4" show-word-limit @keydown.enter.native="passname(checkname)"></el-input>
        </div>
         
          <el-table :data="currrentstudent" border="1" stripe   height="550px">

            <el-table-column fixed="" prop="id" label="ID" width="100"/>
            <el-table-column prop="name" label="姓名" width="100"/>
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
         

          <el-table-column  label="头像上传" width="100"> 
              <template slot-scope="scope">                
                
                <el-button type="primary" plain="" @click="passimgid(scope.row.id)" size="small" icon="el-icon-edit">上传</el-button>
               
                
              </template>
          </el-table-column>

           <el-table-column  label="简历上传" width="100"> 
              <template slot-scope="scope">                
                
                <el-button type="primary" plain="" @click="passurlid(scope.row.id)" size="small" icon="el-icon-edit">上传</el-button>
               
                
              </template>
          </el-table-column>
         
          <el-table-column  label="下载" width="100">
             <template slot-scope="scope" v-if="scope.row.fileUrl">                
                
                 <el-button type="primary" plain="" @click="download(scope.row.fileUrl)" size="small" icon="el-icon-edit">下载</el-button>
               
              </template>
          </el-table-column>
        </el-table>

         <el-pagination
          background
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentpage"
            :page-sizes="[1, 2, 4, 8]"
            :page-size="pagesize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="students.length">
          </el-pagination>
    </div>
</template>
<script>
import {formatDate} from '@/view/date.js'
export default {
  data() {
    return {
      checkname:"",
      currentpage:1,
      pagesize:4,
      students: [],
      currrentstudent:[],
     
    }
  },
  methods: {
      handleSizeChange(val) {
        this.pagesize=val;
       this.getcurrentstudent();
      },
      handleCurrentChange(val) {
        
        this.currentpage=val;
        this.getcurrentstudent();
      },
      getcurrentstudent()
      {
        var begin=this.currentpage*this.pagesize-this.pagesize;
        var end=this.currentpage*this.pagesize-1;
        var temp=[];
        if(end>=this.students.length)
        {
          for(var i=begin;i<this.students.length;i++)
            {
              temp.push(this.students[i])
            } 
            
        }
        else
        {
          for(var i=begin;i<=end;i++)
            {
              temp.push(this.students[i])
            } 
           
        }
         this.currrentstudent=temp;
        
      },
    getAllStudent(){
      this.$axios.get("api/student/findAllStudents")
      .then(res => {
          this.students = res.data;
          this.getcurrentstudent();
      })
      .catch(err => {
          console.log(err);
      });
    },

   deleteStudent(id){
      this.$axios
        .get('api/student/deletebyid?id='+id)
        .then(res => {
             this.getAllStudent()
          alert("删除成功")
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
     passurlid(id) {
       this.$router.push({name: 'uploadfile', params: {id:id}})
    },
     passimgid(id) {
       this.$router.push({name: 'uploadimg', params: {id:id}})
    },
    passname(name) {
       this.$router.push({name: 'byname', params: {name:name}})
    },
    download(url)
    {
      window.location.href=url;
      
    }
      
    
     
  },
  mounted() {
    this.getAllStudent()
   
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