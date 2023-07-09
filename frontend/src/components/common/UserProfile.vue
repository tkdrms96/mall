<template>
  <span class="wrap_profile">
    <span class="com_profile">
      <a>
        <img
          class="profile"
          :src="user.thumbnail || defaultImageURL"
          alt="profile"
          :title="user.title"
        />
      </a>
    </span>
  </span>
</template>

<script>
export default {
  name: "UserProfile",
  created() {
    const user = this.$store.getters.getUser;
    this.user.title = user.name;
    this.user.thumbnail = user.thumbnail;
  },
  data() {
    return {
      defaultImageURL: "/src/assets/images/profile_sample.png",
      user: {
        title: "",
        thumbnail: "",
      },
    };
  },
};
</script>
