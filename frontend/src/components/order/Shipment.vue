<template>
  <div class="container">
    <h2>배송 정보</h2>
    <div class="com_form">
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">받는 사람</span>
          </label>
          <div class="form_data cell">
            <div class="com_ipt">
              <input
                class="ipt_normal"
                type="text"
                v-model="shippingInfo.name"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">휴대폰 번호</span>
          </label>
          <div class="form_data cell">
            <div class="com_ipt">
              <input
                class="ipt_normal"
                type="text"
                v-model="shippingInfo.mobileNumber"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">배송지</span>
          </label>
          <div class="form_data cell">
            <div class="com_ipt">
              <input
                class="ipt_normal"
                type="text"
                v-model="shippingInfo.destination"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">요청 사항</span>
          </label>
          <div class="form_data cell">
            <div class="com_ipt">
              <input
                class="ipt_normal"
                type="text"
                placeholder="배송 시 요청사항을 입력해주세요."
                v-model="shippingInfo.requestTerm"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      shippingInfo: {
        name: "",
        mobileNumber: "",
        destination: "",
        requestTerm: "",
      },
    };
  },
  created() {
    const user = this.$store.getters.getUser;
    if (!user) {
      return;
    }
    this.shippingInfo.name = user.name;
    this.shippingInfo.mobileNumber = user.mobile;

    if (user.addresses && user.addresses.length > 0) {
      const zipCode = user.addresses[0].zipCode
        ? "(" + user.addresses[0].zipCode + ")"
        : "";
      this.shippingInfo.destination = zipCode + " " + user.addresses[0].address;
    }
  },
  methods: {
    getData() {
      return {
        receiver: this.shippingInfo.name,
        receiverPhoneNumber: this.shippingInfo.mobileNumber,
        receiverAddress: this.shippingInfo.destination,
        requestForDelivery: this.shippingInfo.requestTerm,
      };
    },
  },
};
</script>
