<template>
  <!-- 회원 정보 수정 -->
  <div class="w-full w-full pl-6">
    <div class="mb-[56px]">
      <p class="headline4-bold-small mr-[8px]">회원 정보 관리</p>
    </div>
    <div>
      <div
        class="flex border-t-[1px] gray-d9--text border-current last:border-b-[1px] border-line"
      >
        <div
          class="w-[80px] shrink-0 px-[10px] py-[12px] gray-f5--background gray-666--text body1-bold-medium flex items-center"
        >
          닉네임
        </div>
        <div class="px-[10px] py-[12px] w-full">
          <div class="max-w-[400px]">
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
                <span data-v-e2593c18="" class="BaseLabelText__text"></span
                ><span data-v-e2593c18="" class="BaseLabelText__mark">*</span>
              </div>
              <input
                data-v-6d6ea1ac=""
                type="text"
                class="BaseTextField__hiddenInput"
                tabindex="-1"
              /><label
                data-v-6d6ea1ac=""
                class="BaseTextField BaseTextField--large"
                ><!---->
                <input
                  v-model="newMemberInfo.nickname"
                  data-v-6d6ea1ac=""
                  id="userName"
                  name="userName"
                  type="text"
                  class="BaseTextField__input BaseTextField__input--left"
                  :placeholder="닉네임"
                  autocomplete="off"
                /><!---->
                <div data-v-524f63ea="" class="inline-flex items-center">
                  <!---->
                </div>
                <!----></label
              ><!---->
            </div>
          </div>
        </div>
      </div>
      <div
        class="flex border-t-[1px] gray-d9--text border-current last:border-b-[1px] border-line"
      >
        <div
          class="w-[80px] shrink-0 px-[10px] py-[12px] gray-f5--background gray-666--text body1-bold-medium flex items-center"
        >
          이메일
        </div>
        <div class="px-[10px] py-[12px] w-full">
          <div>
            <div class="flex items-center">
              <p class="mr-[8px] black--text body1-regular-medium">
                {{ memberStore.member.email }}
              </p>
              <button
                @click="openChangeBtn"
                data-v-524f63ea=""
                data-v-7940d6dd=""
                type="outline"
                class="CoreButton BaseButtonRectangle body1-regular-small BaseButtonRectangle__outline"
                style="
                  background-color: rgb(255, 255, 255);
                  color: rgb(51, 51, 51);
                  height: 36px;
                  flex-direction: row;
                  --core-button-padding-x: 8;
                  --button-rectangle-border-color: #acacac;
                "
              >
                <!----><!---->
                <div data-v-524f63ea="" class="inline-flex items-center">
                  <span data-v-524f63ea="" class="CoreButton__text">{{
                    openChangeBtnText
                  }}</span>
                </div>
              </button>
            </div>

            <!-- 변경버튼 누르면 나오는 창 -->
            <div v-if="openChangeBtnText === '취소하기'">
              <p class="black--text my-[8px] body1-regular-medium text-left">
                변경할 이메일 주소를 입력해주세요. (예.abcd@cgb.me)
              </p>
              <div class="flex max-w-[400px]">
                <div class="mr-[4px] w-full">
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
                      <span data-v-e2593c18="" class="BaseLabelText__mark"
                        >*</span
                      >
                    </div>
                    <input
                      data-v-6d6ea1ac=""
                      type="text"
                      class="BaseTextField__hiddenInput"
                      tabindex="-1"
                    />
                    <label
                      data-v-6d6ea1ac=""
                      class="BaseTextField BaseTextField--large"
                      ><!---->
                      <input
                        v-model="newEmail"
                        data-v-6d6ea1ac=""
                        id="email"
                        name="email"
                        type="text"
                        class="BaseTextField__input BaseTextField__input--left"
                        placeholder="이메일 주소"
                        autocomplete="off"
                      /><!---->
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
                        </div></button
                      ><!----></label
                    ><!---->
                  </div>
                </div>

                <!-- 인증메일 발송 -->
                <button
                  @click="sendChangeEmail"
                  data-v-524f63ea=""
                  data-v-7940d6dd=""
                  type="fill"
                  class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill shrink-0"
                  style="
                    background-color: rgb(107, 106, 106);
                    color: rgb(255, 255, 255);
                    height: 44px;
                    flex-direction: row;
                    --core-button-padding-x: 16;
                  "
                >
                  <!----><!---->
                  <div data-v-524f63ea="" class="inline-flex items-center">
                    <span data-v-524f63ea="" class="CoreButton__text"
                      >인증메일 발송</span
                    >
                  </div>
                </button>
              </div>
            </div>

            <!-- 인증요청 보내면 나오는 창 -->
            <div
              v-if="false"
              class="max-w-[500px] gray-f5--background gray-d9--text border-[1px] border-current px-[20px] py-[10px] mt-[10px]"
            >
              <p class="body1-regular-medium gray-333--text">
                <span class="navy-500--text">{{ newEmail }}</span> 로 인증메일을
                발송하였습니다.
              </p>
              <p class="body1-regular-medium gray-333--text">
                이메일에 포함된 이메일 주소 변경 완료 링크를 눌러 주세요.
              </p>
            </div>
          </div>
        </div>
      </div>
      <div
        class="flex border-t-[1px] gray-d9--text border-current last:border-b-[1px] border-line"
      >
        <div
          class="w-[80px] shrink-0 px-[10px] py-[12px] gray-f5--background gray-666--text body1-bold-medium flex items-center"
        >
          전화
        </div>
        <div class="px-[10px] py-[12px] w-full">
          <div>
            <div>
              <div class="flex items-center">
                <p class="mr-[8px] black--text body1-regular-medium">
                  {{ memberStore.member.cellphone }}
                </p>
                <button
                  data-v-524f63ea=""
                  data-v-7940d6dd=""
                  type="outline"
                  class="CoreButton BaseButtonRectangle body1-regular-small BaseButtonRectangle__outline"
                  style="
                    background-color: rgb(255, 255, 255);
                    color: rgb(51, 51, 51);
                    height: 36px;
                    flex-direction: row;
                    --core-button-padding-x: 8;
                    --button-rectangle-border-color: #acacac;
                  "
                >
                  <!----><!---->
                  <div data-v-524f63ea="" class="inline-flex items-center">
                    <span data-v-524f63ea="" class="CoreButton__text"
                      >변경하기</span
                    >
                  </div>
                </button>
              </div>
              <p class="gray-999--text mt-[8px] body1-regular-medium text-left">
                주문, 배송시 등록된 번호로 SMS를 발송해 드립니다.
              </p>
            </div>
            <!---->
          </div>
        </div>
      </div>

      <!-- TODO : 알림여부 설정  -->
      <!--      <div class="flex border-t-[1px] gray-d9&#45;&#45;text border-current last:border-b-[1px] border-line">-->
      <!--        <div-->
      <!--          class="w-[80px] shrink-0 px-[10px] py-[12px] gray-f5&#45;&#45;background gray-666&#45;&#45;text body1-bold-medium flex items-center">-->
      <!--          알림설정</div>-->
      <!--        <div class="px-[10px] py-[12px] w-full">-->
      <!--          <div>-->
      <!--            <p class="body1-regular-medium black&#45;&#45;text mb-[8px] text-left"> 할인쿠폰/이벤트/감동적인 뉴스레터를 받아보시겠습니까? </p>-->
      <!--            <div class="flex justify-start gap-x-[8px]"><label data-v-ee180726=""-->
      <!--                class="BaseCheckbox BaseCheckbox__size&#45;&#45;medium BaseCheckbox__verticalAlign&#45;&#45;center BaseCheckbox__state&#45;&#45;unChecked basis-0"-->
      <!--                style="&#45;&#45;BaseCheckbox&#45;&#45;label-margin: 4;">-->
      <!--                <div data-v-ee180726="" class="BaseCheckbox__wrapper"><input data-v-ee180726=""-->
      <!--                    class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726=""-->
      <!--                    class="BaseCheckbox__button"><svg data-v-6d2bd019="" data-v-ee180726="" width="24"-->
      <!--                      height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"-->
      <!--                      class="BaseIcon BaseCheckbox__icon"-->
      <!--                      style="width: 28px; height: 28px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #d9d9d9;">-->
      <!--                      <g clip-path="url(#clip0_2582_8708)">-->
      <!--                        <path fill-rule="evenodd" clip-rule="evenodd"-->
      <!--                          d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">-->
      <!--                        </path>-->
      <!--                      </g>-->
      <!--                      <defs>-->
      <!--                        <clipPath id="clip0_2582_8708">-->
      <!--                          <rect width="24" height="24"></rect>-->
      <!--                        </clipPath>-->
      <!--                      </defs>-->
      <!--                    </svg></span><span data-v-ee180726="" class="BaseCheckbox__text"-->
      <!--                    style="color: rgb(51, 51, 51);">SMS</span></div>-->
      <!--              </label><label data-v-ee180726=""-->
      <!--                class="BaseCheckbox BaseCheckbox__size&#45;&#45;medium BaseCheckbox__verticalAlign&#45;&#45;center BaseCheckbox__state&#45;&#45;unChecked"-->
      <!--                style="&#45;&#45;BaseCheckbox&#45;&#45;label-margin: 4;">-->
      <!--                <div data-v-ee180726="" class="BaseCheckbox__wrapper"><input data-v-ee180726=""-->
      <!--                    class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726=""-->
      <!--                    class="BaseCheckbox__button"><svg data-v-6d2bd019="" data-v-ee180726="" width="24"-->
      <!--                      height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"-->
      <!--                      class="BaseIcon BaseCheckbox__icon"-->
      <!--                      style="width: 28px; height: 28px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #d9d9d9;">-->
      <!--                      <g clip-path="url(#clip0_2582_8708)">-->
      <!--                        <path fill-rule="evenodd" clip-rule="evenodd"-->
      <!--                          d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">-->
      <!--                        </path>-->
      <!--                      </g>-->
      <!--                      <defs>-->
      <!--                        <clipPath id="clip0_2582_8708">-->
      <!--                          <rect width="24" height="24"></rect>-->
      <!--                        </clipPath>-->
      <!--                      </defs>-->
      <!--                    </svg></span><span data-v-ee180726="" class="BaseCheckbox__text"-->
      <!--                    style="color: rgb(51, 51, 51);">이메일</span></div>-->
      <!--              </label></div>-->
      <!--          </div>-->
      <!--        </div>-->
      <!--      </div>-->
    </div>
    <div class="flex justify-end items-center py-[16px]">
      <button
        @click="clickMemberDeleteBtn"
        data-v-524f63ea=""
        data-v-7940d6dd=""
        type="outline"
        class="CoreButton BaseButtonRectangle body1-regular-small BaseButtonRectangle__outline"
        style="
          background-color: rgb(255, 255, 255);
          color: rgb(51, 51, 51);
          height: 36px;
          flex-direction: row;
          --core-button-padding-x: 8;
          --button-rectangle-border-color: #acacac;
        "
      >
        <!----><!---->
        <div data-v-524f63ea="" class="inline-flex items-center">
          <span data-v-524f63ea="" class="CoreButton__text">회원탈퇴</span>
        </div>
      </button>

      <!-- 회원탈퇴시 모달 -->
      <div v-if="isModalVisible">
        <div data-v-60bedabc="" class="BaseDialog flex justify-center items-center fixed top-0 left-0"
             style="--dialog-footer: 64;">
          <div data-v-60bedabc="" class="BaseDialog__scrim"></div>
          <div data-v-60bedabc="" class="BaseDialog__wrapper--small--basic BaseDialog__container" tabindex="0"><!---->
            <div data-v-60bedabc="" class="BaseDialog__contents"><!---->
              <div data-v-60bedabc="" class="BaseDialog__contentsInner">
                <div class="px-[16px] pt-[24px] pb-[16px]">
                  <div class="text-center">
                    <h3 class="subtitle3-bold-medium mb-[10px] gray-333--text whitespace-pre-wrap">정말 탈퇴하시겠습니까?</h3>
                    <p class="body1-regular-medium gray-666--text whitespace-pre-line"> 보유하신 포인트와 등급 혜택이 모두 삭제됩니다.
                    </p>
                  </div>
                </div>
              </div>
            </div>


            <div data-v-60bedabc=""
                 class="px-[16px] flex justify-center shrink-0 overflow-y-auto BaseDialog__footer pt-[8px] pb-[16px]">

              <!-- 확인 버튼 -->
              <div data-v-60bedabc="" class="grow BaseDialog__footerWrapper--fixed">
                <div>
                  <button @click="clickConfirmBtn" data-v-524f63ea="" data-v-7940d6dd="" type="fill"
                          class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__fill"
                          style="background-color: rgb(27, 27, 27); color: rgb(255, 255, 255); height: 40px; flex-direction: row; --core-button-padding-x: 16; width: 95%">
                    <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">확인</span></div>
                  </button>
                </div>
              </div>

              <!-- 취소 버튼 -->
              <div data-v-60bedabc="" class="grow BaseDialog__footerWrapper--fixed">
                <div>
                  <button @click="clickCancelBtn" data-v-524f63ea="" data-v-7940d6dd="" type="fill"
                          class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__fill"
                          style="background-color: rgb(107,106,106); color: rgb(255, 255, 255); height: 40px; flex-direction: row; --core-button-padding-x: 16; width: 95%">
                    <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">취소</span></div>
                  </button>
                </div>
              </div>
            </div>



          </div>
        </div><!---->
        <div class="BaseSnackbar__fadeOut !hidden BaseSnackbar" data-v-ac6313c6="">
          <div class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]" data-v-ac6313c6=""><!---->
            <div class="body1-regular-medium line-clamp-2 whitespace-pre-line" data-v-ac6313c6=""></div><!---->
          </div>
        </div>
      </div>

    </div>
    <div class="flex justify-center items-center pb-[16px]">
      <button
        @click="updateMemberInfo"
        data-v-524f63ea=""
        data-v-7940d6dd=""
        type="fill"
        class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill"
        style="
          background-color: #000;
          color: rgb(255, 255, 255);
          height: 44px;
          flex-direction: row;
          --core-button-padding-x: 16;
        "
      >
        <!----><!---->
        <div data-v-524f63ea="" class="inline-flex items-center">
          <span data-v-524f63ea="" class="CoreButton__text"
            >회원정보 수정하기</span
          >
        </div>
      </button>
    </div>
  </div>
