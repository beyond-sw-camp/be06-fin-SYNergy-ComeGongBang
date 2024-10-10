<template>
  <div class="appContents appContentsBottomNav" data-v-261d543d="">
    <div>
      <div class="flex flex-col items-center">
        <!-- 광고 캐러샐 -->
        <div
          class="BaseUnitFetch w-desktop advertise-container margin-bottom"
          style="--unit-fetch-height: 400px"
          recent-product-uuid="3c6cec2e-6c85-4215-8f63-bd4c4917b8a7"
          showroom-index="-1"
          data-v-684c7181=""
          data-v-6603c621=""
        >
          <AdvertiseCarousel />
        </div>
        <!-- 상품 캐러셀 -->
        <div
          class="BaseUnitFetch w-desktop product-carousel margin-bottom"
          style="--unit-fetch-height: 400px"
          recent-product-uuid="3c6cec2e-6c85-4215-8f63-bd4c4917b8a7"
          data-v-6f0bac7e=""
          data-v-6603c621=""
        >
          <div style="text-align: left; font-size: 20px; font-weight: 700">
            <!-- 카테고리 상품 -->
            추석 선물 대전
          </div>
          <CarouselComponent :productList="this.hashtagProductList"/>
          <router-link :to="{ name: 'HashtagProductList', params: { hashtagIdx: 1 } }">
            <div data-v-6f0bac7e="" class="flex justify-center">
              <button
                data-v-524f63ea=""
                data-v-7940d6dd=""
                data-v-6f0bac7e=""
                type="outline"
                class="CoreButton BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline more-btn"
              >
                <div data-v-524f63ea="" class="inline-flex items-center">
                  <span data-v-524f63ea="" class="CoreButton__text"
                    >작품 더보기</span
                  >
                </div>
              </button>
            </div>
          </router-link>
        </div>
        <!-- 상품 캐러셀 -->
        <div
          class="BaseUnitFetch w-desktop product-carousel margin-bottom"
          style="--unit-fetch-height: 400px"
          recent-product-uuid="3c6cec2e-6c85-4215-8f63-bd4c4917b8a7"
          data-v-6f0bac7e=""
          data-v-6603c621=""
        >
          <div style="text-align: left; font-size: 20px; font-weight: 700">
            <!-- 카테고리 상품 -->
            오늘의 핫딜 상품
            <span class="margin-left-20px">
              <CountDown/>
            </span>
          </div>
          <CarouselComponent :productList="this.hotDealProductList"/>
          <router-link :to="{ name: 'HashtagProductList', params: { hashtagIdx: 2 } }">
            <div data-v-6f0bac7e="" class="flex justify-center">
              <button
                data-v-524f63ea=""
                data-v-7940d6dd=""
                data-v-6f0bac7e=""
                type="outline"
                class="CoreButton BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline more-btn"
              >
                <div data-v-524f63ea="" class="inline-flex items-center">
                  <span data-v-524f63ea="" class="CoreButton__text"
                    >작품 더보기</span
                  >
                </div>
              </button>
            </div>
          </router-link>
        </div>
        <div
          class="MainFab MainFab__display--none MainFab__device--desktop"
          data-v-59d23028=""
        >
          <img src="" class="MainFab__image" data-v-59d23028="" />
        </div>
      </div>
    </div>
    <div class="TheFabContainer" data-v-261d543d="" data-v-0397dfb3="">
      <!--[--><!----><button
        type="button"
        class="CoreButton IdsButtonFab__size--medium IdsButtonFab__iconSize--medium IdsButtonFab TheMoveToTopFab__display--hide TheFabContainer__item"
        style="
          background-color: rgb(255, 255, 255);
          color: rgb(51, 51, 51);
          height: 56px;
          width: 56px;
          flex-direction: row;
          --core-button-padding-x: 0px;
        "
        data-v-0397dfb3=""
        data-v-524f63ea=""
        data-v-0b9311f9=""
        data-v-01e4f5dd=""
      >
        <!----><!--[-->
        <div class="IdsButtonFab__contents" data-v-0b9311f9="">
          <div class="IdsButtonFab__contentsInner" data-v-0b9311f9="">
            <!--[-->
            <div data-v-0b9311f9="">
              <svg
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                style="
                  width: 32px;
                  height: 32px;
                  opacity: 1;
                  fill: currentColor;
                  --BaseIcon-color: #333333;
                "
                class="BaseIcon IdsButtonFab__contentsIcon"
                data-v-6d2bd019=""
                data-v-0b9311f9=""
              >
                <g clip-path="url(#clip0_124_2944)">
                  <path
                    d="M3.96869 11.7197L11.4687 4.21967C11.7616 3.92678 12.2365 3.92678 12.5293 4.21967L20.0293 11.7197L18.9687 12.7803L12.749 6.5606V20H11.249V6.56072L5.02935 12.7803L3.96869 11.7197Z"
                  ></path>
                </g>
                <defs>
                  <clipPath id="clip0_124_2944">
                    <rect width="24" height="24"></rect>
                  </clipPath>
                </defs>
              </svg>
            </div>
            <!--]--><!---->
          </div>
        </div>
        <!--]--></button
      ><!--]-->
    </div>
  </div>
</template>

<script>
import { mapStores } from 'pinia';
import { useProductStore } from '@/stores/useProductStore'

import CarouselComponent from '@/components/product/CarouselComponent.vue';
import AdvertiseCarousel from "@/components/AdvertiseCarousel.vue";
import CountDown from '@/components/common/CountDown.vue';

export default {
  components: {
    CarouselComponent,
    AdvertiseCarousel,
    CountDown
  },
  computed:{
    ...mapStores(useProductStore),
  },
  data(){
    return{
      hashtagProductList : [],
      hotDealProductList : []
    }
  },
  created(){
    this.makeCarousel();
  },
  mounted(){

  },
  methods:{
    async getCategoryProductList(idx, page, size){
      await this.productStore.searchByCategory(idx, page, size, null, null);
    },
    async getHashTagProductList(idx, page, size){
      return await this.productStore.searchByHashTag(idx, page, size);
    },
    async makeCarousel(){
      this.productStore.hashTagProductList=[];
      let list = await this.getHashTagProductList(1, 0, 20);
      this.hashtagProductList = [list.slice(0,10), list.slice(10)];

      this.productStore.hashTagProductList=[];
      // const hotdeallist = await this.getHashTagProductList(2, 0, 20);
      list = await this.getHashTagProductList(2, 0, 20);
      console.log(list)
      this.hotDealProductList = [list.slice(0,10), list.slice(10)];
      // this.hotDealProductList = [this.productStore.hashTagProductList.slice(0,10), this.productStore.hashTagProductList.slice(10)];
    },
  }
};
</script>

<style scoped>
.product-carousel {
  margin-top: 30px;
}
.advertise-container {
  width: 50%;
}
.more-btn {
  background-color: rgb(255, 255, 255);
  color: rgb(51, 51, 51);
  height: 40px;
  width: 360px;
  flex-direction: row;
  margin-top: 20px;
  --core-button-padding-x: 16;
  --button-rectangle-border-color: #acacac;
}
.margin-bottom{
  margin-bottom: 100px;
}
.margin-left-20px{
  margin-left: 20px;
}
</style>
