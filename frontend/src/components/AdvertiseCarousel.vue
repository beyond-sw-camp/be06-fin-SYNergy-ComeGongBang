<template>
  <Carousel :items-to-show="2.5" :wrap-around="true" :autoplay="2000">
    <Slide v-for="(img, index) in images" :key="index" 
    class="slide"
    >
        <div class="carousel-image carousel__item"><img :src="img"/></div>
      <!-- <div class="carousel__item">{{ slide }}</div> -->
    </Slide>

    <template #addons>
      <Navigation />
    </template>
  </Carousel>
</template>

<script>
import { defineComponent } from 'vue'
import { Carousel, Navigation, Slide } from 'vue3-carousel'

import 'vue3-carousel/dist/carousel.css'

export default defineComponent({
  name: 'WrapAround',
  components: {
    Carousel,
    Slide,
    Navigation,
  },
  data(){
    return{
        images : [
            "https://image.idus.com/image/files/0426c5c7d00f4b1fb3cd2a16cee8ce24_720.jpg",
            "https://image.idus.com/image/files/7c79f1b864f64f4592f0d168280a7bc8_720.jpg",
            "https://image.idus.com/image/files/d37ce23f6803443481378a4b782b93d3_720.jpg",
            "https://image.idus.com/image/files/68d7bc1e4ab64d88bcc75b45b1bb8491_720.jpg",
            "https://image.idus.com/image/files/235a881297544b1da2af46ca5b30f88e_720.jpg",
            "https://image.idus.com/image/files/7bcb14dffeef4442ae9d188d103ae5f2_720.jpg"
        ],
        currentSlide: 0
    }
  },
  methods: {
    updateCurrentSlide(index) {
      this.currentSlide = index;
    }
  }
})
</script>
<style scoped>
.carousel-image{
    margin: 0 10px;
}
.carousel-image img{
    border-radius: 20px;
}
/* 현재 슬라이드가 아닌 경우 투명도 50% */
.inactive-slide {
    opacity: 0.2;
    /* transition: opacity 0.5s ease; */
}
</style>
