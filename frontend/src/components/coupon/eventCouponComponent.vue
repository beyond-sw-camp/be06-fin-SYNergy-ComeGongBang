<template>
  <div class="w-full w-full pl-6">
    <div
        data-v-b42a95d0=""
        class="BaseSubHeader mb-[36px]"
        style="
        --sub-header-padding-left: 0;
        --sub-header-padding-right: 0;
        --sub-header-min-height: 48;
      "
    >
      <!---->
      <br/>
      <div data-v-b42a95d0="" class="BaseSubHeader__contents">
        <p class="headline4-bold-small" style="padding-top: 30px">
          이벤트/쿠폰
        </p>
      </div>
      <div data-v-b42a95d0="" class="BaseSubHeader__append">
        <button
            data-v-524f63ea=""
            data-v-8493c3f2=""
            type="default"
            class="CoreButton BaseButtonText body1-regular-small"
            style="
            background-color: transparent;
            color: rgb(80, 95, 205);
            height: 32px;
            flex-direction: row-reverse;
            --core-button-padding-x: 8;
          "
        >
          <!--     쿠폰 등록 -->
          <!--          <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">쿠폰 등록</span>-->
          <!--          </div>-->
        </button>
      </div>
    </div>

    <!--  쿠폰 없을 때 -->
    <div
        v-if="eventCouponList.length === 0"
        class="px-[16px] mb-[24px] flex flex-col items-center"
    >
      <div
          class="BaseEmptyStates BaseEmptyStates__buttonStyle--full !py-[150px]"
          data-v-58c5a73f=""
      >
        <div class="BaseEmptyStates__image" data-v-58c5a73f="">
          <svg
              width="24"
              height="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
              style="
              width: 80px;
              height: 80px;
              opacity: 1;
              fill: currentColor;
              --BaseIcon-color: #999999;
            "
              class="BaseIcon"
              data-v-6d2bd019=""
              data-v-58c5a73f=""
          >
            <g clip-path="url(#clip0_124_3028)">
              <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2ZM12 3.5C7.30558 3.5 3.5 7.30558 3.5 12C3.5 16.6944 7.30558 20.5 12 20.5C16.6944 20.5 20.5 16.6944 20.5 12C20.5 7.30558 16.6944 3.5 12 3.5ZM12.75 11V17H11.25V11H12.75ZM12.75 7V9H11.25V7H12.75Z"
              ></path>
            </g>
            <defs>
              <clipPath id="clip0_124_3028">
                <rect width="24" height="24"></rect>
              </clipPath>
            </defs>
          </svg>
        </div>
        <div class="BaseEmptyStates__title" data-v-58c5a73f="">
          현재 진행중인 이벤트가 없습니다.
        </div>
        <div class="BaseEmptyStates__description" data-v-58c5a73f="">
          항상 이용해주셔서 감사합니다.
        </div>
        <div class="BaseEmptyStates__buttons" data-v-58c5a73f="">
          <!--[-->
          <!--]-->
        </div>
      </div>
      <!---->

      <div
          class="px-[16px] py-[32px] gray-f5--background w-full !px-[32px] mt-[24px]"
      >
        <p class="subtitle3-bold-medium gray-666--text mb-[10px]">안내사항</p>
        <ul class="list-disc">
          <li
              class="body3-regular-medium gray-666--text ml-[16px] mb-[4px] last:mb-0"
          >
            쿠폰은 중복 적용이 불가합니다.
          </li>
          <li
              class="body3-regular-medium gray-666--text ml-[16px] mb-[4px] last:mb-0"
          >
            시너지 발행 쿠폰은 구매하신 작가님 별 구매금액 비율로 최종 할인이
            적용됩니다.
          </li>
        </ul>
      </div>
    </div>

    <!--    쿠폰 있을 때 -->
    <div v-else class="px-[16px] mb-[24px] flex flex-col items-center">
      <div class="w-[900px] mt-[36px] mb-[36px]">
        <div class="grid grid-cols-2 gap-[12px]">
          <div
              v-for="coupon in eventCouponList"
              :key="coupon.couponIdx"
              class="relative h-[240px] px-[28px] flex items-center"
          >
            <img
                src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAArAAAAHWCAYAAACPAbpsAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAA4aSURBVHgB7d1PdlPnHcfh9wrqNp3UGaZAjzzEDAgriFlByAoKOyArwKzAZAWmKwg7iLOCwAAztE4JZOpRKG2st++9NQTLMoUciPWVn+cc/7u6uvgIDz76nVevutLUvb3V8qd/rRY+mu6zy5OywPwNAAApuv5Tffp4s4y6O4WPbdIe8Uk5qN+XMtrpLl3eKaeg/vRkXGq90T6utj+BjXakhWsnXgGACAL2dE3ao79TRqO7H3tCO0xY//jiZvv2y1LLRgEACDUqnKZxew5xs0zrXn32eHuYjH5gfbi2694pKz/vtXDdEq8AQDoBuzAOQ/b57tYwLf0A6tMnG2XlxQ/tupuWCAAAy+L83KO17JRz3a3Ch/NL6dedrpauTUBH5Yt25PO559Vyu0XnjTY1vf5blxUcLhe40/692285a799elC67lH73SblD93DAgCwiKb12/JGO50/6bxFf9V8oMnh1wf9p2G5wEGbjHZDzI5nzh0fTmO/7v66fq+8h/9d9+cHpXZX55/QnpzU7m755ZOH3drafgEAWHCtifZbw7x2vnAqDp8g3ByC85fpzbkvoqtlq93+l3bu3Xe55nCtaf2uTVXHc641hOtp7XwAAPChWAN7yvqQ7S5d6XeBWCu/Tml/Na2bw4uw/o/X8Xpsmlv7ZyxfdxfXr4tXAGAZCNgFMYTshfW1FqHHp619xD7fPXE968nx2oJ4NLrW4vW9liEAACwyAbtghmnsvIjtlxP0uwrMMy9ea33UprrXrWUGAJaNgF1AJ0bsqH47u1dsv+1WmRev//nzhngFAJaRgF1QJ0TsaovT7Vc/1H/u3hi23TpqUs6NbthhAABYVgJ2gQ0R25WdIwdr2RjCtXeubB27k2UDAMCSs43Wonv58quysrJ35J20WrjW57tftJgdHzm3321AvAIAS84EdsF1a9f2y8Gxd0Ubz1s6YLcBAOAsELABur+tPzi2lGDWqLteAADOAAGb4qB7y7txdfctHQAAzgoBG2J4F62TprCj8k5vNQsAsAwEbJJ5U9hadkxfAYCzRMAGGaawpc7s71r/UQAAzhDbaIXpLlz5tAAAnGEmsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEEbAAAEQRsAAARBGwAABEOV+IUp/t7rUv418PlK+7i+v3CgDAGWECG6T++PhmeTNee6PyZQEAOEMEbJJR9/djx2rZqE+fbBQAgDNCwIYYIrXF6twbz9U7BQDgjBCwKUZ1+8TbTGEBgDNEwAaYu/Z11qhuFQCAM0DALrj605Nx6brZJQKTMq13Z459Xp/v3i4AAEtOwC66g+mDMjt9rfVud+nKZulD9sjxsmUpAQCw7ATsAmvT1ztt+nr16NHufnfxyv3h22l369idRnV7mNoCACwpAbughnid1s2Zw5P2P/Z66UB36fJOO+ebmXPG7dh3IhYAWFYCdgGdEK/90oGvus8uT9481F26crt0ZWfmTBELACwtAbtA6t7ean32ZHt+vPZvGXvl4dw7vnz5VZldD/sqYn98/HkBAFgiAnZBDC++WnnxQ/vu5rEbp/Vud3H93kn37dau7ZdRd73Mi9iu+2GY6AIALAkBe8qGqevz3a0yqt+VeXu9Tl/vOPBWw9KC+RHbX2OzPtvdO9xPFgAgmoA9Jf3EtT59fK+s/LxXapmzf2vdL7Xeepd4feWNiJ231KCfxm6/Ctk+nAsAQKDzc492ZdULgD6gg+lqmXbj9miPW5T222LdaIG62j/Qc9X6qJwb3Zh9wda7OLzPtRbHmy1m5y0dGEK2rLzYbpPfnXJQvy+1e9iO7bffb1IAABZNrUd+HArqLbHD76pNXaflm/eZur71av2TkOkJSxMAAEJZQrAwuvtlNLr2oeJ1uGKbxnYX1tf6pQilmK4CAMtBwJ6uSf8irfLvTz7tLly+9VuWDLyL/p27XodsPbZnLABAlPOF30ndbyk5aV/79aaPWrjunLiv60dy+Ba094cXcJ17sVG60n9cbR/jYpkBABDiv+O3Jhnqs53PAAAAAElFTkSuQmCC"
                class="absolute top-0 left-0 w-full h-full"
            />
            <div class="flex flex-col justify-center">
              <div class="mb-[16px] flex"></div>
              <div class="flex items-center">
                <div
                    data-v-2fc5c54e=""
                    class="BaseAvatar shrink-0"
                    style="
                    --BaseAvatar-image: url(https://image.idus.com/static/idus_logo_new.png);
                    --BaseAvatar-size: 32;
                  "
                >
                  <div data-v-2fc5c54e="" class="BaseAvatar__avatar">
                    <div
                        data-v-2fc5c54e=""
                        class="BaseAvatar__avatarImage"
                    ></div>
                  </div>
                  <div
                      data-v-8f163f81=""
                      data-v-2fc5c54e=""
                      class="CoreBadge BaseAvatar__iconDot"
                      style="
                      --CoreBadge-color-background: #ef7014;
                      --CoreBadge-color-outline: #ffffff;
                      --CoreBadge-size: 6;
                      --CoreBadge-fontSize: 11;
                      --CoreBadge-offset-x: 0;
                      --CoreBadge-offset-y: 0;
                      --CoreBadge-position: relative;
                    "
                  >
                    <!---->
                  </div>
                  <div
                      data-v-8f163f81=""
                      data-v-2fc5c54e=""
                      class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
                      style="
                      --CoreBadge-color-background: #000000;
                      --CoreBadge-color-outline: #ffffff;
                      --CoreBadge-size: 20;
                      --CoreBadge-fontSize: 11;
                      --CoreBadge-offset-x: 0;
                      --CoreBadge-offset-y: 0;
                      --CoreBadge-position: relative;
                    "
                  >
                    <!---->
                  </div>
                </div>
                <p class="body1-regular-small ml-[8px]">{{ coupon.name }}</p>
              </div>
              <div class="flex flex-col pl-[40px] mt-[4px]">
                <p
                    class="headline3-bold-small h-[32px] shrink-0"
                    style="text-align: left"
                >
                  {{ coupon.discountPercent }}%
                </p>
                <!--                <p class="body3-regular-small gray-999&#45;&#45;text mt-[8px]">40,000원 이상 구매시</p>-->
                <div class="flex items-center mt-[8px]">
                  <p class="body3-regular-small gray-666--text">
                    {{ formatDate(coupon.publicationDate) }} ~
                    {{ formatDate(coupon.expirationDate) }}
                  </p>
                </div>

                <button
                    @click="issueCoupon(coupon.couponIdx)"
                    type="button"
                    class="issue-button cursor-pointer CoreButton BaseButtonRectangle body1-regular-small"
                    style=""
                >
                  쿠폰 발급
                </button>

                <div class="mt-[16px] flex"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div data-v-e5a5a8d6="" class="BasePagination">
          <button
              data-v-524f63ea=""
              data-v-778c1d9b=""
              data-v-e5a5a8d6=""
              type="button"
              class="CoreButton CoreButton--disabled BaseButtonIcon BasePagination__arrow mr-[8px]"
              style="
              background-color: transparent;
              height: 32px;
              flex-direction: column;
              --core-button-padding-x: 4;
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
                width: 24px;
                height: 24px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-bottom: 0px;
              "
            >
              <g clip-path="url(#clip0_124_2946)">
                <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M14.4697 5.46973L15.5303 6.53039L10.061 12.0001L15.5303 17.4697L14.4697 18.5304L8.46967 12.5304C8.2034 12.2641 8.1792 11.8475 8.39705 11.5538L8.46967 11.4697L14.4697 5.46973Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2946">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div data-v-524f63ea="" class="inline-flex items-center">
              <!---->
            </div>
          </button>
          <div data-v-e5a5a8d6="" class="BasePagination__pages">
            <div
                data-v-77e9e007=""
                data-v-e5a5a8d6=""
                class="BasePaginationItem BasePaginationItem--active BasePagination__item"
            >
              <div
                  data-v-77e9e007=""
                  class="BasePaginationItem__item BasePaginationItem__number"
              >
                1
              </div>
            </div>
            <div
                data-v-77e9e007=""
                data-v-e5a5a8d6=""
                class="BasePaginationItem BasePaginationItem--active BasePagination__item"
                style="display: none"
            >
              <div
                  data-v-77e9e007=""
                  class="BasePaginationItem__item BasePaginationItem__number"
              >
                1
              </div>
            </div>
          </div>
          <button
              data-v-524f63ea=""
              data-v-778c1d9b=""
              data-v-e5a5a8d6=""
              type="button"
              class="CoreButton CoreButton--disabled BaseButtonIcon BasePagination__arrow ml-[8px]"
              style="
              background-color: transparent;
              height: 32px;
              flex-direction: column;
              --core-button-padding-x: 4;
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
                width: 24px;
                height: 24px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-bottom: 0px;
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
              <!---->
            </div>
          </button>
        </div>
      </div>
      <div
          class="px-[16px] py-[32px] gray-f5--background w-full !px-[32px] mt-[24px]"
      >
        <p class="subtitle3-bold-medium gray-666--text mb-[10px]">안내사항</p>
        <ul class="list-disc">
          <li
              class="body3-regular-medium gray-666--text ml-[16px] mb-[4px] last:mb-0"
          >
            쿠폰은 중복 적용이 불가합니다.
          </li>
          <li
              class="body3-regular-medium gray-666--text ml-[16px] mb-[4px] last:mb-0"
          >
            시너지 발행 쿠폰은 구매하신 작가님 별 구매금액 비율로 최종 할인이
            적용됩니다.
          </li>
        </ul>
      </div>
    </div>
    <!---->
  </div>

  <!-- 모달창 -->
  <div v-if="isModalVisible" class="modal-backdrop">
    <div class="modal-content">

      <p v-if="progress===0">대기열에 진입 중입니다... 잠시만 기다려주세요.</p>

      <div v-else>
        <p>
          현재 대기열 위치: {{ position }}번<br/>
          내 뒤로 대기 중인 인원: {{ backPosition }}명
        </p>
        <div class="progress-container">
          <div class="progress-bar" :style="{ width: progress + '%' }"></div>
        </div>
        <p>{{ progress !== undefined ? progress.toFixed(2) : '0.00' }}% 대기율 </p>
      </div>

      <br/><br/>
      <button @click="handleCloseModal" class="close-button">닫기</button>
    </div>
  </div>

</template>

<script setup>
import {useCouponStore} from "@/stores/useCouponStore";
import {formatDate} from "@/utils/formatDate";
import {computed, onBeforeUnmount, onMounted, ref} from "vue";
import swal from "sweetalert2";
import router from "@/router";

const couponStore = useCouponStore();
const eventCouponList = computed(() => couponStore.eventCouponList);

const isPolling = ref(false);
const intervalId = ref(null);
const isModalVisible = ref(false);

const position = ref(0);
const backPosition = ref(0);
const progress = ref(0);


const showAlert = (content) => {
  swal.fire({
    text: content,
    padding: "30px 0 30px 0",
    showCancelButton: true,
    confirmButtonText: "쿠폰함으로",
  }).then((result) => {
    if (result.isConfirmed) {
      router.push('/myCouponList');
    }
  });
};

const showAlert2 = (content) => {
  swal.fire({
    text: content,
    padding: "30px 0 30px 0",
    showCancelButton: true,
    confirmButtonText: "로그인하기",
  }).then((result) => {
    if (result.isConfirmed) {
      router.push('/login');
    }
  });
};

const issueCoupon = async (couponIdx) => {
  const response = await couponStore.getEventCoupon(couponIdx);

  if (response.inQueue) {
    position.value = 0;
    backPosition.value = 0;
    progress.value = 0;

    showModal();
    startPolling(response.queueIdx);
  } else if (response.code === 2002){
    console.log(response)
    showAlert2(response.message);
  } else {
    showAlert(response.message)
  }
};


const startPolling = (queueIdx) => {
  if (!isPolling.value) {
    isPolling.value = true;
    intervalId.value = setInterval(async () => {

      const response = await couponStore.fetchQueueStatus(queueIdx);
      if (response.isIssued === true) {
        clearInterval(intervalId.value);
        isPolling.value = false;
        showAlert(`쿠폰이 발급되었습니다!`);
        closeModal();
      } else {

        position.value = response.position;
        backPosition.value = response.backPosition;
        progress.value = response.progress;
      }
    }, 3000);
  }
};

const showModal = () => {
  isModalVisible.value = true;
  isPolling.value = false;
};

const closeModal = async () => {
  isModalVisible.value = false;

};

const handleCloseModal = async () => {
  await removeFromQueue();
  clearInterval(intervalId.value);
  closeModal();
};

const removeFromQueue = async () => {
  if (couponStore.queueIdx) {
    await couponStore.removeFromQueue(couponStore.queueIdx);
    couponStore.queueIdx = null;
  }
};

onBeforeUnmount(() => {
  clearInterval(intervalId.value);
  handleCloseModal();
});

onMounted(() => {
  couponStore.fetchEventCouponList();
});
</script>

<style scoped>





.dday {
  border: 1px solid black;
  border-radius: 5px;
  padding: 3px;
}

.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6); /* 어두운 배경 */
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999; /* 다른 요소보다 위에 나타나도록 설정 */
}

