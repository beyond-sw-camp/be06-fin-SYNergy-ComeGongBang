<template>
  <div>
    <div class="product-list-container">
      <div class="rel" v-for="product in productList" :key="product.idx">
        <div
          data-v-f8c6bf35=""
          data-v-eee6c6ce=""
          class="ProductCardFavorite BaseProductCardImage__favorite"
          style="--product-card-favorite-size: 44"
          @click.stop.prevent="toggleLike(product)"
        >
          <!-- 하트  -->
          <span
            data-v-b1510e51=""
            data-v-f8c6bf35=""
            name="favorite_fill_shadow_p5"
            class="BaseIconColor"
            :class="
              product.isMemberLiked
                ? 'fill-heart'
                : 'BaseIconColor__favorite_shadow_p5'
            "
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
import { useAtelierStore } from "@/stores/useAtelierStore";
import { useLikesStore } from "@/stores/useLikesStore";
import ProductComponent from "./ProductComponent.vue";
import swal from 'sweetalert2';

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
    const showAlert = (content) => {
      swal.fire({
        title: "Oops!",
        text: content,
        icon: "error",
      });
    };

    // 찜하기 토글 함수
    const toggleLike = async (product) => {
      const atelierStore = useAtelierStore();
      //찜하기기능
      const response = await likesStore.toggleLike(product.idx);
      if (response === false) {
        // showAlert("찜 과정 중 오류가 발생하였습니다.");
      } else {
        product.isMemberLiked = !product.isMemberLiked;
        atelierStore.havingProductsLikeCount =
          response.atelierHavingProductsLikesCount;
      }
    };
    return {
      likesStore,
      toggleLike,
      showAlert,
    };
  },
};
</script>

<style scoped>
.product-list-container {
  padding: 10px;
  display: grid;
  gap: 10px;
  //grid-template-columns: auto auto auto auto auto;
  grid-template-columns: repeat(5, 1fr);
}
.rel {
  position: relative;
}
.fill-heart {
  background-image: url("@/assets/heart.png");
  background-size: contain; /* 이미지를 전체 크기에 맞춤 */
  background-repeat: no-repeat; /* 이미지가 반복되지 않도록 설정 */
  width: 23px; /* 이미지 크기 */
  height: 23px; /* 이미지 크기 */
  display: inline-block; /* span 내부 요소에 이미지가 나타나도록 block 요소로 설정 */
}
</style>