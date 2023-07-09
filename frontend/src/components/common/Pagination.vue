<template>
  <div class="wrap_paging">
    <div class="com_paging">
      <a @click="prevPage" title="이전" class="prev"
        ><i class="ic_set ic_prev"></i
      ></a>
      <a
        :class="{ active: curPage === start + idx - 1 }"
        v-for="idx in end - start"
        :key="idx"
        @click="selectPage(start + idx - 1)"
      >
        <span class="txt">{{ start + idx }}</span>
      </a>
      <a @click="nextPage" title="다음" class="next"
        ><i class="ic_set ic_next"></i
      ></a>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    pageModel: Object,
  },
  data() {
    return {
      curPage: 0,
      totalSize: 0,
      listCount: 8,
      btnCount: 10,
      start: 0,
      // end: 10,
    };
  },
  computed: {
    end() {
      return Math.min(this.pageModel.totalPages, this.start + this.btnCount);
    },
  },
  methods: {
    selectPage(pageIdx) {
      this.curPage = pageIdx;
      this.changePageEvent();
    },
    nextPage() {
      if (this.start + this.btnCount - 1 >= this.pageModel.totalPages) {
        return;
      }
      this.refreshPage(this.btnCount);
    },
    prevPage() {
      if (this.start <= 1) {
        return;
      }
      this.refreshPage(this.btnCount * -1);
    },
    refreshPage(segment) {
      this.start += segment;
      this.curPage = this.start;
      this.changePageEvent();
    },
    changePageEvent() {
      this.$emit("changePage", this.curPage, this.listCount);
    },
  },
};
</script>