.modal-content {
  background-color: white; /* 모달 내부 배경 */
  padding: 20px; /* 적당한 padding */
  border-radius: 8px; /* 모서리 둥글게 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 그림자 효과 */
  animation: fadeIn 0.3s ease-in-out; /* 나타나는 애니메이션 */
  max-width: 500px;
  width: 100%;
  text-align: center;
}

.CoreButton {
  z-index: 1;
  background-color: #5095cd;
  color: white;
  height: 36px;
  width: 100px;
  margin-top: 10px;
  border: none;
  transition: background-color 0.3s, color 0.3s;
}

.CoreButton:hover {
  background-color: #3b7fa4;
  color: white;
}

.CoreButton:active {
  background-color: #2a5e7a;
  color: white;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.progress-container {
  width: 100%;
  background-color: #e0e0e0;
  border-radius: 4px;
  margin: 10px 0;
  height: 20px;
}

.progress-bar {
  height: 100%;
  background-color: #5095cd;
  border-radius: 4px;
  transition: width 0.3s ease-in-out;
}
.BaseAvatar__avatarImage[data-v-2fc5c54e] {
  background-image: url(https://github-production-user-asset-6210df.s3.amazonaws.com/104816530/368289656-2ce021dd-af1a-4277-abdd-6ba502aea81c.PNG?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAVCODYLSA53PQK4ZA%2F20241020%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20241020T160026Z&X-Amz-Expires=300&X-Amz-Signature=96721dd77a9ace1a56cc04c4084270452c70c9c0d206b785629b6c5078609d57&X-Amz-SignedHeaders=host);
  background-position: 50%;
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 50%;
  min-height: 100%;
  min-width: 100%;
}

</style>

