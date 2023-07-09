<template>
  <span class="figure" @click="selectProduct(product.id)">
    <img :src="product.imgUrl" alt="" />
  </span>
  <div class="item_summary">
    <span class="txt shop">{{ product.brand }}</span>
    <span class="txt item ellipsis_clamp2">{{ product.name }}</span>
    <span class="price">{{ productPrice + "원" }}</span>
  </div>
</template>

<script>
import { joinComma } from "@/utils/string";
export default {
  props: {
    product: {
      type: Object,
    },
  },
  computed: {
    productPrice() {
      return joinComma(this.product.price);
    },
  },
  methods: {
    selectProduct(productId) {
      this.$router.push(`/product/${productId}`);
    },
  },
};
</script>
