<template>
  <div class="content_body">
    <div class="wrap_full_content">
      <p class="txt_big">
        {{ message }}
      </p>
      <p class="desc" v-if="this.code">
        주문번호 : {{ code }}<br />
        {{ paymentDateTime + "\n" }}<br />
        결제금액 : <span class="em">{{ purchasePrice + "원" }}</span
        ><br />
      </p>
      <a class="major large">
        <span class="txt">쇼핑 계속하기</span>
      </a>
    </div>
  </div>
</template>

<script>
import { joinComma } from "@/utils/string";
import moment from "moment";
import { getOrderDetails } from "@/api/order";

export default {
  name: "orderResult",
  computed: {
    purchasePrice() {
      return joinComma(this.totalPrice);
    },
  },
  created() {
    this.code = this.$route.query.code;
    if (typeof this.code !== "undefined" && this.code !== null) {
      getOrderDetails(this.code).then(
        (response) => {
          this.message = response.data.message;
          this.code = response.data.code;
          this.paymentDateTime = moment(response.data.paymentDateTime).format(
            "YYYY-MM-DD HH:mm:SS"
          );
          this.totalPrice = response.data.totalPrice;
        },
        (errorResponse) => {
          this.message = errorResponse.response.data.message;
        }
      );
    } else {
      this.message = this.$route.query.message;
    }
  },
  data() {
    return {
      code: "",
      paymentDateTime: "",
      totalPrice: 0,
      statusCode: "",
      message: "",
    };
  },
  methods: {},
};
</script>
