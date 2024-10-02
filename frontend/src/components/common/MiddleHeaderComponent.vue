<template>
  <div
    class="DesktopHeaderSearchBar z-desktop-header white--background w-full flex items-center justify-center sticky top-0 z-[1500]"
    data-v-4e58ad83=""
    data-v-8659a67b=""
  >
    <div
      class="flex w-desktop justify-between h-full items-center white--background"
      data-v-8659a67b=""
    >
      <div class="flex h-full items-center" data-v-8659a67b="">
        <div
          class="flex items-center justify-center w-[88px] cursor-pointer mr-[16px]"
          data-v-8659a67b=""
        >
          <a
            aria-current="page"
            class="router-link-active router-link-exact-active"
            href="/"
            data-v-8659a67b=""
          >
            <div class="CgbLogo" data-v-e70698af="" data-v-8659a67b=""></div>
          </a>
        </div>

        <div class="h-full" data-v-8659a67b="">
          <div
            @click="categoryStore.openCategory()"
            class="flex w-[168px] px-[8px] mr-[10px] h-full items-center cursor-pointer"
            data-v-8659a67b=""
          >
            <svg
              width="24"
              height="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
              style="
                width: 14px;
                height: 14px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
              "
              class="BaseIcon"
              data-v-6d2bd019=""
              data-v-8659a67b=""
            >
              <g clip-path="url(#clip0_124_2966)">
                <path d="M3 6H21V4.5H3V6Z"></path>
                <path d="M21 12.75H3V11.25H21V12.75Z"></path>
                <path d="M21 19.5H3V18H21V19.5Z"></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2966">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <span
              class="body1-bold-small ml-[10px] text-[15px] gray-333--text"
              data-v-8659a67b=""
              >전체 카테고리
            </span>
          </div>
          <div
            style="display: none"
            class="w-screen white--background left-0 flex flex-col justify-center items-center absolute top-[74px] gray-d9--text border-current"
            data-v-8659a67b=""
          >
            <div class="w-desktop flex min-h-[440px] pt-[12px]">
              <div class="flex flex-col w-[220px]">
                <div
                  class="w-full h-[48px] flex flex-row items-center justify-between cursor-pointer gray-333--text rounded-[10px] black-500--text black-50--background"
                >
                  <div class="flex items-center body1-bold-small ml-[12px]">
                    식품
                  </div>
                  <svg
                    data-v-6d2bd019=""
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    class="BaseIcon mr-[13px]"
                    style="
                      width: 24px;
                      height: 24px;
                      opacity: 1;
                      fill: currentcolor;
                      --BaseIcon-color: #ffc6a0;
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
                <!-- 대분류 -->
                <div
                  class="w-full h-[48px] flex flex-row items-center justify-between cursor-pointer gray-333--text rounded-[10px]"
                >
                  <div class="flex items-center body1-bold-small ml-[12px]">
                    패션/주얼리
                  </div>
                  <!---->
                </div>
                <div
                  class="w-full h-[48px] flex flex-row items-center justify-between cursor-pointer gray-333--text rounded-[10px]"
                >
                  <div class="flex items-center body1-bold-small ml-[12px]">
                    홈리빙
                  </div>
                  <!---->
                </div>
              </div>
              <div class="white--background pl-[20px]">
                <div class="flex flex-wrap items-start w-[1059px]">
                  <a
                    class="flex items-center w-full subtitle3-bold-small ml-[10px] mt-[10px] mb-[12px] cursor-pointer gray-333--text hover:underline"
                  >
                    <div
                      data-v-24b1dfb3=""
                      class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight mr-[10px]"
                      style="
                        --BaseImage-width: 36;
                        --BaseImage-height: 36;
                        --BaseImage-radius: 18;
                      "
                    >
                      <div
                        data-v-24b1dfb3=""
                        class="BaseImage__image"
                        style="
                          background-image: url('https://image.idus.com/image/files/424920cc31b04460a0406bcd4429170d.png');
                        "
                      >
                        <img
                          data-v-24b1dfb3=""
                          src="https://image.idus.com/image/files/424920cc31b04460a0406bcd4429170d.png"
                          class="hidden"
                          loading="lazy"
                        />
                      </div>
                    </div>
                    식품관 바로가기
                    <svg
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
                  </a>
                  <div class="w-full grid grid-cols-5 auto-cols-max">
                    <!-- 디저트/음료 -->
                    <div class="flex flex-col w-[202px] w-full">
                      <span
                        class="w-full shrink-0 p-[10px] flex items-center gray-ac--text caption1-bold-small"
                        >디저트/음료</span
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >전체</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >디저트/베이커리</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >떡/전통간식</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >초콜릿/사탕</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >음료/커피/차</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >전통주</a
                      >
                    </div>
                    <!-- 수제 먹거리 -->
                    <div class="flex flex-col w-[202px] w-full">
                      <span
                        class="w-full shrink-0 p-[10px] flex items-center gray-ac--text caption1-bold-small"
                        >수제먹거리</span
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >전체</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >건강식품</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >간편식/요리</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >식사대용</a
                      ><a
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >가공식품</a
                      ><a
                        href="/v2/category/1077"
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >김치</a
                      ><a
                        href="/v2/category/1078"
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >반찬</a
                      ><a
                        href="/v2/category/1079"
                        class="w-full px-[12px] py-[8px] flex items-center gray-333--text body1-regular-small cursor-pointer shrink-0 hover:underline"
                        >소스/장류</a
                      >
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="border-b border-current gray-f5--text w-screen h-[1px]"
            ></div>
          </div>
        </div>
        <HeaderCategoriesComponent />
        <div data-v-8659a67b="" data-v-8a32ee7e="">
          <!--[-->
          <div class="DesktopHeaderSearchInput" data-v-8a32ee7e="">
            <div
              class="BaseTextField__container DesktopHeaderSearchInput__input"
              data-v-6d6ea1ac=""
              data-v-8a32ee7e=""
            >
              <div
                class="BaseLabelText"
                style="display: none"
                data-v-e2593c18=""
                data-v-6d6ea1ac=""
              >
                <span class="BaseLabelText__text" data-v-e2593c18=""></span
                ><!---->
              </div>
              <label
                class="BaseTextField BaseTextField--medium BaseTextField--outlined"
                data-v-6d6ea1ac=""
                ><!----><input
                  value=""
                  type="text"
                  class="BaseTextField__input BaseTextField__input--left"
                  placeholder="상품을 검색해보세요!"
                  data-v-6d6ea1ac=""
                  v-model="searchKeyword"
                  @keyup.enter="search"
                /><!----><button
                  type="button"
                  class="CoreButton BaseButtonIcon ml-[8px]"
                  style="
                    background-color: transparent;
                    color: #666666;
                    height: 20px;
                    flex-direction: column;
                  "
                  data-v-524f63ea=""
                  data-v-778c1d9b=""
                  data-v-6d6ea1ac=""
                  @click="search"
                >
                  <!----><!--[--><svg
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
                      margin-bottom: 0px;
                    "
                    class="BaseIcon CoreButton__icon"
                    data-v-6d2bd019=""
                    data-v-524f63ea=""
                  >
                    <g clip-path="url(#clip0_124_2969)">
                      <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M10.86 2.60999C15.4163 2.60999 19.11 6.30364 19.11 10.86C19.11 12.8679 18.3927 14.7082 17.2004 16.1388L21.3903 20.3297L20.3297 21.3903L16.1388 17.2004C14.7082 18.3927 12.8679 19.11 10.86 19.11C6.30364 19.11 2.60999 15.4163 2.60999 10.86C2.60999 6.30364 6.30364 2.60999 10.86 2.60999ZM10.86 4.10999C7.13206 4.10999 4.10999 7.13206 4.10999 10.86C4.10999 14.5879 7.13206 17.61 10.86 17.61C14.5879 17.61 17.61 14.5879 17.61 10.86C17.61 7.13206 14.5879 4.10999 10.86 4.10999Z"
                      ></path>
                    </g>
                    <defs>
                      <clipPath id="clip0_124_2969">
                        <rect width="24" height="24"></rect>
                      </clipPath>
                    </defs>
                  </svg>
                  <div class="inline-flex items-center" data-v-524f63ea="">
                    <!--[--><!--]--><!---->
                  </div>
                  <!--]-->
                </button></label
              ><!---->
            </div>
            <div
              class="HeaderAutoComplete DesktopHeaderSearchInput__autoComplete"
              style="display: none"
              data-v-8a32ee7e=""
              data-v-c791091c=""
            >
              <!--[--><!--]-->
            </div>
          </div>
          <!--]-->
        </div>
        <div
          data-v-ef695987=""
          data-v-8659a67b=""
          class="flex items-center relative ml-[12px] pl-[16px]"
        >
          <div data-v-ef695987="" class="flex">
            <div
              data-v-8a88ccd0=""
              data-v-ef695987=""
              class="flex justify-between items-center cursor-pointer HeaderKeywordItem--medium flex w-full"
            >
              <span
                data-v-8a88ccd0=""
                class="flex items-center px-[4px] py-[13px]"
              >
                <span
                  data-v-8a88ccd0=""
                  class="w-[20px] min-w-[20px] body1-bold-small gray-999--text"
                  >15
                </span>
                <span
                  data-v-8a88ccd0=""
                  class="HeaderKeywordItem--medium__keyword flex black--text gray-333--text mx-[6px] line-clamp-1 flex-1"
                  >생일선물</span
                >
              </span>
            </div>
            <div
              data-v-ef695987=""
              class="shadow-[0_2px_4px_0_#d9d9d9] flex flex-col items-center bg-white py-[16px] px-[10px] DesktopHeaderKeywordRank__layer"
              style="display: none"
            >
              <div
                data-v-de0565e1=""
                class="BaseTabs BaseTabs__size--small BaseTabs__style--filled BaseTabs--width BaseTabs__border--bottom"
                style="--BaseTabs-item-length: 2; --BaseTabs-margin-x: 0"
              >
                <div data-v-de0565e1="" class="BaseTabs__inner" role="tablist">
                  <div
                    data-v-47c662bd=""
                    data-v-de0565e1=""
                    class="BaseTab"
                    role="tab"
                    border-top="false"
                    border-bottom="true"
                    style="--BaseTab-width: 149"
                  >
                    <div data-v-47c662bd="" class="BaseTab__contents">
                      <div data-v-47c662bd="" class="BaseTab__prefix"></div>
                      <div
                        data-v-9dbc8be1=""
                        data-v-47c662bd=""
                        class="BaseFontVariable"
                      >
                        <div data-v-9dbc8be1="" class="BaseFontVariable__text">
                          <span
                            data-v-9dbc8be1=""
                            class="BaseFontVariable__text--hidden"
                            >실시간 급상승</span
                          ><span
                            data-v-9dbc8be1=""
                            class="BaseFontVariable__text--display"
                            >실시간 급상승</span
                          >
                        </div>
                        <span
                          data-v-9dbc8be1=""
                          class="flex-auto inline-flex items-center"
                        ></span>
                      </div>
                    </div>
                    <div data-v-47c662bd="" class="BaseTab__empty"></div>
                    <div data-v-47c662bd="" class="BaseTab__activator"></div>
                  </div>
                  <div
                    data-v-47c662bd=""
                    data-v-de0565e1=""
                    class="BaseTab BaseTab--active"
                    role="tab"
                    border-top="false"
                    border-bottom="true"
                    style="--BaseTab-width: 149"
                  >
                    <div data-v-47c662bd="" class="BaseTab__contents">
                      <div data-v-47c662bd="" class="BaseTab__prefix"></div>
                      <div
                        data-v-9dbc8be1=""
                        data-v-47c662bd=""
                        class="BaseFontVariable"
                      >
                        <div data-v-9dbc8be1="" class="BaseFontVariable__text">
                          <span
                            data-v-9dbc8be1=""
                            class="BaseFontVariable__text--hidden"
                            >인기 검색어</span
                          ><span
                            data-v-9dbc8be1=""
                            class="BaseFontVariable__text--display"
                            >인기 검색어</span
                          >
                        </div>
                        <span
                          data-v-9dbc8be1=""
                          class="flex-auto inline-flex items-center"
                        ></span>
                      </div>
                    </div>
                    <div data-v-47c662bd="" class="BaseTab__empty"></div>
                    <div data-v-47c662bd="" class="BaseTab__activator"></div>
                  </div>
                </div>
                <!---->
              </div>
              <div data-v-62649463="" class="grid grid-cols-2 pt-[10px]">
                <div
                  data-v-8a88ccd0=""
                  data-v-62649463=""
                  class="flex justify-between items-center cursor-pointer HeaderKeywordItem--small px-[12px] w-[149px] h-[34px] overflow-hidden DesktopHeaderKeywordRankList__item"
                >
                  <span
                    data-v-8a88ccd0=""
                    class="flex items-center px-[4px] py-[13px]"
                    ><span
                      data-v-8a88ccd0=""
                      class="w-[20px] min-w-[20px] body1-bold-small gray-999--text"
                      >1</span
                    ><span
                      data-v-8a88ccd0=""
                      class="HeaderKeywordItem--small__keyword flex black--text gray-333--text mx-[6px] line-clamp-1 flex-1"
                      >추석선물</span
                    ></span
                  >
                </div>
                <div
                  data-v-8a88ccd0=""
                  data-v-62649463=""
                  class="flex justify-between items-center cursor-pointer HeaderKeywordItem--small px-[12px] w-[149px] h-[34px] overflow-hidden DesktopHeaderKeywordRankList__item"
                >
                  <span
                    data-v-8a88ccd0=""
                    class="flex items-center px-[4px] py-[13px]"
                    ><span
                      data-v-8a88ccd0=""
                      class="w-[20px] min-w-[20px] body1-bold-small gray-999--text"
                      >2</span
                    ><span
                      data-v-8a88ccd0=""
                      class="HeaderKeywordItem--small__keyword flex black--text gray-333--text mx-[6px] line-clamp-1 flex-1"
                      >두바이초콜릿</span
                    ></span
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="flex" data-v-8659a67b="">
        <div
          class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__colorType--white IDSTooltip__innerPosition--bottom IDSTooltip__innerAlign--center IDSTooltip__innerCloseAlign--start ml-[20px]"
          style="--ids-tooltip-width: 327px; --ids-tooltip-full-left: --8px"
          data-v-8659a67b=""
          data-v-b6faa6c8=""
        >
          <div class="IDSTooltip__trigger" data-v-b6faa6c8="">
            <!------------------관심버튼--------------------->

            <div class="BaseBadgeNotification__wrapper" data-v-cdfdef93="">
              <router-link
                to="/mypage/favorite/likes"
                type="button"
                class="CoreButton BaseButtonIcon caption1-regular-small rounded-[2px]"
                style="
                  background-color: transparent;
                  color: #333333;
                  height: 67px;
                  width: 60px;
                  flex-direction: column;
                "
                data-v-524f63ea=""
                data-v-778c1d9b=""
              >
                <svg
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
                  <span class="CoreButton__text" data-v-524f63ea="">관심</span>
                </div>
              </router-link>
              <div
                data-v-cdfdef93=""
                class="BaseBadgeNotification caption1-regular-small white--text black-500--background BaseBadgeNotification--small BaseBadgeNotification__icon"
                style="padding: 0px; position: absolute; top: 9px; right: 9px"
              >
                <span data-v-cdfdef93=""
                  ><svg
                    data-v-6d2bd019=""
                    data-v-cdfdef93=""
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                    class="BaseIcon"
                    style="
                      width: 8px;
                      height: 8px;
                      opacity: 1;
                      fill: currentcolor;
                      --BaseIcon-color: white;
                    "
                  >
                    <path
                      d="M16.616 3V13.968L7.256 3H5V20.736H8.504V9.864L17.696 20.736H20.12V3H16.616Z"
                    ></path>
                  </svg>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div data-v-8659a67b="" class="ml-[8px]">
          <router-link
            to="/mypage"
            data-v-524f63ea=""
            data-v-778c1d9b=""
            type="button"
            class="CoreButton BaseButtonIcon caption1-regular-small rounded-[2px]"
            style="
              background-color: transparent;
              color: rgb(51, 51, 51);
              height: 67px;
              width: 60px;
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
                width: 28px;
                height: 28px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-bottom: 2px;
              "
            >
              <g clip-path="url(#clip0_124_3001)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M12.0005 3C16.6498 3 17.8077 8.99775 13.6839 12.1844L13.624 12.228L15.3069 12.9465L15.6812 13.1108L15.9549 13.2351C19.6238 14.9538 21.6364 17.3136 21.7453 20.7061L21.75 21H20.25C20.25 18.1476 18.6226 16.1412 15.3186 14.5935L15.0135 14.4555L13.8716 13.9629L12.0964 13.2063L11.999 13.163L11.0507 13.5711L9.68313 14.153L8.98 14.4583L8.68065 14.5937C5.48037 16.0931 3.85333 18.0382 3.75477 20.7358L3.75 21H2.25C2.25 17.5338 4.16036 15.1255 7.73389 13.3837L8.16278 13.1808L8.82559 12.8889L10.374 12.228L10.3151 12.1843C6.2556 9.04586 7.31828 3.1811 11.7916 3.0041L12.0005 3ZM12.0005 4.5C8.83703 4.5 8.08966 8.88445 11.545 11.2237C11.6271 11.2791 11.7177 11.3355 11.8177 11.3932L12 11.494L12.0242 11.481C12.1338 11.4217 12.2336 11.3641 12.3244 11.3077L12.4539 11.2238C15.9112 8.88428 15.1647 4.5 12.0005 4.5Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_3001">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div data-v-524f63ea="" class="inline-flex items-center">
              <span data-v-524f63ea="" class="CoreButton__text">내 정보</span>
            </div>
          </router-link>
          <div class="w-[60px]">
            <div
              data-v-b6faa6c8=""
              class="IDSTooltip__wrapper IDSTooltip__display--hide IDSTooltip__display--close IDSTooltip__colorType--yellow IDSTooltip__display--blocked IDSTooltip__innerPosition--bottom IDSTooltip__innerAlign--center IDSTooltip__innerCloseAlign--center"
              style="
                --ids-tooltip-width: 200px;
                --ids-tooltip-full-left: --8px;
                --ids-tooltip-offset-y: -12px;
              "
            >
              <div data-v-b6faa6c8="" class="IDSTooltip__trigger"></div>
            </div>
          </div>
        </div>
        <div
          class="BaseBadgeNotification__wrapper ml-[8px]"
          data-v-8659a67b=""
          data-v-cdfdef93=""
        >
          <!--[-->
          <router-link
            to="/cart"
            type="button"
            class="CoreButton BaseButtonIcon caption1-regular-small rounded-[2px]"
            style="
              background-color: transparent;
              color: #333333;
              height: 67px;
              width: 60px;
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
              <g clip-path="url(#clip0_124_2976)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M7.5 17C8.88071 17 10 18.1193 10 19.5C10 20.8807 8.88071 22 7.5 22C6.11929 22 5 20.8807 5 19.5C5 18.1193 6.11929 17 7.5 17ZM16.5 17C17.8807 17 19 18.1193 19 19.5C19 20.8807 17.8807 22 16.5 22C15.1193 22 14 20.8807 14 19.5C14 18.1193 15.1193 17 16.5 17ZM7.5 18.5C6.94772 18.5 6.5 18.9477 6.5 19.5C6.5 20.0523 6.94772 20.5 7.5 20.5C8.05228 20.5 8.5 20.0523 8.5 19.5C8.5 18.9477 8.05228 18.5 7.5 18.5ZM16.5 18.5C15.9477 18.5 15.5 18.9477 15.5 19.5C15.5 20.0523 15.9477 20.5 16.5 20.5C17.0523 20.5 17.5 20.0523 17.5 19.5C17.5 18.9477 17.0523 18.5 16.5 18.5ZM3.57994 2.25C3.9013 2.25 4.18255 2.45389 4.28705 2.74983L4.31514 2.85173L4.799 5.25H18.7534C19.6716 5.25 20.4246 5.95711 20.4976 6.85647L20.5034 7C20.5034 7.08512 20.4972 7.17007 20.4848 7.25418L20.4617 7.37963L18.9062 14.3796C18.7393 15.1303 18.1047 15.6779 17.3502 15.7434L17.1978 15.75H6.81846C6.0374 15.75 5.35786 15.2338 5.14025 14.4963L5.103 14.346L2.965 3.75H1V2.25H3.57994ZM18.7534 6.75H5.101L6.5734 14.0494C6.593 14.1466 6.66746 14.2211 6.76062 14.2432L6.81846 14.25H17.1978C17.2916 14.25 17.3752 14.1979 17.418 14.1185L17.4419 14.0542L18.9974 7.05423L19.0034 7C19.0034 6.88165 18.9212 6.78251 18.8107 6.7566L18.7534 6.75Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2976">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div class="inline-flex items-center" data-v-524f63ea="">
              <!--[--><!--]--><span class="CoreButton__text" data-v-524f63ea=""
                >장바구니</span
              >
            </div>
            <!--]--> </router-link
          ><!--]-->
          <div
            data-v-cdfdef93=""
            class="BaseBadgeNotification caption1-regular-small white--text black-500--background BaseBadgeNotification--small"
            style="padding: 0px 4px; position: absolute; top: 8px; right: 8px"
          >
            <span data-v-cdfdef93="">{{
              memberStore.member.productsInCartCount
            }}</span>
          </div>
        </div>
      </div>
    </div>
    <!---->
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";
import { useCategoryStore } from "@/stores/useCategoryStore";
import HeaderCategoriesComponent from "./HeaderCategoriesComponent.vue";
// import { useRouter } from "vue-router";

