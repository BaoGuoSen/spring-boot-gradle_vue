import Vue from 'vue'
import App from '../App'
import Router from 'vue-router'
import studentList from '@/view/studentList'
import studentForm from '@/view/studentForm'
import HelloWorld from '@/components/HelloWorld'
import check from '@/view/check'
import update from '@/view/update'
import byname from '@/view/byname'
import uploadimg from '@/view/uploadimg'
import uploadfile from '@/view/uploadfile'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/index',
      name: 'HelloWorld',
      component: HelloWorld,
    },
    {
      path: '/student/studentList',
      name: 'studentList',
      component: studentList
    },
    {
      path: '/student/studentForm/:type',
      name: 'studentAddForm',
      component: studentForm
    },
    {
      path: '/student/check',
      name: 'check',
      component: check
    },
    {
      path: '/student/update/:id',
      name: 'update',
      component: update
    },
    {
      path: '/student/byname/:name',
      name: 'byname',
      component: byname
    },
    {
      path: '/img/upload/:id',
      name: 'uploadimg',
      component: uploadimg
    },
    {
      path: '/file/upload/:id',
      name: 'uploadfile',
      component: uploadfile
    },
  ]
})
