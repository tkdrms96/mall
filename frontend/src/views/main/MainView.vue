<template>
  <div class="section_container">
    <MainHeader />

    <div class="section_body">
      <div class="section_content">
        <Category />
        <RouterView />
      </div>
    </div>
  </div>
</template>

<script>
import MainHeader from "@/components/main/MainHeader.vue";
import Category from "@/components/main/Category.vue";
import { login, getUser } from "@/api/user";

export default {
  name: "MainView",
  components: { Category, MainHeader },
  created() {
    this.requestLogin();
  },
  methods: {
    requestLogin() {
      login().then(() => {
        this.getUser();
      });
    },
    getUser() {
      getUser().then((result) => {
        this.$store.commit("updateUser", result.data);
      });
    },
  },
};
</script>
