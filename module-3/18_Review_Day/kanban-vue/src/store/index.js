import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage 
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    boards: [],
    activeBoardId: null,
    boardCards: [],
    card: {
      title: '',
      description: '',
      status: '',
      comments: []
    }
  },
  mutations: {
    SET_BOARDS(state, data) {
      state.boards = data;
    },
    SET_ACTIVE_BOARD(state, boardId) {
      state.activeBoardId = boardId;
    },
    SET_BOARD_CARDS(state, data) {
      state.boardCards = data;
    },
    SET_CURRENT_CARD(state, data) {
      state.card = data;
    },
    DELETE_BOARD(state, boardIdToDelete) {
      state.boards = state.boards.filter((board) => {
        return board.id !== boardIdToDelete;
      });
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  },
  actions: {
  },
  modules: {
  }
})
