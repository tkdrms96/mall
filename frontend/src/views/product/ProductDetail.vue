<!-- eslint-disable prettier/prettier -->
<template>
  <div class="section_body">
    <div class="section_content">
      <div class="content_body">
        <div class="wrap_item_detail">
          <div class="wrap_item_picture">
            <img class="img_item detail" :src="product.imgUrl" />
          </div>
          <div class="wrap_item_info">
            <div class="item_summary">
              <span class="txt shop">{{ product.brand }}</span>
              <span class="txt item ellipsis_clamp2">{{ product.name }}</span>
              <span class="price">{{ productBasePrice + "원" }}</span>
            </div>

            <!-- [디자인 샘플] 개발에 활용 /design/02_제품상세.html 참고 -->
            <div class="item_option">
              <div class="wrap_form_static">
                <div class="com_form">
                  <div class="wrap_row">
                    <div class="row">
                      <label class="form_tit cell">옵션 선택</label>
                      <div class="form_data cell">
                        <div class="com_slt">
                          <select class="slt_normal" @change="addProductOption">
                            <option selected="" disabled="">
                              기본 옵션 선택
                            </option>
                            <template v-for="option in product.productOptionList" v-bind:key="option.id">
                              <option v-if="option.type == 'OPTION'" :value="JSON.stringify(option)">
                                {{ option.name }} {{ option.price > 0 ? '(+' + option.price + '원)' : '' }}
                              </option>
                            </template>
                          </select>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="wrap_row">
                    <div class="row">
                      <label class="form_tit cell">추가 상품</label>
                      <div class="form_data cell">
                        <div class="com_slt">
                          <select class="slt_normal" @change="addProductOption">
                            <option selected="" disabled="">
                              추가 상품 선택
                            </option>
                            <template v-for="option in product.productOptionList" v-bind:key="option.id">
                              <option v-if="option.type == 'ADD'" :value="JSON.stringify(option)">
                                {{ option.name }} {{ option.price > 0 ? '(+' + option.price + '원)' : '' }}
                              </option>
                            </template>
                          </select>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- 상품 주문 정보 -->
            <div class="item_option_unit">
              <div class="wrap_option">
                <label class="tit ellipsis">{{ product.name }}</label>
                <span class="com_number">
                  <button class="minus" @click="minusOption">
                    <span class="ic_set ic_minus"></span>
                  </button>
                  <input
                    class="ipt_normal"
                    type="number"
                    name="quantity"
                    :value="orderCount"
                    @keyup.enter="editCount"
                    @input="editCount"
                  />
                  <button class="plus" @click="plusOption">
                    <span class="ic_set ic_plus"></span>
                  </button>
                </span>
                <p class="txt_price">
                  <span class="price">{{
                    joinComma(product.price * orderCount) + "원"
                  }}</span>
                </p>
              </div>
            </div>

            <!-- [디자인 샘플] 개발에 활용 -->
            <template v-for="items in option" v-bind:key="items">
              <div class="item_option_unit" >
              <div class="wrap_option">
                <label class="tit">{{ items.name }} </label>
                <span class="com_number">
                  <button class="minus">
                    <span class="ic_set ic_minus"></span>
                  </button>
                  <input
                    class="ipt_normal"
                    type="number"
                    name="quantity"
                    min="1"
                    max="10"
                    :value="items.count" 
                    @keyup.enter="addOptionCount"
                    @input="addOptionCount"
                  />
                  <button class="plus" @click="addOptionCount(items)">
                    <span class="ic_set ic_plus"></span>
                  </button>
                </span>
                <p class="txt_price">
                  <span class="price"> {{ items.price > 0 ? joinComma(items.totalPrice) +'원' : ''}}</span>
                </p>
                <button class="del" title="삭제" >
                  <i class="ic_set ic_del" @click="removeProductOption(items)"></i>
                </button>
              </div>
            </div>
          </template>
            

            <!-- 금액 처리 -->
            <div class="item_total">
              <span class="txt total">총 금액(VAT포함)</span>
              <span class="txt price">{{ parseInt(purchasePrice) + parseInt(purchaseOptionPrice) + ',000원' }}</span>
              <a class="major large flex" @click="purchase">
                <span class="txt">구매하기</span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getProduct } from "@/api/product";
import { joinComma } from "@/utils/string";

export default {
  created() {
    this.productId = this.$route.params.productId;
    this.searchProduct(this.productId);
  },
  data() {
    return {
      product: {},
      option: [],
      orderCount: 1,
    };
  },
  computed: {
    productBasePrice() {
      return joinComma(this.product.price);
    },
    purchasePrice() {
      let result = this.product.price * this.orderCount;
      return joinComma(result);
    },
    purchaseOptionPrice() {
      let result = 0;
      this.option.forEach(function (o) {
        result += parseInt(o.totalPrice);
      });
      return joinComma(result);
    },
  },
  methods: {
    purchase() {
      this.$store.commit("updateOrderItem", {
        imgUrl: this.product.imgUrl,
        quantity: this.orderCount,
        price: this.product.price,
        totalPrice: this.product.price * this.orderCount,
        option: this.option,
      });
      this.$store.commit("updateProduct", this.product);
      this.$store.commit("updateOption", this.option);
      this.$router.push("/order/payment");
    },
    searchProduct(productId) {
      getProduct(productId).then((result) => {
        this.product = result.data;
      });
    },
    minusOption() {
      this.orderCount = Math.max(1, this.orderCount - 1);
    },
    plusOption() {
      this.orderCount = this.orderCount + 1;
    },
    editCount(event) {
      this.orderCount = event.target.value;
    },
    joinComma(num) {
      return joinComma(num);
    },
    addProductOption(evt) {
      console.log("addProductOption");
      const option = JSON.parse(evt.target.value);
      const price = option.price;
      option["count"] = 1;
      option["totalPrice"] = price;
      option["price"] = price;
      this.option.push(option);
    },
    removeProductOption(evt) {
      this.option = this.option.filter(o => o.id !== evt.id);
      this.optionTotalPrice = this.optionTotalPrice - evt.price;
    },
    addOptionCount(evt) {
      const optionIndex = this.option.findIndex((o) => o.id === evt.id);
      this.option[optionIndex].count += 1;
      this.option[optionIndex].totalPrice += evt.price;
    }
  },
};
</script>
