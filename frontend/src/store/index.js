import { createStore } from "vuex";
import order from "./order";
import user from "./user";

export const store = new createStore({
  modules: {
    order,
    user,
  },
});
