<template>
  <div class="content_top">
    <ul class="com_tag">
      <li
        :class="{ active: curIdx === idx }"
        v-for="(category, idx) in categories"
        :key="idx"
        @click="selectCategory(idx)"
      >
        <span class="txt">{{ category }}</span>
      </li>
    </ul>
    <div class="wrap_breadcrumb">
      <ol class="com_breadcrumbs">
        <li class="item">
          <a><span class="ic_set ic_home" title="Home"></span>Home</a>
        </li>
        <li class="item active"><a>Category_A</a></li>
      </ol>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      categories: ["All", "Category_A", "Category_B", "Category_C"],
      curIdx: 0,
    };
  },
  methods: {
    selectCategory(idx) {
      this.curIdx = idx;
    },
  },
};
</script>
