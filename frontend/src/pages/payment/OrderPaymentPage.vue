<template>
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
              <div
                  data-v-b1bb0ef0=""
                  data-v-1e0e31f6=""
                  class="DesktopPaymentSection mb-[28px]"
              >
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0="">주문 고객</span>
                  </div>
                  <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__right"
                  ></div>
                </div>
                <div data-v-b1bb0ef0="">
                  <div data-v-1e0e31f6="" class="mt-[20px] mb-[20px] text-left">
                    <div
                        data-v-1e0e31f6=""
                        class="DesktopPaymentProductMember__row"
                    >
                      <span
                          data-v-1e0e31f6=""
                          class="DesktopPaymentProductMember__title w-[70px] pr-[12px]"
                      >이름</span
                      ><span
                        data-v-1e0e31f6=""
                        class="DesktopPaymentProductMember__content"
                    >{{ memberStore.nickname }}</span
                    >
                    </div>
                    <div
                        data-v-1e0e31f6=""
                        class="DesktopPaymentProductMember__row"
                    >
                      <span
                          data-v-1e0e31f6=""
                          class="DesktopPaymentProductMember__title w-[70px] pr-[12px]"
                      >전화번호</span
                      ><span
                        data-v-1e0e31f6=""
                        id="as-payment-user-cellphone"
                        class="DesktopPaymentProductMember__content"
                    >{{ memberStore.cellphone }}</span
                    >
                      <!-- <button
                        data-v-524f63ea=""
                        data-v-7940d6dd=""
                        data-v-1e0e31f6=""
                        type="outline"
                        class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline ml-[20px]"
                        style="
                          background-color: rgb(255, 255, 255);
                          color: rgb(51, 51, 51);
                          height: 28px;
                          width: 76px;
                          flex-direction: row;
                          --core-button-padding-x: 8;
                          --button-rectangle-border-color: #acacac;
                        "
                      >
                        
                        <div
                          data-v-524f63ea=""
                          class="inline-flex items-center"
                        >
                          <span data-v-524f63ea="" class="CoreButton__text"
                            >변경하기</span
                          >
                        </div>
                      </button> -->
                    </div>
                    <div
                        data-v-1e0e31f6=""
                        class="DesktopPaymentProductMember__description"
                    >
                      주문, 배송시 등록된 번호로 SMS를 발송해 드립니다.
                    </div>
                  </div>
                  <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__divider mt-[8px]"
                  ></div>
                </div>
              </div>
              <div
                  data-v-e01c0c5e=""
                  class="DesktopPaymentProductDelivery mb-[28px]"
              >
                <div
                    data-v-e01c0c5e=""
                    class="flex justify-between items-center py-[16px] border-b border-[#333333]"
                >
                  <div
                      data-v-e01c0c5e=""
                      class="subtitle3-bold-small gray-333--text"
                  >
                    배송 정보
                  </div>
                  <div data-v-e01c0c5e="">
                    <button
                        data-v-524f63ea=""
                        data-v-8493c3f2=""
                        type="default"
                        class="CoreButton BaseButtonText body1-regular-small font-bold"
                        style="
                        background-color: transparent;
                        color: rgb(80, 95, 205);
                        height: 32px;
                        flex-direction: row-reverse;
                        --core-button-padding-x: 8;
                      "
                    >
                      <div data-v-524f63ea="" class="inline-flex items-center">
                        <span data-v-524f63ea="" class="CoreButton__text"
                        >배송지 변경</span
                        >
                      </div>
                    </button>
                  </div>
                </div>
                <div
                    data-v-e01c0c5e=""
                    class="white--background w-full flex flex-col py-[20px]"
                >
                  <div class="w-full flex flex-col gap-[8px] pb-[8px]">
                    <div class="flex">
                      <div
                          data-v-24a9185e=""
                          class="BaseBadgeBusiness BaseBadgeBusiness__colorType--black-500 BaseBadgeBusiness__size--medium mr-[4px] flex-none"
                          style="
                          font-weight: bold;
                          color: #f20039;
                          background-color: #ffd6e0;
                          border-radius: 5px;
                        "
                          v-if="selectedAddress.isDefault===true"
                      >
                        기본배송지
                      </div>
                      <div class="flex break-all">
                        <div class="body1-bold-small">
                          {{selectedAddress.recipient}}
                          <span class="body1-regular-small">
                            ({{selectedAddress.addressName}})
                          </span>
                        </div>
                      </div>
                    </div>
                    <p class="body1-regular-medium text-left">
                      {{ selectedAddress.cellphone }}
                    </p>
                    <p class="body1-regular-medium text-left break-all">
                      {{ selectedAddress.address}}
                      {{selectedAddress.detailAddress}}
                    </p>
                  </div>
                </div>
                <div
                    data-v-e01c0c5e=""
                    class="DesktopPaymentProductDelivery__divider"
                ></div>
              </div>
              <div
                  data-v-b1bb0ef0=""
                  data-v-a3670613=""
                  class="DesktopPaymentSection mb-[28px]"
              >
                <div data-v-b1bb0ef0="" class="DesktopPaymentSection__title">
                  <div data-v-b1bb0ef0="" class="DesktopPaymentSection__left">
                    <span data-v-b1bb0ef0="">
                      주문 작품 정보 ({{ cartStore.purchaseProductList.length }}건)
                    </span
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
                              :style="{ 'background-image': `url(${item.productUrl})` }"
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
                              >{{ option.price }}원</span
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
                    <span data-v-b1bb0ef0="">아이디어스 할인 혜택</span>
                  </div>
                  <div
                      data-v-b1bb0ef0=""
                      class="DesktopPaymentSection__right"
                  ></div>
                </div>
                <div data-v-b1bb0ef0="">
                  <div class="mt-[20px] mb-[20px]">
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
                              src="https://cdn.idus.kr/static/common/images/20240524/074009_image_grade02.png"
                              class="h-[18px] w-auto"
                          /></span>
                          <p class="body1-bold-small mr-[4px]">
                            {{memberStore.gradeName}} {{gradePercent}}% 추가할인
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
                            <p class="body1-bold-small">{{cartStore.gradeDiscount}}원</p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="DesktopPaymentDiscount"></div>
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
                          <!--                        class="BaseRadio__buttonOuterCircle" todo 원래 아래 span 클래스 내용-->
                          <span
                              data-v-02c06866=""
                              :class="{ 'circle-border': payment === '2' }"
                          >
                            <!--  class="BaseRadio__buttonInnerCircle" todo 원래 아래 span 클래스 내용-->
                            <span
                                data-v-02c06866=""
                                :class="{ 'circle-inner': payment === '2' }"
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
                            >{{ cartStore.productPrice }}</span
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
                                src="https://cdn.idus.kr/static/common/images/20240524/074009_image_grade02.png"
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
                              >동손 1% 추가할인</span
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
                            >-{{cartStore.gradeDiscount}}원</span
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
                            >아이디어스는 전 작품</span
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
                      {{ cartStore.totalPrice }}
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
                      >{{ gradeDiscount }}원 할인 받았어요</span
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
                >
                  <div
                      data-v-524f63ea=""
                      class="inline-flex items-center"
                      @click="makePayment"
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
import { useDeliveryStore } from "@/stores/useDeliveryStore";

