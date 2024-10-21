<template>
  <!-- 로딩창-->
  <div v-if="orderStore.loading" class="BaseOverlay z-[1000]" style="
                --BaseOverlay-position: fixed;
                --BaseOverlay-background: rgba(245, 245, 245, 0.6);
                --BaseOverlay-blur: blur(0px);
              " data-v-546911c4="" data-v-a5290452="">
    <div class="BaseOverlay__scrim" data-v-546911c4=""></div>
    <div class="BaseOverlay__content" data-v-546911c4="">
      <div class="flex justify-center items-center" data-v-a5290452="">
        <div class="relative w-full" data-v-a5290452="">
          <div class="BaseProgressIndicator flex justify-center items-center w-full h-[108px]"
               data-v-a5290452="" data-v-3e1417ba="">
            <div class="BaseLoaderCircle" style="width: 48px; height: 48px" data-v-d3ab2c08=""
                 data-v-3e1417ba="">
              <svg viewBox="0 0 50 50" class="BaseLoaderCircle__inner" data-v-d3ab2c08="">
                <circle class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--underlay" cx="50%"
                        cy="50%" r="20" data-v-d3ab2c08=""></circle>
                <circle class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--overlay" cx="50%"
                        cy="50%" r="20" data-v-d3ab2c08=""></circle>
              </svg>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!---------------->
  <div
    data-v-261d543d=""
    class="appContainer"
    style="
      --desktop-header-menu-top: 75px;
      --desktop-header-sticky-height: 124px;
    "
  >
    <div data-v-261d543d="" id="MoveToTopTrigger"></div>
    <div data-v-261d543d="" class="appContents">
      <div>
        <div class="flex flex-col">
          <div class="flex justify-between items-center w-full my-[40px]">
            <span class="headline4-bold-small">주문 결제</span>
            <div data-v-efa8f703="" class="DesktopOrderStepper">
              <div data-v-efa8f703="" class="flex">
                <div data-v-efa8f703="" class="mr-[8px]">01</div>
                <div data-v-efa8f703="" class="mr-[8px]">장바구니</div>
              </div>
              <svg
                data-v-6d2bd019=""
                data-v-efa8f703=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon mr-[8px] last:hidden"
                style="
                  width: 20px;
                  height: 20px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #d9d9d9;
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
              <div data-v-efa8f703="" class="flex DesktopOrderStepper--active">
                <div data-v-efa8f703="" class="mr-[8px]">02</div>
                <div data-v-efa8f703="" class="mr-[8px]">주문 결제</div>
              </div>
              <svg
                data-v-6d2bd019=""
                data-v-efa8f703=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon mr-[8px] last:hidden"
                style="
                  width: 20px;
                  height: 20px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #d9d9d9;
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
              <div data-v-efa8f703="" class="flex">
                <div data-v-efa8f703="" class="mr-[8px]">03</div>
                <div data-v-efa8f703="" class="mr-[8px]">주문 완료</div>
              </div>
              <svg
                data-v-6d2bd019=""
                data-v-efa8f703=""
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                class="BaseIcon mr-[8px] last:hidden"
                style="
                  width: 20px;
                  height: 20px;
                  opacity: 1;
                  fill: currentcolor;
                  --BaseIcon-color: #d9d9d9;
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
            </div>
          </div>
          <div class="flex justify-between mb-[80px]">
            <div class="w-[800px] mt-[16px] mr-[80px]">
<!--              받는 사람-->
              <div
                data-v-30a5f488=""
                class="DesktopPaymentPresentTaker mb-[36px]"
              >
                <div
                  data-v-b1bb0ef0=""
                  data-v-30a5f488=""
                  class="DesktopPaymentSection"
                >
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                    <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                      <span data-v-b1bb0ef0="">받는 사람</span
                      ><!---->
                    </div>
                    <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__right"
                    >
                      <!---->
                    </div>
                  </div>
                  <div data-v-b1bb0ef0="">
                    <div
                      data-v-30a5f488=""
                      class="DesktopPaymentPresentTaker__row mb-[16px] margin-top-16"
                    >
                      <div
                        data-v-30a5f488=""
                        class="DesktopPaymentPresentTaker__title"
                      >
                        <span
                          data-v-30a5f488=""
                          class="body1-regular-small gray-666--text"
                          >아이디</span
                        >
                        <span data-v-30a5f488="" class="red-500--text ml-[4px]"
                          >*</span
                        >
                      </div>
                      <div
                        data-v-30a5f488=""
                        class="DesktopPaymentPresentTaker__input"
                      >
                        <div
                          data-v-6d6ea1ac=""
                          class="BaseTextField__container"
                          showerrormessage="true"
                        >
                          <div
                            data-v-e2593c18=""
                            data-v-6d6ea1ac=""
                            class="BaseLabelText"
                            style="display: none"
                          >
                            <span
                              data-v-e2593c18=""
                              class="BaseLabelText__text"
                            ></span
                            ><!---->
                          </div>
                          <input
                            data-v-6d6ea1ac=""
                            type="text"
                            class="BaseTextField__hiddenInput"
                            tabindex="-1"
                          />
                          <label
                            data-v-6d6ea1ac=""
                            class="BaseTextField BaseTextField--medium"
                            ><!---->
                            <input
                              data-v-6d6ea1ac=""
                              id="paymentPresentTakerPhone"
                              name="paymentPresentTakerPhone"
                              type="text"
                              class="BaseTextField__input BaseTextField__input--left"
                              placeholder="아이디를 입력해주세요"
                              maxlength="20"
                              v-model="toMemberEmail"
                            /><!---->
                            <button
                              data-v-524f63ea=""
                              data-v-778c1d9b=""
                              data-v-6d6ea1ac=""
                              type="button"
                              class="CoreButton BaseButtonIcon BaseTextField__clearIcon"
                              style="
                                background-color: transparent;
                                color: rgb(172, 172, 172);
                                height: 20px;
                                flex-direction: column;
                                display: none;
                              "
                            >
                              <!---->
                              <svg
                                data-v-6d2bd019=""
                                data-v-524f63ea=""
                                width="24"
                                height="24"
                                viewBox="0 0 24 24"
                                xmlns="http://www.w3.org/2000/svg"
                                class="BaseIcon CoreButton__icon"
                                style="
                                  width: 20px;
                                  height: 20px;
                                  opacity: 1;
                                  fill: currentcolor;
                                  --BaseIcon-color: #333333;
                                  margin-bottom: 0px;
                                "
                              >
                                <g clip-path="url(#clip0_124_2957)">
                                  <path
                                    fill-rule="evenodd"
                                    clip-rule="evenodd"
                                    d="M12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2ZM15.4697 7.46967L11.9997 10.9397L8.53033 7.46967L7.46967 8.53033L10.9397 11.9997L7.46967 15.4697L8.53033 16.5303L11.9997 13.0597L15.4697 16.5303L16.5303 15.4697L13.0597 11.9997L16.5303 8.53033L15.4697 7.46967Z"
                                  ></path>
                                </g>
                                <defs>
                                  <clipPath id="clip0_124_2957">
                                    <rect width="24" height="24"></rect>
                                  </clipPath>
                                </defs>
                              </svg>
                              <div
                                data-v-524f63ea=""
                                class="inline-flex items-center"
                              >
                                <!---->
                              </div></button
                            ><!----> </label
                          ><!---->
                        </div>
                      </div>
                    </div>
                    <div
                      data-v-30a5f488=""
                      class="DesktopPaymentPresentTaker__divider"
                    ></div>
                    <!---->
                  </div>
                </div>
              </div>
