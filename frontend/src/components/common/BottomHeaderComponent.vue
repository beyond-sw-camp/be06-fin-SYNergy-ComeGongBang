<template>
  <div
    class="DesktopHeaderMenuBar DesktopHeaderMenuBar--stickyHeader DesktopHeaderMenuBar--stickyHeaderMenu z-[1490]"
    data-v-4e58ad83=""
    data-v-cc87a9e7=""
  >
    <div
      class="BaseTabs BaseTabs__size--medium BaseTabs--full BaseTabs__style--outline BaseTabs__align--left BaseTabs__font--size BaseTabs__font--weight gray-666--text w-desktop px-[180px]"
      style="--BaseTabs-item-length: 4; --BaseTabs-margin-x: 0"
      data-v-de0565e1=""
      data-v-cc87a9e7=""
    >
      <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
        <!--빅딜상품-->
        <div
          class="BaseTab"
          style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
          role="tab"
          border-top="false"
          border-bottom="false"
          data-v-47c662bd=""
          data-v-de0565e1=""
        >
          <div class="BaseTab__contents" data-v-47c662bd="">
            <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
              <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1=""
                  >빅딜상품</span
                >
                <span class="BaseFontVariable__text--display" data-v-9dbc8be1=""
                  >빅딜상품</span
                >
              </div>
              <span
                class="flex-auto inline-flex items-center"
                data-v-9dbc8be1=""
              ></span>
            </div>
          </div>
          <div class="BaseTab__empty" data-v-47c662bd=""></div>
          <div class="BaseTab__activator" data-v-47c662bd=""></div>
        </div>
        <!--기념일-->
        <div
          class="BaseTab"
          style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
          role="tab"
          border-top="false"
          border-bottom="false"
          data-v-47c662bd=""
          data-v-de0565e1=""
        >
          <div class="BaseTab__contents" data-v-47c662bd="">
            <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
              <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1=""
                  >기념일</span
                >
                <span class="BaseFontVariable__text--display" data-v-9dbc8be1=""
                  >기념일</span
                >
              </div>
              <span
                class="flex-auto inline-flex items-center"
                data-v-9dbc8be1=""
              ></span>
            </div>
          </div>
          <div class="BaseTab__empty" data-v-47c662bd=""></div>
          <div class="BaseTab__activator" data-v-47c662bd=""></div>
        </div>
        <!--추천상품-->
        <div
          class="BaseTab"
          style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
          role="tab"
          border-top="false"
          border-bottom="false"
          data-v-47c662bd=""
          data-v-de0565e1=""
        >
          <div class="BaseTab__contents" data-v-47c662bd="">
            <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
              <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1=""
                  >추천상품</span
                >
                <span class="BaseFontVariable__text--display" data-v-9dbc8be1=""
                  >추천상품</span
                >
              </div>
              <span
                class="flex-auto inline-flex items-center"
                data-v-9dbc8be1=""
              ></span>
            </div>
          </div>
          <div class="BaseTab__empty" data-v-47c662bd=""></div>
          <div class="BaseTab__activator" data-v-47c662bd=""></div>
        </div>
        <!--이벤트쿠폰-->
        <div
          class="BaseTab"
          style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
          role="tab"
          border-top="false"
          border-bottom="false"
          data-v-47c662bd=""
          data-v-de0565e1=""
        >
          <div class="BaseTab__contents" data-v-47c662bd="">
            <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
              <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1=""
                  >이벤트 쿠폰</span
                >
                <span class="BaseFontVariable__text--display" data-v-9dbc8be1=""
                  >이벤트 쿠폰</span
                >
              </div>
              <span
                class="flex-auto inline-flex items-center"
                data-v-9dbc8be1=""
              ></span>
            </div>
          </div>
          <div class="BaseTab__empty" data-v-47c662bd=""></div>
          <div class="BaseTab__activator" data-v-47c662bd=""></div>
        </div>
      </div>
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
</style>