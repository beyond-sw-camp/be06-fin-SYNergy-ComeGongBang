<template>
  <div class="image-carousel">
    <!-- 상단 큰 이미지 -->
    <div class="main-image">
      <img :src="selectedImageUrl" alt="Selected Image" />
    </div>

    <!-- 이미지 리스트 -->
    <div class="image-list-container">
      <div
          class="image-list"
          :style="{ transform: `translateX(-${currentSlide * slideWidth}px)` }"
      >
        <div
            v-for="(image, index) in productStore.productDetail.productImages.slice(0, 6)"
            :key="index"
            class="thumbnail"
            @click="changeImage(image.productImageUrl)"
        >
          <img :src="image.productImageUrl" alt="Thumbnail" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, computed } from "vue";
import { useProductStore } from "@/stores/useProductStore";

export default {
  setup() {
    const productStore = useProductStore();

    const selectedImageUrl = ref(
        productStore.productDetail.productImages[0].productImageUrl
    );
    console.log("메인사진", selectedImageUrl);
    const currentSlide = ref(0);
    const slideWidth = 90; // 썸네일의 너비 + margin
    const itemsPerSlide = 8; // 한번에 보여줄 썸네일 개수
    const maxSlides = computed(() =>
        Math.ceil(
            (productStore.productDetail.productImages.length - itemsPerSlide) /
            itemsPerSlide
        )
    );

    const changeImage = (imageUrl) => {
      selectedImageUrl.value = imageUrl;
    };

    const nextSlide = () => {
      if (currentSlide.value < maxSlides.value) {
        currentSlide.value++;
      }
    };

    const prevSlide = () => {
      if (currentSlide.value > 0) {
        currentSlide.value--;
      }
    };

    return {
      productStore,
      selectedImageUrl,
      changeImage,
      currentSlide,
      slideWidth,
      nextSlide,
      prevSlide,
      maxSlides,
    };
  },
};
</script>

<style scoped>
.image-carousel {
  max-width: 500px;
  margin: auto;
  margin-right: 50px;
}

.main-image img {
  width: 100%;
  height: 500px;
  object-fit: cover;
  margin-bottom: 10px;
}

.image-list-container {
  position: relative;
  overflow: hidden;
}

.image-list {
  display: flex;
  transition: transform 0.3s ease;
}

.thumbnail {
  cursor: pointer;
  margin-right: 10px;
}

.thumbnail:last-child {
  margin-right: 0;
}

.thumbnail img {
  width: 80px;
  height: 80px; /* 높이를 일정하게 설정 */
  object-fit: cover; /* 이미지 비율을 유지하면서 잘리게 설정 */
  border: 2px solid transparent;
}

.thumbnail:hover img {
  border: 2px solid #007bff;
}

.slide-button {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background: rgba(255, 255, 255, 0.8);
  border: none;
  cursor: pointer;
  z-index: 1;
}

.prev-button {
  left: 10px;
}

.next-button {
  right: 10px;
}
</style>