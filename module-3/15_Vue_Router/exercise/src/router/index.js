import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home'
import MyBooks from '@/views/MyBooks'
import NewBook from '@/views/NewBook'
Vue.use(VueRouter);
// index route thing imports views nigga!!!
const routes = [

  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'MyBooks',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'NewBook',
    component: NewBook
  },

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
