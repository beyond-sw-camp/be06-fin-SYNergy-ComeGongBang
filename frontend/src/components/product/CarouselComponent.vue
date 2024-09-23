<template>
  <Carousel :wrap-around="true">
    <Slide v-for="slide in 2" :key="slide">
      <div class="carousel__item"><ProductList5LayoutComponent :productList="productList"/></div>
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

export default defineComponent({
    name: 'ProductCarousel',
    props : {
      productList : {
        type : Object,
        required : true
      }
    },
    components: {
        Carousel,
        Slide,
        Pagination,
        Navigation,
        ProductList5LayoutComponent
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
  /* padding: 10px 70px; */
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  border: 5px solid white;
}
</style>