<!--              선물 메세지-->
              <div
                data-v-b1bb0ef0=""
                data-v-1784e89b=""
                class="DesktopPaymentSection"
              >
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0="">선물 메시지</span
                    ><!---->
                  </div>
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__right">
                    <!---->
                  </div>
                </div>
                <div data-v-b1bb0ef0="">
                  <div
                    data-v-1784e89b=""
                    class="DesktopPaymentPresentCelebrationMessage"
                  >
                    <div
                      data-v-1784e89b=""
                      class="DesktopPaymentPresentCelebrationMessage__cardInfo"
                    >
                      <div data-v-1784e89b="" class="flex flex-1">
                        <div
                          data-v-be77401d=""
                          data-v-1784e89b=""
                          class="BaseTextarea BaseTextarea__type--outline BaseTextarea__autoSize DesktopPaymentPresentCelebrationMessage__textarea"
                          id="DesktopPaymentPresentCelebrationMessage"
                          name="DesktopPaymentPresentCelebrationMessage"
                          style="
                            --BaseTextarea-min-height: 257;
                            --BaseTextarea-max-height: 257;
                            --BaseTextarea-radius: 2;
                          "
                        >
                          <div
                            data-v-e2593c18=""
                            data-v-be77401d=""
                            class="BaseLabelText BaseTextarea__label"
                            style="display: none"
                          >
                            <span
                              data-v-e2593c18=""
                              class="BaseLabelText__text"
                            >
                            </span
                            ><!---->
                          </div>
                          <textarea
                            data-v-be77401d=""
                            placeholder="제 마음이 담긴 선물을 받아주세요"
                            maxlength="300"
                            class="BaseTextarea__textarea"
                            style="height: 1px"
                            v-model="presentMessage"
                          ></textarea>
                          <div
                            data-v-be77401d=""
                            class="BaseTextarea__assistiveArea"
                          >
                            <div
                              data-v-86c06fc2=""
                              data-v-be77401d=""
                              class="BaseTextHelper BaseTextHelper--default"
                            >
                              <!---->
                              <div
                                data-v-86c06fc2=""
                                class="inline-flex items-center"
                              ></div>
                            </div>
                            <div
                              data-v-612abd8a=""
                              data-v-be77401d=""
                              class="BaseTextCounter BaseTextCounter--default"
                            >
                              <span data-v-612abd8a="">{{messageLength}}/300</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!---->
                </div>
              </div>
