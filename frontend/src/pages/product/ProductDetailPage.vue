<template>
  <div
    class="appContainer"
    style="
      --mobile-the-snackbar-bottom: 60px;
      --desktop-header-menu-top: 27px;
      --desktop-header-sticky-height: 0px;
    "
    data-v-261d543d=""
    v-if="this.productStore.productDetail"
  >
    <div id="MoveToTopTrigger" ref="top" data-v-261d543d=""></div>
    <div class="appContents" data-v-261d543d="">
      <div>
        <div class="ProductDetail" data-v-6da505b4="">
          <div class="flex justify-center" data-v-6da505b4="">
            <!-- <div><CarouselProductDetailComponent/></div> -->
            <div><ProductDetailPaymentComponent /></div>
          </div>
          <!-- 탭 -->
          <div
            class="BaseTabs BaseTabs__size--large BaseTabs__style--outline BaseTabs--width BaseTabs__border--top BaseTabs__border--bottom BaseTabs__align--left"
            style="--BaseTabs-item-length: 4; --BaseTabs-margin-x: 0"
            data-v-de0565e1=""
            data-v-6da505b4=""
          >
            <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
              <!--[-->
              <div
                class="BaseTab BaseTab--active"
                style="--BaseTab-width: 170"
                role="tab"
                border-top="true"
                border-bottom="true"
                data-v-47c662bd=""
                data-v-de0565e1=""
                v-for="(tab, index) in tabs"
                :key="index"
                @click="moveScroll(index)"
              >
                <div class="BaseTab__contents" data-v-47c662bd="">
                  <div
                    class="BaseFontVariable"
                    data-v-9dbc8be1=""
                    data-v-47c662bd=""
                  >
                    <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                      <span class="BaseFontVariable__text" data-v-9dbc8be1="">{{
                        tab.name
                      }}</span>
                      <span class="review-count-text">{{ tab.count }}</span>
                    </div>
                  </div>
                </div>
              </div>
              <!--]-->
            </div>
            <!---->
          </div>
          <!-- 상품 상세 , 더보기 버튼-->
          <div
            class="ProductDetailDescription"
            :class="{ contract: !isInfoMoreOn }"
            style="--description-height: initial"
            data-v-6da505b4=""
            data-v-1d911075=""
          >
            <!-- 상품 상세 정보 -->
            <div data-v-1d911075="">
              <a data-v-1d911075=""
                ><div
                  class="CoreImage"
                  style="--image-height: initail"
                  data-v-e62d27a4=""
                  data-v-1d911075=""
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://cdn.idus.kr/static/common/images/20230619/004502_web_1120.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                  >
                    <svg
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      xmlns="http://www.w3.org/2000/svg"
                      style="
                        width: 30%;
                        height: 30%;
                        opacity: 1;
                        fill: currentColor;
                        --BaseIcon-color: #ffffff;
                      "
                      class="BaseIcon CoreImageDefault__icon"
                      data-v-6d2bd019=""
                      data-v-dfe5a850=""
                    >
                      <path
                        d="M9.98878 22C8.00515 22 6.20082 21.0922 4.92883 19.4213C3.54252 17.599 3.12786 15.0371 3.84847 12.7341C4.77753 9.75972 7.76195 7.01737 12.3355 7.59565C12.8174 7.65617 13.2993 7.74919 13.7745 7.87134V2H17.2229V9.35067C18.6148 10.1553 19.879 11.0721 21.0008 12.0919L18.9252 14.748C18.4209 14.275 17.6925 13.6911 17.1164 13.2776C17.0761 13.9803 16.9808 14.7659 16.8576 15.4641C16.5594 17.153 15.8254 18.7903 14.6184 20.0253C13.3655 21.3063 11.7797 21.9989 9.9899 21.9989L9.98878 22ZM11.1297 10.8883C8.12842 10.8883 7.23186 13.2361 7.07385 13.7416C6.59531 15.2724 7.04135 16.6262 7.61738 17.3838C8.03653 17.9341 8.96895 18.8239 10.4942 18.5875C12.1786 18.3263 13.2489 16.5388 13.5425 14.8757C13.7353 13.7842 13.8115 12.6803 13.8417 11.415C12.9867 11.0945 12.0453 10.8883 11.1297 10.8883Z"
                      ></path>
                    </svg>
                  </div></div
              ></a>
              <div class="white--background" data-v-1d911075="">
                <div
                  class="DescriptionNotice mt-[20px] mx-[16px] mb-[20px]"
                  data-v-1d911075=""
                  data-v-9757c483=""
                >
                  <div class="DescriptionNotice__title" data-v-9757c483="">
                    ❤️필독!!확인부탁드립니다❤️
                  </div>
                  <div class="DescriptionNotice__contents" data-v-9757c483="">
                    배송일 지정시 꼭!! 발송일로 남겨주세요(평일기준) 주소변경 /
                    수량변경 시 주문취소후 재주문으로 부탁드려요 🙇🏻‍♀️ 00일발송 🆗
                    00배송 ❌
                  </div>
                </div>
                <div
                  class="DescriptionNotice mt-[20px] mx-[16px] mb-[20px]"
                  data-v-1d911075=""
                  data-v-ab812ee6=""
                >
                  <div class="DescriptionNotice__title" data-v-ab812ee6="">
                    안심하고 드세요!
                  </div>
                  <div class="DescriptionNotice__contents" data-v-ab812ee6="">
                    식품위생법에 따른 영업 신고, 등록을 하신 작가님이 판매하는
                    안전식품입니다.
                  </div>
                </div>
              </div>
              <div data-v-33a92dff="" data-v-1d911075="" class="ComponentQuote">
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
                <div data-v-33a92dff="" class="ComponentQuote__text">
                  ❤️발송일지정시 다른발송일을 선택하시면 같은날로 발송됩니다.
                  각각 다른발송일로 받으시려면 주문을 따로 주문주세요
                </div>
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote BaseIconQuote__iconType--end"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
              </div>
              <div
                data-v-6b4aad3c=""
                data-v-1d911075=""
                class="ComponentSubject"
              >
                샤브레쿠키 / 초코칩쿠키 / 캐릭터머랭
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/9d095adb6e9b4385b6c0b9ae73abcaf7_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  기본 샤브레 세트
                </div>
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/46cdeb425b174f2ca10f595edebb8d23_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  초코칩 + 곰쿠키 세트
                </div>
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/2f7c368fc7ca4cf39a8e0d61d6e42b5d_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  초코칩+해바리기곰,토끼머랭 세트
                </div>
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/dd64afde76e9404d8d79bad27c91f1df_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  샤브레 + 벚꽃머랭 세트
                </div>
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/e678a1e99db94063808f9493bd1ec43d_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  샤브레 + 강아지곰머랭 세트
                </div>
              </div>
              <div data-v-d09d2e07="" data-v-1d911075="" class="ComponentImage">
                <div
                  data-v-e62d27a4=""
                  data-v-d09d2e07=""
                  class="CoreImage"
                  style="--image-height: initail"
                >
                  <img
                    data-v-e62d27a4=""
                    src="https://image.idus.com/image/files/bd4b85a513074504b11e0ec4c3efd7d5_720.jpg"
                    class="CoreImage__image"
                    role="img"
                    alt=""
                  />
                  <div
                    data-v-dfe5a850=""
                    data-v-e62d27a4=""
                    class="CoreImageDefault CoreImageDefault__display--none"
                    style="--ids-image-default-size: 50%"
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
                <div data-v-d09d2e07="" class="ComponentImage__label">
                  샤브레+크로바곰 (108*80*60) 위에 옵션만 깨짐방지를 위해
                  용기가변경됩니다.
                </div>
              </div>
              <div data-v-33a92dff="" data-v-1d911075="" class="ComponentQuote">
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
                <div data-v-33a92dff="" class="ComponentQuote__text">
                  서늘한실온보관7일 냉동보관 1달입니다.
                </div>
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote BaseIconQuote__iconType--end"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
              </div>
              <div data-v-33a92dff="" data-v-1d911075="" class="ComponentQuote">
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
                <div data-v-33a92dff="" class="ComponentQuote__text">
                  📌📝수량 20개부터 스티커 가능합니다. 메세지 또는 요청사항에
                  문구를 남겨주세요~
                </div>
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote BaseIconQuote__iconType--end"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
              </div>
              <div data-v-33a92dff="" data-v-1d911075="" class="ComponentQuote">
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
                <div data-v-33a92dff="" class="ComponentQuote__text">
                  발송일지정 지정발송일을 요청사항에 남겨주세요. 평일기준
                  1~2일소요되오니 여유있게 잡아주세요~ 발송일은
                  택배출발일입니다.
                </div>
                <div
                  data-v-bac4f2fe=""
                  data-v-33a92dff=""
                  class="BaseIconQuote BaseIconQuote__iconType--end"
                  style="--quote-size: 24"
                >
                  <div data-v-bac4f2fe="" class="BaseIconQuote__icon"></div>
                </div>
              </div>
              <div data-v-8c526e1a="" data-v-1d911075="" class="ComponentText">
                ❤️❤️❤️❤️❤️❤️❤️ ✔제품특성상 택배배송중 약간의 부서짐이
                있을수있으니 참고 꼭 부탁드려요 🙏
                ----------------------------------------- ❤ 하루의 즐거운 당충전
                ❤ 달콤상회디저트 예쁘게 맛있다~~!! 한번먹어보면 자꾸 생각나는
                입안이 행복해지는 수제쿠키 ✔맛구성 ❤샤브레쿠키 ❤ 바닐라 /
                초코아몬드/ 말차 ❤초코칩쿠키❤ ❤캐릭터머랭❤ ✔️메인사진외 금액별
                구성 가능하세요. 메시지로 상담가능합니다. ^^ ✔️포장상자크키 대략
                108*80*45 ✔️포장시사용하는 메세지카드/리본은 랜덤으로
                바뀔수있습니다.(재고소진시) ✔🚛우체국택배로 배송됩니다 🚚
                ✔쿠키의 크키는 수제작업으로인해 조금씩 크기가 약간씩
                틀릴수있어요. ✔꼼꼼히 포장하지만 배송중 약간의 깨짐이
                발생할수있어요 😢 깨짐으로인해 반품.환불은 불가입니다.
              </div>
            </div>
            <!-- 상품 더보기 버튼 -->
            <div
              style=""
              class="ProductDetailDescription__more"
              data-v-1d911075=""
              @click="handleInfoMoreOnOff"
            >
              <button
                type="outline"
                class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline"
                style="
                  background-color: rgb(255, 255, 255);
                  color: rgb(80, 95, 205);
                  height: 44px;
                  flex-direction: row-reverse;
                  --core-button-padding-x: 16;
                  font-weight: bold;
                  --button-rectangle-border-color: #505fcd;
                "
                data-v-524f63ea=""
                data-v-7940d6dd=""
                data-v-1d911075=""
              >
                <!----><!--[--><svg
                  data-v-6d2bd019=""
                  data-v-524f63ea=""
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  class="BaseIcon CoreButton__icon"
                  :class="{ rotate: !isInfoMoreOn }"
                  style="
                    width: 20px;
                    height: 20px;
                    opacity: 1;
                    fill: currentcolor;
                    --BaseIcon-color: #333333;
                    margin-left: 2px;
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
                <div class="inline-flex items-center" data-v-524f63ea="">
                  <!--[--><!--]--><span
                    class="CoreButton__text"
                    data-v-524f63ea=""
                    >{{ infoMoreButtonCmt }}</span
                  >
                </div>
                <!--]-->
              </button>
            </div>
          </div>
          <!-- 유의사항 -->
          <div class="mt-[36px]" data-v-6da505b4="">
            <div data-v-6da505b4="">
              <div
                class="BaseSubHeader BaseSubHeader--clickable"
                style="
                  --sub-header-padding-left: 0;
                  --sub-header-padding-right: 0;
                  --sub-header-min-height: 56;
                "
                data-v-b42a95d0=""
              >
                <!---->
                <div class="BaseSubHeader__contents" data-v-b42a95d0="">
                  <!--[--><span class="subtitle3-bold-small"
                    >작품 정보제공 고시</span
                  ><!--]-->
                </div>
                <div class="BaseSubHeader__append" data-v-b42a95d0="">
                  <!--[--><svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    style="
                      width: 20px;
                      height: 20px;
                      opacity: 1;
                      fill: currentColor;
                      --BaseIcon-color: #666666;
                    "
                    class="BaseIcon"
                    data-v-6d2bd019=""
                  >
                    <g clip-path="url(#clip0_124_2949)">
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M17.4697 8.46973L18.5304 9.53039L12.5304 15.5304C12.2641 15.7967 11.8475 15.8209 11.5538 15.603L11.4697 15.5304L5.46973 9.53039L6.53039 8.46973L12.0001 13.9391L17.4697 8.46973Z"
                      ></path>
                    </g>
                    <defs>
                      <clipPath id="clip0_124_2949">
                        <rect width="24" height="24"></rect>
                      </clipPath>
                    </defs></svg
                  ><!--]-->
                </div>
              </div>
              <div style="display: none" class="body1-regular-small pb-[16px]">
                <!--[-->
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">포장단위별 용량(중량), 수량</div>
                  <div class="whitespace-pre-line">개별포장후 상자포장</div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">생산자 및 소재지</div>
                  <div class="whitespace-pre-line">
                    JJ달콤상회/충남 공주시 신관동 신금2길47 대아상가
                  </div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">원재료명 및 함량</div>
                  <div class="whitespace-pre-line">
                    샤브레:버터(영국)아몬드가루(미국산)계란(국산)아몬드슬라이스(미국)말차가루(일본)
                    모양쿠키:버터(영국)
                    아몬드가루(미국산)슈가파우더(미국,브라질)식용색소(미국)밀가루(미국)계란(국산)
                    초코칩쿠키:버터(영국)초코칩(싱가포르)밀가루(미국)계란(국산)
                  </div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">
                    제조연월일, 소비기한 또는 품질유지기한
                  </div>
                  <div class="whitespace-pre-line">작품상세표시</div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">관리법상 표시사항</div>
                  <div class="whitespace-pre-line">해당사항없음</div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">구성</div>
                  <div class="whitespace-pre-line">작품상세표시</div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">보관방법 또는 취급방법</div>
                  <div class="whitespace-pre-line">작품상세표시</div>
                </div>
                <div class="body1-regular-medium mb-[10px] last:mb-0">
                  <div class="gray-999--text">작품관련문의</div>
                  <div class="whitespace-pre-line">
                    하단의 "작품 문의" 버튼 선택
                  </div>
                </div>
                <!--]-->
              </div>
            </div>
            <hr
              class="BaseDivider"
              style="--border-color: #f5f5f5"
              data-v-6ef4cf18=""
              data-v-6da505b4=""
            />
            <div data-v-6da505b4="">
              <div
                class="BaseSubHeader BaseSubHeader--clickable"
                style="
                  --sub-header-padding-left: 0;
                  --sub-header-padding-right: 0;
                  --sub-header-min-height: 56;
                "
                data-v-b42a95d0=""
              >
                <!---->
                <div class="BaseSubHeader__contents" data-v-b42a95d0="">
                  <!--[--><span class="subtitle3-bold-small">제작 / 배송</span
                  ><!--]-->
                </div>
                <div class="BaseSubHeader__append" data-v-b42a95d0="">
                  <!--[-->
                  <div
                    class="flex items-center body1_regular_small gray-666--text"
                  >
                    <div><span>평균 2일 / </span> 최대 3일 이내</div>
                    <svg
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      xmlns="http://www.w3.org/2000/svg"
                      style="
                        width: 20px;
                        height: 20px;
                        opacity: 1;
                        fill: currentColor;
                        --BaseIcon-color: #666666;
                      "
                      class="BaseIcon"
                      data-v-6d2bd019=""
                    >
                      <g clip-path="url(#clip0_124_2949)">
                        <path
                          fill-rule="evenodd"
                          clip-rule="evenodd"
                          d="M17.4697 8.46973L18.5304 9.53039L12.5304 15.5304C12.2641 15.7967 11.8475 15.8209 11.5538 15.603L11.4697 15.5304L5.46973 9.53039L6.53039 8.46973L12.0001 13.9391L17.4697 8.46973Z"
                        ></path>
                      </g>
                      <defs>
                        <clipPath id="clip0_124_2949">
                          <rect width="24" height="24"></rect>
                        </clipPath>
                      </defs>
                    </svg>
                  </div>
                  <!--]-->
                </div>
              </div>
              <div
                style="display: none"
                class="body1_regular_medium pb-[16px] whitespace-pre-line"
              >
                주문 후 제작에 들어가는 작품입니다.
              </div>
            </div>
            <hr
              class="BaseDivider"
              style="--border-color: #f5f5f5"
              data-v-6ef4cf18=""
              data-v-6da505b4=""
            />
            <div data-v-6da505b4="">
              <div
                class="BaseSubHeader BaseSubHeader--clickable"
                style="
                  --sub-header-padding-left: 0;
                  --sub-header-padding-right: 0;
                  --sub-header-min-height: 56;
                "
                data-v-b42a95d0=""
              >
                <!---->
                <div class="BaseSubHeader__contents" data-v-b42a95d0="">
                  <!--[--><span class="subtitle3_bold_small"
                    >교환 / 환불 / 반품</span
                  ><!--]-->
                </div>
                <div class="BaseSubHeader__append" data-v-b42a95d0="">
                  <!--[--><svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    style="
                      width: 20px;
                      height: 20px;
                      opacity: 1;
                      fill: currentColor;
                      --BaseIcon-color: #666666;
                    "
                    class="BaseIcon"
                    data-v-6d2bd019=""
                  >
                    <g clip-path="url(#clip0_124_2949)">
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M17.4697 8.46973L18.5304 9.53039L12.5304 15.5304C12.2641 15.7967 11.8475 15.8209 11.5538 15.603L11.4697 15.5304L5.46973 9.53039L6.53039 8.46973L12.0001 13.9391L17.4697 8.46973Z"
                      ></path>
                    </g>
                    <defs>
                      <clipPath id="clip0_124_2949">
                        <rect width="24" height="24"></rect>
                      </clipPath>
                    </defs></svg
                  ><!--]-->
                </div>
              </div>
              <div style="display: none" class="body1_regular_medium pb-[40px]">
                <!--[-->
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText--bold DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >[반품/교환 배송비]<br
                  /></span>
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >반품 : 편도 3,000원 / 왕복 6,000원 <br />교환 : 6,000원
                    <br />단순변심 및 고객님의 사유로 교환/반품하는 경우,
                    배송비는 고객님 부담입니다.<br />판매 작가님이 설정한
                    최소구매금액(1만 원)이 있는 경우, 고객님의 사유로
                    교환/반품하여 최소구매금액이 불충족될 시, 왕복 배송비는
                    고객님 부담입니다.<br />교환/반품하는 작품의 수량에 따라서
                    배송비는 추가 발생할 수 있습니다.<br />제주/도서산간 지역은
                    기본 배송비 외 추가 운임이 발생할 수 있습니다. 배송지역별
                    금액이 상이하므로 구매 전, 교환/반품 비용을 별도
                    문의하시기를 바랍니다. <br />교환/반품 조건(택배사, 배송비
                    부담, 반품 주소 등)을 반드시 작가님과 확인하고, 교환/반품
                    절차를 진행해 주시기를 바랍니다.<br /><br /><br
                  /></span>
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText--bold DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >[교환/반품이 불가능한 경우]<br
                  /></span>
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >• 반품가능기간(작품 수령후 7일 이내)이 지난 경우<br />•
                    고객님의 주문에 따라 개별적으로 생산되는 작품이 제작에
                    들어간 경우<br />• 고객의 사유로 작품 등이 전부 또는 일부가
                    멸실/훼손된 경우(단지, 작품 확인을 위한 포장 훼손 제외)<br />•
                    고객의 사용, 시간 경과, 소비에 의해 작품 등의 가치가 현저히
                    감소한 경우<br />• 시간의 경과에 의해 재판매가 곤란할 정도로
                    작품 등의 가치가 현저히 감소한 경우(신선 식품 등)<br />•
                    복제가 가능한 작품 등의 포장을 훼손되거나 디지털 콘텐츠 등의
                    제공이 개시된 경우<br /><br /><br
                  /></span>
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText--bold DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >[작가님 교환/환불 안내]<br
                  /></span>
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    >주문 전 판매 작가님과 연락하여 확인해주세요.</span
                  >
                </div>
                <div
                  class="BaseDecorateText transform-gpu whitespace-pre-line inline"
                  data-v-a1957620=""
                >
                  <span
                    class="DecorateText"
                    style="
                      font-size: 14px;
                      color: #333333;
                      background-color: inherit;
                    "
                    data-v-a1957620=""
                    ><br /><br />전자상거래 등에서의 소비자보호에 관한 법률에
                    의한 규정이 작가님이 제시한 조건보다 우선합니다.<br />단,
                    작가님이 제시한 조건이 관계법령보다 고객님께 유리한 경우에는
                    작가님의 제시 사항이 적용됩니다.<br
                  /></span>
                </div>
                <!--]-->
              </div>
            </div>
            <hr
              class="BaseDivider"
              style="--border-color: #f5f5f5"
              data-v-6ef4cf18=""
              data-v-6da505b4=""
            />
          </div>
          <!-- 후기 -->
          <hr
            class="BaseDivider my-[36px]"
            style="--border-color: #d9d9d9"
            data-v-6ef4cf18=""
            data-v-6da505b4=""
          />
          <div ref="review"></div>
          <!-- 키워드 -->
          <div data-v-6da505b4="">
            <hr
              class="BaseDivider my-[36px]"
              style="--border-color: #d9d9d9"
              data-v-6ef4cf18=""
              data-v-6da505b4=""
            />
            <div
              class="BaseSubHeader"
              style="
                --sub-header-padding-left: 0;
                --sub-header-padding-right: 0;
                --sub-header-min-height: 56;
              "
              data-v-b42a95d0=""
            >
              <div class="BaseSubHeader__contents" data-v-b42a95d0="">
                <span class="subtitle1_bold_small">작품 키워드</span>
              </div>
            </div>
            <div class="flex flex-wrap pb-[24px] w-full">
              <span
                class="BaseChip__outline BaseChip--medium BaseChip__outline--gray-666 BaseChip mb-[8px] mr-[8px]"
                data-v-43db7e7b=""
                v-for="(hashtag, index) in this.productStore.productDetail.productHashTags" :key="index"
              >
                <div
                  class="BaseBadgeNotification__wrapper"
                  data-v-cdfdef93=""
                  data-v-43db7e7b=""
                >
                  <div
                    class="BaseFontVariable"
                    data-v-9dbc8be1=""
                    data-v-43db7e7b=""
                  >
                    <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                      <span class="BaseFontVariable__text" data-v-9dbc8be1="">
                        #{{hashtag}}
                      </span>
                    </div>
                  </div>
                </div>
              </span>
            </div>
          </div>
          <!-- 문의 -->
          <hr
            class="BaseDivider my-[36px]"
            style="--border-color: #d9d9d9"
            data-v-6ef4cf18=""
            data-v-6da505b4=""
          />
          <div ref="ask">
            <AskCommentComponent :productIdx="productIdx"></AskCommentComponent>
          </div>
          <!-- 작가 정보 -->
          <!-- <AtelierProfileCardComponent :productIdx="productIdx"></AtelierProfileCardComponent> -->
          <!-- ============================ 기존 html 영역 ============================  -->
          <div data-v-1903850c="" id="ARTIST" ref="atelier" data-v-6da505b4="">
            <hr
              data-v-1903850c=""
              class="BaseDivider my-[36px]"
              data-v-6ef4cf18=""
              data-v-6da505b4=""
              style="--border-color: #d9d9d9"
            />
            <div
              data-v-1903850c=""
              data-v-6da505b4=""
              class="flex flex-col w-full"
            >
              <div data-v-1903850c="" class="flex w-full">
                <a
                  href="https://www.idus.com/w/artist/5697b8a5-24fa-4ec9-87e1-feb61bc66e60"
                  rel="noopener noreferrer"
                  data-v-1903850c=""
                  ><div
                    data-v-4bef34a0=""
                    class="BaseAvatarArtist mt-[10px]"
                    style="--overlay-size: 95; --overlay-image: url()"
                    data-v-1903850c=""
                  >
                    <!-- <div
                      data-v-2fc5c54e=""
                      data-v-4bef34a0=""
                      class="BaseAvatar BaseAvatar--border"
                      :style="{
                        '--BaseAvatar-image': `url(${productStore.productDetail.atelierProfileInfoRes.atelierProfileImage})`,
                        '--BaseAvatar-size': '68'
                      }"
                      data-v-1903850c=""
                    >
                    
                    </div> -->
                    <img class="atelier-img" :src="this.productStore.productDetail.atelierProfileInfoRes.atelierProfileImage"/>
                    </div
                ></a>
                <div
                  data-v-1903850c=""
                  class="flex flex-col items-start justify-start w-full ml-[8px] mt-[24px]"
                >
                  <a
                    data-v-1903850c=""
                    href="https://www.idus.com/w/artist/5697b8a5-24fa-4ec9-87e1-feb61bc66e60"
                    rel="noopener noreferrer"
                    class="flex items-center"
                    ><span
                      data-v-1903850c=""
                      class="subtitle3_bold_small gray-333--text line-clamp-1"
                      >{{this.productStore.productDetail.atelierProfileInfoRes.atelierName}}</span
                    ><svg
                      data-v-1903850c=""
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
                      <g data-v-1903850c="" clip-path="url(#clip0_124_2947)">
                        <path
                          data-v-1903850c=""
                          fill-rule="evenodd"
                          clip-rule="evenodd"
                          d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z"
                        ></path>
                      </g>
                      <defs data-v-1903850c="">
                        <clipPath data-v-1903850c="" id="clip0_124_2947">
                          <rect
                            data-v-1903850c=""
                            width="24"
                            height="24"
                          ></rect>
                        </clipPath>
                      </defs></svg
                  ></a>
                  <div
                    data-v-1903850c=""
                    data-v-2c82c531=""
                    class="BaseRating BaseRating__sizeText--medium mt-[6px]"
                    style="--BaseRating-gap: 0"
                  >
                    <div
                      data-v-1903850c=""
                      data-v-2c82c531=""
                      class="BaseRating__rangeList"
                    >
                      <svg
                        data-v-1903850c=""
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
                        <g data-v-1903850c="" clip-path="url(#clip0_124_2995)">
                          <path
                            data-v-1903850c=""
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                          ></path>
                        </g>
                        <defs data-v-1903850c="">
                          <clipPath data-v-1903850c="" id="clip0_124_2995">
                            <rect
                              data-v-1903850c=""
                              width="24"
                              height="24"
                            ></rect>
                          </clipPath>
                        </defs></svg
                      ><svg
                        data-v-1903850c=""
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
                        <g data-v-1903850c="" clip-path="url(#clip0_124_2995)">
                          <path
                            data-v-1903850c=""
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                          ></path>
                        </g>
                        <defs data-v-1903850c="">
                          <clipPath data-v-1903850c="" id="clip0_124_2995">
                            <rect
                              data-v-1903850c=""
                              width="24"
                              height="24"
                            ></rect>
                          </clipPath>
                        </defs></svg
                      ><svg
                        data-v-1903850c=""
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
                        <g data-v-1903850c="" clip-path="url(#clip0_124_2995)">
                          <path
                            data-v-1903850c=""
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                          ></path>
                        </g>
                        <defs data-v-1903850c="">
                          <clipPath data-v-1903850c="" id="clip0_124_2995">
                            <rect
                              data-v-1903850c=""
                              width="24"
                              height="24"
                            ></rect>
                          </clipPath>
                        </defs></svg
                      ><svg
                        data-v-1903850c=""
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
                        <g data-v-1903850c="" clip-path="url(#clip0_124_2995)">
                          <path
                            data-v-1903850c=""
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                          ></path>
                        </g>
                        <defs data-v-1903850c="">
                          <clipPath data-v-1903850c="" id="clip0_124_2995">
                            <rect
                              data-v-1903850c=""
                              width="24"
                              height="24"
                            ></rect>
                          </clipPath>
                        </defs></svg
                      ><svg
                        data-v-1903850c=""
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
                        <g data-v-1903850c="" clip-path="url(#clip0_124_2995)">
                          <path
                            data-v-1903850c=""
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M12.4363 2.29343C12.6335 2.39076 12.7931 2.55039 12.8904 2.7476L15.2877 7.60507C15.4334 7.90021 15.715 8.10478 16.0407 8.15211L21.4012 8.93104C21.9478 9.01046 22.3264 9.5179 22.247 10.0644C22.2154 10.2821 22.1129 10.4832 21.9554 10.6367L18.0765 14.4177C17.8408 14.6475 17.7333 14.9785 17.7889 15.3029L18.7046 20.6418C18.798 21.1861 18.4324 21.703 17.888 21.7964C17.6713 21.8336 17.4483 21.7983 17.2536 21.6959L12.459 19.1753C12.1677 19.0221 11.8197 19.0221 11.5284 19.1753L6.73375 21.6959C6.2449 21.9529 5.64028 21.765 5.38327 21.2761C5.28094 21.0815 5.24562 20.8585 5.2828 20.6418L6.19849 15.3029C6.25412 14.9785 6.14658 14.6475 5.91089 14.4177L2.03197 10.6367C1.63649 10.2512 1.62839 9.61812 2.01389 9.22264C2.1674 9.06515 2.36855 8.96267 2.58618 8.93104L7.94672 8.15211C8.27243 8.10478 8.554 7.90021 8.69966 7.60507L11.097 2.7476C11.3414 2.25234 11.941 2.04901 12.4363 2.29343Z"
                          ></path>
                        </g>
                        <defs data-v-1903850c="">
                          <clipPath data-v-1903850c="" id="clip0_124_2995">
                            <rect
                              data-v-1903850c=""
                              width="24"
                              height="24"
                            ></rect>
                          </clipPath>
                        </defs>
                      </svg>
                    </div>
                    <div
                      data-v-1903850c=""
                      data-v-2c82c531=""
                      class="BaseRating__label"
                    >
                      <div
                        data-v-1903850c=""
                        data-v-2c82c531=""
                        class="BaseRating__labelRate"
                      >
                        {{this.productStore.productDetail.atelierProfileInfoRes.atelierAverageScore}}
                      </div>
                      <div
                        data-v-1903850c=""
                        data-v-2c82c531=""
                        class="BaseRating__labelAppned"
                      >
                        ({{this.productStore.productDetail.atelierProfileInfoRes.havingProductsReviewCount}})
                      </div>
                    </div>
                  </div>
                  <div
                    class="flex w-full mt-[16px] text-left"
                    data-v-1903850c=""
                  >
                    <div class="flex flex-col w-full" data-v-1903850c="">
                      <div
                        class="body1_regular_small gray-999--text"
                        data-v-1903850c=""
                      >
                        작품 찜
                      </div>
                      <div
                        class="subtitle1_bold_small mt-[4px]"
                        data-v-1903850c=""
                      >
                        {{this.productStore.productDetail.atelierProfileInfoRes.havingProductsLikeCount}}
                      </div>
                    </div>
                    <div class="flex flex-col w-full" data-v-1903850c="">
                      <div
                        class="body1_regular_small gray-999--text"
                        data-v-1903850c=""
                      >
                        팔로워
                      </div>
                      <div
                        class="subtitle1_bold_small mt-[4px]"
                        data-v-1903850c=""
                      >
                        {{this.productStore.productDetail.atelierProfileInfoRes.havingFollowerCount}}
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div data-v-1903850c="">
                <div
                  data-v-1903850c=""
                  data-v-fbfd1092=""
                  class="ArtistIntroduce my-[24px]"
                  style="--introduce-height: 36px"
                >
                  <div
                    data-v-1903850c=""
                    data-v-fbfd1092=""
                    class="ArtistIntroduce__inner text-left"
                  >
                    {{this.productStore.productDetail.atelierProfileInfoRes.oneLineDescription}}
                  </div>
                </div>
                <div
                  data-v-1903850c=""
                  class="grid grid-cols-2 gap-x-[4px] pb-[16px]"
                >
                  <div
                    data-v-1903850c=""
                    data-v-b6faa6c8=""
                    class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__colorType--yellow IDSTooltip__display--blocked IDSTooltip__innerPosition--bottom IDSTooltip__innerAlign--center IDSTooltip__innerCloseAlign--center"
                    style="--ids-tooltip-full-left: --8px"
                  >
                    <div
                      data-v-1903850c=""
                      data-v-b6faa6c8=""
                      class="IDSTooltip__trigger"
                    >
                      <button
                        data-v-1903850c=""
                        data-v-524f63ea=""
                        data-v-7940d6dd=""
                        type="outline"
                        class="CoreButton CoreButton--block BaseButtonRectangle body1-regular-small BaseButtonRectangle__outline"
                        style="
                          background-color: rgb(255, 255, 255);
                          color: rgb(239, 112, 20);
                          height: 36px;
                          flex-direction: row;
                          --core-button-padding-x: 8;
                          --button-rectangle-border-color: #ef7014;
                        "
                      >
                        <svg
                          data-v-1903850c=""
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
                            margin-right: 2px;
                          "
                        >
                          <g
                            data-v-1903850c=""
                            clip-path="url(#clip0_124_2960)"
                          >
                            <path
                              data-v-1903850c=""
                              fill-rule="evenodd"
                              clip-rule="evenodd"
                              d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"
                            ></path>
                          </g>
                          <defs data-v-1903850c="">
                            <clipPath data-v-1903850c="" id="clip0_124_2960">
                              <rect
                                data-v-1903850c=""
                                width="24"
                                height="24"
                              ></rect>
                            </clipPath>
                          </defs>
                        </svg>
                        <div
                          data-v-1903850c=""
                          data-v-524f63ea=""
                          class="inline-flex items-center"
                        >
                          <span
                            data-v-1903850c=""
                            data-v-524f63ea=""
                            class="CoreButton__text"
                            >팔로우</span
                          >
                        </div>
                      </button>
                    </div>
                  </div>
                  <button
                    data-v-1903850c=""
                    data-v-524f63ea=""
                    data-v-7940d6dd=""
                    data-v-9937b295=""
                    type="outline"
                    class="CoreButton BaseButtonRectangle body1-regular-small BaseButtonRectangle__outline"
                    style="
                      background-color: rgb(255, 255, 255);
                      color: rgb(51, 51, 51);
                      flex-direction: row;
                      --core-button-padding-x: 8;
                      font-weight: bold;
                      --button-rectangle-border-color: #acacac;
                    "
                  >
                    <router-link to="/atelier">
                      <div
                        data-v-1903850c=""
                        data-v-524f63ea=""
                        class="inline-flex items-center"
                      >
                        <span
                          data-v-1903850c=""
                          data-v-524f63ea=""
                          class="CoreButton__text"
                          >작가님의 다른 작품 더보기</span
                        >
                      </div>
                    </router-link>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <!-- ============================ 기존 html 영역 ============================  -->

          <!-- 위로 이동 버튼 -->
          <div v-if="isVisible" @click="moveScroll(4)" class="TheFabContainer" data-v-6da505b4="" data-v-0397dfb3="">
            <!--[--><button
              type="button"
              class="CoreButton IdsButtonFab__size--medium IdsButtonFab__iconSize--medium IdsButtonFab TheMoveToTopFab__display--show mb-[12px]"
              style="
                background-color: rgb(255, 255, 255);
                color: rgb(51, 51, 51);
                height: 56px;
                width: 56px;
                flex-direction: row;
                --core-button-padding-x: 0px;
              "
              data-v-6da505b4=""
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
      </div>
    </div>
  </div>
</template>

<script>
// import CarouselProductDetailComponent from "@/components/product/CarouselProductDetailComponent.vue";
import ProductDetailPaymentComponent from "@/components/product/ProductDetailPaymentComponent.vue";
import AskCommentComponent from "@/components/AskCommentComponent";
// import AtelierProfileCardComponent from "@/components/atelier/AtelierProfileCardComponent";
import { ref, onMounted, onUnmounted} from "vue";
import { useRoute } from 'vue-router';
import { useProductStore } from "@/stores/useProductStore";

export default {
  components: {
    // CarouselProductDetailComponent,
    ProductDetailPaymentComponent,
    AskCommentComponent,
    // AtelierProfileCardComponent,
  },
  setup() {

    //탭
    const tabs = ref([ 
      { name: "작품정보" },
      { name: "후기", count: 238 },
      { name: "문의" },
      { name: "공방 정보" },
    ]);

    const review = ref(null);
    const ask = ref(null);
    const atelier = ref(null);
    const top = ref(null);

    const moveScroll = (index) => {
      if (index === 1) {
        review.value?.scrollIntoView({ behavior: "smooth" });
      } else if (index === 2) {
        ask.value?.scrollIntoView({ behavior: "smooth" });
      } else if (index === 3) {
        atelier.value?.scrollIntoView({ behavior: "smooth" });
      }else if (index === 4) {
        top.value?.scrollIntoView({ behavior: "smooth" });
      }
    };


    //작품 정보 더보기, 접기
    const isInfoMoreOn = ref(false);
    const infoMoreButtonCmt = ref("작품 정보 더보기");

    const handleInfoMoreOnOff = () => {
      isInfoMoreOn.value = !isInfoMoreOn.value;
      infoMoreButtonCmt.value = isInfoMoreOn.value
        ? "작품 정보 접기"
        : "작품 정보 더보기";
    };

    const isVisible = ref(false);

    const handleScroll = () => {
      if (window.scrollY > 500) {
        isVisible.value = true;
      } else {
        isVisible.value = false;
      }
    };

    const route = useRoute();

    const productIdx = route.params.idx;
    // console.log("상세페이지 : "+productIdx);

    const productStore = useProductStore();
    // const productDetailData = ref(null);

    console.log("dfdfgfdgdfgdfgdf: "+productIdx);
    productStore.getProductDetail(productIdx);

    onMounted(async () => {
      console.log("불러오기");
      window.addEventListener("scroll", handleScroll);
    });

    onUnmounted(() => {
      window.removeEventListener("scroll", handleScroll);
    });

    return {
      tabs,
      isInfoMoreOn,
      infoMoreButtonCmt,
      review,
      ask,
      atelier,
      top,
      isVisible,
      handleInfoMoreOnOff,
      moveScroll,
      productIdx,
      productStore
      // productDetailData,
    };
  },
};
</script>

<style scoped>
.text-left {
  text-align: left !important;
}
.contract {
  --description-height: 2000px !important;
}
.rotate {
  transform: rotate(180deg);
  transition: transform 0.1s ease-in-out;
}
.review-count-text {
  color: #999;
  font-family: -apple-system, BlinkMacSystemFont, Malgun Gothic, 맑은 고딕,
    helvetica, Apple SD Gothic Neo, sans-serif;
  font-size: 11px;
  font-weight: 400;
  letter-spacing: normal;
  line-height: 1.2;
  margin-left: 4px;
  word-spacing: normal;
}
.atelier-img{
  /* border-radius: 100px; */
  width: 70px !important;
  height: 70px !important;
  object-fit: cover !important;
  border-radius: 50%;
}
</style>