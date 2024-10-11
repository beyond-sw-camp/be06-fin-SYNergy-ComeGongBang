<template>
  <body>
    <div id="__nuxt">
      <div
        class="appContainer"
        style="--container-width: 1040px; --app-bar-height: 0px"
      >
        <div data-v-26a5ae18="" class="TheContainer">
          <div class="appContents">
            <div>
              <div class="grid-cols-12 gap-[8px] grid">
                <div class="col-start-4 col-span-6">
                  <!---->
                  <div class="pb-[48px]">
                    <div
                      data-v-41ff64ed=""
                      class="grid-cols-1 gap-[0px] grid Login"
                    >
                      <div
                        data-v-e70698af=""
                        data-v-41ff64ed=""
                        class="cgbLogo flex justify-self-center mt-[20px] mb-[8px] cursor-pointer"
                        style="height: 70px"
                      ></div>
                      <!-- 로고 -->
                      <div
                        data-v-41ff64ed=""
                        tag="div"
                        class="mb-[32px] text-center subtitle3-regular-medium"
                      >
                        <span
                          data-v-41ff64ed=""
                          class="Login__description px-[4px] subtitle3-bold-medium"
                          ><span
                            data-v-41ff64ed=""
                            class="Login__descriptionText"
                            >로그인</span
                          ></span
                        ><span data-v-41ff64ed="">이 필요한 서비스입니다.</span>
                      </div>
                      <div
                        data-v-343d1a74=""
                        data-v-41ff64ed=""
                        class="BaseTextSideBar mb-[12px]"
                      >
                        <div
                          data-v-343d1a74=""
                          class="BaseTextSideBar__contents"
                        >
                          <div
                            data-v-343d1a74=""
                            class="BaseTextSideBar__text body1-regular-medium text-center"
                          >
                            간편 로그인/회원가입
                          </div>
                        </div>
                      </div>
                      <button
                        @click="moveKakaoLogin"
                        data-v-524f63ea=""
                        data-v-7940d6dd=""
                        data-v-9f9341b7=""
                        data-v-41ff64ed=""
                        type="fill"
                        class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill ButtonKakao kakao--background mb-[12px]"
                        style="
                          background-color: rgb(57, 57, 57);
                          color: rgb(255, 255, 255);
                          height: 44px;
                          flex-direction: row;
                          --core-button-padding-x: 16;
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
                            margin-right: 2px;
                          "
                        >
                          <path
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M11.9994 3C7.01269 3 2.47021 6.33498 2.47021 10.4488C2.47021 13.0065 4.11991 15.2631 6.63257 16.6038L5.5753 20.5113C5.48212 20.8578 5.87231 21.1324 6.17249 20.9324L10.8066 17.8374C11.1978 17.8757 11.5954 17.8976 11.9994 17.8976C17.2629 17.8976 21.529 14.5626 21.529 10.4488C21.529 6.33498 17.2629 3 11.9994 3Z"
                          ></path>
                        </svg>
                        <div
                          data-v-524f63ea=""
                          class="inline-flex items-center"
                        >
                          <span data-v-524f63ea="" class="CoreButton__text"
                            >카카오 3초만에 시작하기</span
                          >
                        </div>
                      </button>

                      <!-- 이메일 회원가입 -->
                      <div>
                        <router-link
                          to="signup"
                          data-v-524f63ea=""
                          data-v-7940d6dd=""
                          data-v-41ff64ed=""
                          type="outline"
                          class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline"
                          style="
                            background-color: rgb(255, 255, 255);
                            color: rgb(51, 51, 51);
                            height: 44px;
                            flex-direction: row;
                            --core-button-padding-x: 16;
                            --button-rectangle-border-color: #acacac;
                          "
                        >
                          <!---->
                          <!---->
                          <div
                            data-v-524f63ea=""
                            class="inline-flex items-center"
                          >
                            <span data-v-524f63ea="" class="CoreButton__text"
                              >이메일로 가입하기</span
                            >
                          </div>
                        </router-link>
                      </div>

                      <!-- 소셜 로그인 -->
                      <div
                        data-v-41ff64ed=""
                        class="mt-[20px] mb-[40px] flex justify-center"
                      >
                        <!--                                              <div data-v-5da5863c="" data-v-41ff64ed="" class="BaseIconMemberType BaseIconMemberType__type&#45;&#45;naver mr-[12px] cursor-pointer" style="height: 48px; width: 48px;"><svg data-v-6d2bd019="" data-v-5da5863c="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon" style="width: 32px; height: 32px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #ffffff;">-->
                        <!--                                                      <path d="M14.8562 12.56L8.91901 4H4V20H9.15702V11.44L15.081 20H20V4H14.8562V12.56Z"></path>-->
                        <!--                                                  </svg></div>-->
                        <!--                                              <div data-v-5da5863c="" data-v-41ff64ed="" class="BaseIconMemberType BaseIconMemberType__type&#45;&#45;facebook mr-[12px] cursor-pointer" style="height: 48px; width: 48px;"><svg data-v-6d2bd019="" data-v-5da5863c="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon" style="width: 32px; height: 32px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #ffffff;">-->
                        <!--                                                      <path d="M16.7529 13.1666L17.3188 9.57811H13.7749V7.24765C13.7749 6.26525 14.2792 5.29922 15.862 5.29922H17.4589V2.26197C17.4589 2.26197 16.0105 2 14.6154 2C11.7046 2 9.81077 3.72738 9.81077 6.84104V9.57811H6.5498V13.1666H9.81077V21.8499C10.4551 21.9481 11.1191 22 11.7942 22C12.4694 22 13.1306 21.9481 13.7777 21.8499V13.1666H16.7529Z">-->
                        <!--                                                      </path>-->
                        <!--                                                  </svg></div>-->
                        <!--                                              <div data-v-5da5863c="" data-v-41ff64ed="" class="BaseIconMemberType BaseIconMemberType__type&#45;&#45;twitter mr-[12px] cursor-pointer" style="height: 48px; width: 48px;"><svg data-v-6d2bd019="" data-v-5da5863c="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon" style="width: 32px; height: 32px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #ffffff;">-->
                        <!--                                                      <path d="M20.9525 8.04571C20.9647 8.22203 20.9647 8.39834 20.9647 8.57628C20.9647 13.9982 16.8371 20.2513 9.28966 20.2513V20.248C7.06013 20.2513 4.8769 19.6126 3 18.4085C3.32419 18.4475 3.65001 18.467 3.97664 18.4678C5.82429 18.4694 7.61913 17.8495 9.07272 16.7079C7.31688 16.6746 5.77717 15.5298 5.23928 13.8584C5.85436 13.9771 6.48812 13.9527 7.09181 13.7877C5.17753 13.401 3.80033 11.7191 3.80033 9.7658C3.80033 9.74793 3.80033 9.73087 3.80033 9.7138C4.37071 10.0315 5.00934 10.2078 5.6626 10.2273C3.85964 9.02235 3.30388 6.62382 4.39265 4.74854C6.47593 7.31202 9.54966 8.87041 12.8493 9.03535C12.5186 7.61021 12.9703 6.11681 14.0364 5.11498C15.689 3.56146 18.2882 3.64108 19.8418 5.29292C20.7607 5.11173 21.6415 4.77454 22.4475 4.29678C22.1412 5.24661 21.5001 6.05343 20.6437 6.56613C21.457 6.47025 22.2517 6.2525 23 5.92018C22.4491 6.74569 21.7552 7.46477 20.9525 8.04571Z">-->
                        <!--                                                      </path>-->
                        <!--                                                  </svg></div>-->
                        <!--                                              <div data-v-5da5863c="" data-v-41ff64ed="" class="BaseIconMemberType BaseIconMemberType__type&#45;&#45;apple BaseIconMemberType__style&#45;&#45;reverse cursor-pointer" style="height: 48px; width: 48px;"><svg data-v-6d2bd019="" data-v-5da5863c="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon" style="width: 32px; height: 32px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #000000;">-->
                        <!--                                                      <path d="M20.2228 16.5779C19.8997 17.3211 19.5171 18.0052 19.0739 18.6342C18.4698 19.4917 17.9752 20.0852 17.5939 20.4148C17.003 20.9558 16.3698 21.2328 15.6918 21.2486C15.2051 21.2486 14.6181 21.1107 13.9348 20.831C13.2493 20.5526 12.6193 20.4148 12.0433 20.4148C11.4392 20.4148 10.7912 20.5526 10.0982 20.831C9.40411 21.1107 8.84496 21.2565 8.41745 21.2709C7.76728 21.2985 7.11922 21.0135 6.47235 20.4148C6.05949 20.0563 5.54307 19.4418 4.92443 18.5712C4.26067 17.6415 3.71497 16.5635 3.28746 15.3344C2.82962 14.0069 2.6001 12.7214 2.6001 11.4768C2.6001 10.0512 2.90955 8.82161 3.52938 7.79123C4.01651 6.96359 4.66457 6.31072 5.47567 5.83144C6.28676 5.35216 7.16315 5.10793 8.10694 5.0923C8.62336 5.0923 9.30057 5.25132 10.1421 5.56383C10.9813 5.8774 11.5202 6.03642 11.7564 6.03642C11.933 6.03642 12.5316 5.85048 13.5464 5.4798C14.506 5.13603 15.3159 4.99369 15.9794 5.04976C17.7773 5.1942 19.128 5.89972 20.0263 7.17079C18.4184 8.14064 17.623 9.49904 17.6388 11.2416C17.6533 12.599 18.148 13.7285 19.1201 14.6253C19.5607 15.0416 20.0527 15.3633 20.6001 15.5918C20.4814 15.9345 20.3561 16.2628 20.2228 16.5779ZM16.0994 0.425576C16.0994 1.48945 15.709 2.4828 14.9307 3.40222C13.9916 4.49524 12.8556 5.12684 11.6237 5.02717C11.608 4.89954 11.5989 4.76521 11.5989 4.62405C11.5989 3.60273 12.0455 2.50971 12.8387 1.61602C13.2347 1.16353 13.7383 0.787293 14.349 0.487159C14.9584 0.191503 15.5349 0.0279994 16.077 0C16.0928 0.142224 16.0994 0.284457 16.0994 0.425562V0.425576Z">-->
                        <!--                                                      </path>-->
                        <!--                                                  </svg></div>-->
                      </div>
                      <div
                        data-v-343d1a74=""
                        data-v-41ff64ed=""
                        class="BaseTextSideBar mb-[16px]"
                      >
                        <div
                          data-v-343d1a74=""
                          class="BaseTextSideBar__contents"
                        >
                          <div
                            data-v-343d1a74=""
                            class="BaseTextSideBar__text body1-regular-medium text-center"
                          >
                            이메일 로그인
                          </div>
                        </div>
                      </div>
                      <div data-v-2b3ae965="" class="mb-[16px]">
                        <div data-v-2b3ae965="">
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
                              ></span>
                              <!---->
                            </div>
                            <input
                              data-v-6d6ea1ac=""
                              type="text"
                              class="BaseTextField__hiddenInput"
                              tabindex="-1"
                            />
                            <!-- 이메일 작성 -->
                            <label
                              data-v-6d6ea1ac=""
                              :class="
                                emailValid === true
                                  ? 'BaseTextField BaseTextField--large'
                                  : 'BaseTextField BaseTextField--large BaseTextField--error'
                              "
                            >
                              <input
                                v-model="member.email"
                                @input="validateEmail"
                                data-v-6d6ea1ac=""
                                id="email"
                                name="email"
                                type="text"
                                class="BaseTextField__input BaseTextField__input--left"
                                placeholder="이메일"
                              />
                              <button
                                data-v-524f63ea=""
                                data-v-778c1d9b=""
                                data-v-6d6ea1ac=""
                                type="button"
                                class="CoreButton BaseButtonIcon BaseTextField__clearIcon"
                                style="
                                  background-color: transparent;
                                  color: rgb(172, 172, 172);
                                  height: 24px;
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
                                    width: 24px;
                                    height: 24px;
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
                                </div>
                              </button>
                            </label>
                          </div>
                        </div>
                        <!-- 닉네임 확인 검증 안내 메시지-->
                        <div
                          v-if="!emailValid"
                          data-v-6d6ea1ac=""
                          class="BaseTextField__assistiveArea"
                        >
                          <div
                            data-v-86c06fc2=""
                            data-v-6d6ea1ac=""
                            class="BaseTextHelper BaseTextHelper--error"
                          >
                            <!---->
                            <div
                              data-v-86c06fc2=""
                              class="inline-flex items-center"
                            >
                              유효하지 않은 이메일입니다.
                            </div>
                          </div>
                          <!---->
                        </div>
                      </div>

                      <div data-v-2b3ae965="" class="mb-[8px]">
                        <div data-v-056d7ed4="" data-v-2b3ae965="">
                          <div
                            data-v-1d2c5c78=""
                            data-v-056d7ed4=""
                            class="BaseTextFieldPassword"
                          >
                            <div
                              data-v-6d6ea1ac=""
                              data-v-1d2c5c78=""
                              class="BaseTextField__container"
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
                                ></span>
                                <!---->
                              </div>
                              <input
                                data-v-6d6ea1ac=""
                                type="text"
                                class="BaseTextField__hiddenInput"
                                tabindex="-1"
                              />
                              <label
                                data-v-6d6ea1ac=""
                                :class="
                                  passwordValid === true
                                    ? 'BaseTextField BaseTextField--large'
                                    : 'BaseTextField BaseTextField--large BaseTextField--error'
                                "
                              >
                                <!-- 비밀번호 입력 -->
                                <input
                                  v-model="member.password"
                                  @input="emptyPassword"
                                  data-v-6d6ea1ac=""
                                  id="password"
                                  name="password"
                                  :type="showPassword ? 'text' : 'password'"
                                  class="BaseTextField__input BaseTextField__input--left"
                                  placeholder="비밀번호 (영문+숫자 8자 이상)"
                                  autocomplete="new-password"
                                />
                                <!-- hidden 상태 -->
                                <button
                                  v-if="!showPassword"
                                  @click="clickShowPassword"
                                  data-v-524f63ea=""
                                  data-v-778c1d9b=""
                                  data-v-6d6ea1ac=""
                                  type="button"
                                  class="CoreButton BaseButtonIcon ml-[8px]"
                                  style="
                                    background-color: transparent;
                                    color: rgb(102, 102, 102);
                                    height: 24px;
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
                                      width: 24px;
                                      height: 24px;
                                      opacity: 1;
                                      fill: currentcolor;
                                      --BaseIcon-color: #333333;
                                      margin-bottom: 0px;
                                    "
                                  >
                                    <g clip-path="url(#clip0_124_2987)">
                                      <path
                                        fill-rule="evenodd"
                                        clip-rule="evenodd"
                                        d="M20.4697 21.5303L16.6629 17.7228C15.186 18.3486 13.5768 18.7499 12 18.7499C6.80076 18.7499 1.25 14.3882 1.25 11.9999C1.25 10.578 3.21929 8.45577 5.91005 6.97161L2.46967 3.53027L3.46967 2.53027L21.4697 20.5303L21.5303 20.4696L20.4697 21.5303ZM6.988 8.04857C6.3688 8.38198 5.77567 8.77319 5.21375 9.21466C4.82783 9.51786 4.46591 9.84506 4.14453 10.1658L3.91134 10.4047L3.6436 10.6955L3.5811 10.7663L3.52048 10.8361L3.29766 11.1041L3.24711 11.1679L3.19871 11.2302L3.02762 11.4628L2.89479 11.6649C2.80089 11.8191 2.75 11.9356 2.75 11.9999C2.75 12.103 2.88021 12.3395 3.10841 12.65L3.19851 12.7698L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3221 9.50335 17.2499 12 17.2499C13.2315 17.2499 14.4236 17.0241 15.5503 16.6108L14.0678 15.1288C13.475 15.5213 12.7642 15.7499 12 15.7499C9.92893 15.7499 8.25 14.071 8.25 11.9999C8.25 11.2357 8.47859 10.5249 8.87113 9.93215L6.988 8.04857ZM12 5.24994C17.197 5.24994 22.75 9.61314 22.75 11.9999C22.75 13.193 21.3639 14.8791 19.3283 16.2677L18.2474 15.1866C18.4303 15.0578 18.6103 14.9238 18.7871 14.7848C18.9479 14.6585 19.1044 14.528 19.2556 14.3956L19.4783 14.1957L19.7952 13.894C19.9312 13.76 20.0603 13.6269 20.1813 13.4968L20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4004 21.25 12.1156 21.25 11.9999C21.25 11.8858 21.0891 11.6066 20.8117 11.2442L20.7023 11.1045L20.4794 10.8365L20.2259 10.5519C19.8241 10.1153 19.3288 9.64145 18.7862 9.21509C16.8299 7.67795 14.4954 6.74994 12 6.74994C11.3233 6.74994 10.6584 6.81817 10.0097 6.94826L8.80638 5.74634C9.85184 5.43366 10.9334 5.24994 12 5.24994ZM9.96949 11.0294C9.82879 11.3233 9.75 11.6524 9.75 11.9999C9.75 13.2426 10.7574 14.2499 12 14.2499C12.3473 14.2499 12.6761 14.1713 12.9698 14.0308L9.96949 11.0294ZM12 8.24994C14.0711 8.24994 15.75 9.92887 15.75 11.9999C15.75 12.2162 15.7317 12.4283 15.6965 12.6345L13.9649 10.903C13.7612 10.5389 13.4593 10.2372 13.095 10.0339L11.365 8.30349C11.5714 8.26828 11.7835 8.24994 12 8.24994Z"
                                      ></path>
                                    </g>
                                    <defs>
                                      <clipPath id="clip0_124_2987">
                                        <rect width="24" height="24"></rect>
                                      </clipPath>
                                    </defs>
                                  </svg>
                                  <div
                                    data-v-524f63ea=""
                                    class="inline-flex items-center"
                                  ></div>
                                </button>
                                <!-- visible 상태 -->
                                <button
                                  v-else
                                  @click="clickShowPassword"
                                  data-v-524f63ea=""
                                  data-v-778c1d9b=""
                                  data-v-6d6ea1ac=""
                                  type="button"
                                  class="CoreButton BaseButtonIcon ml-[8px]"
                                  style="
                                    background-color: transparent;
                                    color: rgb(102, 102, 102);
                                    height: 24px;
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
                                      width: 24px;
                                      height: 24px;
                                      opacity: 1;
                                      fill: currentcolor;
                                      --BaseIcon-color: #333333;
                                      margin-bottom: 0px;
                                    "
                                  >
                                    <g clip-path="url(#clip0_124_3015)">
                                      <path
                                        fill-rule="evenodd"
                                        clip-rule="evenodd"
                                        d="M12 5.25C17.197 5.25 22.75 9.6132 22.75 12C22.75 14.3875 17.1988 18.75 12 18.75C6.80076 18.75 1.25 14.3883 1.25 12C1.25 9.61239 6.80263 5.25 12 5.25ZM12 6.75C9.50447 6.75 7.16994 7.67785 5.21375 9.21471C4.73134 9.59371 4.28645 10.0102 3.91134 10.4047L3.6436 10.6956C3.60132 10.7431 3.56026 10.79 3.52048 10.8362L3.29766 11.1042C3.26325 11.1472 3.23025 11.1892 3.19871 11.2302L3.02762 11.4629L2.89479 11.665C2.80089 11.8191 2.75 11.9356 2.75 12C2.75 12.1159 2.9148 12.4008 3.19851 12.7699L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3222 9.50335 17.25 12 17.25C14.4965 17.25 16.8312 16.322 18.7871 14.7849C19.0282 14.5954 19.26 14.3966 19.4783 14.1958L19.7952 13.894C19.9991 13.6931 20.1876 13.494 20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4005 21.25 12.1157 21.25 12C21.25 11.8715 21.0464 11.5343 20.7023 11.1046L20.4794 10.8366L20.2259 10.552C19.8241 10.1154 19.3288 9.64151 18.7862 9.21515C16.8299 7.678 14.4954 6.75 12 6.75ZM12 8.25C14.0711 8.25 15.75 9.92893 15.75 12C15.75 14.0711 14.0711 15.75 12 15.75C9.92893 15.75 8.25 14.0711 8.25 12C8.25 9.92893 9.92893 8.25 12 8.25ZM12 9.75C10.7574 9.75 9.75 10.7574 9.75 12C9.75 13.2426 10.7574 14.25 12 14.25C13.2426 14.25 14.25 13.2426 14.25 12C14.25 10.7574 13.2426 9.75 12 9.75Z"
                                      ></path>
                                    </g>
                                    <defs>
                                      <clipPath id="clip0_124_3015">
                                        <rect width="24" height="24"></rect>
                                      </clipPath>
                                    </defs>
                                  </svg>
                                  <div
                                    data-v-524f63ea=""
                                    class="inline-flex items-center"
                                  >
                                    <!---->
                                  </div>
                                </button>
                              </label>
                            </div>
                          </div>
                        </div>
                        <!-- 비밀번호 확인 검증 안내 메시지-->
                        <div
                          v-if="!passwordValid"
                          data-v-6d6ea1ac=""
                          class="BaseTextField__assistiveArea"
                        >
                          <div
                            data-v-86c06fc2=""
                            data-v-6d6ea1ac=""
                            class="BaseTextHelper BaseTextHelper--error"
                          >
                            <!---->
                            <div
                              data-v-86c06fc2=""
                              class="inline-flex items-center"
                            >
                              비밀번호를 입력해주세요.
                            </div>
                          </div>
                          <!---->
                        </div>
                      </div>
                      <div data-v-2b3ae965="" class="mb-[8px]">
                        <div
                          data-v-2b3ae965=""
                          class="grid-cols-2 gap-[8px] grid"
                        >
                          <label
                            data-v-ee180726=""
                            data-v-ef34c959=""
                            :class="
                              isEmailSaved
                                ? 'BaseCheckbox__state--checked'
                                : 'BaseCheckbox__state--unChecked'
                            "
                            for="agreeAge"
                            class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked h-[36px]"
                            style="--BaseCheckbox--label-margin: 4"
                          >
                            <div
                              data-v-ee180726=""
                              class="BaseCheckbox__wrapper"
                            >
                              <input
                                data-v-ee180726=""
                                @click="checkEmailSave"
                                id="agreeAge"
                                name="agreeAge"
                                class="BaseCheckbox__input"
                                type="checkbox"
                              /><span
                                data-v-ee180726=""
                                class="BaseCheckbox__button"
                              >
                                <svg
                                  data-v-6d2bd019=""
                                  data-v-ee180726=""
                                  :style="
                                    isEmailSaved
                                      ? '--BaseIcon-color: #ffffff'
                                      : '--BaseIcon-color: #d9d9d9'
                                  "
                                  width="24"
                                  height="24"
                                  viewBox="0 0 24 24"
                                  xmlns="http://www.w3.org/2000/svg"
                                  class="BaseIcon BaseCheckbox__icon"
                                  style="
                                    width: 24px;
                                    height: 24px;
                                    opacity: 1;
                                    fill: currentcolor;
                                    --BaseIcon-color: #d9d9d9;
                                  "
                                >
                                  <g clip-path="url(#clip0_2582_8708)">
                                    <path
                                      fill-rule="evenodd"
                                      clip-rule="evenodd"
                                      d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z"
                                    ></path>
                                  </g>
                                  <defs>
                                    <clipPath id="clip0_2582_8708">
                                      <rect width="24" height="24"></rect>
                                    </clipPath>
                                  </defs></svg></span
                              ><span
                                data-v-ee180726=""
                                class="BaseCheckbox__text"
                                style="color: rgb(51, 51, 51)"
                                >이메일 저장하기</span
                              >
                            </div>
                          </label>
                          <div data-v-2b3ae965="" class="text-right">
                            <router-link
                              to="member/find"
                              data-v-524f63ea=""
                              data-v-8493c3f2=""
                              data-v-2b3ae965=""
                              type="default"
                              class="CoreButton BaseButtonText body1-regular-small"
                              style="
                                background-color: transparent;
                                color: rgb(102, 102, 102);
                                height: 32px;
                                flex-direction: row-reverse;
                                --core-button-padding-x: 8;
                              "
                            >
                              <div
                                data-v-524f63ea=""
                                class="inline-flex items-center"
                              >
                                <span
                                  data-v-524f63ea=""
                                  class="CoreButton__text"
                                  >아이디 / 비밀번호 찾기</span
                                >
                              </div>
                            </router-link>
                          </div>
                        </div>
                      </div>
                      <div data-v-2b3ae965="">
                        <!-- 로그인 버튼 -->
                        <button
                          @click="login"
                          data-v-524f63ea=""
                          data-v-7940d6dd=""
                          data-v-2b3ae965=""
                          type="fill"
                          class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill"
                          style="
                            background-color: rgb(57, 57, 57);
                            color: rgb(255, 255, 255);
                            height: 44px;
                            flex-direction: row;
                            --core-button-padding-x: 16;
                          "
                        >
                          <!---->
                          <!---->
                          <div
                            data-v-524f63ea=""
                            class="inline-flex items-center"
                          >
                            <span data-v-524f63ea="" class="CoreButton__text"
                              >로그인</span
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
        </div>
        <!---->
        <!---->
        <div
          data-v-ac6313c6=""
          class="BaseSnackbar__fadeOut !hidden BaseSnackbar"
        >
          <div
            data-v-ac6313c6=""
            class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]"
          >
            <!---->
            <div
              data-v-ac6313c6=""
              class="body1-regular-medium line-clamp-2 whitespace-pre-line"
            ></div>
            <!---->
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";
import swal from 'sweetalert2';