<!--              주문 작품 정보-->
              <div
                data-v-b1bb0ef0=""
                data-v-a3670613=""
                class="DesktopPaymentSection mb-[28px]"
              >
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0=""
                      >주문 작품 정보 ({{
                        cartStore.purchaseProductList.length
                      }}건)</span
                    >
                  </div>
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__right">
                    <button
                      data-v-524f63ea=""
                      data-v-778c1d9b=""
                      data-v-b1bb0ef0=""
                      type="button"
                      class="CoreButton BaseButtonIcon"
                      style="
                        background-color: transparent;
                        color: rgb(51, 51, 51);
                        height: 20px;
                        flex-direction: column;
                      "
                    >
                      <svg
                        data-v-6d2bd019=""
                        data-v-524f63ea=""
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg"
                        class="BaseIcon CoreButton__icon"
                        style="
                          width: 20px;
                          height: 20px;
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
                      <div
                        data-v-524f63ea=""
                        class="inline-flex items-center"
                      ></div>
                    </button>
                  </div>
                </div>
                <div data-v-b1bb0ef0="">
                  <div
                    data-v-a3670613=""
                    class="DesktopPaymentProductOrderList mt-[12px]"
                  >
                    <div
                      v-for="(atelier, index) in cartStore.purchaseProductList"
                      :key="index"
                      data-v-a3670613=""
                      class="flex flex-col w-full mb-[12px]"
                    >
                      <!-- 공방 이름 -->
                      <div
                        data-v-a3670613=""
                        class="DesktopPaymentProductOrderList__artistName"
                      >
                        {{ atelier.atelierName }}
                      </div>
                      <!-- 공방 결제 상품 목록 -->
                      <div
                        data-v-a3670613=""
                        class="DesktopPaymentProductOrderList__productItem"
                        v-for="(item, index) in atelier.productList"
                        :key="index"
                      >
                        <div
                          data-v-24b1dfb3=""
                          data-v-a3670613=""
                          class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight mr-[12px]"
                          style="
                            --BaseImage-width: 64;
                            --BaseImage-height: 64;
                            --BaseImage-radius: 2;
                          "
                        >
                          <div
                            data-v-24b1dfb3=""
                            class="BaseImage__image"
                            :style="{
                              'background-image': `url(${item.productUrl})`,
                            }"
                          >
                            <img
                              data-v-24b1dfb3=""
                              src="https://image.idus.com/image/files/37c9c62bdde744a0904e00e8706a170d_320.jpg"
                              class="hidden"
                              loading="lazy"
                            />
                          </div>
                        </div>
                        <div
                          data-v-a3670613=""
                          class="DesktopPaymentProductOrderList__productInfo"
                        >
                          <!-- 상품 이름 -->
                          <div
                            data-v-a3670613=""
                            class="DesktopPaymentProductOrderList__productName mb-[12px]"
                          >
                            <div
                              data-v-a3670613=""
                              class="flex flex-auto items-center"
                            >
                              <div
                                data-v-a3670613=""
                                class="flex flex-auto items-center"
                              >
                                {{ item.productName }}
                              </div>
                              <div
                                data-v-a3670613=""
                                class="flex justify-end items-center"
                              ></div>
                            </div>
                          </div>
                          <!--                          상품 리스트-->
                          <div
                            data-v-a3670613=""
                            v-for="(option, index) in item.optionList"
                            :key="index"
                          >
                            <div
                              data-v-a3670613=""
                              class="flex justify-between items-center mb-[12px]"
                            >
                              <div>
                                <div
                                  v-for="(sub, index) in option.subOptionsList"
                                  :key="index"
                                  data-v-a3670613=""
                                  class="body3-regular-small gray-666--text whitespace-pre-wrap display-block"
                                >
                                  • {{ sub.majorOptionName }} :
                                  {{ sub.subOptionName }}
                                </div>
                              </div>
                              <div
                                data-v-a3670613=""
                                class="flex justify-end shrink-0 ml-[4px]"
                              >
                                <span
                                  data-v-a3670613=""
                                  class="body3-regular-medium gray-333--text"
                                  >{{ option.count }}개</span
                                ><span
                                  data-v-a3670613=""
                                  class="body3-regular-medium gray-333--text mx-[4px]"
                                  >/</span
                                ><span
                                  data-v-a3670613=""
                                  class="body3-bold-medium gray-333--text"
                                  >{{ formatPrice(((item.productPrice*(1-item.onSalePercent/100))+(option.price-item.productPrice))*option.count) }}원</span
                                >
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- 배송비 -->
                      <div
                        data-v-a3670613=""
                        class="DesktopPaymentProductOrderList__artistTotal"
                      >
                        <div
                          data-v-a3670613=""
                          class="flex justify-between mb-[8px]"
                        >
                          <span
                            data-v-a3670613=""
                            class="body3-regular-small gray-333--text"
                            >배송비</span
                          >
                          <span
                            data-v-a3670613=""
                            class="body3-bold-small gray-333--text flex items-center"
                            ><div
                              data-v-a1957620=""
                              data-v-a3670613=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline ml-[4px]"
                            >
                              <span
                                data-v-a1957620=""
                                class="DecorateText"
                                style="
                                  font-size: 12px;
                                  color: rgb(51, 51, 51);
                                  background-color: inherit;
                                "
                                >아이디어스는 전 작품</span
                              >
                            </div>
                            <div
                              data-v-a1957620=""
                              data-v-a3670613=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline ml-[4px]"
                            >
                              <span
                                data-v-a1957620=""
                                class="DecorateText__badge"
                              >
                                <div
                                  data-v-c3bdd300=""
                                  data-v-a1957620=""
                                  class="BaseBadgeFreeShipping"
                                  style="--icon-width: 48; --icon-height: 18"
                                >
                                  <div
                                    data-v-c3bdd300=""
                                    class="BaseBadgeFreeShipping__icon"
                                  ></div></div
                              ></span></div
                          ></span>
                        </div>
                      </div>
                      <div
                        data-v-a3670613=""
                        class="DesktopPaymentProductOrderList__divider mt-[12px]"
                      ></div>
                    </div>
                  </div>
                </div>
              </div>

              <div data-v-b1bb0ef0="" class="DesktopPaymentSection mb-[28px]">
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0="">컴공방 할인 혜택</span>
                  </div>
                  <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__right"
                  ></div>
                </div>
                <div data-v-b1bb0ef0="">
                  <div class="mt-[20px] mb-[20px]">
