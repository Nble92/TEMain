import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Board from '../views/Board.vue'
import Card from '../views/Card.vue'
import AddCard from '../views/AddCard.vue'
import EditCard from '../views/EditCard.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/board/:id',
    name: 'Board',
    component: Board
  },
  {
    path: '/board/:boardID/card/:cardID',
    name: 'Card',
    component: Card
  },
  {
    path: '/board/:boardID/card/create',
    name: 'AddCard',
    component: AddCard
  },
  {
    path: '/board/:boardID/card/:cardID/edit',
    name: 'EditCard',
    component: EditCard
  },
  {
    path: "/login",
    name: "login",
    component: Login,
  },
  {
    path: "/logout",
    name: "logout",
    component: Logout,
  },
  {
    path: "/register",
    name: "register",
    component: Register,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
