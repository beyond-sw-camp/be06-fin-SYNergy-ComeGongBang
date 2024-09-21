<template>
      <div
          class="DesktopHeaderMenuBar DesktopHeaderMenuBar--stickyHeader DesktopHeaderMenuBar--stickyHeaderMenu z-[1490]"
          data-v-4e58ad83="" data-v-cc87a9e7="">
        <div
            class="BaseTabs BaseTabs__size--medium BaseTabs--full BaseTabs__style--outline BaseTabs__align--left BaseTabs__font--size BaseTabs__font--weight gray-666--text w-desktop px-[180px]"
            style="--BaseTabs-item-length: 8; --BaseTabs-margin-x: 0" data-v-de0565e1="" data-v-cc87a9e7="">
          <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
            <!--[-->
            <div class="BaseTab" style="--BaseTab-fontSize: 15; --BaseTab-fontWeight: 500" role="tab" border-top="false"
                 border-bottom="false" data-v-47c662bd="" data-v-de0565e1="">
              <div class="BaseTab__contents" data-v-47c662bd="">
                <div class="BaseTab__prefix" data-v-47c662bd="">
                  <!--[--><!--[-->
                  <div data-v-cc87a9e7="">
                    <div data-v-cc87a9e7="" class="lottie-animation-container lottie" autoplay="true" style="
                          --lottie-animation-container-width: 20px;
                          --lottie-animation-container-height: 20px;
                          --lottie-animation-container-background-color: transparent;
                          --lottie-animation-margin: 0 auto;
                        ">
                      <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                           viewBox="0 0 60 60" width="60" height="60" preserveAspectRatio="xMidYMid meet" style="
                            width: 100%;
                            height: 100%;
                            transform: translate3d(0px, 0px, 0px);
                            content-visibility: visible;
                          ">
                        <defs>
                          <clipPath id="__lottie_element_2">
                            <rect width="60" height="60" x="0" y="0"></rect>
                          </clipPath>
                        </defs>
                      </svg>
                    </div>
                  </div>
                  <!--]--><!--]-->
                </div>
                <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
                  <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                    <span class="BaseFontVariable__text--hidden" data-v-9dbc8be1="">선물추천</span>
                      <span class="BaseFontVariable__text--display" data-v-9dbc8be1="">선물추천</span>
                  </div>
                  <span class="flex-auto inline-flex items-center" data-v-9dbc8be1=""><!--[--><!--]--></span>
                </div>
              </div>
              <div class="BaseTab__empty" data-v-47c662bd=""></div>
              <div class="BaseTab__activator" data-v-47c662bd=""></div>
            </div>
            <!--]-->
          </div>
          <!---->
        </div>
      </div>
</template>

<script>
import {
  mapStores
} from 'pinia';
import {
  useMemberStore
} from '@/stores/useMemberStore';

export default {
  data(){
    return {
      isLogined : false,
      upHere : false,
    }
  },
  methods:{
    async logout(){
      const response = await this.memberStore.logout();
      if(response === true){
        alert("로그아웃이 완료되었습니다.");
      } else {
        alert("에러 발생");
      }
    }
  },
  computed:{
    ...mapStores(useMemberStore)
  }
}
</script>

<style scoped>

</style>