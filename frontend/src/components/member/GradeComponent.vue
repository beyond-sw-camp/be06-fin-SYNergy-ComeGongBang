<template>
  <div id="__nuxt">
    <div
      class="appContainer"
      style="
        --desktop-header-menu-top: 75px;
        --desktop-header-sticky-height: 124px;
      "
      data-v-4e58ad83=""
    >
      <div id="MoveToTopTrigger" data-v-4e58ad83=""></div>
      <div class="appContents" data-v-4e58ad83="">
        <!--[-->
        <div class="flex mt-[36px] mb-[64px]">
          <div
            v-if="loading"
            class="BaseOverlay z-[1000]"
            style="
              --BaseOverlay-position: fixed;
              --BaseOverlay-background: rgba(245, 245, 245, 0.6);
              --BaseOverlay-blur: blur(0px);
            "
            data-v-546911c4=""
            data-v-a5290452=""
          >
            <div class="BaseOverlay__scrim" data-v-546911c4=""></div>
            <div class="BaseOverlay__content" data-v-546911c4="">
              <div class="flex justify-center items-center" data-v-a5290452="">
                <div class="relative w-full" data-v-a5290452="">
                  <div
                    class="BaseProgressIndicator flex justify-center items-center w-full h-[108px]"
                    data-v-a5290452=""
                    data-v-3e1417ba=""
                  >
                    <div
                      class="BaseLoaderCircle"
                      style="width: 48px; height: 48px"
                      data-v-d3ab2c08=""
                      data-v-3e1417ba=""
                    >
                      <svg
                        viewBox="0 0 50 50"
                        class="BaseLoaderCircle__inner"
                        data-v-d3ab2c08=""
                      >
                        <circle
                          class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--underlay"
                          cx="50%"
                          cy="50%"
                          r="20"
                          data-v-d3ab2c08=""
                        ></circle>
                        <circle
                          class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--overlay"
                          cx="50%"
                          cy="50%"
                          r="20"
                          data-v-d3ab2c08=""
                        ></circle>
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="w-full pl-6">
            <p class="headline4-bold-small mb-[56px]">회원등급</p>
            <div class="flex justify-center">
              <div class="w-[600px]">
                <div class="px-[16px]">
                  <div class="flex flex-col items-center py-[20px] mb-[10px]">
                    <div
                      data-v-24b1dfb3=""
                      class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight mb-[16px]"
                      style="
                        --BaseImage-width: 72;
                        --BaseImage-height: 72;
                        --BaseImage-radius: 0;
                      "
                    >
                      <div
                        data-v-24b1dfb3=""
                        class="BaseImage__image"
                        style="
                          background-image: url('https://cdn.idus.kr/static/common/images/20240524/073952_image_grade01.png');
                        "
                      >
                        <img
                          data-v-24b1dfb3=""
                          src=""
                          class="hidden"
                          loading="lazy"
                        />
                      </div>
                    </div>
                    <p class="subtitle2-bold-small mb-[8px]">
                      {{ member.nickname }}님의 이번달 등급
                    </p>
                    <p class="headline4-bold-small">{{ grade.myGrade }}</p>
                    <span
                      data-v-43db7e7b=""
                      class="BaseChip__outline BaseChip--small BaseChip__outline--gray-666 BaseChip mt-[16px]"
                      ><!---->
                      <div
                        data-v-cdfdef93=""
                        data-v-43db7e7b=""
                        class="BaseBadgeNotification__wrapper"
                      >
                        <div
                          data-v-9dbc8be1=""
                          data-v-43db7e7b=""
                          class="BaseFontVariable"
                        >
                          <div
                            data-v-9dbc8be1=""
                            class="BaseFontVariable__text"
                          >
                            <span
                              data-v-9dbc8be1=""
                              class="BaseFontVariable__text--hidden"
                              >등급별 혜택보기</span
                            ><span
                              data-v-9dbc8be1=""
                              class="BaseFontVariable__text--display"
                              >등급별 혜택보기</span
                            >
                          </div>
                          <span
                            data-v-9dbc8be1=""
                            class="flex-auto inline-flex items-center"
                          ></span>
                        </div>
                        <!---->
                      </div>
                      <!---->
                    </span>
                  </div>
                  <div
                    class="rounded-[20px] border border-[#FFDECA] yellow-50--background mb-[30px]"
                  >
                    <div
                      class="flex flex-col items-center mx-[20px] mt-[8px] mb-[24px]"
                    >
                      <div class="mb-[16px] w-full px-[16px]">
                        <p
                          class="body1-regular-small gray-666--text text-center py-[12px]"
                        >
                          다음달 예상 등급
                          <span
                            class="body1-bold-small gray-333--text ml-[6px]"
                            >{{ grade.myGrade }}</span
                          >
                        </p>
                        <hr
                          data-v-6ef4cf18=""
                          class="BaseDivider"
                          style="--border-color: #ffdeca"
                        />
                      </div>
                      <p
                        class="text-center whitespace-pre-line body1-bold-medium mb-[12px]"
                      >
                        {{ grade.benefitMessage }}
                      </p>
                      <p class="text-center body3-bold-medium orange-500--text">
                        동손 혜택 : 1% 추가할인 + 깜짝 쿠폰
                      </p>
                    </div>
                  </div>
                  <div
                    data-v-424b2739=""
                    class="GradeProgress"
                    style="--67570cab: 0"
                  >
                    <div data-v-424b2739="" class="GradeProgress__wrapper">
                      <div
                        data-v-424b2739=""
                        class="GradeProgress__progress"
                      ></div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel--active GradeProgressLabel--now GradeProgressLabel"
                        style="--left: 0"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            아기손
                          </p>
                        </div>
                      </div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel"
                        style="--left: 20"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            동손
                          </p>
                        </div>
                      </div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel"
                        style="--left: 40"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            은손
                          </p>
                        </div>
                      </div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel"
                        style="--left: 60"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            금손
                          </p>
                        </div>
                      </div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel"
                        style="--left: 80"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            황금손
                          </p>
                        </div>
                      </div>
                      <div
                        data-v-42631f3d=""
                        data-v-424b2739=""
                        class="GradeProgressLabel"
                        style="--left: 100"
                      >
                        <div
                          data-v-42631f3d=""
                          class="GradeProgressLabel__label"
                        >
                          <p
                            data-v-42631f3d=""
                            class="GradeProgressLabel__label__text"
                          >
                            장인
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <hr
                  data-v-6ef4cf18=""
                  class="BaseDivider mt-[40px] mb-[20px]"
                  style="--border-color: #f5f5f5"
                />
                <div class="px-[16px]">
                  <div class="mb-[30px]">
                    <div
                      data-v-b42a95d0=""
                      class="BaseSubHeader"
                      style="
                        --sub-header-padding-left: 0;
                        --sub-header-padding-right: 8;
                        --sub-header-min-height: 48;
                      "
                    >
                      <!---->
                      <div data-v-b42a95d0="" class="BaseSubHeader__contents">
                        <p class="subtitle2-bold-small">등급별 혜택보기</p>
                      </div>
                      <!---->
                    </div>
                    <p class="body2-regular-medium mb-[22px] gray-999--text">
                      최근 6개월 동안 발송완료된 누적 구매 금액을 기준으로<br />
                      매월 1일 새로운 등급이 부여됩니다.
                    </p>
                    <div class="border-t border-[#E1E1E1] w-full">
                      <div
                        class="flex h-[44px] gray-f5--background items-center"
                      >
                        <p
                          class="w-[104px] shrink-0 body2_bold_small gray-999--text text-center"
                        >
                          등급
                        </p>
                        <p
                          class="w-full body2_bold_small gray-999--text text-center"
                        >
                          기준별 혜택
                        </p>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--master GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/074105_image_grade06.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            장인
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.6
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <!---->
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            100만원 이상 구매
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--percent"
                            >
                              5% 추가할인
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              정기쿠폰 2장 (총 2만원 할인)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              승급쿠폰 (1만 2천원 할인, 생애 1회)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--royalGold GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/074055_image_grade05.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            황금손
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.5
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <!---->
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            50만원 ~ 100만원 미만 구매
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--percent"
                            >
                              4% 추가할인
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              정기쿠폰 1장 (5천원 할인)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              승급쿠폰 (1만원 할인, 생애 1회)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--gold GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/074035_image_grade04.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            금손
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.4
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <!---->
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            20만원 ~ 50만원 미만 구매
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--percent"
                            >
                              3% 추가할인
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              승급쿠폰 (7천원 할인, 생애 1회)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--silver GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/074023_image_grade03.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            은손
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.3
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <!---->
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            10만원 ~ 20만원 미만 구매
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--percent"
                            >
                              2% 추가할인
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--highlighted"
                            >
                              승급쿠폰 (5천원 할인, 생애 1회)
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--bronze GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/074009_image_grade02.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            동손
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.2
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <!---->
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            10만원 미만 구매
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--percent"
                            >
                              1% 추가할인
                            </p>
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                      <div
                        data-v-f51d8c8b=""
                        class="GradeInfoItem--baby GradeInfoItem"
                      >
                        <div data-v-f51d8c8b="" class="GradeInfoItem__grade">
                          <div
                            data-v-24b1dfb3=""
                            data-v-f51d8c8b=""
                            class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight GradeInfoItem__grade__image"
                            style="
                              --BaseImage-width: 48;
                              --BaseImage-height: 48;
                              --BaseImage-radius: 0;
                            "
                          >
                            <div
                              data-v-24b1dfb3=""
                              class="BaseImage__image"
                              style="
                                background-image: url('https://cdn.idus.kr/static/common/images/20240524/073952_image_grade01.png');
                              "
                            >
                              <img
                                data-v-24b1dfb3=""
                                src=""
                                class="hidden"
                                loading="lazy"
                              />
                            </div>
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__name"
                          >
                            아기손
                          </p>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__grade__level"
                          >
                            Lv.1
                          </p>
                        </div>
                        <div data-v-f51d8c8b="" class="GradeInfoItem__info">
                          <div
                            data-v-24a9185e=""
                            data-v-f51d8c8b=""
                            class="BaseBadgeBusiness BaseBadgeBusiness__colorType--orange-50 BaseBadgeBusiness__size--small mb-[6px]"
                            style="font-weight: normal"
                          >
                            <!---->
                            내 등급
                          </div>
                          <p
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__requirement"
                          >
                            구매 내역이 없으신 분
                          </p>
                          <div
                            data-v-f51d8c8b=""
                            class="GradeInfoItem__info__benefit"
                          >
                            <!---->
                            <p
                              data-v-f51d8c8b=""
                              class="GradeInfoItem__info__benefit--list"
                            >
                              깜짝 쿠폰
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div
                    class="px-[16px] pt-[28px] pb-[22px] rounded-[12px] bg-[#EEEEFF] cursor-pointer mb-[30px]"
                  >
                    <p
                      class="purple-500--text body2-bold-small mb-[10px] text-center"
                    >
                      d+ 멤버십 가입하고 최대 혜택 받으세요
                    </p>
                    <p class="subtitle1-bold-small mb-[16px] text-center">
                      무제한 즉시할인 + 매월 정기 쿠폰팩
                    </p>
                    <div class="flex justify-center">
                      <div
                        data-v-62ba81fa=""
                        class="BaseBannerMembership max-w-[412px] w-full"
                      >
                        <div
                          data-v-27c9b08d=""
                          data-v-62ba81fa=""
                          class="BaseIconMembershipColor"
                          style="--icon-width: 24; --icon-height: 24"
                        >
                          <div
                            data-v-27c9b08d=""
                            class="BaseIconMembershipColor__icon"
                          ></div>
                        </div>
                        <div
                          data-v-a1957620=""
                          data-v-62ba81fa=""
                          class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]"
                        >
                          <span
                            data-v-a1957620=""
                            class="DecorateText"
                            style="
                              font-size: 13px;
                              color: rgb(255, 255, 255);
                              background-color: inherit;
                            "
                            >멤버십 가입시
                          </span>
                        </div>
                        <div
                          data-v-a1957620=""
                          data-v-62ba81fa=""
                          class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]"
                        >
                          <span
                            data-v-a1957620=""
                            class="DecorateText DecorateText--bold"
                            style="
                              font-size: 13px;
                              color: rgb(255, 255, 255);
                              background-color: inherit;
                            "
                            >4천 쿠폰 + 5% 추가할인</span
                          >
                        </div>
                        <svg
                          data-v-6d2bd019=""
                          data-v-62ba81fa=""
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
                            --BaseIcon-color: #ffffff;
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
                            <clippath id="clip0_124_2947">
                              <rect width="24" height="24"></rect>
                            </clippath>
                          </defs>
                        </svg>
                      </div>
                    </div>
                  </div>
                </div>
                <div data-v-203e9f45="" class="ImageMapper">
                  <img
                    data-v-203e9f45=""
                    src=""
                    usemap="#desktop-grade-notice"
                    class="ImageMapper__image"
                  /><map name="desktop-grade-notice"
                    ><area
                      coords="169.49999999999997,361.5,246.5,380"
                      shape="rect"
                      class="cursor-pointer"
                      data-coords="339,723,493,760"
                  /></map>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--]-->
        <div class="TheFabContainer" data-v-4e58ad83="" data-v-0397dfb3="">
          <!--[--><!----><button
            type="button"
            class="CoreButton IdsButtonFab__size--medium IdsButtonFab__iconSize--medium IdsButtonFab TheMoveToTopFab__display--hide TheFabContainer__item"
            style="
              background-color: rgb(255, 255, 255);
              color: rgb(51, 51, 51);
              height: 56px;
              width: 56px;
              flex-direction: row;
              --core-button-padding-x: 0px;
            "
            data-v-0397dfb3=""
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
                      <clippath id="clip0_124_2944">
                        <rect width="24" height="24"></rect>
                      </clippath>
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
      <div
        class="BaseSnackbar__fadeOut !hidden BaseSnackbar TheSnackbar"
        data-v-4e58ad83=""
        data-v-ac6313c6=""
      >
        <div
          class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]"
          data-v-ac6313c6=""
        >
          <!---->
          <div
            class="body1-regular-medium line-clamp-2 whitespace-pre-line"
            data-v-ac6313c6=""
          ></div>
          <!---->
        </div>
      </div>
      <!----><!---->
    </div>
  </div>
</template>

<script setup>
import { useGradeStore } from '@/stores/useGradeStore';
import { useMemberStore } from '@/stores/useMemberStore';
import { onMounted } from 'vue';

const gradeStore = useGradeStore();
const memberStore = useMemberStore();

onMounted(() => {
  gradeStore.fetchGrade();
  memberStore.getMemberInfo();
});

const grade = gradeStore.grade;
const member = memberStore.member;
</script>
