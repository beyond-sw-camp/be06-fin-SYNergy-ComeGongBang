<template>
  <div class="pb-[80px]">
    <div class="ATFArtist" data-v-1ef4b2e1="">
      <div class="ATFArtist__artist" data-v-1ef4b2e1="">
        <a
          href="https://www.idus.com/w/artist/5697b8a5-24fa-4ec9-87e1-feb61bc66e60"
          rel="noopener noreferrer"
          data-v-1ef4b2e1=""
          ><div
            class="BaseAvatar mr-[4px]"
            style="
              --BaseAvatar-image: url(//image.idus.com/image/files/3c6ef38e01f34c2eb874f48946bf729d_320.jpg);
              --BaseAvatar-size: 32;
            "
            data-v-2fc5c54e=""
            data-v-1ef4b2e1=""
          >
            <div class="BaseAvatar__avatar" data-v-2fc5c54e="">
              <div class="BaseAvatar__avatarImage" data-v-2fc5c54e=""></div>
            </div>
            <div
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
              data-v-8f163f81=""
              data-v-2fc5c54e=""
            >
              <!--[--><!--]--><!---->
            </div>
            <div
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
              data-v-8f163f81=""
              data-v-2fc5c54e=""
            >
              <!--[--><!--]--><!---->
            </div>
          </div></a
        >
        <div class="flex flex-col" data-v-1ef4b2e1="">

            <router-link to="/">
                <div class="flex" data-v-1ef4b2e1="">
                  <span class="ATFArtist__artistName" data-v-1ef4b2e1=""
                    >{{productStore.product.atelier}}</span
                  ><svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    style="
                      width: 16px;
                      height: 16px;
                      opacity: 1;
                      fill: currentColor;
                      --BaseIcon-color: #333333;
                    "
                    class="BaseIcon"
                    data-v-6d2bd019=""
                    data-v-1ef4b2e1=""
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
            </router-link>

        </div>
      </div>
      <div class="w-[50%] text-right" data-v-1ef4b2e1="">
        <div class="ATFArtist__review" data-v-1ef4b2e1="">
          <div
            class="BaseRating BaseRating__sizeText--medium"
            style="--BaseRating-color: #505fcd; --BaseRating-gap: 0"
            data-v-2c82c531=""
            data-v-1ef4b2e1=""
          >
            <div class="BaseRating__rangeList" data-v-2c82c531="">
              <!--[-->
              <svg
                width="24"
                height="24"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
                style="
                  width: 14px;
                  height: 14px;
                  opacity: 1;
                  fill: currentColor;
                  --BaseIcon-color: #ffaf00;
                "
                class="BaseIcon CoreStar__type--full BaseRating__rangeListItem"
                data-v-6d2bd019=""
                data-v-2c82c531=""
                v-for="star in 5" :key="star.index"
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
            <div class="BaseRating__label" data-v-2c82c531="">
              <div class="BaseRating__labelRate" data-v-2c82c531="">{{productStore.product.score}}</div>
              <div class="BaseRating__labelAppned" data-v-2c82c531="">
                <!--[-->({{productStore.product.reviewCount}})<!--]-->
              </div>
            </div>
          </div>
          <svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            style="
              width: 16px;
              height: 16px;
              opacity: 1;
              fill: currentColor;
              --BaseIcon-color: #505fcd;
            "
            class="BaseIcon"
            data-v-6d2bd019=""
            data-v-1ef4b2e1=""
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
    </div>
    <div
      class="flex items-center justify-between headline5-regular-small py-[12px]"
    >
      {{productStore.product.name}}
      <div class="flex ml-[10px]">
        <button
          type="button"
          class="CoreButton BaseButtonIcon caption1-regular-small"
          style="
            background-color: transparent;
            color: #333333;
            height: 44px;
            width: 44px;
            flex-direction: column;
            font-weight: normal;
          "
          data-v-524f63ea=""
          data-v-778c1d9b=""
        >
          <!----><!--[--><svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            style="
              width: 28px;
              height: 28px;
              opacity: 1;
              fill: currentColor;
              --BaseIcon-color: #333333;
              margin-bottom: 2px;
            "
            class="BaseIcon CoreButton__icon"
            data-v-6d2bd019=""
            data-v-524f63ea=""
          >
            <g clip-path="url(#clip0_124_3004)">
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M3.45575 5.21022C5.40348 2.72095 8.88417 2.58926 11.6176 4.8757L11.8163 5.04731L11.999 5.21506C14.6601 2.69744 18.173 2.61584 20.2537 4.86834L20.4033 5.03732L20.5444 5.2104C23.7406 9.29788 20.7753 15.9377 12.3669 20.6542C12.139 20.782 11.861 20.782 11.6331 20.6542C3.22467 15.9377 0.259448 9.29788 3.45575 5.21022ZM19.3628 6.1344C17.8977 4.261 15.1694 4.24208 13.0001 6.33299C15.4857 9.59717 14.7287 13.0513 12 13.0513C9.27157 13.0513 8.51447 9.59788 10.9985 6.33541C8.8256 4.24529 6.1059 4.25738 4.63724 6.13438C2.24403 9.19499 4.42837 14.4872 11.3009 18.7195L11.6484 18.9302L12 19.1361L12.3516 18.9302C19.2633 14.8041 21.6399 9.60005 19.5868 6.44778L19.4786 6.28928L19.3628 6.1344ZM12 7.49506L11.9857 7.51565C10.377 9.76459 10.8087 11.5513 12 11.5513C13.1572 11.5513 13.5977 9.86523 12.1473 7.70726L12 7.49506Z"
              ></path>
            </g>
            <defs>
              <clipPath id="clip0_124_3004">
                <rect width="24" height="24"></rect>
              </clipPath>
            </defs>
          </svg>
          <div class="inline-flex items-center" data-v-524f63ea="">
            <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
              >696</span
            >
          </div>
          <!--]-->
        </button>
        <div class="ml-[4px]">
          <div
            class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__display--close IDSTooltip__colorType--yellow IDSTooltip__innerPosition--bottom IDSTooltip__innerAlign--end IDSTooltip__innerCloseAlign--center"
            style="--ids-tooltip-full-left: --8px"
            data-v-b6faa6c8=""
          >
            <div class="IDSTooltip__trigger" data-v-b6faa6c8="">
              <!--[--><!--[--><button
                type="button"
                class="CoreButton BaseButtonIcon caption1-regular-small"
                style="
                  background-color: transparent;
                  color: #333333;
                  height: 44px;
                  width: 44px;
                  flex-direction: column;
                "
                data-v-524f63ea=""
                data-v-778c1d9b=""
              >
                <!----><!--[--><svg
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  style="
                    width: 28px;
                    height: 28px;
                    opacity: 1;
                    fill: currentColor;
                    --BaseIcon-color: #333333;
                    margin-bottom: 2px;
                  "
                  class="BaseIcon CoreButton__icon"
                  data-v-6d2bd019=""
                  data-v-524f63ea=""
                >
                  <g clip-path="url(#clip0_124_2972)">
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M18 2C19.6569 2 21 3.34315 21 5C21 6.65685 19.6569 8 18 8C17.2273 8 16.5228 7.70787 15.991 7.22802L10.34 11.974L15.9961 16.7674C16.5273 16.2903 17.2298 16 18 16C19.6569 16 21 17.3431 21 19C21 20.6569 19.6569 22 18 22C16.3431 22 15 20.6569 15 19C15 18.659 15.0569 18.3313 15.1617 18.0259L9.19194 12.9681C7.97302 14.3227 6.90904 15 6 15C4.34315 15 3 13.6569 3 12C3 10.3431 4.34315 9 6 9C6.87794 9 7.9004 9.63175 9.06738 10.8952L9.179 10.991L15.16 5.96915C15.0563 5.66513 15 5.33914 15 5C15 3.34315 16.3431 2 18 2ZM18 17.5C17.1716 17.5 16.5 18.1716 16.5 19C16.5 19.8284 17.1716 20.5 18 20.5C18.8284 20.5 19.5 19.8284 19.5 19C19.5 18.1716 18.8284 17.5 18 17.5ZM6 10.5C5.17157 10.5 4.5 11.1716 4.5 12C4.5 12.8284 5.17157 13.5 6 13.5C6.36713 13.5 6.99833 13.1025 7.81298 12.2501L8.002 12.046L7.9692 12.0076L8.014 11.969L7.96672 11.93L7.973 11.921L7.81234 11.7493C7.0491 10.9508 6.44695 10.5517 6.07221 10.5047L6 10.5ZM18 3.5C17.1716 3.5 16.5 4.17157 16.5 5C16.5 5.82843 17.1716 6.5 18 6.5C18.8284 6.5 19.5 5.82843 19.5 5C19.5 4.17157 18.8284 3.5 18 3.5Z"
                    ></path>
                  </g>
                  <defs>
                    <clipPath id="clip0_124_2972">
                      <rect width="24" height="24"></rect>
                    </clipPath>
                  </defs>
                </svg>
                <div class="inline-flex items-center" data-v-524f63ea="">
                  <!--[--><!--]--><span
                    class="CoreButton__text"
                    data-v-524f63ea=""
                    >공유</span
                  >
                </div>
                <!--]--></button
              ><!--]--><!--]-->
            </div>
            <!---->
          </div>
          <!--[--><!----><!----><!--]-->
        </div>
      </div>
    </div>
    <div class="flex items-center justify-between mb-[12px]">
      <div class="leading-[1.2]" data-v-882bdf84="">
        <div class="mb-[4px] text-left" data-v-882bdf84="">
          <!--[-->
          <div
            class="BaseDecorateText transform-gpu whitespace-pre inline mr-[6px]"
            data-v-882bdf84=""
            data-v-a1957620=""
          >
            <span
              class="DecorateText--strike DecorateText"
              style="font-size: 14px; color: #999999; background-color: inherit"
              data-v-a1957620=""
              >{{productStore.product.price+""}}원</span
            >
          </div>
          <!--]-->
        </div>
        <div class="flex items-center mb-[4px]" data-v-882bdf84="">
          <!--[-->
          <div
            class="BaseDecorateText transform-gpu whitespace-pre inline size22"
            data-v-882bdf84=""
            data-v-a1957620=""
          >
            <span
              class="DecorateText--bold DecorateText"
              style="font-size: 22px; color: #ff4b50; background-color: inherit"
              data-v-a1957620=""
              >{{productStore.product.percent}}%
            </span>
          </div>
          <div
            class="BaseDecorateText transform-gpu whitespace-pre inline size22"
            data-v-882bdf84=""
            data-v-a1957620=""
          >
            <span
              class="DecorateText--bold DecorateText"
              style="font-size: 22px; color: #333333; background-color: inherit"
              data-v-a1957620=""
              >{{productStore.product.price*(100-productStore.product.percent)/100}}원</span
            >
          </div>
        </div>
        <!----><!---->
      </div>
    </div>
    <!---->
    <div class="ProductDetailATFDiscountInfo mt-[16px] mb-[20px] max-w-[580px]">
      <div
        class="border-[#e1e1e1] border-[1px] rounded-[8px] p-[14px] leading-[1.2] border-gray"
      >
        <!----><!---->
        <div>
          <!--[-->
          <div
            class="flex justify-between body2-regular-small mb-[10px] last:mb-0"
          >
            <div class="flex">
              <!----><!--[-->
              <div
                class="BaseDecorateText transform-gpu whitespace-pre-line line-clamp-1 text-ellipsis break-all"
                data-v-a1957620=""
              >
                <span
                  class="DecorateText"
                  style="
                    font-size: 13px;
                    color: #333333;
                    background-color: inherit;
                  "
                  data-v-a1957620=""
                  >작품 즉시할인</span
                >
              </div>
              <!--]-->
            </div>
            <!--[-->
            <div
              class="BaseDecorateText transform-gpu whitespace-pre inline ml-[8x] whitespace-nowrap"
              data-v-a1957620=""
            >
              <span
                class="DecorateText"
                style="
                  font-size: 13px;
                  color: #333333;
                  background-color: inherit;
                "
                data-v-a1957620=""
                >-{{productStore.product.price*productStore.product.percent/100}}원</span
              >
            </div>
            <!--]-->
          </div>
          <!--]-->
        </div>
      </div>
      <div
        class="border-[#e1e1e1] border-[1px] rounded-[8px] p-[14px] mt-[16px] leading-[1.2] border-gray"
      >
        <div class="flex justify-between">
          <!--[-->
          <div
            class="BaseDecorateText transform-gpu whitespace-pre inline"
            data-v-a1957620=""
          >
            <span
              class="DecorateText--bold DecorateText"
              style="font-size: 14px; color: #333333; background-color: inherit"
              data-v-a1957620=""
              >멤버십 가입시 혜택가</span
            >
          </div>
          <!--]--><!--[-->
          <div
            class="BaseDecorateText transform-gpu whitespace-pre inline"
            data-v-a1957620=""
          >
            <span
              class="DecorateText--bold DecorateText"
              style="font-size: 18px; color: #ff4b50; background-color: inherit"
              data-v-a1957620=""
              >4,800원</span
            >
          </div>
          <!--]-->
        </div>
        <div class="mt-[20px] cursor-pointer">
          <div class="BaseBannerMembership" data-v-62ba81fa="">
            <!--[-->
            <div
              class="BaseIconMembershipColor"
              style="--icon-width: 24; --icon-height: 24"
              data-v-62ba81fa=""
              data-v-27c9b08d=""
            >
              <div
                class="BaseIconMembershipColor__icon"
                data-v-27c9b08d=""
              ></div>
            </div>
            <!--]--><!--[--><!--[-->
            <div
              class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]"
              data-v-62ba81fa=""
              data-v-a1957620=""
            >
              <span
                class="DecorateText"
                style="
                  font-size: 13px;
                  color: #ffffff;
                  background-color: inherit;
                "
                data-v-a1957620=""
                >멤버십 가입시
              </span>
            </div>
            <div
              class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]"
              data-v-62ba81fa=""
              data-v-a1957620=""
            >
              <span
                class="DecorateText--bold DecorateText"
                style="
                  font-size: 13px;
                  color: #ffffff;
                  background-color: inherit;
                "
                data-v-a1957620=""
                >4천원 쿠폰 + 5% 추가할인</span
              >
            </div>
            <!--]--><!--]--><!--[--><svg
              width="24"
              height="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
              style="
                width: 20px;
                height: 20px;
                opacity: 1;
                fill: currentColor;
                --BaseIcon-color: #ffffff;
              "
              class="BaseIcon"
              data-v-6d2bd019=""
              data-v-62ba81fa=""
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
              </defs></svg
            ><!--]-->
          </div>
        </div>
      </div>
      <!---->
    </div>
    <div class="ATFExtra">
      <hr
        class="BaseDivider"
        style="--border-color: #f5f5f5"
        data-v-6ef4cf18=""
      />
      <hr
        class="BaseDivider"
        style="--border-color: #f5f5f5"
        data-v-6ef4cf18=""
      />
    </div>
    <!--[--><!----><!--]-->
    <div class="py-[20px]">
      <div class="mb-[20px]">
        <div class="OptionButton text-left border-gray" :class="{'toggle-on-background':isToggleOn}" data-v-7bf7483b="" @click="toggleOnOff">
          <div class="flex-auto whitespace-nowrap mr-[12px]" data-v-7bf7483b="">
            {{isToggleOn ? `옵션 선택 (${productStore.selectedIdx.size}/${productStore.product.options.length})` : `옵션을 선택해주세요`}}
          </div>
          <svg
            data-v-6d2bd019=""
            data-v-7bf7483b=""
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            class="BaseIcon min-w-[20px]"
            style="
              width: 20px;
              height: 20px;
              opacity: 1;
              fill: currentcolor;
              --BaseIcon-color: #999999;
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
          data-v-05d83f31=""
          class="DialogOption__container DialogOption__type--atf"
          :class="{'toggle-off' : !isToggleOn}"
        >
          <div data-v-05d83f31="" class="DialogOption">
            <div data-v-05d83f31="" class="DialogOption__contents">
              <div data-v-05d83f31="" class="">
                <div data-v-05d83f31="">
                  <div
                    data-v-237a5614=""
                    class="ProductOptionSelector mb-[8px] border-gray"
                    v-for="option in productStore.product.options" :key="option.idx"
                    @click="optionToggle(option.idx)"
                  >
                    <div
                      data-v-237a5614=""
                      class="ProductOptionSelector__title"
                      :class="{'toggle-on-background':selectedOptionIdx===option.idx}"
                    >
                      <div
                        data-v-237a5614=""
                        class="flex-auto whitespace-nowrap mr-[12px] text-left"
                      >
                        {{option.idx}}.{{option.name}}
                      </div>
                      <div
                        data-v-237a5614=""
                        class="flex-auto body2-regular-small text-right text-ellipsis whitespace-nowrap overflow-hidden"
                      >
                        {{productStore.selectedIdx.get(option.idx)}}
                      </div>
                      <svg
                        data-v-6d2bd019=""
                        data-v-237a5614=""
                        width="24"
                        height="24"
                        viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg"
                        class="BaseIcon min-w-[20px]"
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
                        v-for=" select in option.selects" :key="select.idx" 
                        @click="optionSelect(option.idx, select.idx)"
                        :class="{'toggle-off':selectedOptionIdx!==option.idx}">
                        <div data-v-237a5614="" class="ProductOptionSelector__item">
                          <div data-v-237a5614="">
                            {{select.name}}
                            <!---->
                          </div>
                        </div>
                        <hr
                          data-v-6ef4cf18=""
                          data-v-237a5614=""
                          class="BaseDivider mx-[12px]"
                          style="--border-color: #e1e1e1"
                        />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="mt-[10px]">
          <!--[-->
          <div data-v-1d6c00b5="" class="SelectedItem mb-[8px]">
            <div data-v-1d6c00b5="" class="SelectedItem__info">
              <div data-v-1d6c00b5="">
                <span v-for="option in productStore.product.options" :key="option.idx">{{option.idx}}.{{option.name}}:{{option.selectedIdx}}/</span>
                <!-- 1. 줄: 꽃크레파스 / 2. 펜던트: 나무원형S / 3. 사이즈: XS / 4.
                글씨체: 꽃보다곰팅체 / 5. 리뷰할인: 리뷰 쓰실분 선택 -->
              </div>
              <div data-v-1d6c00b5="" class="w-[20px]">
                <svg
                  data-v-6d2bd019=""
                  data-v-1d6c00b5=""
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  class="BaseIcon ml-[8px] cursor-pointer"
                  style="
                    width: 20px;
                    height: 20px;
                    opacity: 1;
                    fill: currentcolor;
                    --BaseIcon-color: #333333;
                  "
                >
                  <g clip-path="url(#clip0_124_2945)">
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M18.4697 4.46973L19.5303 5.53039L13.0597 11.9997L19.5303 18.4697L18.4697 19.5304L11.9997 13.0597L5.53033 19.5304L4.46967 18.4697L10.9397 11.9997L4.46967 5.53039L5.53033 4.46973L11.9997 10.9397L18.4697 4.46973Z"
                    ></path>
                  </g>
                  <defs>
                    <clipPath id="clip0_124_2945">
                      <rect width="24" height="24"></rect>
                    </clipPath>
                  </defs>
                </svg>
              </div>
            </div>
            <div data-v-1d6c00b5="" class="SelectedItem__tools">
              <div data-v-c2d3b141="" data-v-1d6c00b5="" class="Count">
                <div
                  data-v-c2d3b141=""
                  class="h-full border-r-[1px] border-[#f5f5f5]"
                >
                  <button
                    data-v-524f63ea=""
                    data-v-778c1d9b=""
                    data-v-c2d3b141=""
                    type="button"
                    class="CoreButton CoreButton--disabled BaseButtonIcon gray-f5--background"
                    style="
                      background-color: transparent;
                      height: 30px;
                      width: 30px;
                      flex-direction: column;
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
                        width: 20px;
                        height: 20px;
                        opacity: 1;
                        fill: currentcolor;
                        --BaseIcon-color: #333333;
                        margin-bottom: 0px;
                      "
                    >
                      <g clip-path="url(#clip0_124_2961)">
                        <path
                          fill-rule="evenodd"
                          clip-rule="evenodd"
                          d="M19 11.25V12.75H5V11.25H19Z"
                        ></path>
                      </g>
                      <defs>
                        <clipPath id="clip0_124_2961">
                          <rect width="24" height="24"></rect>
                        </clipPath>
                      </defs>
                    </svg>
                    <div data-v-524f63ea="" class="inline-flex items-center">
                      <!---->
                    </div>
                  </button>
                </div>
                <div
                  data-v-c2d3b141=""
                  class="h-full border-l-[1px] border-[#f5f5f5]"
                >
                  <button
                    data-v-524f63ea=""
                    data-v-778c1d9b=""
                    data-v-c2d3b141=""
                    type="button"
                    class="CoreButton BaseButtonIcon"
                    style="
                      background-color: transparent;
                      color: rgb(51, 51, 51);
                      height: 30px;
                      width: 30px;
                      flex-direction: column;
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
                        width: 20px;
                        height: 20px;
                        opacity: 1;
                        fill: currentcolor;
                        --BaseIcon-color: #333333;
                        margin-bottom: 0px;
                      "
                    >
                      <g clip-path="url(#clip0_124_2960)">
                        <path
                          fill-rule="evenodd"
                          clip-rule="evenodd"
                          d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"
                        ></path>
                      </g>
                      <defs>
                        <clipPath id="clip0_124_2960">
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
              <div data-v-1d6c00b5="">8,600원</div>
            </div>
          </div>
          <!--]-->
        </div>
      </div>
      <div>
        <div>
          <div class="my-[16px]">
            <!---->
            <div class="flex items-center justify-between">
              <div
                class="flex items-center whitespace-pre-line body2-regular-small"
              >
                <div
                  data-v-a1957620=""
                  class="BaseDecorateText transform-gpu whitespace-pre inline mr-[4px] last:mr-0"
                >
                  <span
                    data-v-a1957620=""
                    class="DecorateText"
                    style="
                      font-size: 12px;
                      color: rgb(102, 102, 102);
                      background-color: inherit;
                    "
                    >배송비</span
                  >
                </div>
                <div
                  data-v-a1957620=""
                  class="BaseDecorateText transform-gpu whitespace-pre inline mr-[4px] last:mr-0"
                >
                  <span data-v-a1957620="" class="DecorateText__badge"
                    ><!---->
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
              <div class="flex items-center ml-[10px]">
                <div
                  class="flex items-center body3_regular_small gray-666--text cursor-pointer"
                >
                  총 작품금액
                  <!---->
                </div>
                <!---->
                <div class="flex items-center headline5-bold-small ml-[6px]">
                  8,600<span class="subtitle2-regular-small">원</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="my-[16px]">
        <div
          class="flex items-center justify-center yellow-100--background py-[10px] rounded-[4px]"
        >
          <img
            class="w-[20px] h-[20px] mr-[4px]"
            src="data:image/svg+xml,%3csvg%20width='40'%20height='40'%20viewBox='0%200%2040%2040'%20fill='none'%20xmlns='http://www.w3.org/2000/svg'%3e%3cpath%20d='M6.9835%2036.5417C10.8502%2036.725%2014.5835%2036.5%2018.2335%2036.5L18.6502%2022.375H6.00016C5.67516%2027.7583%206.00016%2032.475%206.9835%2036.5417Z'%20fill='%23FAC1EC'/%3e%3cpath%20d='M20.8335%2022.3666V36.7332C25.7168%2036.9166%2030.1085%2036.8916%2033.5835%2036.2416C34.2418%2031.7166%2034.3835%2027.1749%2034.0252%2022.6249L20.8335%2022.3666Z'%20fill='%23FAC1EC'/%3e%3cpath%20d='M30.2419%2012.0667L20.9669%2011.9667L20.8252%2019.8917L35.4335%2019.6583C35.8752%2016.7417%2035.9085%2014.275%2035.5085%2011.9917L30.2419%2012.0667Z'%20fill='%23FF7014'/%3e%3cpath%20d='M4.7417%2011.9667C4.03337%2014.6083%204.03337%2017.25%204.7417%2019.8917H18.65V11.9667H4.7417Z'%20fill='%23FF7014'/%3e%3cpath%20d='M28.9502%203.16663L25.4918%204.94996L19.8085%207.94996L15.5918%205.68329L11.3585%203.16663L10.0835%2010.5H18.6502H20.9752L30.2418%2010.6083L28.9502%203.16663Z'%20fill='%238DC6FA'/%3e%3c/svg%3e"
          />
          <div class="body3-regular-small">
            장바구니에 담아 여러 작품을 한 번에 선물할 수 있어요!
          </div>
        </div>
      </div>
      <div>
        <div class="grid grid-cols-3 gap-x-[6px]">
            <router-link to="/">
                <button
                    type="outline"
                    class="CoreButton CoreButton--block BaseButtonRectangle subtitle2-bold-small BaseButtonRectangle__outline"
                    style="
                    background-color: #ffffff;
                    color: #333333;
                    height: 48px;
                    flex-direction: row;
                    --core-button-padding-x: 16;
                    --button-rectangle-border-color: #acacac;
                    "
                    data-v-524f63ea=""
                    data-v-7940d6dd=""
                >
                    <!----><!--[--><!---->
                    <div class="inline-flex items-center" data-v-524f63ea="">
                    <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
                        >장바구니</span
                    >
                    </div>
                    <!--]-->
                </button>
            </router-link>
            <router-link to="/">
                <button
                    type="outline"
                    class="CoreButton CoreButton--block BaseButtonRectangle subtitle2-bold-small BaseButtonRectangle__outline"
                    style="
                    background-color: #ffffff;
                    color: #333333;
                    height: 48px;
                    flex-direction: row;
                    --core-button-padding-x: 16;
                    --button-rectangle-border-color: #acacac;
                    "
                    data-v-524f63ea=""
                    data-v-7940d6dd=""
                >
                    <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    style="
                        width: 22px;
                        height: 22px;
                        opacity: 1;
                        fill: currentColor;
                        --BaseIcon-color: #333333;
                        margin-right: 2px;
                    "
                    class="BaseIcon CoreButton__icon"
                    data-v-6d2bd019=""
                    data-v-524f63ea=""
                    >
                    <g clip-path="url(#clip0_124_3027)">
                        <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M17.0903 2.97915C17.9899 3.73664 18.1933 4.61193 17.7906 5.55203L19 5.55286C20.1046 5.55286 21 6.44829 21 7.55286V8.55286C21 9.34413 20.5405 10.0281 19.8738 10.3524C19.9552 10.5694 20 10.8059 20 11.0529V18.5529C20 19.6574 19.1046 20.5529 18 20.5529H6C4.89543 20.5529 4 19.6574 4 18.5529V11.0529C4 10.8059 4.04476 10.5694 4.1266 10.351C3.45951 10.0281 3 9.34413 3 8.55286V7.55286C3 6.44829 3.89543 5.55286 5 5.55286L6.20314 5.55203C5.8004 4.61193 6.00382 3.73664 6.90343 2.97915C8.40719 1.71296 10.1209 2.56548 11.997 5.12144L12.1081 4.97152C13.9407 2.53253 15.6163 1.73805 17.0903 2.97915ZM11.25 10.552L6 10.5529C5.75454 10.5529 5.55039 10.7297 5.50806 10.963L5.5 11.0529V18.5529C5.5 18.7983 5.67688 19.0025 5.91012 19.0448L6 19.0529L11.25 19.052V10.552ZM18 10.5529L12.75 10.552V19.052L18 19.0529C18.2455 19.0529 18.4496 18.876 18.4919 18.6427L18.5 18.5529V11.0529C18.5 10.8074 18.3231 10.6032 18.0899 10.5609L18 10.5529ZM11.25 7.05202L5 7.05286C4.75454 7.05286 4.55039 7.22973 4.50806 7.46298L4.5 7.55286V8.55286C4.5 8.79832 4.67688 9.00246 4.91012 9.0448L5 9.05286L11.25 9.05202V7.05202ZM19 7.05286L12.75 7.05202V9.05202L19 9.05286C19.2455 9.05286 19.4496 8.87598 19.4919 8.64273L19.5 8.55286V7.55286C19.5 7.3074 19.3231 7.10325 19.0899 7.06091L19 7.05286ZM7.86958 4.12656C7.45012 4.47976 7.42073 4.92744 7.92265 5.55272L10.447 5.55202L10.3854 5.47395C9.23233 4.0322 8.40437 3.67626 7.86958 4.12656ZM13.5465 5.5519L16.0717 5.5519C16.573 4.92705 16.5434 4.4796 16.1242 4.12656C15.5799 3.66825 14.7319 4.04512 13.5465 5.5519Z"
                        ></path>
                    </g>
                    <defs>
                        <clipPath id="clip0_124_3027">
                        <rect width="24" height="24"></rect>
                        </clipPath>
                    </defs>
                    </svg>
                    <div class="inline-flex items-center" data-v-524f63ea="">
                    <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
                        >선물하기</span
                    >
                    </div>
                </button>
            </router-link>
            <button
                type="button"
                class="ButtonNPay border-green"
                size="xx_large"
                data-v-503e5502=""
            >
                <div
                class="BaseIconNPay"
                style="--icon-width: 58; --icon-height: 20"
                data-v-503e5502=""
                data-v-8179ca44=""
                >
                <div class="BaseIconNPay__icon" data-v-8179ca44=""></div>
                </div>
            </button>
        </div>
        <div class="mt-[5px]">
            <router-link to="/">
                <button
                    type="fill"
                    class="CoreButton CoreButton--block BaseButtonRectangle subtitle2-bold-small BaseButtonRectangle__fill"
                    style="
                    background-color: #ef7014;
                    color: #ffffff;
                    height: 48px;
                    flex-direction: row;
                    --core-button-padding-x: 16;
                    "
                    data-v-524f63ea=""
                    data-v-7940d6dd=""
                >
                    <!----><!--[--><!---->
                    <div class="inline-flex items-center" data-v-524f63ea="">
                    <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
                        >구매하기</span
                    >
                    </div>
                    <!--]-->
                </button>
            </router-link>
        </div>
      </div>
      <hr
        class="BaseDivider my-[8px]"
        style="--border-color: #f5f5f5"
        data-v-6ef4cf18=""
      />
      <div class="flex items-center">
        <button
          type="outline"
          class="CoreButton BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline"
          style="
            background-color: #ffffff;
            color: #ef7014;
            height: 40px;
            width: 189px;
            flex-direction: row;
            --core-button-padding-x: 16;
            --button-rectangle-border-color: #ef7014;
          "
          data-v-524f63ea=""
          data-v-7940d6dd=""
        >
          <!----><!--[--><svg
            width="24"
            height="24"
            viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg"
            style="
              width: 18px;
              height: 18px;
              opacity: 1;
              fill: currentColor;
              --BaseIcon-color: #333333;
              margin-right: 2px;
            "
            class="BaseIcon CoreButton__icon"
            data-v-6d2bd019=""
            data-v-524f63ea=""
          >
            <g clip-path="url(#clip0_124_2996)">
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M20 3.19995C21.0544 3.19995 21.9182 4.01583 21.9945 5.05069L22 5.19995V17.2C22 18.2543 21.1841 19.1181 20.1493 19.1945L20 19.2H6.20711C6.10102 19.2 5.99841 19.2337 5.9136 19.2952L5.85355 19.3464L2.85355 22.3464C2.75979 22.4402 2.63261 22.4928 2.5 22.4928C2.25454 22.4928 2.05039 22.316 2.00806 22.0827L2 21.9928V5.19995C2 4.14559 2.81588 3.28179 3.85074 3.20544L4 3.19995H20ZM7.5 9.94995C6.80964 9.94995 6.25 10.5096 6.25 11.2C6.25 11.8903 6.80964 12.45 7.5 12.45C8.19036 12.45 8.75 11.8903 8.75 11.2C8.75 10.5096 8.19036 9.94995 7.5 9.94995ZM12 9.94995C11.3096 9.94995 10.75 10.5096 10.75 11.2C10.75 11.8903 11.3096 12.45 12 12.45C12.6904 12.45 13.25 11.9456 13.25 11.2552C13.25 10.5649 12.6904 9.94995 12 9.94995ZM16.5 9.94995C15.8096 9.94995 15.25 10.5096 15.25 11.2C15.25 11.8903 15.8096 12.45 16.5 12.45C17.1904 12.45 17.75 11.8903 17.75 11.2C17.75 10.5096 17.1904 9.94995 16.5 9.94995Z"
              ></path>
            </g>
            <defs>
              <clipPath id="clip0_124_2996">
                <rect width="24" height="24"></rect>
              </clipPath>
            </defs>
          </svg>
          <div class="inline-flex items-center" data-v-524f63ea="">
            <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
              >작품문의</span
            >
          </div>
          <!--]-->
        </button>
        <div class="body2_regular_small ml-[16px] gray-666--text">
          작품 및 배송 관련 문의는 작품문의 버튼을 이용해주세요.
        </div>
      </div>
    </div>
    <div class="px-[10px] pb-[20px]">
      <div class="body1-regular-small pt-[20px] pb-[16px]">
        <div class="flex items-center h-[18px] cursor-pointer">
          <div class="min-w-[60px] gray-999--text">배송비</div>
          <div class="flex items-center justify-between w-full pl-[8px]">
            <div class="flex flex-wrap w-full">
              <!--[-->
              <div
                class="BaseDecorateText transform-gpu whitespace-pre inline"
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
                  >아이디어스는</span
                >
              </div>
              <div
                class="BaseDecorateText transform-gpu whitespace-pre inline"
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
                >
                  전 작품
                </span>
              </div>
              <div
                class="BaseDecorateText transform-gpu whitespace-pre inline"
                data-v-a1957620=""
              >
                <span class="DecorateText__badge" data-v-a1957620=""
                  ><!---->
                  <div
                    class="BaseBadgeFreeShipping"
                    style="--icon-width: 48; --icon-height: 18"
                    data-v-a1957620=""
                    data-v-c3bdd300=""
                  >
                    <div
                      class="BaseBadgeFreeShipping__icon"
                      data-v-c3bdd300=""
                    ></div></div
                ></span>
              </div>
              <!--]-->
            </div>
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
                --BaseIcon-color: #333333;
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
        </div>
        <div
          style="display: none"
          class="whitespace-pre-line body1-regular-medium gray-666--text gray-f5--background p-[16px] my-[16px] rounded-[12px]"
        >
          제주 / 도서산간 배송 시 추가 3,000원
        </div>
      </div>
      <div class="body1_regular_small pb-[16px]">
        <div class="flex items-center">
          <div class="w-[60px] gray-999--text">배송시작</div>
          <div class="flex items-center pl-[8px]">
            <div class="flex items-center">
              <span class="body1-bold-small navy-500--text">빠른배송</span
              ><span class="body3-regular-small ml-[6px] gray-999--text"
                >평균 1일 이내 배송시작 (예상87%)</span
              >
            </div>
          </div>
        </div>
        <div class="mt-[20px]">
          <div data-v-01eed007="" class="DeliveryRangeItem">
            <div data-v-01eed007="" class="w-[50px]">당일</div>
            <div data-v-01eed007="" class="DeliveryRangeItem__graph">
              <div
                data-v-e7e8311f=""
                data-v-01eed007=""
                class="Graph"
                style="--graph-color: #999999; --graph-active-width: 20"
              >
                <div data-v-e7e8311f="" class="Graph__range"></div>
              </div>
            </div>
            <div data-v-01eed007="" class="w-[40px] text-end">20%</div>
          </div>
          <div
            data-v-01eed007=""
            class="DeliveryRangeItem DeliveryRangeItem--active"
          >
            <div data-v-01eed007="" class="w-[50px]">1일</div>
            <div data-v-01eed007="" class="DeliveryRangeItem__graph">
              <div
                data-v-e7e8311f=""
                data-v-01eed007=""
                class="Graph"
                style="--graph-color: #ef7014; --graph-active-width: 67"
              >
                <div data-v-e7e8311f="" class="Graph__range"></div>
              </div>
            </div>
            <div data-v-01eed007="" class="w-[40px] text-end">67%</div>
          </div>
          <div data-v-01eed007="" class="DeliveryRangeItem">
            <div data-v-01eed007="" class="w-[50px]">2일</div>
            <div data-v-01eed007="" class="DeliveryRangeItem__graph">
              <div
                data-v-e7e8311f=""
                data-v-01eed007=""
                class="Graph"
                style="--graph-color: #999999; --graph-active-width: 12"
              >
                <div data-v-e7e8311f="" class="Graph__range"></div>
              </div>
            </div>
            <div data-v-01eed007="" class="w-[40px] text-end">12%</div>
          </div>
          <div data-v-01eed007="" class="DeliveryRangeItem">
            <div data-v-01eed007="" class="w-[50px]">3일</div>
            <div data-v-01eed007="" class="DeliveryRangeItem__graph">
              <div
                data-v-e7e8311f=""
                data-v-01eed007=""
                class="Graph"
                style="--graph-color: #999999; --graph-active-width: 1"
              >
                <div data-v-e7e8311f="" class="Graph__range"></div>
              </div>
            </div>
            <div data-v-01eed007="" class="w-[40px] text-end">1%</div>
          </div>
          <div data-v-01eed007="" class="DeliveryRangeItem">
            <div data-v-01eed007="" class="w-[50px]">4일 이상</div>
            <div data-v-01eed007="" class="DeliveryRangeItem__graph">
              <div
                data-v-e7e8311f=""
                data-v-01eed007=""
                class="Graph"
                style="--graph-color: #999999; --graph-active-width: 0"
              >
                <div data-v-e7e8311f="" class="Graph__range"></div>
              </div>
            </div>
            <div data-v-01eed007="" class="w-[40px] text-end">0%</div>
          </div>
          <ul
            class="list-disc ml-[20px] mt-[20px] mb-[30px] gray-999--text body3-regular-medium"
          >
            <li>최근 3개월 주문의 배송준비 기간 (주말, 공휴일 제외)</li>
            <li>
              배송 시작일은 영업일 기준으로 주말, 공휴일, 작가님, 택배사
              사정으로 예측치와 다를 수 있습니다.
            </li>
          </ul>
          <hr
            data-v-6ef4cf18=""
            class="BaseDivider"
            style="--border-color: #f5f5f5"
          />
        </div>
      </div>
    </div>
    <!----><!---->
    <div class="mt-[36px]">
      <div class="flex flex-col"><!--[--><!--]--></div>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";

export default {
    computed:{
        ...mapStores(useProductStore)
    },
    data(){
        return{
            selectedOptionIdx : "",
            isToggleOn : false,
        }
    },
    methods:{
        optionSelect(optionIdx, selectIdx){
            // this.productStore.product.options[optionIdx-1].selectedIdx = selectIdx;
            this.productStore.selectedIdx.set(optionIdx, selectIdx);
            if(this.productStore.selectedIdx.size===this.productStore.product.options.length){
                this.isToggleOn=false;
            }
            this.selectedOptionIdx++;
        },
        optionToggle(idx){
            if(this.selectedOptionIdx===idx){
                this.selectedOptionIdx="";
            }
            else{
                this.selectedOptionIdx = idx;
            }
        },
        toggleOnOff(){
            this.isToggleOn = !this.isToggleOn;
        }
    }
};
</script>

<style scoped>
.border-gray{
    border: rgb(225 225 225) 1px solid;
}
.text-left{
    text-align: left;
}
.toggle-off{
    display: none;
}
.toggle-on-background{
    background-color: #f5f5f5;
}
.border-green{
    border: #03c75a 1px solid;
}

</style>