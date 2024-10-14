<template>
  <div id="__nuxt">
    <div
      data-v-d1265ec2=""
      class="BaseProductCardVertical"
      style="--product-card-round: 2; position: relative; overflow: hidden"
    >
      <div
        data-v-eee6c6ce=""
        data-v-d1265ec2=""
        class="BaseProductCardImage BaseProductCardImage__size--large BaseProductCardImage__action--clickable"
        style="--product-card-round: 2"
      >
        <div data-v-eee6c6ce="" class="BaseProductCardImage__image">
          <div
            data-v-db6621f4=""
            data-v-eee6c6ce=""
            class="CoreImageRatio__loadStatus--success CoreImageRatio img-ratio"
            radius="2"
            style="
              --ids-image-ratio: 1;
              background-size: cover;
            "
            :style="{ backgroundImage: `url(${product.thumbnailUrl})` }"
          >
            <div
              data-v-db6621f4=""
              class="CoreImageRatio__image"
              role="img"
              alt=""
              style="transform: scale(1)"
            ></div>
            <div
              data-v-dfe5a850=""
              data-v-db6621f4=""
              class="CoreImageDefault CoreImageDefault__display--none"
              style="--ids-image-default-size: 100%"
            >
              <svg
                data-v-6d2bd019=""
                data-v-dfe5a850=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon CoreImageDefault__icon"
                style="
                  width: 30%;
                  height: 30%;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #ffffff;
                "
              >
                <path
                  d="M9.98878 22C8.00515 22 6.20082 21.0922 4.92883 19.4213C3.54252 17.599 3.12786 15.0371 3.84847 12.7341C4.77753 9.75972 7.76195 7.01737 12.3355 7.59565C12.8174 7.65617 13.2993 7.74919 13.7745 7.87134V2H17.2229V9.35067C18.6148 10.1553 19.879 11.0721 21.0008 12.0919L18.9252 14.748C18.4209 14.275 17.6925 13.6911 17.1164 13.2776C17.0761 13.9803 16.9808 14.7659 16.8576 15.4641C16.5594 17.153 15.8254 18.7903 14.6184 20.0253C13.3655 21.3063 11.7797 21.9989 9.9899 21.9989L9.98878 22ZM11.1297 10.8883C8.12842 10.8883 7.23186 13.2361 7.07385 13.7416C6.59531 15.2724 7.04135 16.6262 7.61738 17.3838C8.03653 17.9341 8.96895 18.8239 10.4942 18.5875C12.1786 18.3263 13.2489 16.5388 13.5425 14.8757C13.7353 13.7842 13.8115 12.6803 13.8417 11.415C12.9867 11.0945 12.0453 10.8883 11.1297 10.8883Z"
                ></path>
              </svg>
            </div>
          </div>
<!--          <div-->
<!--            data-v-f8c6bf35=""-->
<!--            data-v-eee6c6ce=""-->
<!--            class="ProductCardFavorite BaseProductCardImage__favorite"-->
<!--            style="&#45;&#45;product-card-favorite-size: 44"-->
<!--          >-->
<!--            <span-->
<!--              data-v-b1510e51=""-->
<!--              data-v-f8c6bf35=""-->
<!--              name="favorite_fill_shadow_p5"-->
<!--              class="BaseIconColor BaseIconColor__favorite_fill_shadow_p5"-->
<!--              style="&#45;&#45;BaseIconColor-size: 28"-->
<!--            ></span>-->
<!--            <span data-v-b1510e51="" data-v-f8c6bf35="" name="favorite_shadow_p5" class="BaseIconColor BaseIconColor__favorite_shadow_p5" style="&#45;&#45;BaseIconColor-size: 28;"></span> 하트 빈거-->
<!--          </div>-->
          <!---->
          <div
            data-v-eee6c6ce=""
            class="BaseProductCardImage__imageBottom"
          ></div>
          <!---->
        </div>
      </div>
      <div
        data-v-87378e3e=""
        data-v-d1265ec2=""
        class="BaseProductCardVerticalContents__size--large BaseProductCardVerticalContents"
        style="--product-card-contents-margin-y: 10"
      >
        <div
          data-v-87378e3e=""
          class="BaseProductCardVerticalContents__artistName"
        >
          <span data-v-87378e3e="" class="line-clamp-1 gray-999--text">{{
            product.atelier_name
          }}</span
          ><!---->
        </div>
        <div
          data-v-87378e3e=""
          class="BaseProductCardVerticalContents__productName"
        >
          {{ product.name }}
        </div>
        <div
          data-v-87378e3e=""
          class="BaseProductCardVerticalContents__priceContainer"
        >
          <div
            data-v-87378e3e=""
            class="BaseProductCardVerticalContents__priceContainerDiscount"
          >
            15%
          </div>
          <div
            data-v-87378e3e=""
            class="BaseProductCardVerticalContents__priceContainerPrice"
          >
            {{ product.price
            }}<span
              data-v-87378e3e=""
              class="BaseProductCardVerticalContents__priceContainerPriceUnit"
              >원</span
            >
          </div>
        </div>
        <div class="mt-[4px] mb-[8px]">
          <div
            class="flex flex-wrap items-end subtitle3-bold-small red-500--text"
          >
            10,450<span class="body3-regular-small mr-[4px]">원</span>  <!--TODO 할인 적용률 값 넣기 -->
            <div></div>
          </div>
        </div>
        <div
          data-v-87378e3e=""
          class="BaseProductCardVerticalContents__reviewRate"
        >
          <div
            data-v-2c82c531=""
            data-v-87378e3e=""
            class="BaseRating BaseRating__sizeText--small"
            style="--BaseRating-gap: 0"
          >
            <div data-v-2c82c531="" class="BaseRating__rangeList">
              <svg
                data-v-6d2bd019=""
                data-v-2c82c531=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon CoreStar__type--full BaseRating__rangeListItem"
                style="
                  width: 14px;
                  height: 14px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #ffaf00;
                "
              >
                <g clip-path="url(#clip0_124_2995)">
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                  ></path>
                </g>
                <defs>
                  <clipPath id="clip0_124_2995">
                    <rect width="24" height="24"></rect>
                  </clipPath>
                </defs>
              </svg>
            </div>
            <div data-v-2c82c531="" class="BaseRating__label">
              <div data-v-2c82c531="" class="BaseRating__labelRate">
                {{ product.averageScore }}
              </div>
              <div data-v-2c82c531="" class="BaseRating__labelAppned">(6)</div> <!--TODO : 총 후기 수 넣기 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { computed } from "vue";
import { useLikesStore } from "@/stores/useLikesStore";

export default {
  props: {
    product: {
      type: Object,
      required: true,
    },
  },
  setup(props) {
    const likesStore = useLikesStore();

    // 현재 상품이 찜 상태인지 확인
    const isLiked = computed(() => {
      return likesStore.productList.some(
        (item) => item.idx === props.product.idx
      );
    });

    // 찜하기 토글 함수
    const toggleLike = () => {
      likesStore.toggleLike(props.product.idx);
    };

    return {
      isLiked,
      toggleLike,
    };
  },
};
</script>

<style scoped>
.img-ratio {
  background-size: cover !important;
  background-position: center !important;
  aspect-ratio: 1 / 1; /* 정사각형 비율 */
  width: 100%; /* 부모 요소의 넓이에 맞추어 넓이를 100%로 설정 */
}

</style>