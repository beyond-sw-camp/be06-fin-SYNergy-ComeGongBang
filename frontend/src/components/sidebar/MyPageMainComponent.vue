<template>
  <router-view />
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "MyPageSideBarComponent",
  computed: {
    // ...mapStores(useSideBarMenuStore),
  },
  components: {},
  created() {
    // this.searchByCategory();
  },
  methods: {
    // searchByCategory() {
    //   this.productStore.searchByCategory(); //Todo 현재는 카테고리 상품 리스트만 조회 가능하므로 추후 다른 종류의 상품리스트에도 사용할 수 있도록 리팩토링
    // },
  },
});
</script>

<style>
</style>