export default {
  data() {
    return {
      isLogined: false,
      upHere: false,
      isCategoryOpen: false,
      searchKeyword: "",
    };
  },
  components: {
    HeaderCategoriesComponent,
  },
  methods: {
    async logout() {
      const response = await this.memberStore.logout();
      if (response === true) {
        alert("로그아웃이 완료되었습니다.");
        window.location.href = "/"; // 로그인 페이지 메인페이지 리다이렉트
      } else {
        alert("에러 발생");
      }
    },
    async search() {
      //상품 페이지로 이동
      this.$router.push(`/search/${this.searchKeyword}`);
      this.searchKeyword = "";
    },

    // openCategory() {
    //   this.isCategoryOpen = true;
    // },

    // closeCategory() {
    //   this.isCategoryOpen = false;
    // },

    toggleCategory() {
      this.isCategoryOpen = !this.isCategoryOpen;
    },
  },
  computed: {
    ...mapStores(useMemberStore),
    ...mapStores(useCategoryStore),
  },
};
</script>

<style scoped>
.CgbLogo {
  background-image: url("https://github.com/user-attachments/assets/2ce021dd-af1a-4277-abdd-6ba502aea81c");
  background-size: contain; /* 이미지 크기 조절 */
  background-repeat: no-repeat; /* 이미지 반복 방지 */
  background-position: center; /* 이미지 가운데 정렬 */
  width: 100px; /* 원하는 너비 설정 */
  height: 120px; /* 원하는 높이 설정 */
}
</style>