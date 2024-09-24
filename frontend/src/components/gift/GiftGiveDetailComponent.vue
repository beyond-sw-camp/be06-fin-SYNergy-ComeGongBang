<template>
  <div class="w-full pl-6">
    <div class="w-full">
      <p class="headline4-bold-small mb-[56px] text-left padding-left">보낸 선물 상세보기</p>
      <div class="grid gap-[36px]">
        <GiftGiveComponent :gift="giftStore.giftGiveDetailInfo"/>
        <div
          data-v-b786c61e=""
          class="GiftSendMessageCardDesktop border-b border-[#f5f5f5] padding-left"
        >
          <p
            data-v-b786c61e=""
            class="subtitle2-bold-small border-b pb-[16px] border-[#333333] text-left"
          >
            선물 받는 분
          </p>
          <div data-v-b786c61e="" class="grid grid-cols-2 my-[20px] gap-[20px]">
            <div data-v-b786c61e="" class="flex flex-col gap-[20px] text-left">
              <div
                data-v-b786c61e=""
                class="GiftSendMessageCardDesktop__formRow"
              >
                <p data-v-b786c61e="" class="GiftSendMessageCardDesktop__text">
                  받는 사람
                </p>
                <p data-v-b786c61e="" class="GiftSendMessageCardDesktop__text">
                  {{giftStore.giftGiveDetailInfo.toUser}}
                </p>
              </div>
              <div
                data-v-b786c61e=""
                class="GiftSendMessageCardDesktop__formRow"
              >
                <p data-v-b786c61e="" class="GiftSendMessageCardDesktop__text">
                  휴대폰
                </p>
                <div
                  data-v-b786c61e=""
                  class="flex justify-between w-full items-center"
                >
                  <p
                    data-v-b786c61e=""
                    class="body1-regular-small min-w-[110px]"
                  >
                    {{giftStore.giftGiveDetailInfo.toPhone}}
                  </p>
                  <!---->
                </div>
              </div>
              <!---->
              <div
                data-v-b786c61e=""
                class="GiftSendMessageCardDesktop__formRow"
              >
                <p data-v-b786c61e="" class="GiftSendMessageCardDesktop__text">
                  선물 메시지
                </p>
                <p
                  data-v-b786c61e=""
                  class="GiftSendMessageCardDesktop__message"
                >
                  {{giftStore.giftGiveDetailInfo.message}}
                </p>
              </div>
            </div>
          </div>
        </div>
        <div
          data-v-7a558f2d=""
          class="GiftPaymentInfoCardDesktop border-b border-[#f5f5f5] padding-left"
        >
          <p
            data-v-7a558f2d=""
            class="subtitle2-bold-small border-b pb-[16px] border-[#333333] text-left"
          >
            결제 정보
          </p>
          <div data-v-7a558f2d="" class="grid grid-cols-2">
            <div data-v-7a558f2d="" class="border-r border-[#f5f5f5]">
              <div
                data-v-7a558f2d=""
                class="flex flex-col gap-[8px] py-[16px] pr-[16px]"
              >
                <!----><!---->
                <div data-v-7a558f2d="" class="flex justify-between">
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 12px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >작품금액</span
                    >
                  </div>
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 14px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >{{giftStore.giftGiveDetailInfo.price}}원</span
                    >
                  </div>
                </div>
                <div data-v-7a558f2d="" class="flex justify-between">
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 12px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >상품 할인 금액</span
                    >
                  </div>
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 14px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >{{giftStore.giftGiveDetailInfo.discount}}원</span
                    >
                  </div>
                </div>
                <div data-v-7a558f2d="" class="flex justify-between">
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 12px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >배송비</span
                    >
                  </div>
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 14px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >{{giftStore.giftGiveDetailInfo.deliveryFee}}원</span
                    >
                  </div>
                </div>
                <div data-v-7a558f2d="" class="flex justify-between">
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 12px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >적립금 사용금액</span
                    >
                  </div>
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 14px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >-{{giftStore.giftGiveDetailInfo.savings}}원</span
                    >
                  </div>
                </div>
                <div data-v-7a558f2d="" class="flex justify-between">
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 12px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >결제수단</span
                    >
                  </div>
                  <div
                    data-v-a1957620=""
                    data-v-7a558f2d=""
                    class="BaseDecorateText transform-gpu whitespace-pre inline"
                  >
                    <span
                      data-v-a1957620=""
                      class="DecorateText"
                      style="
                        font-size: 14px;
                        color: rgb(51, 51, 51);
                        background-color: inherit;
                      "
                      >{{giftStore.giftGiveDetailInfo.payment}}</span
                    >
                  </div>
                </div>
              </div>
            </div>
            <div data-v-7a558f2d="" class="pl-[16px] py-[16px]">
              <div data-v-7a558f2d="" class="flex justify-between mb-[15px]">
                <div
                  data-v-a1957620=""
                  data-v-7a558f2d=""
                  class="BaseDecorateText transform-gpu whitespace-pre inline"
                >
                  <span
                    data-v-a1957620=""
                    class="DecorateText DecorateText--bold"
                    style="
                      font-size: 14px;
                      color: rgb(51, 51, 51);
                      background-color: inherit;
                    "
                    >최종 결제금액</span
                  >
                </div>
                <div
                  data-v-a1957620=""
                  data-v-7a558f2d=""
                  class="BaseDecorateText transform-gpu whitespace-pre inline"
                >
                  <span
                    data-v-a1957620=""
                    class="DecorateText DecorateText--bold"
                    style="
                      font-size: 16px;
                      color: rgb(51, 51, 51);
                      background-color: inherit;
                    "
                    >{{giftStore.giftGiveDetailInfo.totalPrice}}원</span
                  >
                </div>
              </div>
              <!---->
            </div>
          </div>
        </div>
        <!---->
      </div>
    </div>
  </div>
</template>

<script>
import GiftGiveComponent from './GiftGiveComponent.vue';

import { mapStores } from "pinia";
import { useGiftStore } from "@/stores/useGiftStore"

export default {
    components:{
        GiftGiveComponent
    },
    computed:{
        ...mapStores(useGiftStore)
    }
};
</script>

<style scoped>
.text-left{
    text-align: left;
}
.padding-left{
    padding-left: 1.5rem;
}
</style>