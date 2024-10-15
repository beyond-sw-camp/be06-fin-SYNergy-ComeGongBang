<template>
  <div
    v-for="review in reviewList"
    :key="review.reviewIdx"
    data-v-e18d7120=""
    class="px-[16px] pt-[12px] pb-[16px] border-b-4 border-[#f5f5f5] DesktopWrittenReviewItem"
  >
    <a
      data-v-e18d7120=""
      href="https://www.idus.com/v2/product/51fb9acf-861a-42bc-95cb-139ab6286bb8"
      rel="noopener noreferrer"
      class="flex items-center justify-between pb-[12px] border-b border-[#f5f5f5]"
      ><div data-v-e18d7120="" class="flex items-center">
        <div data-v-e18d7120="" class="min-w-[40px] min-h-[40px] mr-[8px]">
          <div
            data-v-eee6c6ce=""
            data-v-e18d7120=""
            class="BaseProductCardImage BaseProductCardImage__size--large"
            style="--product-card-round: 8"
          >
            <div data-v-eee6c6ce="" class="BaseProductCardImage__image">
              <div
                data-v-db6621f4=""
                data-v-eee6c6ce=""
                class="CoreImageRatio__loadStatus--success CoreImageRatio"
                radius="8"
                :style="{
                  '--ids-image-background': `url(${review.thumbnailImages})`,
                  '--ids-image-ratio': 1,
                }"
              >
                <div
                  data-v-db6621f4=""
                  class="CoreImageRatio__image"
                  role="img"
                  alt=""
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
              <!----><!----><!----><!---->
            </div>
          </div>
        </div>
        <div data-v-e18d7120="" class="subtitle3-regular-small gray-666--text">
          {{ review.productName }}
        </div>
      </div>
      <svg
        data-v-6d2bd019=""
        data-v-e18d7120=""
        width="24"
        height="24"
        viewBox="0 0 24 24"
        xmlns="http://www.w3.org/2000/svg"
        class="BaseIcon"
        style="
          width: 24px;
          height: 24px;
          opacity: 1;
          fill: currentcolor;
          --BaseIcon-color: #acacac;
        "
      >
        <g clip-path="url(#clip0_124_2947)">
          <path
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z"
          ></path>
        </g>
        <defs>
          <clipPath id="clip0_124_2947">
            <rect width="24" height="24"></rect>
          </clipPath>
        </defs></svg></a
    ><a
      data-v-e18d7120=""
      href="https://www.idus.com/w/review/6a0c43b4-02ab-4610-9152-b876c8764877"
      rel="noopener noreferrer"
      ><div
        data-v-e18d7120=""
        class="flex justify-between items-center pt-[16px]"
      >
        <!-- 별점 -->
        <div
          data-v-2c82c531=""
          data-v-e18d7120=""
          class="BaseRating BaseRating__sizeText--small"
          style="--BaseRating-gap: 2"
        >
          <div data-v-2c82c531="" class="BaseRating__rangeList">
            <!-- Filled Stars -->
            <template v-for="index in 5" :key="index">
              <svg
                v-if="index <= review.score"
                data-v-6d2bd019=""
                data-v-2c82c531=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon CoreStar__type--full BaseRating__rangeListItem"
                style="
                  width: 24px;
                  height: 24px;
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
              <svg
                v-else
                data-v-6d2bd019=""
                data-v-2c82c531=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon CoreStar__type--empty BaseRating__rangeListItem"
                style="
                  width: 24px;
                  height: 24px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #d9d9d9;
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
            </template>
          </div>
        </div>

        <div data-v-e18d7120="" class="body1-regular-small gray-999--text">
          {{ formatDate(review.createdAt) }}
        </div>
      </div>
      <div data-v-e18d7120="" class="flex w-[700px] pt-[10px]">
        <!---->
        <div
          data-v-e18d7120=""
          class="line-clamp-4 subtitle3-regular-medium h-fit"
        >
          {{ review.content }}
        </div>
      </div></a
    >
  </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/useReviewStore";
import { onMounted, computed } from "vue";
import { formatDate } from "@/utils/formatDate";

const reviewStore = useReviewStore();
const reviewList = computed(() => reviewStore.reviewList);

onMounted(() => {
  reviewStore.fetchMyReviews();
});

</script>
