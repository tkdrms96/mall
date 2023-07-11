export default {
  state: {
    orderItem: {},
    product: {},
    option: [],
  },
  getters: {
    getOrderItem(state) {
      return state.orderItem;
    },
    getProduct(state) {
      return state.product;
    },
    getOption(state) {
      return state.option;
    },
  },
  mutations: {
    updateOrderItem(state, payload) {
      return (state.orderItem = payload);
    },
    updateProduct(state, payload) {
      return (state.product = payload);
    },
    updateOption(state, payload) {
      return (state.option = payload);
    }
  },
  actions: {},
};
