export default {
  state: {
    userMessage: {
      userId: 1,
      name: "脆脆鲨",
      avatar:
        "https://cd-mapbed.oss-cn-beijing.aliyuncs.com/1_qq_30199527.jpg", 
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
