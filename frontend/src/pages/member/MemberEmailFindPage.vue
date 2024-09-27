<template>
<body>
  <div id="__nuxt">
    <div class="appContainer" style="--container-width: 1040px; --app-bar-height: 0px;">
      <div data-v-26a5ae18="" class="TheContainer">
        <div class="appContents">
          <div>
            <div class="grid-cols-12 gap-[8px] grid">
              <div class="col-start-4 col-span-6"><!---->
                <div class="pb-[48px]">
                  <div class="grid-cols-1 gap-[0px] grid">
                    <div class="grid-cols-1 gap-[0px] grid">
                      <div data-v-e70698af=""
                        class="BaseLogo BaseLogo__en BaseLogo__en--default BaseLogo__en--medium flex justify-self-center mt-[20px] mb-[26px] cursor-pointer">
                      </div> <!-- 로고 -->
                      <div data-v-343d1a74="" class="BaseTextSideBar mb-[40px]">
                        <div data-v-343d1a74="" class="BaseTextSideBar__contents">
                          <div data-v-343d1a74="" class="BaseTextSideBar__text body1-regular-medium text-center">이메일로 찾기
                          </div>
                        </div>
                      </div>
                    </div>
                    <p class="subtitle3-regular-medium text-center mb-[40px]">가입시 사용한 이메일 주소를 입력하면 가입 정보를 보내드립니다.</p>
                    <div class="mb-[8px]">
                      <div>
                        <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                          <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText" style="display: none;"><span
                              data-v-e2593c18="" class="BaseLabelText__text"></span><!----></div><input
                            data-v-6d6ea1ac="" type="text" class="BaseTextField__hiddenInput" tabindex="-1"><label
                            data-v-6d6ea1ac="" class="BaseTextField BaseTextField--large"><!---->
                            <input v-model="email"
                              data-v-6d6ea1ac="" id="email" name="email" type="text"
                              class="BaseTextField__input BaseTextField__input--left"
                              placeholder="이메일을 입력해주세요."><!----><button data-v-524f63ea="" data-v-778c1d9b=""
                              data-v-6d6ea1ac="" type="button"
                              class="CoreButton BaseButtonIcon BaseTextField__clearIcon"
                              style="background-color: transparent; color: rgb(172, 172, 172); height: 24px; flex-direction: column; display: none;"><!----><svg
                                data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                                xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                                style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                <g clip-path="url(#clip0_124_2957)">
                                  <path fill-rule="evenodd" clip-rule="evenodd"
                                    d="M12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2ZM15.4697 7.46967L11.9997 10.9397L8.53033 7.46967L7.46967 8.53033L10.9397 11.9997L7.46967 15.4697L8.53033 16.5303L11.9997 13.0597L15.4697 16.5303L16.5303 15.4697L13.0597 11.9997L16.5303 8.53033L15.4697 7.46967Z">
                                  </path>
                                </g>
                                <defs>
                                  <clipPath id="clip0_124_2957">
                                    <rect width="24" height="24"></rect>
                                  </clipPath>
                                </defs>
                              </svg>
                              <div data-v-524f63ea="" class="inline-flex items-center"><!----></div>
                            </button><!----></label><!---->
                        </div>
                      </div>
                    </div>
                    <button @click="findEmail" data-v-524f63ea="" data-v-7940d6dd="" type="fill"
                      class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill"
                      style="background-color: rgb(239, 112, 20); color: rgb(255, 255, 255); height: 44px; flex-direction: row; --core-button-padding-x: 16;"><!----><!---->
                      <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea=""
                          class="CoreButton__text">이메일로 전송</span></div>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div><!----><!---->
      <div data-v-ac6313c6="" class="BaseSnackbar__fadeOut !hidden BaseSnackbar">
        <div data-v-ac6313c6="" class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]"><!---->
          <div data-v-ac6313c6="" class="body1-regular-medium line-clamp-2 whitespace-pre-line"></div><!---->
        </div>
      </div>
    </div>
  </div>

  <div v-if="isOpenModal">
    <MemberEmailFindModal></MemberEmailFindModal>
  </div>

</body>
</template>

<script>
import { mapStores } from 'pinia';
import { useMemberStore } from '@/stores/useMemberStore';
import MemberEmailFindModal from "@/components/member/MemberEmailFindModal";
export default {
    name: "EmailFindPage",
    components:{
      MemberEmailFindModal,
    },
    data(){
        return{
            email : "",
            isOpenModal : false,
        };
    },
    computed:{
        ...mapStores(useMemberStore)
    },
    methods: {
      openModal(){
        this.isOpenModal = true
      },
      async findEmail(){
        this.openModal();
        // await this.memberStore.findEmail(this.email);
      },

    }
}

</script>

