<template>
  <div >
    <div class="logo">
      <img src="../assets/logo.png" weight="150" height="60"/>
    </div>
    <router-link to='/student/studentList'>
      <div class="list">
            学生管理
      </div>
    </router-link>
  
  

  </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
.logo {
  height: 80px;
}
.list{
    /* margin:10px; */
    height:50px;
    width:100%;
}
.left-menu {
  height: 100%
}
</style>