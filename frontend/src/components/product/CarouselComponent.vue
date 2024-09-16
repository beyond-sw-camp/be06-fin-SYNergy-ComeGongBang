<template>
  <Carousel>
    <Slide v-for="slide in 2" :key="slide">
      <div class="carousel__item"><ProductList5LayoutComponent :productList="this.productStore.productList"/></div>
    </Slide>

    <template #addons>
      <Navigation />
      <Pagination />
    </template>
  </Carousel>
</template>

<script>
import { defineComponent } from 'vue'
import { Carousel, Navigation, Pagination, Slide } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
import ProductList5LayoutComponent from './ProductList5LayoutComponent.vue'
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore"

export default defineComponent({
    name: 'ProductCarousel',
    computed: {
        ...mapStores(useProductStore)
    },
    components: {
        Carousel,
        Slide,
        Pagination,
        Navigation,
        ProductList5LayoutComponent
    },
    created(){
        this.searchByCategory()
    },
    methods:{
        searchByCategory(){
            this.productStore.searchByCategory(); //Todo 현재는 카테고리 상품 리스트만 조회 가능하므로 추후 다른 종류의 상품리스트에도 사용할 수 있도록 리팩토링
        }
    }
})
</script>

<style scoped>
.carousel__item {
  min-height: 200px;
  width: 100%;
  color: var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  justify-content: center;
  align-items: center;
}

.carousel__slide {
  padding: 10px 70px;
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  border: 5px solid white;
}
</style>
