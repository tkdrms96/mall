<template>
  <div class="content_body">
    <ul class="wrap_container_item">
      <li class="wrap_item" v-for="product in products" :key="product">
        <ProductListItem :product="product" />
      </li>
    </ul>
    <Pagination
      @changePage="changePage"
      :pageModel="pageModel"
      ref="pagination"
    />
  </div>
</template>

<script>
import ProductListItem from "../../components/product/ProductItem.vue";
import Pagination from "../../components/common/Pagination.vue";
import { getProducts } from "@/api/product";

export default {
  name: "ProductList",
  components: { Pagination, ProductListItem },
  created() {
    this.searchProducts(0, 8);
  },
  data() {
    return {
      products: {},
      pageModel: {
        totalElements: 0,
        totalPages: 0,
      },
    };
  },
  methods: {
    searchProducts(page, size) {
      const pageModel = {
        page: page,
        size: size,
      };
      const res = getProducts(pageModel);
      res.then((res) => {
        this.products = res.data.content;
        this.pageModel = {
          totalElements: res.data.totalElements,
          totalPages: res.data.totalPages,
        };
      });
    },
    changePage(page, size) {
      this.searchProducts(page, size);
    },
  },
};
</script>
