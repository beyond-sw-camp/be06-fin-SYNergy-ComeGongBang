<template>
  <div class="w-full pl-6 text-left">
    <div class="PageGiftReceiveDetailDesktop w-full">
      <p class="headline4-bold-small mb-[56px] text-left">받은 선물 상세보기</p>
      <div class="PageGiftReceiveDetailDesktop__contents grid gap-[36px]">
        <div class="border-b border-[#f5f5f5]">
          <p
            class="subtitle2-bold-small border-b pb-[16px] border-[#333333] text-left"
          >
            선물 메시지
          </p>
          <div class="grid grid-cols-2 my-[20px] gap-[20px]">
            <div>
              <p class="subtitle2-bold-small text-left">
                {{ giftStore.giftReceivedDetailInfo.fromUser }}으로부터 선물이
                도착했어요!
              </p>
              <p
                class="body1-regular-medium mt-[20px] whitespace-pre-line text-left"
              >
                {{ giftStore.giftReceivedDetailInfo.message }}
              </p>
            </div>
          </div>
        </div>
        <div>
          <div
            class="flex justify-between border-b items-center py-[16px] border-[#333333]"
          >
            <p class="subtitle2-bold-small gray-333--text">
              선물 작품 정보 ({{ giftStore.giftReceivedDetailInfo.count }}건)
            </p>
            <button
              data-v-524f63ea=""
              data-v-778c1d9b=""
              type="button"
              class="CoreButton BaseButtonIcon"
              style="
                background-color: transparent;
                color: rgb(51, 51, 51);
                height: 24px;
                flex-direction: column;
                font-weight: normal;
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
                  width: 24px;
                  height: 24px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #333333;
                  margin-bottom: 0px;
                "
              >
                <g clip-path="url(#clip0_124_2948)">
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M11.4697 8.46967C11.736 8.2034 12.1527 8.1792 12.4463 8.39705L12.5304 8.46967L18.5304 14.4697L17.4697 15.5303L12.0001 10.061L6.53039 15.5303L5.46973 14.4697L11.4697 8.46967Z"
                  ></path>
                </g>
                <defs>
                  <clipPath id="clip0_124_2948">
                    <rect width="24" height="24"></rect>
                  </clipPath>
                </defs>
              </svg>
              <div data-v-524f63ea="" class="inline-flex items-center">
                <!---->
              </div>
            </button>
          </div>
          <div>
            <table class="min-w-full">
              <thead class="hidden">
                <tr>
                  <th>작품명</th>
                  <th>배송상태</th>
                  <th>작가명</th>
                </tr>
              </thead>
              <tbody class="border-b border-[#f5f5f5]">
                <tr
                  class="border-r border-[#f5f5f5]"
                  colspan="1"
                  v-for="product in giftStore.giftReceivedDetailInfo.products"
                  :key="product.idx"
                >
                  <td
                    data-v-3259b056=""
                    class="DesktopGiftReceiveDetailProductItem flex w-full group mt-[16px] pr-[16px]"
                    product-state="SHIPPED"
                    clickable="false"
                  >
                    <div data-v-3259b056="" class="mr-[12px]">
                      <div
                        data-v-24b1dfb3=""
                        data-v-3259b056=""
                        class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight BaseImage__hover"
                        style="
                          --BaseImage-width: 64;
                          --BaseImage-height: 64;
                          --BaseImage-radius: 2;
                        "
                      >
                        <div data-v-24b1dfb3="" class="BaseImage__image">
                          <img
                            data-v-24b1dfb3=""
                            :src="product.image_url"
                            loading="lazy"
                          />
                        </div>
                      </div>
                    </div>
                    <div data-v-3259b056="" class="flex flex-col w-full">
                      <div
                        data-v-3259b056=""
                        class="flex justify-start mb-[6px]"
                      >
                        <div
                          data-v-b6faa6c8=""
                          data-v-3259b056=""
                          class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__colorType--gray IDSTooltip__innerPosition--right IDSTooltip__innerAlign--center IDSTooltip__innerCloseAlign--center"
                          style="--ids-tooltip-full-left: --8px"
                        >
                          <div data-v-b6faa6c8="" class="IDSTooltip__trigger">
                            <div
                              data-v-24a9185e=""
                              data-v-3259b056=""
                              class="BaseBadgeBusiness BaseBadgeBusiness__colorType--black-500 BaseBadgeBusiness__size--large BaseBadgeBusiness__style--round"
                              style="
                                font-weight: normal;
                                color: rgb(102, 102, 102);
                                background-color: rgb(245, 245, 245);
                              "
                            >
                              <!---->
                              {{ product.state }}
                            </div>
                          </div>
                          <!---->
                        </div>
                      </div>
                      <p
                        data-v-3259b056=""
                        class="body1-regular-small gray-333--text line-clamp-2 text-left"
                      >
                        {{ product.name }}
                      </p>
                      <div data-v-3259b056="">
                        <div
                          data-v-3259b056=""
                          class="flex items-center py-[12px] justify-between"
                        >
                          <div data-v-3259b056="">
                            <ul data-v-3259b056="">
                              <li data-v-3259b056="">
                                메뉴 : 랜덤마카롱 6개 (+9,500원)
                              </li>
                            </ul>
                            <ul data-v-3259b056="">
                              <li data-v-3259b056="">상자 : 상자선택안함</li>
                            </ul>
                          </div>
                          <p data-v-3259b056="" class="gray-333--text flex">
                            <span data-v-3259b056="" class="body3-regular-small"
                              >{{ product.count }}개</span
                            ><!---->
                          </p>
                        </div>
                        <!---->
                      </div>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <!---->
        <div
          class="white--background w-full flex flex-col pb-[20px] border-b border-[#f5f5f5]"
        >
          <div
            class="flex justify-between items-center py-[16px] mb-[20px] border-b border-[#333333]"
          >
            <div class="subtitle2-bold-small gray-333--text">배송 정보</div>
          </div>
          <div class="GiftInformation">
            <div class="flex flex-col gap-[12px]">
              <div
                class="GiftInformationRow flex items-center justify-between w-full"
              >
                <div
                  class="GiftInformationRow__label self-baseline body1-regular-small gray-333--text min-w-[70px] w-[70px] mr-[8px] mt-[1px]"
                >
                  받는 사람
                </div>
                <div
                  class="GiftInformationRow__value body1-regular-small gray-333--text flex-auto"
                >
                  {{ giftStore.giftReceivedDetailInfo.deliveryInfo.toUser }}
                </div>
              </div>
              <div
                class="GiftInformationRow flex items-center justify-between w-full"
              >
                <div
                  class="GiftInformationRow__label self-baseline body1-regular-small gray-333--text min-w-[70px] w-[70px] mr-[8px] mt-[1px]"
                >
                  <span class="break-keep">휴대폰</span>
                </div>
                <div
                  class="GiftInformationRow__value body1-regular-small gray-333--text flex-auto"
                >
                  {{ giftStore.giftReceivedDetailInfo.deliveryInfo.phone }}
                </div>
              </div>
              <div
                class="GiftInformationRow flex items-center justify-between w-full"
              >
                <div
                  class="GiftInformationRow__label self-baseline body1-regular-small gray-333--text min-w-[70px] w-[70px] mr-[8px] mt-[1px]"
                >
                  주소
                </div>
                <div
                  class="GiftInformationRow__value body1-regular-small gray-333--text flex-auto"
                >
                  ({{ giftStore.giftReceivedDetailInfo.deliveryInfo.post }}){{
                    giftStore.giftReceivedDetailInfo.deliveryInfo.address
                  }}
                  {{
                    giftStore.giftReceivedDetailInfo.deliveryInfo.addressDetail
                  }}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="grid border-y border-[#f5f5f5]">
          <div class="">
            <div
              class="flex justify-between items-center select-none cursor-pointer h-[48px]"
            >
              <strong class="body1-regular-small">유의사항</strong
              ><svg
                data-v-6d2bd019=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon"
                style="
                  width: 20px;
                  height: 20px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #333333;
                "
              >
                <g clip-path="url(#clip0_124_2948)">
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M11.4697 8.46967C11.736 8.2034 12.1527 8.1792 12.4463 8.39705L12.5304 8.46967L18.5304 14.4697L17.4697 15.5303L12.0001 10.061L6.53039 15.5303L5.46973 14.4697L11.4697 8.46967Z"
                  ></path>
                </g>
                <defs>
                  <clipPath id="clip0_124_2948">
                    <rect width="24" height="24"></rect>
                  </clipPath>
                </defs>
              </svg>
            </div>
            <div class="pr-[ipx] pt-[4px] pb-[20px]">
              <div class="body3-regular-medium gray-666--text">
                • 위 유효기간까지 배송 주소 입력이 완료되어야 하며, 유효기간
                만료 시 선물은 취소됩니다.<br />• 배송 주소 입력 후, 선물 받으신
                작품의 품절 혹은 작가의 사정에 의해 주문취소가 진행될 수
                있습니다.<br />• 제주/도서 산간 지역은 선물하기 서비스가
                제한됩니다.
              </div>
            </div>
          </div>
          <!---->
        </div>
      </div>
      <!----><!---->
    </div>
    <button
      data-v-524f63ea=""
      data-v-7940d6dd=""
      type="fill"
      class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill grow button-style"
      style="
        background-color: rgb(239, 112, 20);
        color: rgb(255, 255, 255);
        height: 44px;
        flex-direction: row;
        --core-button-padding-x: 16;
      "
      @click="changeGiftStatus"
      :disabled="giftStore.giftReceivedDetailInfo.status"
    >
      <!----><!---->
      <div data-v-524f63ea="" class="inline-flex items-center">
        <span data-v-524f63ea="" class="CoreButton__text">선물 받기</span>
      </div>
    </button>
  </div>
</template>

<script>
// import GiftReceivedComponent from "./GiftReceivedComponent.vue";

import { mapStores } from "pinia";
import { useGiftStore } from "@/stores/useGiftStore";

export default {
  components: {
    // GiftReceivedComponent,
  },
  computed: {
    ...mapStores(useGiftStore),
  },
  methods: {
    changeGiftStatus() {
      //상품 상태 변경??
      this.giftStore.giftReceivedDetailInfo.status = true;
      //알림
      alert("선물 받기 완료");
      //버튼 비활성화
    },
  },
};
</script>

<style scoped>
.text-left {
  text-align: left;
}
.padding-left {
  padding-left: 1.5rem;
}
.button-style {
  width: 300px !important;
  margin-left: 50%;
  transform: translate(-50%, 0);
  margin-top: 50px;
}
</style>