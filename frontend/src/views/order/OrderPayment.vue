<template>
  <div class="section_body grid_col_3">
    <div class="section_content">
      <div class="content_top">
        <h1>주문/결제</h1>
      </div>
      <div class="content_body">
        <Shipment ref="shipment" />
        <OrderRequester />
        <OrderItem ref="orderItem" @syncUpdate="updateOrderItem" />
        <Payment ref="payment" />
      </div>
    </div>
    <div class="section_aside">
      <div class="aside_header">
        <h2>결제 금액</h2>
      </div>
      <div class="aside_footer">
        <div class="wrap_summary">
          <table class="com_tb_metadata tb_order_total">
            <tbody>
              <tr>
                <td class="tit"><span class="txt">상품 금액</span></td>
                <td class="data">
                  <span class="txt">{{ productPrice + "원" }}</span>
                </td>
              </tr>
              <tr>
                <td class="tit">
                  <span class="txt">할인금액</span>
                </td>
                <td class="data">
                  <span class="txt">0원</span>
                </td>
              </tr>

              <tr class="total">
                <td class="tit"><span class="txt">결제 예정 금액</span></td>
                <td class="data">
                  <span class="txt">{{ paymentPrice + "원" }}</span>
                </td>
              </tr>
            </tbody>
          </table>
        </div>

        <div class="aside_action">
          <button class="major large flex" @click="goPayment">
            <span class="txt">{{ paymentPrice }}원 결제하기</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OrderRequester from "@/components/order/OrderRequester.vue";
import Shipment from "@/components/order/Shipment.vue";
import OrderItem from "@/components/order/OrderItem.vue";
import Payment from "@/components/order/Payment.vue";
import { joinComma } from "@/utils/string";
import { addOrder } from "@/api/order";
import routerMixin from "@/mixin/routerMixin.js";

export default {
  name: "OrderPayment",
  mixins: [routerMixin],
  components: { Payment, OrderItem, Shipment, OrderRequester },
  created() {
    if (!this.selectedOptions || !this.product) {
      this.$router.push("/");
    }
  },
  computed: {
    productPrice() {
      if (!this.orderItem.price) {
        return 0;
      }
      return joinComma(this.orderItem.totalPrice);
    },
    paymentPrice() {
      if (!this.orderItem.price) {
        return 0;
      }
      return joinComma(this.orderItem.totalPrice);
    },
  },
  data() {
    return {
      product: {},
      selectedOptions: [],
      orderItem: {},
      data: {},
    };
  },
  methods: {
    goPayment() {
      const shipmentData = this.$refs.shipment.getData();
      const orderProductData = this.$refs.orderItem.getData();
      const paymentData = this.$refs.payment.getData();
      paymentData.totalPrice = orderProductData.price.totalPrice;
      paymentData.discountPrice = orderProductData.price.discountPrice;
      const payload = {
        orderReceiver: shipmentData,
        orderPayment: paymentData,
        orderItems: orderProductData.orderRequests,
      };

      addOrder(payload).then(
        (response) => {
          this.goToRoute("/order/result", {
            code: response.data.code,
          });
        },
        (errorResponse) => {
          this.goToRoute("/order/result", {
            message: errorResponse.response.data.message,
          });
        }
      );
    },
    updateOrderItem(orderItem) {
      this.orderItem = orderItem;
    },
  },
};
</script>

<style scoped>
.section_aside {
  padding: 150px 0 24px 48px;
}
</style>
