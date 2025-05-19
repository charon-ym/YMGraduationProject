import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import news from '@/views/modules/news/list'
import jiaogong from '@/views/modules/jiaogong/list'
import xuesheng from '@/views/modules/xuesheng/list'
import xueshengrudang from '@/views/modules/xueshengrudang/list'
import jiaogongrudang from '@/views/modules/jiaogongrudang/list'
import dangzuzhixinxi from '@/views/modules/dangzuzhixinxi/list'
import erjixueyuan from '@/views/modules/erjixueyuan/list'
import payrecord from '@/views/payrecord'
import transfer from '../views/transfer.vue';
import studyrecord from '../views/studyrecord.vue';
import huodongList from '../views/modules/huodong/huodongList.vue';
import huodongManage from '../views/modules/huodong/huodongManage.vue';
import huodongPulish from '../views/modules/huodong/huodongPulish.vue';


// import { component } from 'vue/types/umd';、


//2.配置路由   注意：名字
const routes = [{
  path: '/index',
  name: '首页',
  component: Index,
  children: [{
    // 这里不设置值，是把main作为默认页面
    path: '/home',
    name: '系统首页',
    component: Home,
    meta: { icon: '', title: 'center' }
  }, {
    path: '/updatePassword',
    name: '修改密码',
    component: UpdatePassword,
    meta: { icon: '', title: 'updatePassword' }
  }, {
    path: '/pay',
    name: '支付',
    component: pay,
    meta: { icon: '', title: 'pay' }
  }, {
    path: '/payrecord',
    name: '支付记录',
    component: payrecord,
    meta: { icon: '', title: 'payrecord' }
  }, {
    path: '/studyrecord',
    name: '学习记录',
    component: studyrecord,
    meta: { icon: '', title: 'studyrecord' }
  },{
    path: '/center',
    name: '个人信息',
    component: center,
    meta: { icon: '', title: 'center' }
  }
    , {
    path: '/news',
    name: '党建宣传',
    component: news
  }
    , {
    path: '/jiaogong',
    name: '教工',
    component: jiaogong
  }
    , {
    path: '/xuesheng',
    name: '学生',
    component: xuesheng
  }
    , {
    path: '/xueshengrudang',
    name: '学生入党',
    component: xueshengrudang
  }
    , {
    path: '/jiaogongrudang',
    name: '教工入党',
    component: jiaogongrudang
  }
    , {
    path: '/dangzuzhixinxi',
    name: '党组织信息',
    component: dangzuzhixinxi
  }
    , {
    path: '/erjixueyuan',
    name: '二级学院',
    component: erjixueyuan
  },
  {
    path: '/transfer',
    name: '关系转接',
    component: transfer
  },
  {
    path:'/huodonglist',
    name:'组织活动',
    component: huodongList
  },
  {
    path:'/huodongmanage',
    name:'组织活动管理',
    component: huodongManage
  },
  {
    path:'/huodongpulish',
    name:'组织活动发布',
    component: huodongPulish
  }
  ]
},
{
  path: '/login',
  name: 'login',
  component: Login,
  meta: { icon: '', title: 'login' }
},
{
  path: '/register',
  name: 'register',
  component: register,
  meta: { icon: '', title: 'register' }
},
{
  path: '/',
  name: '系统首页',
  redirect: '/index'
}, /*默认跳转路由*/
{
  path: '*',
  component: NotFound
}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
export default router;
