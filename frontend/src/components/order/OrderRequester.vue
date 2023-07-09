<template>
  <div class="container">
    <h2>주문자 정보</h2>
    <div class="com_form">
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">주문자명</span>
          </label>
          <div class="form_data cell">
            <div class="com_ipt">
              <input
                class="ipt_normal"
                type="text"
                v-model="orderRequester.name"
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
                v-model="orderRequester.mobileNumber"
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
      orderRequester: {
        name: "김다우",
        mobileNumber: "010-5858-3030",
      },
    };
  },
  created() {
    const user = this.$store.getters.getUser;
    if (!user) {
      return;
    }
    this.orderRequester.name = user.name;
    this.orderRequester.mobileNumber = user.mobile;
  },
};
</script>
