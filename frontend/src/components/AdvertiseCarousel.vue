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
            // "https://synergy-frontend.s3.ap-northeast-2.amazonaws.com/cgbAds1.png",
            // "https://image.idus.com/image/files/7c79f1b864f64f4592f0d168280a7bc8_720.jpg",
            // "https://synergy-frontend.s3.ap-northeast-2.amazonaws.com/cgbAds4.png",
            // "https://synergy-frontend.s3.ap-northeast-2.amazonaws.com/cgbAds2.png",
            // "https://synergy-frontend.s3.ap-northeast-2.amazonaws.com/cgbAds3.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+450.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+449.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+448.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+447.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+446.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+445.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+444.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+443.png",
          "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/Group+451.png"
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
