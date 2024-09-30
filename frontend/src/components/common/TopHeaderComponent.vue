<template>
  <div
    class="flex items-center justify-center w-full h-[30px] gray-f5--background z-desktop-header relative z-[1510]"
    data-v-4e58ad83=""
  >
    <div class="flex-row flex w-desktop justify-between">
      <div class="flex relative"></div>

      <!-- 로그인 안되었을 때 -->
      <span
        v-if="memberStore.isLogined === false"
        class="flex body3-regular-small"
        ><!--[-->
        <router-link
          to="/login"
          type="default"
          class="CoreButton BaseButtonText body3-regular-small mr-[4px]"
          style="
            background-color: transparent;
            color: #666666;
            height: 30px;
            flex-direction: row-reverse;
            --core-button-padding-x: 8;
          "
          data-v-524f63ea=""
          data-v-8493c3f2=""
        >
          <div class="inline-flex items-center" data-v-524f63ea="">
            <span class="CoreButton__text" data-v-524f63ea="">로그인</span>
          </div>
        </router-link>
        <router-link
          to="/signup"
          type="default"
          class="CoreButton BaseButtonText body3-regular-small mr-[4px]"
          style="
            background-color: transparent;
            color: #666666;
            height: 30px;
            flex-direction: row-reverse;
            --core-button-padding-x: 8;
          "
          data-v-524f63ea=""
          data-v-8493c3f2=""
          ><!----><!--[--><!---->
          <div class="inline-flex items-center" data-v-524f63ea="">
            <!--[--><!--]-->
            <span class="CoreButton__text" data-v-524f63ea="">회원가입</span>
          </div>
        </router-link>
        <div class="BaseMenus__wrapper" data-v-d1f9d3af="">
          <div class="BaseMenus__toggle" data-v-d1f9d3af="">
            <!--[--><button
              type="default"
              class="CoreButton BaseButtonText body3-regular-small"
              style="
                background-color: transparent;
                color: #666666;
                height: 30px;
                flex-direction: row-reverse;
                --core-button-padding-x: 8;
              "
              data-v-524f63ea=""
              data-v-8493c3f2=""
            >
              <!----><!--[--><!---->
              <div class="inline-flex items-center" data-v-524f63ea="">
                <!--[--><!--]--><span
                  class="CoreButton__text"
                  data-v-524f63ea=""
                  >고객센터</span
                >
              </div>
              <!--]--></button
            ><!--]-->
          </div>
          <div
            class="BaseMenus BaseMenus__position--bottom"
            style="--ids-menus-offset-x: -122; --ids-menus-toggle-height: 30"
            data-v-d1f9d3af=""
          >
            <!--[-->
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >공지사항</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >자주 묻는 문의</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >채팅 상담</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >단체선물 문의</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <!--]-->
          </div>
        </div>
      </span>

      <!-- 로그인 되었을 때 -->
      <span
        v-else
        @mouseleave="upHere = false"
        class="flex body3-regular-small"
      >
        <!-- "이름" 님 토글 -->
        <div
          @mouseover="upHere = true"
          class="BaseMenus__wrapper"
          data-v-d1f9d3af=""
        >
          <div class="BaseMenus__toggle" data-v-d1f9d3af="">
            <button
              type="default"
              class="CoreButton BaseButtonText body3-regular-small"
              style="
                background-color: transparent;
                color: #666666;
                height: 30px;
                flex-direction: row-reverse;
                --core-button-padding-x: 8;
              "
              data-v-524f63ea=""
              data-v-8493c3f2=""
            >
              <div class="inline-flex items-center" data-v-524f63ea="">
                <span class="CoreButton__text" data-v-524f63ea="">
                  {{ memberStore.member.nickname }} 님
                </span>
              </div>
            </button>
          </div>
          <div
            class="BaseMenus BaseMenus__position--bottom openInfo"
            style="--ids-menus-offset-x: 0; --ids-menus-toggle-height: 30"
            data-v-d1f9d3af=""
          >
            <!-- 회원 정보 관리 -->
            <div
              :style="{ display: upHere ? 'block' : 'none' }"
              data-v-d1f9d3af=""
            >
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <router-link
                  to="/update/member-info"
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <span class="body1-regular-medium" data-v-a833c376=""
                    >회원 정보 관리</span
                  >
                </router-link>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <!-- 주문 배송 -->
            <div
              :style="{ display: upHere ? 'block' : 'none' }"
              data-v-d1f9d3af=""
            >
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <router-link
                  to="/order-list"
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <span class="body1-regular-medium" data-v-a833c376=""
                    >주문배송</span
                  >
                </router-link>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <!-- 로그아웃 -->
            <button @click="logout">
              <div
                :style="{ display: upHere ? 'block' : 'none' }"
                data-v-d1f9d3af=""
              >
                <div
                  class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                  data-v-a833c376=""
                  data-v-d1f9d3af=""
                >
                  <div
                    class="flex items-center w-full px-[12px] cursor-pointer"
                    data-v-a833c376=""
                  >
                    <span class="body1-regular-medium" data-v-a833c376=""
                      >로그아웃</span
                    >
                  </div>
                </div>
                <div
                  class="BaseMenus__divider"
                  style="display: none"
                  data-v-d1f9d3af=""
                ></div>
              </div>
            </button>
            <!--]-->
          </div>
        </div>

        <!-- 알림 토글 -->
        <!-- <span class="relative w-[55px] flex justify-center items-center ml-[4px] gray-666--text"><button
                type="button" class="CoreButton BaseButtonIcon body3-regular-small" style="
                    background-color: transparent;
                    color: #666666;
                    height: 30px;
                    width: 55px;
                    flex-direction: row;
                  " data-v-524f63ea="" data-v-778c1d9b="">
                <svg width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" style="
                      width: 16px;
                      height: 16px;
                      opacity: 1;
                      fill: currentColor;
                      --BaseIcon-color: #333333;
                      margin-right: 4px;
                    " class="BaseIcon CoreButton__icon" data-v-6d2bd019="" data-v-524f63ea="">
                  <g clip-path="url(#clip0_124_2980)">
                    <path fill-rule="evenodd" clip-rule="evenodd"
                          d="M12 2C16.1421 2 19.5 5.35786 19.5 9.5L19.499 13.8379L21.0485 16.014C21.4222 16.5389 21.3328 17.2538 20.8619 17.6723L20.7552 17.7572C20.5435 17.908 20.2901 17.9889 20.0303 17.9889L15.7621 17.9889C15.7621 17.9926 15.7621 17.9963 15.7621 18C15.7621 20.0711 14.0832 21.75 12.0121 21.75C9.94107 21.75 8.26214 20.0711 8.26214 18L8.26175 17.988L3.96975 17.9889C3.32254 17.9889 2.79022 17.4971 2.7262 16.8668L2.71975 16.7389C2.71975 16.4791 2.80074 16.2257 2.95146 16.014L4.499 13.8399L4.5 9.5C4.5 5.43908 7.72748 2.13198 11.7573 2.00385L12 2ZM14.2607 17.988L9.76217 17.9889C9.76215 17.9926 9.76214 17.9963 9.76214 18C9.76214 19.2426 10.7695 20.25 12.0121 20.25C13.2548 20.25 14.2621 19.2426 14.2621 18L14.2607 17.988ZM12 3.5C8.68629 3.5 6 6.18629 6 9.5V14.0786C6 14.2345 5.95141 14.3866 5.86098 14.5136L4.454 16.4889H19.545L18.139 14.5136C18.0712 14.4183 18.0269 14.309 18.009 14.1945L18 14.0786V9.5C18 6.18629 15.3137 3.5 12 3.5Z">
                    </path>
                  </g>
                  <defs>
                    <clipPath id="clip0_124_2980">
                      <rect width="24" height="24"></rect>
                    </clipPath>
                  </defs>
                </svg>
                <div class="inline-flex items-center" data-v-524f63ea="">
                  <span class="CoreButton__text" data-v-524f63ea="">알림</span>
                </div>
              </button>
            </span> -->

        <!-- 고객센터 토글 -->
        <div class="BaseMenus__wrapper" data-v-d1f9d3af="">
          <div class="BaseMenus__toggle" data-v-d1f9d3af="">
            <!--[--><button
              type="default"
              class="CoreButton BaseButtonText body3-regular-small"
              style="
                background-color: transparent;
                color: #666666;
                height: 30px;
                flex-direction: row-reverse;
                --core-button-padding-x: 8;
              "
              data-v-524f63ea=""
              data-v-8493c3f2=""
            >
              <!----><!--[--><!---->
              <div class="inline-flex items-center" data-v-524f63ea="">
                <!--[--><!--]--><span
                  class="CoreButton__text"
                  data-v-524f63ea=""
                  >고객센터</span
                >
              </div>
              <!--]--></button
            ><!--]-->
          </div>
          <!-- 고객센터 토글 열었을 때 -->
          <div
            class="BaseMenus BaseMenus__position--bottom"
            style="--ids-menus-offset-x: -122; --ids-menus-toggle-height: 30"
            data-v-d1f9d3af=""
          >
            <!--[-->
            <!-- 공지사항 -->
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >공지사항</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <!-- 자주 묻는 문의 -->
            <div style="display: none" data-v-d1f9d3af="">
              <div
                class="BaseMenusItem gray-333--text BaseMenusItem--medium"
                data-v-a833c376=""
                data-v-d1f9d3af=""
              >
                <div
                  class="flex items-center w-full px-[12px] cursor-pointer"
                  data-v-a833c376=""
                >
                  <!----><!--[--><!--]--><span
                    class="body1-regular-medium"
                    data-v-a833c376=""
                    >자주 묻는 문의</span
                  >
                </div>
              </div>
              <div
                class="BaseMenus__divider"
                style="display: none"
                data-v-d1f9d3af=""
              ></div>
            </div>
            <!--]-->
          </div>
        </div>
      </span>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";

export default {
  data() {
    return {
      isLogined: false,
      upHere: false,
    };
  },
  methods: {
    async logout() {
      const response = await this.memberStore.logout();
      if (response === true) {
        alert("로그아웃이 완료되었습니다.");
        window.location.href = "http://localhost:3000/"; // 로그인 페이지 메인페이지 리다이렉트
      } else {
        alert("에러 발생");
      }
    },
  },
  computed: {
    ...mapStores(useMemberStore),
  },
};
</script>

<style scoped>
.openInfo {
  margin-top: 0px !important;
}
</style>