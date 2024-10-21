<template>
  <div>
    <div class="width-100">
      <p class="headline4-bold-small mb-[40px] text-align">주문/배송 내역</p>
      <div class="flex items-center mb-[30px]">
        <div class="mr-[4px] shrink-0 flex items-center">
          <div data-v-d1f9d3af="" data-v-6f505039="" class="BaseMenus__wrapper">
            <div
              data-v-d1f9d3af=""
              class="BaseMenus__toggle"
              @click="toggleOnOff"
            >
              <label
                data-v-6f505039=""
                class="BaseDropdown__label BaseDropdown--small"
                tabindex="0"
              >
                <div data-v-6f505039="" class="flex">
                  <!----><span
                    data-v-6f505039=""
                    class="BaseDropdown__value body1-regular-medium line-clamp-1"
                    >{{ selectedYear }}</span
                  ><span
                    data-v-6f505039=""
                    class="BaseDropdown__placeholder body1-regular-medium"
                  ></span>
                </div>
                <svg
                  data-v-6d2bd019=""
                  data-v-6f505039=""
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  class="BaseIcon ml-[8px]"
                  :class="{ rotated: toggleOn }"
                  style="
                    width: 24px;
                    height: 24px;
                    opacity: 1;
                    fill: currentcolor;
                    --BaseIcon-color: #333333;
                  "
                >
                  <g clip-path="url(#clip0_124_2950)">
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M7 10L12 15L17 10H7Z"
                    ></path>
                  </g>
                  <defs>
                    <clipPath id="clip0_124_2950">
                      <rect width="24" height="24"></rect>
                    </clipPath>
                  </defs>
                </svg>
              </label>
            </div>
            <!-- 년도 토글 -->
            <div
              class="BaseMenus BaseMenus__position--bottom"
              style="--ids-menus-offset-x: 0; --ids-menus-toggle-height: 36"
              data-v-d1f9d3af=""
              :class="{ 'toggle-off': !toggleOn }"
            >
              <!--[-->
              <div
                v-for="year in orderStore.years"
                :key="year.idx"
                @click="select(year)"
                data-v-d1f9d3af=""
              >
                <div
                  class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                  data-v-a833c376=""
                  data-v-d1f9d3af=""
                >
                  <label
                    class="BaseCheckmark BaseCheckmark__verticalAlign--center BaseCheckmark__state--checked BaseCheckmark__fontStyle--bold px-[12px]"
                    style="--BaseCheckmark--label-margin: 0"
                    data-v-28b63d4b=""
                    data-v-a833c376=""
                    ><input
                      type="radio"
                      class="BaseCheckmark__input"
                      value="2024"
                      checked=""
                      data-v-28b63d4b="" />
                    <span
                      class="BaseCheckmark__text"
                      style="color: #333333"
                      data-v-28b63d4b=""
                      >{{ year.year }}</span
                    ><span
                      class="BaseCheckmark__button not-selected"
                      data-v-28b63d4b=""
                      :class="{ selected: selectedIdx === year.idx }"
                      ><svg
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg"
                        style="
                          width: 20px;
                          height: 20px;
                          opacity: 1;
                          fill: currentColor;
                          --BaseIcon-color: #ef7014;
                        "
                        class="BaseIcon BaseCheckmark__icon"
                        data-v-6d2bd019=""
                        data-v-28b63d4b=""
                      >
                        <g clip-path="url(#clip0_124_2952)">
                          <path
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M19.4697 5.46973L20.5303 6.53039L9.53033 17.5304C9.26406 17.7967 8.8474 17.8209 8.55378 17.603L8.46967 17.5304L3.46967 12.5304L4.53033 11.4697L9 15.9391L19.4697 5.46973Z"
                          ></path>
                        </g>
                        <defs>
                          <clipPath id="clip0_124_2952">
                            <rect width="24" height="24"></rect>
                          </clipPath>
                        </defs></svg></span
                  ></label>
                </div>
                <div class="BaseMenus__divider" data-v-d1f9d3af=""></div>
              </div>
              <!--]-->
            </div>
          </div>
        </div>
      </div>
      <EmptyContentComponent
        v-if="this.orderStore.orderList.length === 0"
        content="주문 목록이 없습니다."
      />
      <div v-if="this.orderStore.orderList.length !== 0">
        <div>
          <!---->
          <div class="pb-[16px]">
            <div
              v-for="order in orderStore.orderList"
              :key="order.idx"
              class="border border-[#d9d9d9] white--background mb-[16px] last:mb-0 border-gray"
            >
              <div
                class="border-b border-[#d9d9d9] flex justify-between items-center px-[12px] h-[40px] cursor-pointer border-bottom-gray"
              >
                <p class="gray-999--text body1-bold-small">{{ formatDate(order.date) }}</p>
                <button
                  data-v-524f63ea=""
                  data-v-8493c3f2=""
                  type="default"
                  class="CoreButton BaseButtonText body1-regular-small !pr-0"
                  style="
                    background-color: transparent;
                    color: rgb(51, 51, 51);
                    height: 32px;
                    flex-direction: row-reverse;
                    --core-button-padding-x: 8;
                    font-weight: bold;
                  "
                >
                  <!----><svg
                    data-v-6d2bd019=""
                    data-v-524f63ea=""
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    class="BaseIcon CoreButton__icon"
                    style="
                      width: 18px;
                      height: 18px;
                      opacity: 1;
                      fill: currentcolor;
                      --BaseIcon-color: #333333;
                      margin-left: 0px;
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
                    </defs>
                  </svg>
                  <div data-v-524f63ea="" class="inline-flex items-center">
                    <span data-v-524f63ea="" class="CoreButton__text"
                      >{{ formatPrice(order.price) }}원</span
                    >
                  </div>
                </button>
              </div>
              <div
                class="border-b border-[#d9d9d9] last:border-none py-[12px] cursor-pointer"
              >
                <div class="flex justify-between items-center px-[12px]">
                  <div class="w-[60px] h-[60px] shrink-0 mr-[8px]">
                    <div
                      data-v-db6621f4=""
                      class="CoreImageRatio__loadStatus--success CoreImageRatio rounded-[4px]"
                      :style="`--ids-image-background: url(${order.imageUrl});`"
                      style="
                        --ids-image-ratio: 1;
                      "
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
                  </div>
                  <div class="w-full">
                    <p
                      class="body1-bold-small mb-[8px] line-clamp-1 text-ellipsis align-left"
                    >
                      {{ order.name }}
                    </p>
                    <p
                        class="body1-regular-small gray-999--text line-clamp-1 text-ellipsis align-left"
                        style="margin-bottom: 5px"
                    >
                      {{ order.optionString }}
                    </p>
                    <p
                      class="body1-regular-small gray-999--text line-clamp-1 text-ellipsis align-left"
                    >
                      {{ order.atelier }}
                    </p>
                  </div>
                  <div
                    data-v-24a9185e=""
                    class="BaseBadgeBusiness BaseBadgeBusiness__colorType--gray-f5 BaseBadgeBusiness__size--large BaseBadgeBusiness__style--round shrink-0"
                    style="font-weight: normal"
                  >
                    {{ order.state }}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useOrderStore } from "@/stores/useOrderStore";
