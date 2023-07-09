export default {
  state: {
    user: {},
  },
  getters: {
    getUser(state) {
      return state.user;
    },
    getCustomerId(state) {
      return state.user.customerId;
    },
  },
  mutations: {
    updateUser(state, payload) {
      return (state.user = payload);
    },
  },
  actions: {},
};
