export default {
  state: {
    userMessage: {
      id: -1,
      name: "",
      avatar:
        "", 
    },
  },
  mutations: {
    changeInfo(state, val) {
      state.userMessage = val;
    },
  },
  actions: {},
  namespaced: true,
};
