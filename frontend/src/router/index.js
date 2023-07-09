import { createRouter, createWebHistory } from "vue-router";
import ProductList from "../views/product/ProductList.vue";
import ProductDetail from "../views/product/ProductDetail.vue";
import OrderPayment from "../views/order/OrderPayment.vue";
import OrderResult from "../views/order/OrderResult.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      redirect: "/products",
    },
    {
      path: "/products",
      name: "productList",
      component: ProductList,
    },
    {
      path: "/product/:productId",
      name: "productDetail",
      component: ProductDetail,
    },
    {
      path: "/order/payment",
      name: "orderPayment",
      component: OrderPayment,
      props: true,
    },
    {
      path: "/order/result",
      name: "orderResult",
      component: OrderResult,
      props: true,
    },
  ],
});

export default router;