export default {
  data() {
    return {
      payment: null,
      isNoticeOn: false,
      productPrice: 0,
      totalPrice: 0,
      totalCount: 0,
      gradePercent: 0,
      gradeDiscount : 0,
      purchaseProductList:[],
      cartIds:[],
      selectedAddress : null
    };
  },
  computed: {
    ...mapStores(useOrderStore),
    ...mapStores(useCartStore),
    ...mapStores(useMemberStore),
    ...mapStores(useDeliveryStore)
  },
  created() {
    //주문 상품 조회
    this.getOrderProductList();

    //등급 계산
    // this.gradePercent = this.memberStore.getGradePercent s();
    this.gradePercent = 2;
  },
  mounted() {
    //배송지
    this.getAddressList();
  },
  methods: {
    noticeClick() {
      this.isNoticeOn = !this.isNoticeOn;
    },
    //배송지 조회
    async getAddressList(){
      await this.deliveryStore.fetchAddresses();
      this.selectedAddress = this.deliveryStore.addresses[0];
    },
    //선택한 상품 조회
    async getOrderProductList(){
      this.cartIds = await this.cartStore.selectedItems.map(item => item.cartIdx);
      const cartArray = Object.values(this.cartIds);
      await this.cartStore.getSelectedCartProductList(cartArray);
    },
    //결제
    async makePayment() {
      const customData = this.cartIds;
      const paymentData = {
        totalPrice: this.cartStore.totalPrice,
        customData: customData,
      };

     await this.orderStore.makePayment(paymentData);

      window.location.href = '/order-list';
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
</style>
