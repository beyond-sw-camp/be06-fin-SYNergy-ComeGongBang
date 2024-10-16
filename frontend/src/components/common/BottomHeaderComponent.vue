<template>
  <div
    class="DesktopHeaderMenuBar DesktopHeaderMenuBar--stickyHeader DesktopHeaderMenuBar--stickyHeaderMenu z-[1490]"
    data-v-4e58ad83=""
    data-v-cc87a9e7=""
  >
    <div
      class="BaseTabs BaseTabs__size--medium BaseTabs--full BaseTabs__style--outline BaseTabs__align--left BaseTabs__font--size BaseTabs__font--weight gray-666--text w-desktop px-[180px]"
      style="
        --BaseTabs-item-length: 4;
        --BaseTabs-margin-x: 0;
      "
      data-v-de0565e1=""
      data-v-cc87a9e7=""
    >
      <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
        <!--빅딜상품-->
        <!--        todo click="alert없애고 라우팅 하기"-->
        <router-link to="/search/hashtag/2" exact-active-class="active">
          <div
            class="BaseTab --active"
            style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
            role="tab"
            border-top="false"
            border-bottom="false"
            data-v-47c662bd=""
            data-v-de0565e1=""
          >
            <div class="BaseTab__contents" data-v-47c662bd="">
              <div
                class="BaseFontVariable"
                data-v-9dbc8be1=""
                data-v-47c662bd=""
              >
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >빅딜상품</span
                  >
                  <span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
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
        </router-link>
        <!--기념일-->
        <router-link to="/search/hashtag/1" exact-active-class="active">
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
              <div
                class="BaseFontVariable"
                data-v-9dbc8be1=""
                data-v-47c662bd=""
              >
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >기념일</span
                  >
                  <span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
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
        </router-link>
        <!--추천상품-->
        <router-link to="/" >
          <div
            class="BaseTab"
            style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500"
            role="tab"
            border-top="false"
            border-bottom="false"
            data-v-47c662bd=""
            data-v-de0565e1=""
            @click="alert"
          >
            <div class="BaseTab__contents" data-v-47c662bd="">
              <div
                class="BaseFontVariable"
                data-v-9dbc8be1=""
                data-v-47c662bd=""
              >
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >추천상품</span
                  >
                  <span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
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
        </router-link>
        <!--이벤트쿠폰-->
        <router-link to="/event/coupon" exact-active-class="active">
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
              <div
                class="BaseFontVariable"
                data-v-9dbc8be1=""
                data-v-47c662bd=""
              >
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >이벤트 쿠폰</span
                  >
                  <span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
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
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";
import swal from 'sweetalert2';

export default {
  data() {
    return {
      isLogined: false,
      upHere: false,
    };
  },
  methods: {
    showAlert(content) {
      swal.fire({
        title: "Oops!",
        text: content,
        icon: "error",
      });
    },
    showSuccessAlert(content) {
      swal.fire({
        title: "Success!",
        text: content,
        icon: "success",
      });
    },
    async logout() {
      const response = await this.memberStore.logout();
      if (response === true) {
        this.showSuccessAlert("로그아웃이 완료되었습니다.");
        window.location.href = "/";
      } else {
        this.showAlert("에러 발생");
      }
    },
    alert() {
      this.showAlert("서비스 준비중입니다.");
    },
  },
  computed: {
    ...mapStores(useMemberStore),
  },
};
</script>

<style scoped>
.active {
  border-bottom: 2px solid rgb(42, 94, 122);
  color: rgb(42, 94, 122);
}

</style>