<!--                    등급 할인-->
                    <div data-v-61d1fc82="" class="mb-[12px]">
                      <div
                          data-v-61d1fc82=""
                          class="DesktopPaymentDiscountLabel__content"
                      >
                        <div
                            data-v-61d1fc82=""
                            class="DesktopPaymentDiscountLabel__content__label"
                        >
                          <span class="mr-[4px]"
                          ><img
                              :src="`${memberStore.member.gradeImageUrl}`"
                              class="h-[18px] w-auto"
                          /></span>
                          <p class="body1-bold-small mr-[4px]">
                            {{memberStore.member.gradeName}} {{memberStore.member.gradePercent}}% 추가할인
                          </p>
                          <p class="body3-regular-small"></p>
                        </div>
                        <div
                            data-v-61d1fc82=""
                            class="DesktopPaymentDiscountLabel__content__main"
                        >
                          <div
                              class="h-[40px] px-[12px] flex items-center gray-f5--background"
                          >
                            <p class="body1-bold-small">
                              {{ formatPrice(discountPrice) }}원
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
<!--                    쿠폰 할인-->
                    <div data-v-474981d8="" data-v-61d1fc82="" class="mb-[12px]">
                      <div data-v-474981d8="" data-v-61d1fc82="" class="DesktopPaymentDiscountLabel__content">
                        <div data-v-474981d8="" data-v-61d1fc82="" class="DesktopPaymentDiscountLabel__content__label">
                          <p data-v-474981d8="" class="body1-bold-small mr-[4px]">쿠폰 선택 </p>
                        </div>
                        <div data-v-474981d8="" data-v-61d1fc82="" style="position: relative;" class="DesktopPaymentDiscountLabel__content__main">
                          <!--                          토글 제목?-->
                          <div @click="couponToggleOnOff" class="coupon-1 e1brt3tk0">
                            <button class="coupon-2">
                              <span v-if="!selectedCoupon">
                                사용가능 쿠폰 {{ couponStore.couponList.length }}장
                              </span>
                              <span v-if="selectedCoupon">
                                {{selectedCoupon.name}} ({{selectedCoupon.discountPercent}}% 할인)
                              </span>
                              <span class="css-1e56lav">
                                <span rotate="0" class="css-13gazkp ebkt7i80" :class="{'coupon-rotate':!isCouponToggleOff}"></span>
                              </span>
                            </button>
                          </div>
                          <!--                          토글 박스-->
                          <div v-if="couponStore.couponList.length > 0" role="listbox" :class="{'coupon-toggle-off' : !isCouponToggleOff}" class="css-wvvmzg e12aaan21">
                            <div v-if="selectedCoupon" @click="selectCoupon(null)"
                                  class="css-n37ofm e1ro4vie8">
                              <span class="css-4ntluf e1ro4vie7"></span>
                              <span class="css-16hni5r e1ro4vie6">사용 안함</span>
                            </div>
                            <div  v-for="(coupon, index) in couponStore.couponList"
                                  :key="index"
                                  @click="selectCoupon(coupon)"
                                  class="css-n37ofm e1ro4vie8">
                              <span class="css-4ntluf e1ro4vie7"></span>
                              <span class="css-16hni5r e1ro4vie6">{{ coupon.discountPercent }}% 할인</span>
                              <div class="css-vkpof6 e1ro4vie4">
                                <strong class="css-1a90ff4 e1ro4vie2">{{ coupon.name }}</strong>
                                <!--                                <span class="css-bs5mk4 e1ro4vie1">2만원 이상 주문 시</span>-->
                                <span class="css-bs5mk4 e1ro4vie0">2024년 10월23일 24시 만료</span>
                              </div>
                            </div>
                            <!--                            <div class="css-1ie56gn e1ro4vie8">-->
                            <!--                              <span class="css-4ntluf e1ro4vie7"></span>-->
                            <!--                              <span class="css-1ebfw21 e1ro4vie6">사용 불가</span>-->
                            <!--                              <div class="css-kmlyvg e1ro4vie4">-->
                            <!--                                <strong class="css-1bfy7g3 e1ro4vie2">[앱전용] 무료배송 쿠폰</strong>-->
                            <!--                                <span class="css-bs5mk4 e1ro4vie1">[앱전용] 2만원 이상 주문 시</span>-->
                            <!--                                <span class="css-bs5mk4 e1ro4vie0">2024년 11월10일 24시 만료</span>-->
                            <!--                              </div>-->
                            <!--                            </div>-->
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__divider mt-[8px]"
                  ></div>
                </div>
              </div>
              <div
                data-v-b1bb0ef0=""
                data-v-695a71dd=""
                data-v-d1712a15=""
                class="DesktopPaymentSection DesktopPaymentProductPayMethod"
              >
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0="">결제 수단</span>
                  </div>
                  <div
                    data-v-b1bb0ef0=""
                    class="DesktopPaymentSection__right"
                  ></div>
                </div>
                <div data-v-b1bb0ef0="">
                  <!-- 결제 수단 선택 -->
                  <div
                    data-v-695a71dd=""
                    class="DesktopPaymentPayMethod mt-[20px] mb-[10px]"
                  >
                    <!-- 일반 카드 결제 -->
                    <!--                    <div data-v-695a71dd="" class="py-[12px]">-->
                    <!--                      <label-->
                    <!--                        data-v-02c06866=""-->
                    <!--                        data-v-695a71dd=""-->
                    <!--                        class="BaseRadio BaseRadio__verticalAlign&#45;&#45;center BaseRadio__state&#45;&#45;unChecked DesktopPaymentPayMethod__radio"-->
                    <!--                        id="2"-->
                    <!--                        style="&#45;&#45;BaseRadio&#45;&#45;label-margin: 4"-->
                    <!--                        ><input-->
                    <!--                          data-v-02c06866=""-->
                    <!--                          type="radio"-->
                    <!--                          class="BaseRadio__input"-->
                    <!--                          value="1"-->
                    <!--                          v-model="payment"-->
                    <!--                        /><span data-v-02c06866="" class="BaseRadio__button"-->
                    <!--                          ><span-->
                    <!--                            data-v-02c06866=""-->
                    <!--                            class="BaseRadio__buttonOuterCircle"-->
                    <!--                            :class="{'circle-border':payment==='1'}"-->
                    <!--                            ><span-->
                    <!--                              data-v-02c06866=""-->
                    <!--                              class="BaseRadio__buttonInnerCircle"-->
                    <!--                              :class="{'circle-inner':payment==='1'}"-->
                    <!--                            ></span></span></span-->
                    <!--                        ><span-->
                    <!--                          data-v-02c06866=""-->
                    <!--                          class="BaseRadio__text"-->
                    <!--                          style="color: rgb(51, 51, 51)"-->
                    <!--                          ><div data-v-695a71dd="" class="flex flex-col flex-1">-->
                    <!--                            <div-->
                    <!--                              data-v-695a71dd=""-->
                    <!--                              class="DesktopPaymentPayMethod__payMethod"-->
                    <!--                            >-->
                    <!--                              <span-->
                    <!--                                data-v-695a71dd=""-->
                    <!--                                class="DesktopPaymentPayMethod__title"-->
                    <!--                                >일반 카드 결제</span-->
                    <!--                              >-->
                    <!--                            </div>-->
                    <!--                            -->
                    <!--                          </div></span-->
                    <!--                        ></label-->
                    <!--                      >-->
                    <!--                    </div>-->
                    <!-- 카카오 결제 -->
                    <div data-v-695a71dd="" class="py-[12px]">
                      <label
                        data-v-02c06866=""
                        data-v-695a71dd=""
                        class="BaseRadio BaseRadio__verticalAlign--center BaseRadio__state--unChecked DesktopPaymentPayMethod__radio"
                        id="8"
                        style="--BaseRadio--label-margin: 4"
                      >
                        <!--                       todo type="radio" 원래 input 타입-->
                        <input
                          data-v-02c06866=""
                          class="BaseRadio__input"
                          value="2"
                          v-model="payment" /><span
                          data-v-02c06866=""
                          class="BaseRadio__button"
                        >
                          <!--                        class="BaseRadio__buttonOuterCircle" todo 원래 아래 span 클래스 내용  circle-border 로 고치기 -->
                          <span
                              data-v-02c06866=""
                              :class="{ 'BaseRadio__buttonOuterCircle': payment === '2' }"
                          >
                            <!--  class="BaseRadio__buttonInnerCircle" todo 원래 아래 span 클래스 내용 circle-inner로 고치기-->
                            <span
                                data-v-02c06866=""
                                :class="{ 'BaseRadio__buttonInnerCircle': payment === '2' }"
                            ></span></span></span
                      ><span
                          data-v-02c06866=""
                          class="BaseRadio__text"
                          style="color: rgb(51, 51, 51)"
                          ><div data-v-695a71dd="" class="flex flex-col flex-1">
                            <div
                              data-v-695a71dd=""
                              class="DesktopPaymentPayMethod__payMethod"
                            >
                              <img
                                data-v-695a71dd=""
                                class="DesktopPaymentPayMethod__image"
                                src="https://image.idus.com/image/files/e6af2ece0e484d0bac914438fa210c5f.png"
                              />
                            </div></div></span
                      ></label>
                    </div>
                    <!-- 네이버 결제 -->
                    <!--                    <div data-v-695a71dd="" class="py-[12px]">-->
                    <!--                      <label-->
                    <!--                        data-v-02c06866=""-->
                    <!--                        data-v-695a71dd=""-->
                    <!--                        class="BaseRadio BaseRadio__verticalAlign&#45;&#45;center BaseRadio__state&#45;&#45;unChecked DesktopPaymentPayMethod__radio"-->
                    <!--                        id="3"-->
                    <!--                        style="&#45;&#45;BaseRadio&#45;&#45;label-margin: 4"-->
                    <!--                        ><input-->
                    <!--                          data-v-02c06866=""-->
                    <!--                          type="radio"-->
                    <!--                          class="BaseRadio__input"-->
                    <!--                          value='3'-->
                    <!--                          v-model="payment"-->
                    <!--                        /><span data-v-02c06866="" class="BaseRadio__button"-->
                    <!--                          ><span-->
                    <!--                            data-v-02c06866=""-->
                    <!--                            class="BaseRadio__buttonOuterCircle"-->
                    <!--                            :class="{'circle-border':payment==='3'}"-->
                    <!--                            ><span-->
                    <!--                              data-v-02c06866=""-->
                    <!--                              class="BaseRadio__buttonInnerCircle"-->
                    <!--                              :class="{'circle-inner':payment==='3'}"-->
                    <!--                            ></span></span></span-->
                    <!--                        ><span-->
                    <!--                          data-v-02c06866=""-->
                    <!--                          class="BaseRadio__text"-->
                    <!--                          style="color: rgb(51, 51, 51)"-->
                    <!--                          ><div data-v-695a71dd="" class="flex flex-col flex-1">-->
                    <!--                            <div-->
                    <!--                              data-v-695a71dd=""-->
                    <!--                              class="DesktopPaymentPayMethod__payMethod"-->
                    <!--                            >-->
                    <!--                              <img-->
                    <!--                                data-v-695a71dd=""-->
                    <!--                                class="DesktopPaymentPayMethod__image"-->
                    <!--                                src="https://image.idus.com/image/files/756efae428d54f2fbcac29768a730d3b.png"-->
                    <!--                              />-->
                    <!--                            </div>-->
                    <!--                            -->
                    <!--                          </div></span-->
                    <!--                        ></label-->
                    <!--                      >-->
                    <!--                    </div>-->
                  </div>
                  <div
                    data-v-b1bb0ef0=""
                    class="DesktopPaymentSection__divider mt-[8px]"
                  ></div>
                </div>
              </div>
            </div>
