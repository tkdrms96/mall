export default {
  state: {
    orderItem: {},
    product: {},
  },
  getters: {
    getOrderItem(state) {
      return state.orderItem;
    },
    getProduct(state) {
      return state.product;
    },
  },
  mutations: {
    updateOrderItem(state, payload) {
      return (state.orderItem = payload);
    },
    updateProduct(state, payload) {
      return (state.product = payload);
    },
  },
  actions: {},
};
