export default {
  state: {
    chatUser: {
      
    },
  },
  mutations: {
    changeUser(state, val) {
      state.chatUser = val;
    },
  },
  actions: {},
  namespaced: true,
};