export default {
  name: "LoginComponent",
  data() {
    return {
      emailValid: true,
      passwordValid: true,
      passwordEmpty: true,
      isEmailSaved: false,
      member: {
        email: "",
        password: "",
      },
      showPassword: false,
    };
  },
  computed: {
    ...mapStores(useMemberStore),
  },
  methods: {
    showAlert(content) {
      swal.fire({
        title: "Oops!",
        text: content,
        icon: "error",
      });
    },
    validateEmail() {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      this.emailValid = emailPattern.test(this.member.email);
    },
    // validatePassword() {
    //     const passwordPattern = /^(?=.*[A-Z])(?=.*\W).{8,}$/;
    //     this.passwordValid = passwordPattern.test(this.member.password);
    // },
    emptyPassword() {
      this.passwordValid = this.member.password !== "";
    },
    validateForm() {
      this.validateEmail();
      // this.validatePassword();
      this.emptyPassword();
      if (this.emailValid && this.passwordValid) {
        return true;
      }
      return false;
    },
    checkEmailSave() {
      if (this.isEmailSaved === true) {
        this.isEmailSaved = false;
      } else {
        this.isEmailSaved = true;
      }
    },
    clickShowPassword() {
      if (this.showPassword === false) {
        this.showPassword = true;
        return false;
      } else {
        this.showPassword = false;
        return true;
      }
    },
    async login() {
      const passValidation = this.validateForm();

      if (passValidation) {
        const result = await this.memberStore.login(this.member);
        if (result === true) {
          await this.memberStore.getMemberInfo();
          window.location.href = "/"; // 메인페이지 리다이렉트
          // this.$router.push(`/redirect/${this.memberStore.member.userName}`);
        } else {
          this.showAlert("이메일과 비밀번호를 확인해주세요.");
          this.member.password = "";
        }
      } else {
        console.log("로그인 실패");
      }
    },

    moveKakaoLogin() {
      this.memberStore.kakaoLogin();
    },
  },
};
</script>
<style scoped>
.cgbLogo {
  background-image: url("@/assets/cgb.png");
  background-repeat: no-repeat;
  background-size: contain; /* 또는 cover, 원하는 크기에 따라 선택 */
  display: inline-block;
  vertical-align: middle;
  width: 100px; /* 원하는 너비 */
  height: 42px; /* 원하는 높이 */
}
</style>
