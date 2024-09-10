<template>
  <Carousel>
    <Slide v-for="slide in 2" :key="slide">
      <div class="carousel__item"><CarouselProductListComponent :productList="this.productStore.productList"/></div>
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
import CarouselProductListComponent from './CarouselProductListComponent.vue'
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
        CarouselProductListComponent
    },
    created(){
        this.searchByCategory()
    },
    methods:{
        searchByCategory(){
            this.productStore.searchByCategory();
        }
    }
})
</script>

<style scoped>
.carousel__item {
  min-height: 200px;
  width: 100%;
  /* background-color: var(--vc-clr-primary); */
  color: var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  /* display: flex; */
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
