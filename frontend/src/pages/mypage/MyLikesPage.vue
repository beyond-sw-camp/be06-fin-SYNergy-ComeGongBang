<template>
  <div class="my-page">
    <MyPageMainComponent />
    <MyPageSideBarComponent />
  </div>
</template>

<script>
import { defineComponent } from "vue";
import MyPageMainComponent from "@/components/sidebar/MyPageMainComponent.vue";
import MyPageSideBarComponent from "@/components/sidebar/MyPageSideBarComponent.vue";

export default defineComponent({
  name: "MyLikesPage",
  computed: {
    // ...mapStores(useProductStore),
  },
  components: {
    MyPageMainComponent,
    MyPageSideBarComponent,
  },
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