<template>
  <div>
    <div class="product-list-container">
      <div class="rel" v-for="product in productList" :key="product.idx">
        <div
          data-v-f8c6bf35=""
          data-v-eee6c6ce=""
          class="ProductCardFavorite BaseProductCardImage__favorite"
          style="--product-card-favorite-size: 44"
          @click.stop.prevent="toggleLike(product.idx)"
        >
          <!-- 하트꽉찬거  -->
          <span
            v-if="
              product.isMemberliked == true && product.isMemberliked != null
            "
            data-v-b1510e51=""
            data-v-f8c6bf35=""
            name="favorite_fill_shadow_p5"
            class="BaseIconColor BaseIconColor__favorite_shadow_p5"
            style="--BaseIconColor-size: 28"
          ></span>
          <!--하트빈거-->
          <span
            v-if="!product.memberIsLiked"
            data-v-b1510e51=""
            data-v-f8c6bf35=""
            name="favorite_shadow_p5"
            class="BaseIconColor BaseIconColor__favorite_shadow_p5"
            style="--BaseIconColor-size: 28"
          ></span>
        </div>
        <router-link
          :to="{ name: 'productDetail', params: { idx: product.idx } }"
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
  setup(props) {
    const likesStore = useLikesStore();
    console.log("상품리스트5레이아웃", props.productList[0].isMemberliked); // productList를 출력
    // const productStore = useProductStore();

    // 찜하기 토글 함수
    const toggleLike = (productIdx) => {
      //찜하기기능
      likesStore.toggleLike(productIdx);
      console.log("4layout 상품정보", likesStore.productList);

      ///product.isMemberLiked = !product.isMemberLiked; // 상태를 반전
    };

    return {
      likesStore,
      toggleLike,
    };
  },
};
</script>

<style scoped>
.product-list-container {
  padding: 10px;
  display: grid;
  gap: 10px;
  grid-template-columns: auto auto auto auto auto;
}
.rel {
  position: relative;
}
</style>