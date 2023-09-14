import { createStore } from 'vuex'

export default createStore({
  state: {
    loggedIn: false, // 初始状态为未登录
    userid: '', // 用户名属性，用于存储登录用户的账号
  },
  getters: {
  },
  mutations: {
    login(state, userid) {
      state.loggedIn = true;
      state.userid = userid; // 存储登录用户的账号
    },
    logout(state) {
      state.loggedIn = false;
      state.userid = ''; // 清除用户账号信息
    },
  },
  actions: {
  },
  modules: {
  }
})
