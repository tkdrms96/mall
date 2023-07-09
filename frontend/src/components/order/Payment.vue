<template>
  <div class="container">
    <h2>결제 수단</h2>
    <div class="com_toggle_nav">
      <a
        class="btn_light_nav"
        :class="{ on: curPayOption.key === method.key }"
        v-for="(method, idx) in payment.method"
        :key="idx"
        @click="selectPayOption(method.key)"
        >{{ method.name }}</a
      >
    </div>
    <div class="com_form" v-if="curPayOption.key === 'CREDITCARD'">
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">카드 종류</span>
          </label>
          <div class="form_data cell">
            <div class="com_slt">
              <select class="slt_normal" @click="selectCardCompany($event)">
                <option
                  v-for="(method, idx) in paymentMethod"
                  :key="idx"
                  :value="idx"
                >
                  {{ method.cardCompany }}
                </option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="wrap_row">
        <div class="row">
          <label class="form_tit cell">
            <span class="txt">할부</span>
          </label>
          <div class="form_data cell">
            <div class="com_slt">
              <select class="slt_normal" @click="selectInstallIdx($event)">
                <option
                  v-for="(plan, idx) in cardMonthlyInstallmentPlan"
                  :key="idx"
                  :value="plan.value"
                >
                  {{ plan.name }}
                </option>
              </select>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    cardMonthlyInstallmentPlan() {
      if (!this.paymentMethod[this.selectedCardIdx]) {
        return [];
      }
      return this.paymentMethod[this.selectedCardIdx].monthlyInstallmentPlan;
    },
  },
  data() {
    return {
      paymentMethod: [
        {
          cardCompany: "현대카드",
          value: "HD",
          monthlyInstallmentPlan: [
            {
              name: "일시불",
              value: 0,
            },
            {
              name: "1개월",
              value: 1,
            },
            {
              name: "2개월",
              value: 2,
            },
            {
              name: "3개월",
              value: 3,
            },
          ],
        },
        {
          cardCompany: "신한카드",
          value: "SH",
          monthlyInstallmentPlan: [
            {
              name: "일시불",
              value: 0,
            },
          ],
        },
        {
          cardCompany: "농협카드",
          value: "NH",
          monthlyInstallmentPlan: [
            {
              name: "일시불",
              value: 0,
            },
          ],
        },
      ],
      curPayOption: {
        key: "CREDITCARD",
      },
      payment: {
        method: [
          { name: "신용카드", key: "CREDITCARD" },
          { name: "실시간 계좌이체", key: "TRANSPORT" },
        ],
      },
      selectedCardIdx: 0,
      selectedInstallIdx: 0,
    };
  },
  methods: {
    selectPayOption(key) {
      this.curPayOption.key = key;
    },
    selectCardCompany(event) {
      const selectedIdx = event.target.value;
      this.selectedInstallIdx = 0;
      this.selectedCardIdx = selectedIdx;
    },
    selectInstallIdx(event) {
      this.selectedInstallIdx = event.target.value;
    },
    getData() {
      let data = {
        payType: this.curPayOption.key,
      };
      if (this.curPayOption.key === "CREDITCARD") {
        const method = this.paymentMethod[this.selectedCardIdx];
        data.cardType = "MASTER";
        data.installment =
          method.monthlyInstallmentPlan[this.selectedInstallIdx].value > 0;
        data.monthlyInstallment =
          this.paymentMethod[this.selectedCardIdx].monthlyInstallmentPlan[
            this.selectedInstallIdx
          ].value;
      }
      return data;
    },
  },
};
</script>
