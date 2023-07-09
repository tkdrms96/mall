const routerMixin = {
  methods: {
    goToRoute(route, data) {
      this.$router.push({
        path: route,
        query: data,
      });
    },
  },
};

export default routerMixin;