<!--            결제 박스-->
            <div class="w-[400px]">
              <div
                  data-v-878ae115=""
                  data-v-d65d286b=""
                  class="DesktopPaymentTotal"
              >
                <div data-v-878ae115="" class="DesktopPaymentTotal__title">
                  결제 정보
                </div>
                <hr
                    data-v-6ef4cf18=""
                    data-v-878ae115=""
                    class="BaseDivider"
                    style="--border-color: #333333"
                />
                <div data-v-d65d286b="" class="py-[20px]">
                  <div data-v-d65d286b="" class="mb-[16px] last:mb-0">
                    <div
                        data-v-c41fe987=""
                        data-v-d65d286b=""
                        class="flex justify-between items-center"
                    >
                      <div data-v-c41fe987="" class="flex">
                        <div data-v-c41fe987="" class="flex flex-col">
                          <div data-v-c41fe987="" class="flex items-center">
                            <div
                                data-v-a1957620=""
                                data-v-c41fe987=""
                                class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
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
                          </div>
                        </div>
                      </div>
                      <div data-v-c41fe987="" class="flex flex-col items-end">
                        <div data-v-c41fe987="" class="flex items-center">
                          <div
                              data-v-a1957620=""
                              data-v-c41fe987=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                          >
                            <span
                                data-v-a1957620=""
                                class="DecorateText DecorateText--bold"
                                style="
                                font-size: 14px;
                                color: rgb(51, 51, 51);
                                background-color: inherit;
                              "
                            >{{ formatPrice(cartStore.productPrice) }}원</span
                            >
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div data-v-d65d286b="" class="mb-[16px] last:mb-0">
                    <div
                        data-v-c41fe987=""
                        data-v-d65d286b=""
                        class="flex justify-between items-center"
                    >
                      <div data-v-c41fe987="" class="flex">
                        <div data-v-c41fe987="" class="mr-[4px]">
                          <div
                              data-v-1cb18953=""
                              data-v-c41fe987=""
                              class="BaseBadge BaseBadge__style--membershipText BaseBadge__style--membershipBackground BaseBadge__style--image mr-[4px] last:mr-0"
                          >
                            <img
                                data-v-1cb18953=""
                                :src="`${memberStore.member.gradeImageUrl}`"
                                class="h-[18px]"
                            />
                          </div>
                        </div>
                        <div data-v-c41fe987="" class="flex flex-col">
                          <div data-v-c41fe987="" class="flex items-center">
                            <div
                                data-v-a1957620=""
                                data-v-c41fe987=""
                                class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                            >
                              <span
                                  data-v-a1957620=""
                                  class="DecorateText"
                                  style="
                                  font-size: 12px;
                                  color: rgb(51, 51, 51);
                                  background-color: inherit;
                                "
                              >{{memberStore.member.gradeName}} {{memberStore.member.gradePercent}}% 추가할인</span
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                      <div data-v-c41fe987="" class="flex flex-col items-end">
                        <div data-v-c41fe987="" class="flex items-center">
                          <div
                              data-v-a1957620=""
                              data-v-c41fe987=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                          >
                            <span
                                data-v-a1957620=""
                                class="DecorateText DecorateText--bold"
                                style="
                                font-size: 14px;
                                color: rgb(51, 51, 51);
                                background-color: inherit;
                              "
                            >-{{ formatPrice(discountPrice) }}원</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div v-if="selectedCoupon" data-v-d65d286b="" class="mb-[16px] last:mb-0">
                    <div
                        data-v-c41fe987=""
                        data-v-d65d286b=""
                        class="flex justify-between items-center"
                    >
                      <div data-v-c41fe987="" class="flex">
                        <div data-v-c41fe987="" class="flex flex-col">
                          <div data-v-c41fe987="" class="flex items-center">
                            <div
                                data-v-a1957620=""
                                data-v-c41fe987=""
                                class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                            >
                              <span
                                  data-v-a1957620=""
                                  class="DecorateText"
                                  style="
                                  font-size: 12px;
                                  color: rgb(51, 51, 51);
                                  background-color: inherit;
                                "
                              >쿠폰 할인</span
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                      <div data-v-c41fe987="" class="flex flex-col items-end">
                        <div data-v-c41fe987="" class="flex items-center">
                          <div
                              data-v-a1957620=""
                              data-v-c41fe987=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                          >
                            <span
                                data-v-a1957620=""
                                class="DecorateText DecorateText--bold"
                                style="
                                font-size: 14px;
                                color: rgb(51, 51, 51);
                                background-color: inherit;
                              "
                            >-{{ formatPrice(couponDiscount) }}원</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div data-v-d65d286b="" class="mb-[16px] last:mb-0">
                    <div
                        data-v-c41fe987=""
                        data-v-d65d286b=""
                        class="flex justify-between items-center"
                    >
                      <div data-v-c41fe987="" class="flex">
                        <div data-v-c41fe987="" class="flex flex-col">
                          <div data-v-c41fe987="" class="flex items-center">
                            <div
                                data-v-a1957620=""
                                data-v-c41fe987=""
                                class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
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
                          </div>
                        </div>
                      </div>
                      <div data-v-c41fe987="" class="flex flex-col items-end">
                        <div data-v-c41fe987="" class="flex items-center">
                          <div
                              data-v-a1957620=""
                              data-v-c41fe987=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                          >
                            <span
                                data-v-a1957620=""
                                class="DecorateText"
                                style="
                                font-size: 12px;
                                color: rgb(51, 51, 51);
                                background-color: inherit;
                              "
                            >컴공방은 전 작품</span
                            >
                          </div>
                          <div
                              data-v-a1957620=""
                              data-v-c41fe987=""
                              class="BaseDecorateText transform-gpu whitespace-pre inline flex mr-[4px] last:mr-0"
                          >
                            <span
                                data-v-a1957620=""
                                class="DecorateText__badge"
                            >
                              <div
                                  data-v-c3bdd300=""
                                  data-v-a1957620=""
                                  class="BaseBadgeFreeShipping"
                                  style="--icon-width: 48; --icon-height: 18"
                              >
                                <div
                                    data-v-c3bdd300=""
                                    class="BaseBadgeFreeShipping__icon"
                                ></div></div
                              ></span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <hr
                    data-v-6ef4cf18=""
                    data-v-d65d286b=""
                    class="BaseDivider"
                    style="--border-color: #f5f5f5"
                />
                <div data-v-d65d286b="" class="py-[16px]">
                  <div data-v-d65d286b="" class="flex justify-between">
                    <p
                        data-v-d65d286b=""
                        class="subtitle3-bold-small h-full flex items-center"
                    >
                      최종 결제 금액
                    </p>
                    <p data-v-d65d286b="" class="subtitle1-bold-small">
                      {{ formatPrice(paymentPrice) }}원
                    </p>
                  </div>
                  <div
                      data-v-d65d286b=""
                      class="mt-[4px] flex justify-end items-center"
                  >
                    <div
                        data-v-a1957620=""
                        data-v-d65d286b=""
                        class="BaseDecorateText transform-gpu whitespace-pre inline"
                    >
                      <span
                          data-v-a1957620=""
                          class="DecorateText"
                          style="
                          font-size: 13px;
                          color: rgb(255, 75, 80);
                          background-color: inherit;
                        "
                      >{{ formatPrice(discountPrice +  couponDiscount)}}원 할인 받았어요</span
                      >
                    </div>
                  </div>
                </div>
                <div
                    data-v-2d1923b8=""
                    data-v-d65d286b=""
                    class="PaymentNotice border-b border-[#f5f5f5] last-of-type:border-b-none"
                >
                  <div
                      data-v-2d1923b8=""
                      class="PaymentNotice__title"
                      @click="noticeClick"
                  >
                    <span
                        data-v-2d1923b8=""
                        class="body2-regular-small gray-333--text"
                    >결제 시 개인정보 제공에 동의합니다.</span
                    >
                    <svg
                        data-v-6d2bd019=""
                        data-v-2d1923b8=""
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg"
                        class="BaseIcon"
                        :class="{ rotate: isNoticeOn }"
                        colors="#999999"
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
                  <div
                      data-v-2d1923b8=""
                      class="PaymentNotice__content"
                      :class="{ 'notice-off': !isNoticeOn }"
                  >
                    ‣ 제공받는 자 :
                    <b style="font-weight: bold">JJ달콤상회,앙보화</b><br />‣
                    목적 :
                    <b style="font-weight: bold"
                    >판매자와 구매자 사이의 원활한 거래 진행, 상품의 배송을
                      위한 배송지 확인, 고객상담 및 불만처리 등</b
                    ><br />‣ 정보 : 주문자 정보(성명, 연락처), 수령인 정보(성명,
                    연락처, 주소)<br />‣ 보유기간 :
                    <b style="font-weight: bold">발송완료 후 15일</b
                    ><br /><br />아이디어스는 통신판매중개자이며 통신판매의
                    당사자가 아닙니다. 따라서 아이디어스는 상품 거래정보 및
                    거래에 대하여 책임을 지지 않습니다.<br />고객님께서는
                    개인정보 제공에 대하여 동의를 거부하실 수 있으나, 거부 시
                    상품 구매가 어렵습니다.
                  </div>
                </div>
                <button
                    data-v-524f63ea=""
                    data-v-7940d6dd=""
                    data-v-d65d286b=""
                    type="fill"
                    class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill mt-[16px]"
                    style="
                    background-color: #000;
                    color: rgb(255, 255, 255);
                    height: 44px;
                    flex-direction: row;
                    --core-button-padding-x: 16;
                    font-weight: bold;
                  "
                    @click="makePayment"
                >
                  <div
                      data-v-524f63ea=""
                      class="inline-flex items-center"
                  >
                    <span data-v-524f63ea="" class="CoreButton__text"
                    >결제하기</span
                    >
                  </div>
                </button>
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
import { useCartStore } from "@/stores/useCartStore";
import { useMemberStore } from "@/stores/useMemberStore";
import { useGiftStore } from "@/stores/useGiftStore";
import { useCouponStore } from "@/stores/useCouponStore";
import swal from 'sweetalert2';
import axios from "axios";
import {formatPrice} from "@/utils/formatPrice";


