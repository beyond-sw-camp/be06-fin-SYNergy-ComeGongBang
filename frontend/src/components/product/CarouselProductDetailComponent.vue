<template>
  <Carousel id="gallery" :items-to-show="1" :wrap-around="true" v-model="currentSlide">
    <Slide v-for="(image, index) in productStore.imageUrl" :key="index">
      <!-- <div class="carousel__item">{{ slide }}</div> -->
      <img :src="image" />
    </Slide>
  </Carousel>

  <Carousel
    id="thumbnails"
    :items-to-show="4"
    :wrap-around="true"
    v-model="currentSlide"
    ref="carousel"
    class="thumnail-height"
  >
    <Slide v-for="(image, index) in productStore.imageUrl" :key="index" class="thumbnail-images">
      <div class="carousel__item" @click="slideTo(index)">
        <img :src="image"/>
      </div>
    </Slide>
  </Carousel>
</template>

<script>
import { defineComponent } from 'vue'
import { Carousel, Slide } from 'vue3-carousel'

import 'vue3-carousel/dist/carousel.css'

import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";

export default defineComponent({
  computed:{
    ...mapStores(useProductStore)
  },
  components: {
    Carousel,
    Slide,
  },
  data: () => ({
    currentSlide: 0,
  }),
  methods: {
    slideTo(index) {
      this.currentSlide = index;
    },
  },
})
</script>

<style scoped>
#thumbnails li{
  /* width: 10% !important; */
}

</style>
