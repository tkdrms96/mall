<template>
  <div class="container">
    <h2>주문 상품</h2>
    <div class="wrap_list_order">
      <div class="wrap_item_picture">
        <a class="figure"><img :src="orderItem.imgUrl" /></a>
      </div>
      <table class="com_tb_data tb_order">
        <tbody>
          <!-- 기본 상품 list -->
          <tr>
            <td class="item flex">
              <span class="txt shop">{{ product.brand }}</span>
              <span class="txt item ellipsis_clamp2">{{ product.name }}</span>
            </td>
            <td class="quantity">
              <span class="txt">{{ orderItem.quantity + "개" }}</span>
            </td>
            <td class="price">
              <span class="txt">{{ totalPrice + "원" }}</span>
            </td>
          </tr>
          <!-- [디자인 샘플] 개발에 활용 /design/03_주문결제.html 참고 -->
          <tr v-for="option in option" v-bind:key="option.id">
            <td class="item flex">
              <div class="wrap_option">
                <div class="tit">{{ option.name }}</div>
                <div class="data">{{ option.option }}</div>
              </div>
            </td>
            <td class="quantity"><span class="txt">{{ option.count }}</span></td>
            <td class="price"><span class="txt">{{ option.totalPrice + '원' }}</span></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { joinComma } from "@/utils/string";
export default {
  computed: {
    totalPrice() {
      return joinComma(this.orderItem.totalPrice);
    },
    optionPrice(option) {
      return joinComma(option);
    }
  },
  created() {
    this.orderItem = this.$store.getters.getOrderItem;
    this.product = this.$store.getters.getProduct;
    this.option = this.$store.getters.getOption;
    this.$emit("syncUpdate", this.orderItem);
  },
  data() {
    return {
      product: {},
      option: [],
      orderItem: {
        price: 0,
      },
    };
  },
  methods: {
    getData() {
      return {
        price: {
          totalPrice: this.orderItem.price * this.orderItem.quantity,
          discountPrice: 0,
        },
        orderRequests: [
          {
            productCode: this.product.code,
            productPrice: this.orderItem.price,
            productQuantity: this.orderItem.quantity,
          },
        ],
      };
    },
  },
};
</script>