export default {
  data() {
    return {
      payment: '2',
      isNoticeOn: false,
      productPrice: 0,
      totalPrice: 0,
      totalCount: 0,
      gradePercent: 0,
      gradeDiscount: 0,
      discountPrice : 0,
      purchaseProductList: [],
      cartIds: [],

      fromMemberName: null,
      toMemberEmail: null,
      presentMessage: "",

      isCouponToggleOff : false,
      selectedCoupon : null,
      couponDiscount : 0,
      paymentPrice :0
    };
  },
  computed: {
    ...mapStores(useOrderStore),
    ...mapStores(useCartStore),
    ...mapStores(useMemberStore),
    ...mapStores(useGiftStore),
    ...mapStores(useCouponStore),
    messageLength() {
      return this.presentMessage.length;
    },
  },
  created() {
    //주문 상품 조회
    this.getOrderProductList();

    //등급 계산
    this.getMemberPaymentInfo();
    //쿠폰 조회
    this.getCouponList();
  },
  mounted() {},
  methods: {
    formatPrice,
    showAlert(content) {
      swal.fire({
        text: content,
        icon: "error",
      });
    },
    noticeClick() {
      this.isNoticeOn = !this.isNoticeOn;
    },
    //쿠폰 조회
    async getCouponList(){
      await this.couponStore.fetchMyCouponList();
    },
    //쿠폰 토글 onoff
    couponToggleOnOff(){
      this.isCouponToggleOff=!this.isCouponToggleOff;
    },
    //쿠폰 선택
    selectCoupon(coupon){
      this.selectedCoupon = coupon;
      this.isCouponToggleOff=!this.isCouponToggleOff;
      if(coupon){
        this.paymentPrice += this.couponDiscount;
        this.couponDiscount = Math.floor(this.paymentPrice*this.selectedCoupon.discountPercent/100);
        this.paymentPrice = this.paymentPrice - this.couponDiscount;
      }else{
        this.paymentPrice += this.couponDiscount;
        this.couponDiscount = 0;
      }
    },
    //선택한 상품 조회
    async getOrderProductList() {
      this.cartIds = await this.cartStore.selectedItems.map(
        (item) => item.cartIdx
      );
      const cartArray = Object.values(this.cartIds);
      await this.cartStore.getSelectedCartProductList(cartArray);
    },
    //맴버 등급 및 할인률 조회
    async getMemberPaymentInfo(){
      await this.memberStore.getMemberPaymentInfo();
      this.discountPrice = Math.floor(this.cartStore.totalPrice*(this.memberStore.member.gradePercent/100));
      this.paymentPrice = this.cartStore.totalPrice - this.discountPrice;
    },
    //결제
    async makePayment() {
      if (this.toMemberEmail === null) {
        this.showAlert("받을 사람 이메일을 입력해주세요.");
        return;
      }
      if (this.cartStore.totalPrice === 0) {
        this.showAlert("가격이 0원입니다.");
        return;
      }
      //선물 받을 사람이 회원이지 확인
      const response = await this.memberStore.isMember(this.toMemberEmail);
      if (response === false) {
        this.cartStore.paymentPrice = this.cartStore.totalPrice - this.discountPrice - this.couponDiscount

        //회원이면 결제 진행
        let present = {
          toMemberEmail: this.toMemberEmail,
          message: this.presentMessage,
        };

        //카트 idx 리스트
        const cartIds = this.cartStore.purchaseProductList.flatMap(product =>
            product.productList.flatMap(prod =>
                prod.optionList.map(option => option.cartIdx)
            )
        );

        //-------사전 재고 검증---------//
        const inventoryResponse = await axios.post(`/api/order/pre/validation`, cartIds, {withCredentials:true});
        if(!inventoryResponse.data.result.isOrderable){
          this.showAlert("상품 재고가 부족합니다.");
          return;
        }

        //-------결제 진행---------//
        let memberCouponIdx = null;
        if(this.selectedCoupon){
          memberCouponIdx = this.selectedCoupon.memberCouponIdx;
        }
        await this.orderStore.makePresent(cartIds, this.paymentPrice, memberCouponIdx, present); //결제 및 주문 테이블에 저장

        // window.location.href = "/gift/give/list";
      } else {
        this.showAlert(
          "받는 사람이 회원이 아닙니다. 이메일을 다시 확인해주세요"
        );
      }
    },
  },
};
</script>

