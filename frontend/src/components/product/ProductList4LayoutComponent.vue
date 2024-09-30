<template>
  <div>
    <div class="product-list-container">
      <div class="rel" v-for="product in productList" :key="product.idx">
        <div
          data-v-f8c6bf35=""
          data-v-eee6c6ce=""
          class="ProductCardFavorite BaseProductCardImage__favorite"
          style="--product-card-favorite-size: 44"
          @click.stop="toggleLike(product)"
        >
          <!-- 하트  -->
          <span
            data-v-b1510e51=""
            data-v-f8c6bf35=""
            name="favorite_fill_shadow_p5"
            class="BaseIconColor"
            :class="product.isMemberLiked ? 'BaseIconColor__favorite_fill_shadow_p5' : 'BaseIconColor__favorite_shadow_p5'"
            style="--BaseIconColor-size: 28"
          ></span>
        </div>

        <router-link
          :to="{ name: 'productDetail', params: { idx: product.idx } }"
          :key="product.idx"
        >
          <ProductComponent :product="product" />
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
// import { useProductStore } from "@/stores/useProductStore";
import { useLikesStore } from "@/stores/useLikesStore";
import ProductComponent from "./ProductComponent.vue";
import { reactive } from "vue";

export default {
  components: {
    ProductComponent,
  },
  data() {
    return {
      page: 0,
      loading: false, //로딩 관리
    };
  },
  props: {
    productList: {
      type: Object,
      required: true,
    },
  },
  computed: {
    // ...mapStores(useProductStore),
    ...mapStores(useLikesStore),
  },
  created() {},
  setup() {
    const likesStore = useLikesStore();
    const likeInfoList = reactive([]);

    // 찜하기 토글 함수
    const toggleLike = async (product) => {
      //찜하기기능
      const response = await likesStore.toggleLike(product.idx);
      if(response===true){
        product.isMemberLiked = !product.isMemberLiked;
      }
    };

    return {
      likesStore,
      toggleLike,
      likeInfoList,
    };
  },
};
</script>

<style scoped>
.product-list-container {
  padding: 10px;
  display: grid;
  gap: 10px;
  grid-template-columns: auto auto auto auto;
}
.rel {
  position: relative;
  z-index: 10;
}
</style>