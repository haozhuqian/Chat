export default {
  state: {
    Me: {
      id: -1,
      name: "",
      avatar:
        "", 
    },
  },
  mutations: {
    setMe(state, val) {
      state.Me = val;
    },
  },
  actions: {},
  namespaced: true,
};