<style scoped>
.text-left {
  text-align: left;
}
.circle-border {
  border: 1px solid #ef7014 !important;
}
.circle-inner {
  background-color: #ef7014 !important;
}
.BaseRadio__buttonOuterCircle{
  border: 1px solid #222222 !important;
}
.BaseRadio__buttonInnerCircle{
  background-color: #222222 !important;
}
.notice-off {
  display: none;
}
.rotate {
  transform: rotate(180deg);
  transition: transform 0.1s ease-in-out;
}
.display-block {
  display: block;
}
.margin-top-16 {
  margin-top: 16px;
}

/*쿠폰 관련*/
.coupon-1 {
  position: relative;
  margin-bottom: 10px;
}
.coupon-2 {
  position: relative;
  width: 100%;
  height: 44px;
  padding: 0px 54px 0px 16px;
  border: 1px solid rgb(221, 221, 221);
  font-size: 14px;
  line-height: 20px;
  text-align: left;
}
.css-1e56lav {
  position: absolute;
  top: 10px;
  right: 16px;
}
.css-13gazkp {
  display: inline-block;
  width: 12px;
  height: 8px;
  background: url(data:image/svg+xml;base64,CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTIiIGhlaWdodD0iOCIgdmlld0JveD0iMCAwIDEyIDgiPgogICAgPGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyBmaWxsPSIjMzMzIj4KICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICA8Zz4KICAgICAgICAgICAgICAgICAgICA8Zz4KICAgICAgICAgICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNNSAwTDEwIDYgMCA2eiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTkwOSAtMjAzNikgdHJhbnNsYXRlKDE5NSAxNzk2KSB0cmFuc2xhdGUoMCA2MCkgdHJhbnNsYXRlKDM3NiAxNjIpIHRyYW5zbGF0ZSgzMzggMTgpIHJvdGF0ZSgtMTgwIDUuNSAzLjUpIi8+CiAgICAgICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPgo=) 0px 0px no-repeat;
}


