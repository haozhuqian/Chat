export default {
    state: {
      userChatting:false,
    },
    mutations: {
      changeUserChatting(state, val) {
        state.userMessage = true;
      },
    },
    actions: {},
    namespaced: true,
  };
  