import EmptyContentComponent from "@/components/common/EmptyContentComponent.vue";
import {formatDate} from "@/utils/formatDate";
import {formatPrice} from "@/utils/formatPrice";

export default {
  name: "OrderListComponent",
  components: {
    EmptyContentComponent,
  },
  computed: {
    ...mapStores(useOrderStore),
  },
  mounted() {
    // this.getOrderList();
    this.selectedYear = this.orderStore.years[0].year;
  },
  created() {
    this.getOrderList(0);
  },
  data() {
    return {
      toggleOn: false,
      selectedIdx: 1,
      selectedYear: 0,
    };
  },
  methods: {
    formatPrice,
    formatDate,
    getOrderList(year) {
      this.orderStore.getOrderList(year);
    },
    toggleOnOff() {
      this.toggleOn = !this.toggleOn;
    },
    select(year) {
      this.selectedIdx = year.idx;
      this.selectedYear = year.year;
      this.toggleOn = false;
      if (year.idx === 1) {
        this.getOrderList(0);
      } else {
        this.getOrderList(year.year);
      }
    },
  },
};
</script>

<style scoped>
.width-100 {
  width: 100%;
}
.align-left {
  text-align: left;
}
.border-gray {
  border: 1px rgb(217 217 217) solid;
}
.border-bottom-gray {
  border-bottom: 1px rgb(217 217 217) solid;
}
.toggle-off {
  display: none;
}
.not-selected {
  display: none;
}
.selected {
  display: block;
}
.rotated {
  transform: rotate(180deg);
  transition: transform 0s ease;
}
.margin-top {
  margin-top: 100px;
}
.text-align {
  text-align: left;
}
</style>