/*쿠폰 토글*/
.coupon-toggle-off{
  display: none;
}
.coupon-rotate {
  transform: rotate(180deg);
  transition: transform 0.1s ease-in-out;
}
.css-wvvmzg {
position: absolute;
  max-height: 227px;
  overflow-y: scroll;
  top: 54px;
  left: 0px;
  width: 100%;
  z-index: 10;
  border: 1px solid rgb(221, 221, 221);
  background: rgb(255, 255, 255);
}
.css-n37ofm {
  display: flex;
  flex-direction: row;
  padding: 15px 20px;
  cursor: pointer;
}
.css-n37ofm + div {
  border-top: 1px solid rgb(244, 244, 244);
}
.css-1ie56gn {
  display: flex;
  flex-direction: row;
  padding: 15px 20px;
}
.css-4ntluf {
  display: inline-flex;
  width: 16px;
  margin-right: 10px;
  padding-top: 5px;
}
.css-16hni5r {
  display: flex;
  flex-direction: column;
  width: 90px;
  margin-right: 20px;
  font-weight: 500;
  font-size: 14px;
  line-height: 20px;
  color: rgb(51, 51, 51);
}
.css-vkpof6 {
  overflow: hidden;
  flex: 1 1 0%;
  width: 388px;
  font-size: 12px;
  line-height: 17px;
  color: rgb(51, 51, 51);
}
.css-1a90ff4 {
  margin-bottom: 6px;
  font-size: 14px;
  line-height: 20px;
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  color: rgb(51, 51, 51);
  font-weight: 500;
}
.css-bs5mk4 {
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.css-n37ofm + div {
  border-top: 1px solid rgb(244, 244, 244);
}
.css-1ie56gn {
  display: flex;
  flex-direction: row;
  padding: 15px 20px;
}
.css-1ebfw21 {
  display: flex;
  flex-direction: column;
  width: 90px;
  margin-right: 20px;
  font-weight: 500;
  font-size: 14px;
  line-height: 20px;
  color: rgb(204, 204, 204);
}
.css-kmlyvg {
  overflow: hidden;
  flex: 1 1 0%;
  width: 388px;
  font-size: 12px;
  line-height: 17px;
  color: rgb(204, 204, 204);
}
.css-1bfy7g3 {
  margin-bottom: 6px;
  font-size: 14px;
  line-height: 20px;
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  color: rgb(204, 204, 204);
  font-weight: 500;
}
.css-bs5mk4 {
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