</template>
    
<script>
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";
import swal from 'sweetalert2';

export default {
  name: "UpdateMemberInfoComponent",
  data() {
    return {

      isModalVisible : false,

      newMemberInfo: {
        nickname: "",
        // email : this.memberStore.member.email,
        // cellphone : this.memberStore.member.cellphone,
      },
      newEmail: "",
      openChangeBtnText: "변경하기",
    };
  },
  mounted() {
    this.newMemberInfo.nickname = this.memberStore.member.nickname;
  },
  computed: {
    ...mapStores(useMemberStore),
  },
  methods: {
    showSuccessAlert(content) {
      swal.fire({
        title: "Success!",
        text: content,
        icon: "success",
      });
    },
    openChangeBtn() {
      if (this.openChangeBtnText === "변경하기") {
        this.openChangeBtnText = "취소하기";
      } else {
        this.openChangeBtnText = "변경하기";
      }
    },
    sendChangeEmail() {
      this.showSuccessAlert(
        this.newEmail +
          "로 인증메일을 발송하였습니다.\n" +
          "이메일에 포함된 이메일 주소 변경 완료 링크를 눌러 주세요."
      );
    },
    clickMemberDeleteBtn(){
      this.isModalVisible = true;
    },
    async clickConfirmBtn(){

      let response = await this.memberStore.deleteMember();
      this.isModalVisible = false;

      alert(response);
    },
    clickCancelBtn(){
      this.isModalVisible = false;
    },

    async updateMemberInfo() {
      let response = await this.memberStore.updateMemberInfo(
        this.newMemberInfo
      );
      if (response.status === 200) {
        alert("회원 정보가 수정되었습니다.");
        window.location.href = "/update/member-info";
      }
    },
  },
};
</script>

<style scoped>
.border-line {
  border: 1px solid #e5e7eb;
}
.text-left {
  text-align: left;
}
</style>