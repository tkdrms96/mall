<template>
  <div class="section_header">
    <h1 class="logo" @click="goHome">
      <img src="@/assets/images/logo_daoustore.png" title="DAOUstore" />
    </h1>
    <div class="snb">
      <Search />
      <UserProfile></UserProfile>
    </div>
  </div>
</template>

<script>
import UserProfile from "@/components/common/UserProfile.vue";
import Search from "@/components/common/SearchForm.vue";
export default {
  name: "MainHeader",
  components: { Search, UserProfile },
  created() {},
  methods: {
    goHome() {
      this.$router.push("/");
    },
  },
};
</script>
