<template>
    <body>
        <div id="__nuxt">
            <div class="appContainer" style="--container-width:1040px;--app-bar-height:0px;">
                <div class="TheContainer" data-v-26a5ae18="">
                    <div class="appContents">
                        <div>
                            <div class="grid-cols-12 gap-[8px] grid">
                                <div class="col-start-4 col-span-6">
                                    <div class="pb-[48px]">
                                        <div>
                                            <div data-v-ef34c959="" class="grid-cols-1 gap-[0px] grid JoinForm">
                                              <div>
                                              <img class="medium flex justify-self-center mt-[20px] mb-[48px] cursor-pointer" src="@/assets/cgb.png" />
<!--                                                <div data-v-e70698af="" data-v-ef34c959="" class="BaseLogo BaseLogo__en BaseLogo__en&#45;&#45;default BaseLogo__en&#45;&#45;medium flex justify-self-center mt-[20px] mb-[48px] cursor-pointer">-->
                                                </div> <!-- 로고 -->
                                                <div data-v-343d1a74="" data-v-ef34c959="" class="BaseTextSideBar mb-[48px] gray-333--text">
                                                    <div data-v-343d1a74="" class="BaseTextSideBar__contents">
                                                        <div data-v-343d1a74="" class="BaseTextSideBar__text body1-regular-medium text-center">
                                                            아주 간단한 회원가입하기
                                                        </div>
                                                    </div>
                                                </div>
                                                <div data-v-f410f0e2="" data-v-ef34c959="" class="BaseStepper body1-regular-small text-center">
                                                    <div data-v-f410f0e2="" class="BaseStepper__stepWrap inline-flex mb-[10px]">
                                                        <div data-v-f410f0e2="" class="BaseStepper__step inline-flex items-center justify-center ml-[48px] first-of-type:ml-0">
                                                            1
                                                        </div>
                                                        <div data-v-f410f0e2="" class="BaseStepper__step--active BaseStepper__step inline-flex items-center justify-center ml-[48px] first-of-type:ml-0">
                                                            2
                                                        </div>
                                                    </div>
                                                    <div data-v-f410f0e2="" class="BaseStepper__text gray-333--text subtitle2-regular-medium mb-[30px]">가입 정보 입력하기
                                                    </div>
                                                </div>


                                                <!-- 이메일 입력  -->
                                                <div data-v-ef34c959="" class="mt-[20px]">
                                                    <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                                                        <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText">
                                                            <span data-v-e2593c18="" class="BaseLabelText__text">이메일</span>
                                                            <span data-v-e2593c18="" class="BaseLabelText__mark">*</span>
                                                        </div>
                                                        <label data-v-6d6ea1ac="" :class="validations.emailValid === true? 'BaseTextField BaseTextField--large signupPadding' : 'BaseTextField BaseTextField--error signupPadding'">

                                                          <input :disabled="!activeEmailInput" v-model="email" @input="validateEmail" data-v-6d6ea1ac="" id="email" name="email" type="text" class="BaseTextField__input BaseTextField__input--left" placeholder="이메일을 입력해주세요." autocomplete="off">
                                                            <!-- 인증요청 버튼 -->
                                                            <div data-v-bb461e2b="" class="PhoneAuth__button ml-[6px]">
                                                                <button @click="sendEmailRequest" data-v-524f63ea="" data-v-7940d6dd="" data-v-bb461e2b="" type="fill"
                                                                :class="validations.emailValid === true && activeBtn === true ?
                                                                'CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill' :
                                                                'CoreButton CoreButton--disabled CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill BaseButtonRectangle--disabled'"
                                                                :disabled ="!activeBtn"
                                                                style="background-color: rgb(239, 112, 20); height: 44px; flex-direction: row; --core-button-padding-x: 16; color: rgb(255, 255, 255)"
                                                                        >
                                                                    <div data-v-524f63ea="" class="inline-flex items-center">
                                                                        <span data-v-524f63ea="" class="CoreButton__text">인증요청
                                                                        </span>
                                                                    </div>
                                                                </button>
                                                            </div>
                                                        </label>
                                                      <!-- 이메일 검증 안내 메시지-->
                                                      <div v-if="!validations.emailValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                        <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                          <div data-v-86c06fc2="" class="inline-flex items-center">유효하지 않은 이메일입니다.</div>
                                                        </div><!---->
                                                      </div>


                                                        <!-- 인증코드 입력 창 -->
                                                        <div v-if="showVerification" data-v-bb461e2b="" class="flex uuidInput">
                                                            <div data-v-bb461e2b="" class="grow">
                                                                <div data-v-bb461e2b="">
                                                                    <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                                                                        <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText" style="display: none;">
                                                                            <span data-v-e2593c18="" class="BaseLabelText__text"></span>
                                                                            
                                                                        </div><input data-v-6d6ea1ac="" type="text" class="BaseTextField__hiddenInput" tabindex="-1">
                                                                        <label data-v-6d6ea1ac="" class="BaseTextField BaseTextField--large">
                                                                            <input :disabled="!activeEmailInput" v-model="uuid" data-v-6d6ea1ac="" id="code" name="formFieldCode" type="text" class="BaseTextField__input BaseTextField__input--left" placeholder="인증코드를 입력해주세요." maxlength="6">
                                                                            <span data-v-6d6ea1ac="" class="BaseTextField__suffixText">
                                                                                <span data-v-bb461e2b="" class="body1-bold-small">
                                                                                </span>
                                                                            </span>
                                                                        </label>
                                                                        
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div data-v-bb461e2b="" class="PhoneAuth__button ml-[6px]">
                                                                <button id="uuidButton" @click="sendUuidRequest" data-v-524f63ea="" data-v-7940d6dd="" data-v-bb461e2b="" type="outline" 
                                                                :disabled="!activeBtn"
                                                                class="CoreButton  CoreButton--block BaseButtonRectangle subtitle3-bold-small 
                                                                BaseButtonRectangle__outline BaseButtonRectangle--disabled" 
                                                                :class="activeBtn === true ? 'CoreButton' : 'corebutton-disable'"
                                                                style="background-color: rgb(255, 255, 255); height: 44px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #acacac;"
                                                                >
                                                                    <div data-v-524f63ea="" class="inline-flex items-center">
                                                                        <span data-v-524f63ea="" class="CoreButton__text">확인
                                                                        </span>
                                                                    </div>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>


                                                <!-- 비밀번호  -->
                                                <!-- 영문 + 숫자 8자 -->
                                                <div data-v-056d7ed4="" data-v-ef34c959="" class="mt-[20px] mb-[6px]">
                                                    <div data-v-1d2c5c78="" data-v-056d7ed4="" class="BaseTextFieldPassword">
                                                        <div data-v-6d6ea1ac="" data-v-1d2c5c78="" class="BaseTextField__container">
                                                            <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText">
                                                                <span data-v-e2593c18="" class="BaseLabelText__text">비밀번호
                                                                </span>
                                                                <span data-v-e2593c18="" class="BaseLabelText__mark">*
                                                                </span>
                                                            </div>
                                                            <input data-v-6d6ea1ac="" type="text" class="BaseTextField__hiddenInput" tabindex="-1">
                                                            <label data-v-6d6ea1ac="" :class="validations.passwordValid === true? 'BaseTextField BaseTextField--large' : 'BaseTextField BaseTextField--large BaseTextField--error '">

                                                                <input v-model="password" @input="validatePassword" data-v-6d6ea1ac="" id="password" name="password" :type="showPassword ? 'text' : 'password'" class="BaseTextField__input BaseTextField__input--left" placeholder="비밀번호 (영문+숫자 8자 이상)" autocomplete="new-password">
                                                                <!-- hidden 상태 -->
                                                                <button v-if=!showPassword @click="clickShowPassword" data-v-524f63ea="" data-v-778c1d9b="" data-v-6d6ea1ac="" type="button" class="CoreButton BaseButtonIcon ml-[8px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 24px; flex-direction: column;">
                                                                    <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                        <g clip-path="url(#clip0_124_2987)">
                                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M20.4697 21.5303L16.6629 17.7228C15.186 18.3486 13.5768 18.7499 12 18.7499C6.80076 18.7499 1.25 14.3882 1.25 11.9999C1.25 10.578 3.21929 8.45577 5.91005 6.97161L2.46967 3.53027L3.46967 2.53027L21.4697 20.5303L21.5303 20.4696L20.4697 21.5303ZM6.988 8.04857C6.3688 8.38198 5.77567 8.77319 5.21375 9.21466C4.82783 9.51786 4.46591 9.84506 4.14453 10.1658L3.91134 10.4047L3.6436 10.6955L3.5811 10.7663L3.52048 10.8361L3.29766 11.1041L3.24711 11.1679L3.19871 11.2302L3.02762 11.4628L2.89479 11.6649C2.80089 11.8191 2.75 11.9356 2.75 11.9999C2.75 12.103 2.88021 12.3395 3.10841 12.65L3.19851 12.7698L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3221 9.50335 17.2499 12 17.2499C13.2315 17.2499 14.4236 17.0241 15.5503 16.6108L14.0678 15.1288C13.475 15.5213 12.7642 15.7499 12 15.7499C9.92893 15.7499 8.25 14.071 8.25 11.9999C8.25 11.2357 8.47859 10.5249 8.87113 9.93215L6.988 8.04857ZM12 5.24994C17.197 5.24994 22.75 9.61314 22.75 11.9999C22.75 13.193 21.3639 14.8791 19.3283 16.2677L18.2474 15.1866C18.4303 15.0578 18.6103 14.9238 18.7871 14.7848C18.9479 14.6585 19.1044 14.528 19.2556 14.3956L19.4783 14.1957L19.7952 13.894C19.9312 13.76 20.0603 13.6269 20.1813 13.4968L20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4004 21.25 12.1156 21.25 11.9999C21.25 11.8858 21.0891 11.6066 20.8117 11.2442L20.7023 11.1045L20.4794 10.8365L20.2259 10.5519C19.8241 10.1153 19.3288 9.64145 18.7862 9.21509C16.8299 7.67795 14.4954 6.74994 12 6.74994C11.3233 6.74994 10.6584 6.81817 10.0097 6.94826L8.80638 5.74634C9.85184 5.43366 10.9334 5.24994 12 5.24994ZM9.96949 11.0294C9.82879 11.3233 9.75 11.6524 9.75 11.9999C9.75 13.2426 10.7574 14.2499 12 14.2499C12.3473 14.2499 12.6761 14.1713 12.9698 14.0308L9.96949 11.0294ZM12 8.24994C14.0711 8.24994 15.75 9.92887 15.75 11.9999C15.75 12.2162 15.7317 12.4283 15.6965 12.6345L13.9649 10.903C13.7612 10.5389 13.4593 10.2372 13.095 10.0339L11.365 8.30349C11.5714 8.26828 11.7835 8.24994 12 8.24994Z"></path></g><defs><clippath id="clip0_124_2987"><rect width="24" height="24"></rect></clippath></defs></svg>
                                                                    <div data-v-524f63ea="" class="inline-flex items-center"></div>                                                        
                                                                </button>
                                                                <!-- visible 상태 -->
                                                                <button v-else @click="clickShowPassword" data-v-524f63ea="" data-v-778c1d9b="" data-v-6d6ea1ac="" type="button" class="CoreButton BaseButtonIcon ml-[8px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 24px; flex-direction: column;">
                                                                    <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                        <g clip-path="url(#clip0_124_3015)">
                                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M12 5.25C17.197 5.25 22.75 9.6132 22.75 12C22.75 14.3875 17.1988 18.75 12 18.75C6.80076 18.75 1.25 14.3883 1.25 12C1.25 9.61239 6.80263 5.25 12 5.25ZM12 6.75C9.50447 6.75 7.16994 7.67785 5.21375 9.21471C4.73134 9.59371 4.28645 10.0102 3.91134 10.4047L3.6436 10.6956C3.60132 10.7431 3.56026 10.79 3.52048 10.8362L3.29766 11.1042C3.26325 11.1472 3.23025 11.1892 3.19871 11.2302L3.02762 11.4629L2.89479 11.665C2.80089 11.8191 2.75 11.9356 2.75 12C2.75 12.1159 2.9148 12.4008 3.19851 12.7699L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3222 9.50335 17.25 12 17.25C14.4965 17.25 16.8312 16.322 18.7871 14.7849C19.0282 14.5954 19.26 14.3966 19.4783 14.1958L19.7952 13.894C19.9991 13.6931 20.1876 13.494 20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4005 21.25 12.1157 21.25 12C21.25 11.8715 21.0464 11.5343 20.7023 11.1046L20.4794 10.8366L20.2259 10.552C19.8241 10.1154 19.3288 9.64151 18.7862 9.21515C16.8299 7.678 14.4954 6.75 12 6.75ZM12 8.25C14.0711 8.25 15.75 9.92893 15.75 12C15.75 14.0711 14.0711 15.75 12 15.75C9.92893 15.75 8.25 14.0711 8.25 12C8.25 9.92893 9.92893 8.25 12 8.25ZM12 9.75C10.7574 9.75 9.75 10.7574 9.75 12C9.75 13.2426 10.7574 14.25 12 14.25C13.2426 14.25 14.25 13.2426 14.25 12C14.25 10.7574 13.2426 9.75 12 9.75Z"></path></g><defs><clipPath id="clip0_124_3015"><rect width="24" height="24"></rect></clipPath></defs></svg>
                                                                    <div data-v-524f63ea="" class="inline-flex items-center"><!----></div>
                                                                </button>
                                                            </label>                                                        
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- 비밀번호 검증 안내 메시지-->
                                                <div v-if="!validations.passwordValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                  <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                    <div data-v-86c06fc2="" class="inline-flex items-center">유효하지 않은 비밀번호입니다.</div>
                                                  </div><!---->
                                                </div>


                                                <!-- 비밀번호 확인 -->
                                                <div data-v-056d7ed4="" data-v-ef34c959="">
                                                    <div data-v-1d2c5c78="" data-v-056d7ed4="" class="BaseTextFieldPassword">
                                                        <div data-v-6d6ea1ac="" data-v-1d2c5c78="" class="BaseTextField__container">
                                                            <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText" style="display: none;">
                                                                <span data-v-e2593c18="" class="BaseLabelText__text"></span>
                                                            </div>
<!--                                                            <input data-v-6d6ea1ac="" type="text" class="BaseTextField__hiddenInput" tabindex="-1">-->
                                                            <label data-v-6d6ea1ac="" :class="validations.confirmPasswordValid === true? 'BaseTextField BaseTextField--large' : 'BaseTextField BaseTextField--large BaseTextField--error'">
                                                                <input v-model="confirmPassword" @input="validConfirmPassword" data-v-6d6ea1ac="" id="passwordConfirm" name="passwordConfirm" :type="showPasswordConfirm ? 'text' : 'password'" class="BaseTextField__input BaseTextField__input--left" placeholder="비밀번호 확인">
                                                                
                                                                <!-- hidden 상태 -->
                                                                <button v-if=!showPasswordConfirm @click="clickShowPasswordConfirm" data-v-524f63ea="" data-v-778c1d9b="" data-v-6d6ea1ac="" type="button" class="CoreButton BaseButtonIcon ml-[8px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 24px; flex-direction: column;">
                                                                    <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                        <g clip-path="url(#clip0_124_2987)">
                                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M20.4697 21.5303L16.6629 17.7228C15.186 18.3486 13.5768 18.7499 12 18.7499C6.80076 18.7499 1.25 14.3882 1.25 11.9999C1.25 10.578 3.21929 8.45577 5.91005 6.97161L2.46967 3.53027L3.46967 2.53027L21.4697 20.5303L21.5303 20.4696L20.4697 21.5303ZM6.988 8.04857C6.3688 8.38198 5.77567 8.77319 5.21375 9.21466C4.82783 9.51786 4.46591 9.84506 4.14453 10.1658L3.91134 10.4047L3.6436 10.6955L3.5811 10.7663L3.52048 10.8361L3.29766 11.1041L3.24711 11.1679L3.19871 11.2302L3.02762 11.4628L2.89479 11.6649C2.80089 11.8191 2.75 11.9356 2.75 11.9999C2.75 12.103 2.88021 12.3395 3.10841 12.65L3.19851 12.7698L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3221 9.50335 17.2499 12 17.2499C13.2315 17.2499 14.4236 17.0241 15.5503 16.6108L14.0678 15.1288C13.475 15.5213 12.7642 15.7499 12 15.7499C9.92893 15.7499 8.25 14.071 8.25 11.9999C8.25 11.2357 8.47859 10.5249 8.87113 9.93215L6.988 8.04857ZM12 5.24994C17.197 5.24994 22.75 9.61314 22.75 11.9999C22.75 13.193 21.3639 14.8791 19.3283 16.2677L18.2474 15.1866C18.4303 15.0578 18.6103 14.9238 18.7871 14.7848C18.9479 14.6585 19.1044 14.528 19.2556 14.3956L19.4783 14.1957L19.7952 13.894C19.9312 13.76 20.0603 13.6269 20.1813 13.4968L20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4004 21.25 12.1156 21.25 11.9999C21.25 11.8858 21.0891 11.6066 20.8117 11.2442L20.7023 11.1045L20.4794 10.8365L20.2259 10.5519C19.8241 10.1153 19.3288 9.64145 18.7862 9.21509C16.8299 7.67795 14.4954 6.74994 12 6.74994C11.3233 6.74994 10.6584 6.81817 10.0097 6.94826L8.80638 5.74634C9.85184 5.43366 10.9334 5.24994 12 5.24994ZM9.96949 11.0294C9.82879 11.3233 9.75 11.6524 9.75 11.9999C9.75 13.2426 10.7574 14.2499 12 14.2499C12.3473 14.2499 12.6761 14.1713 12.9698 14.0308L9.96949 11.0294ZM12 8.24994C14.0711 8.24994 15.75 9.92887 15.75 11.9999C15.75 12.2162 15.7317 12.4283 15.6965 12.6345L13.9649 10.903C13.7612 10.5389 13.4593 10.2372 13.095 10.0339L11.365 8.30349C11.5714 8.26828 11.7835 8.24994 12 8.24994Z"></path></g><defs><clippath id="clip0_124_2987"><rect width="24" height="24"></rect></clippath></defs></svg>
                                                                    <div data-v-524f63ea="" class="inline-flex items-center"></div>                                                        
                                                                </button>
                                                                <!-- visible 상태 -->
                                                                <button v-else @click="clickShowPasswordConfirm" data-v-524f63ea="" data-v-778c1d9b="" data-v-6d6ea1ac="" type="button" class="CoreButton BaseButtonIcon ml-[8px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 24px; flex-direction: column;">
                                                                    <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                        <g clip-path="url(#clip0_124_3015)">
                                                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M12 5.25C17.197 5.25 22.75 9.6132 22.75 12C22.75 14.3875 17.1988 18.75 12 18.75C6.80076 18.75 1.25 14.3883 1.25 12C1.25 9.61239 6.80263 5.25 12 5.25ZM12 6.75C9.50447 6.75 7.16994 7.67785 5.21375 9.21471C4.73134 9.59371 4.28645 10.0102 3.91134 10.4047L3.6436 10.6956C3.60132 10.7431 3.56026 10.79 3.52048 10.8362L3.29766 11.1042C3.26325 11.1472 3.23025 11.1892 3.19871 11.2302L3.02762 11.4629L2.89479 11.665C2.80089 11.8191 2.75 11.9356 2.75 12C2.75 12.1159 2.9148 12.4008 3.19851 12.7699L3.40476 13.0275L3.64322 13.3045C4.06581 13.7793 4.61001 14.3116 5.21285 14.7853C7.16867 16.3222 9.50335 17.25 12 17.25C14.4965 17.25 16.8312 16.322 18.7871 14.7849C19.0282 14.5954 19.26 14.3966 19.4783 14.1958L19.7952 13.894C19.9991 13.6931 20.1876 13.494 20.3567 13.3041L20.5952 13.0271L20.8014 12.7695C21.0852 12.4005 21.25 12.1157 21.25 12C21.25 11.8715 21.0464 11.5343 20.7023 11.1046L20.4794 10.8366L20.2259 10.552C19.8241 10.1154 19.3288 9.64151 18.7862 9.21515C16.8299 7.678 14.4954 6.75 12 6.75ZM12 8.25C14.0711 8.25 15.75 9.92893 15.75 12C15.75 14.0711 14.0711 15.75 12 15.75C9.92893 15.75 8.25 14.0711 8.25 12C8.25 9.92893 9.92893 8.25 12 8.25ZM12 9.75C10.7574 9.75 9.75 10.7574 9.75 12C9.75 13.2426 10.7574 14.25 12 14.25C13.2426 14.25 14.25 13.2426 14.25 12C14.25 10.7574 13.2426 9.75 12 9.75Z"></path></g><defs><clipPath id="clip0_124_3015"><rect width="24" height="24"></rect></clipPath></defs></svg>
                                                                    <div data-v-524f63ea="" class="inline-flex items-center"></div>
                                                                </button>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- 비밀번호 확인 검증 안내 메시지-->
                                                <div v-if="!validations.confirmPasswordValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                  <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                    <div data-v-86c06fc2="" class="inline-flex items-center">비밀번호가 일치하지 않습니다.</div>
                                                  </div><!---->
                                                </div>


                                                <!-- 닉네임  -->
                                                <div data-v-ef34c959="" class="mt-[20px]">
                                                    <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                                                        <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText">
                                                            <span data-v-e2593c18="" class="BaseLabelText__text">닉네임
                                                            </span>
                                                            <span data-v-e2593c18="" class="BaseLabelText__mark">*
                                                            </span>
                                                        </div>
                                                        <input data-v-6d6ea1ac="" type="text" class="BaseTextField__hiddenInput" tabindex="-1">
                                                        <label data-v-6d6ea1ac="" :class="validations.nicknameValid === true? 'BaseTextField BaseTextField--large' : 'BaseTextField BaseTextField--large BaseTextField--error'">
                                                            <input v-model="nickname" @input="validNickname" data-v-6d6ea1ac="" id="nickname" name="nickname" type="text" class="BaseTextField__input BaseTextField__input--left" placeholder="닉네임을 입력해주세요.">
                                                        </label>                                                        
                                                    </div>
                                                </div>
                                                <!-- 닉네임 확인 검증 안내 메시지-->
                                                <div v-if="!validations.nicknameValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                  <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                    <div data-v-86c06fc2="" class="inline-flex items-center">닉네임은 필수입니다.</div>
                                                  </div><!---->
                                                </div>

                                                <!-- 생년월일  -->
                                                <!-- TODO : select box 로 바꿀것-->
                                                <div data-v-e2593c18="" data-v-ef34c959="" class="BaseLabelText mt-[20px]"><span data-v-e2593c18="" class="BaseLabelText__text">생년월일</span><span data-v-e2593c18="" class="BaseLabelText__mark">*</span></div>
                                                <div data-v-bb461e2b="" data-v-ef34c959="" class="grid-cols-1 gap-[0px] grid PhoneAuth" login-type="LoginUserTypeEmail">
                                                    <div data-v-bb461e2b="" class="flex">
                                                        <div data-v-bb461e2b="" class="grow">
                                                            <div data-v-bb461e2b="">
                                                                <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                                                                    <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText" style="display: none;">
                                                                        <span data-v-e2593c18="" class="BaseLabelText__text"></span>
                                                                    </div>
                                                                    <label data-v-6d6ea1ac="" :class="validations.birthdayValid === true? 'BaseTextField BaseTextField--large' : 'BaseTextField BaseTextField--large BaseTextField--error'">
                                                                        <input v-model="birthday" @input="validBirthday" data-v-6d6ea1ac="" id="phone" name="formFieldPhone" type="text" class="BaseTextField__input BaseTextField__input--left" placeholder="- 를 포함해서 입력해주세요." maxlength="10">
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- 생년월일 검증 안내 메시지-->
                                                <div v-if="!validations.birthdayValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                  <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                    <div data-v-86c06fc2="" class="inline-flex items-center">YYYY-MM-DD 형식이 올바르지 않습니다.</div>
                                                  </div><!---->
                                                </div>

                                                <!-- 전화번호  -->
                                                <div data-v-e2593c18="" data-v-ef34c959="" class="BaseLabelText mt-[20px]"><span data-v-e2593c18="" class="BaseLabelText__text">전화번호</span><span data-v-e2593c18="" class="BaseLabelText__mark">*</span></div>
                                                <div data-v-bb461e2b="" data-v-ef34c959="" class="grid-cols-1 gap-[0px] grid PhoneAuth" login-type="LoginUserTypeEmail">
                                                    <div data-v-bb461e2b="" class="flex">
                                                        <div data-v-bb461e2b="" class="grow">
                                                            <div data-v-bb461e2b="">
                                                                <div data-v-6d6ea1ac="" class="BaseTextField__container" showerrormessage="true">
                                                                    <div data-v-e2593c18="" data-v-6d6ea1ac="" class="BaseLabelText" style="display: none;">
                                                                        <span data-v-e2593c18="" class="BaseLabelText__text"></span>
                                                                    </div>
                                                                    <label data-v-6d6ea1ac="" :class="validations.cellPhoneValid === true ? 'BaseTextField BaseTextField--large' : 'BaseTextField BaseTextField--large BaseTextField--error'">
                                                                        <input v-model="cellPhone" @input="validCellPhone" data-v-6d6ea1ac="" id="phone" name="formFieldPhone" type="text" class="BaseTextField__input BaseTextField__input--left" placeholder="- 를 포함해서 입력해주세요." maxlength="13">
                                                                    </label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>      
                                                </div>

                                                <!-- 전화번호 검증 안내 메시지-->
                                                <div v-if="!validations.cellPhoneValid" data-v-6d6ea1ac="" class="BaseTextField__assistiveArea">
                                                  <div data-v-86c06fc2="" data-v-6d6ea1ac="" class="BaseTextHelper BaseTextHelper--error"><!---->
                                                    <div data-v-86c06fc2="" class="inline-flex items-center">xxx-xxxx-xxxx 형식이 올바르지 않습니다.</div>
                                                  </div><!---->
                                                </div>
                                                
                                                <!-- 동의 여부 체크박스(모두 동의합니다) -->
                                                <div data-v-ef34c959="" class="mt-[20px] mb-[20px]"></div>
                                                <label data-v-ee180726="" data-v-ef34c959="" for="agreeAll" :class="agreeAll ? 'BaseCheckbox__state--checked' : 'BaseCheckbox__state--unChecked'" class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center &#39;h-[32px]&#39;" style="--BaseCheckbox--label-margin: 4;">
                                                    <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                        <input @click="checkAgreeAll" v-model="agreeAll" data-v-ee180726="" id="agreeAll" name="agreeAll" class="BaseCheckbox__input" type="checkbox">
                                                            <span data-v-ee180726="" class="BaseCheckbox__button">
                                                              <svg data-v-6d2bd019="" data-v-ee180726="" :style="agreeAll ? '--BaseIcon-color: #ffffff' : '--BaseIcon-color: #d9d9d9'" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor;">
                                                                <g clip-path="url(#clip0_2582_8708)"><path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z"></path></g>
                                                                <defs>
                                                                    <clippath id="clip0_2582_8708">
                                                                        <rect width="24" height="24"></rect>
                                                                    </clippath>
                                                                </defs>
                                                            </svg>
                                                        </span>
                                                            <span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">모두 동의합니다.</span></div>
                                                </label>


                                                <hr data-v-ef34c959="" class="my-[8px]">

                                                <label data-v-ee180726="" data-v-ef34c959="" :class="agreeAge ? 'BaseCheckbox__state--checked' : 'BaseCheckbox__state--unChecked'" for="agreeAge" class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked h-[36px]" style="--BaseCheckbox--label-margin: 4;">
                                                    <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                      <input data-v-ee180726="" @click="checkAgreeAge" id="agreeAge" name="agreeAge" class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726="" class="BaseCheckbox__button">
                                                      <svg data-v-6d2bd019="" data-v-ee180726="" :style="agreeAge ? '--BaseIcon-color: #ffffff' : '--BaseIcon-color: #d9d9d9'" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                                                <g clip-path="url(#clip0_2582_8708)">
                                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                                    </path>
                                                                </g>
                                                                <defs>
                                                                    <clippath id="clip0_2582_8708">
                                                                        <rect width="24" height="24"></rect>
                                                                    </clippath>
                                                                </defs>
                                                            </svg></span><span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">[필수] 만 14세 이상입니다.</span></div>
                                                </label>


                                                <div data-v-ef34c959="" class="flex h-[36px]">
                                                    <label data-v-ee180726="" data-v-ef34c959="" :class="agreePolicyService ? 'BaseCheckbox__state--checked' : 'BaseCheckbox__state--unChecked'" for="agreePolicyService" class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked grow" style="--BaseCheckbox--label-margin: 4;">
                                                        <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                          <input data-v-ee180726="" @click="checkAgreePolicyService" id="agreePolicyService" name="agreePolicyService" class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726="" class="BaseCheckbox__button">
                                                          <svg data-v-6d2bd019="" data-v-ee180726="" :style="agreePolicyService ? '--BaseIcon-color: #ffffff' : '--BaseIcon-color: #d9d9d9'" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                                                    <g clip-path="url(#clip0_2582_8708)">
                                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                                        </path>
                                                                    </g>
                                                                    <defs>
                                                                        <clippath id="clip0_2582_8708">
                                                                            <rect width="24" height="24"></rect>
                                                                        </clippath>
                                                                    </defs>
                                                                </svg></span><span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">[필수] 이용약관 동의</span></div>
                                                    </label>
                                                    <button data-v-524f63ea="" data-v-8493c3f2="" data-v-ef34c959="" type="default" class="CoreButton BaseButtonText body1-regular-small min-w-[42px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 32px; flex-direction: row-reverse; --core-button-padding-x: 8;">
                                                        <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">보기</span></div>
                                                    </button></div>


                                                <div data-v-ef34c959="" class="flex h-[36px]">
                                                    <label data-v-ee180726="" data-v-ef34c959="" for="agreePolicyPrivacy" :class="agreePolicyPrivacy ? 'BaseCheckbox__state--checked' : 'BaseCheckbox__state--unChecked'" class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked grow" style="--BaseCheckbox--label-margin: 4;">
                                                        <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                          <input data-v-ee180726="" @click="checkAgreePolicyPrivacy" id="agreePolicyPrivacy" name="agreePolicyPrivacy" class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726="" class="BaseCheckbox__button">
                                                          <svg data-v-6d2bd019="" data-v-ee180726="" :style="agreePolicyPrivacy ? '--BaseIcon-color: #ffffff' : '--BaseIcon-color: #d9d9d9'" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                                                    <g clip-path="url(#clip0_2582_8708)">
                                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                                        </path>
                                                                    </g>
                                                                    <defs>
                                                                        <clippath id="clip0_2582_8708">
                                                                            <rect width="24" height="24"></rect>
                                                                        </clippath>
                                                                    </defs>
                                                                </svg></span><span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">[필수] 개인정보 수집 및 이용 동의</span></div>
                                                    </label>
                                                    <button data-v-524f63ea="" data-v-8493c3f2="" data-v-ef34c959="" type="default" class="CoreButton BaseButtonText body1-regular-small min-w-[42px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 32px; flex-direction: row-reverse; --core-button-padding-x: 8;">

                                                        <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">보기</span></div>
                                                    </button></div>


<!--                                                <div data-v-ef34c959="" class="flex h-[36px]"><label data-v-ee180726="" data-v-ef34c959="" class="BaseCheckbox BaseCheckbox__size&#45;&#45;small BaseCheckbox__verticalAlign&#45;&#45;center BaseCheckbox__state&#45;&#45;unChecked" style="&#45;&#45;BaseCheckbox&#45;&#45;label-margin: 4;">-->
<!--                                                        <div data-v-ee180726="" class="BaseCheckbox__wrapper"><input data-v-ee180726="" class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726="" class="BaseCheckbox__button"><svg data-v-6d2bd019="" data-v-ee180726="" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; &#45;&#45;BaseIcon-color: #d9d9d9;">-->
<!--                                                                    <g clip-path="url(#clip0_2582_8708)">-->
<!--                                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">-->
<!--                                                                        </path>-->
<!--                                                                    </g>-->
<!--                                                                    <defs>-->
<!--                                                                        <clippath id="clip0_2582_8708">-->
<!--                                                                            <rect width="24" height="24"></rect>-->
<!--                                                                        </clippath>-->
<!--                                                                    </defs>-->
<!--                                                                </svg></span><span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">[선택] 개인정보 수집 및 이용 동의</span></div>-->
<!--                                                    </label>-->
<!--                                                    <button data-v-524f63ea="" data-v-8493c3f2="" data-v-ef34c959="" type="default" class="CoreButton BaseButtonText body1-regular-small min-w-[42px]" style="background-color: transparent; color: rgb(102, 102, 102); height: 32px; flex-direction: row-reverse; &#45;&#45;core-button-padding-x: 8;">-->
<!--                                                          <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">보기</span></div>-->
<!--                                                    </button>-->
<!--                                                </div>-->


                                                <div data-v-ef34c959="" class="flex flex-col">
                                                  <label data-v-ee180726="" data-v-ef34c959="" for="agreeMarketingBenefit" :class="agreeMarketingBenefit ? 'BaseCheckbox__state--checked' : 'BaseCheckbox__state--unChecked'" class="BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked" style="--BaseCheckbox--label-margin: 4;">
                                                        <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                          <input data-v-ee180726="" @click="checkAgreeMarketingBenefit" id="agreeMarketingBenefit" name="agreeMarketingBenefit" class="BaseCheckbox__input" type="checkbox">
                                                          <span data-v-ee180726="" class="BaseCheckbox__button">
                                                            <svg data-v-6d2bd019="" data-v-ee180726="" :style="agreeMarketingBenefit ? '--BaseIcon-color: #ffffff' : '--BaseIcon-color: #d9d9d9'" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseCheckbox__icon" style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                                                <g clip-path="url(#clip0_2582_8708)"><path fill-rule="evenodd" clip-rule="evenodd" d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z"></path></g>
                                                                <defs><clippath id="clip0_2582_8708"><rect width="24" height="24"></rect></clippath></defs>
                                                            </svg></span><span data-v-ee180726="" class="BaseCheckbox__text" style="color: rgb(51, 51, 51);">[선택] 할인쿠폰/이벤트/감동적인 뉴스레터 선택 동의</span></div>
                                                    </label>
<!--                                                    <label data-v-ef34c959="" for="agreeMarketing" class="block ml-[32px] gray-999&#45;&#45;text body1-regular-medium">아이디어스 혜택 정보를 받으시려면 위 항목에-->
<!--                                                        동의해주세요.</label>-->
                                                </div>
                                                <hr data-v-ef34c959="" class="my-[20px]">


                                                <!-- 회원가입 하기 -->
                                                <div data-v-ef34c959="" class="mb-[20px]"></div>
                                                <button @click="validateForm" data-v-524f63ea="" data-v-7940d6dd="" data-v-ef34c959="" type="outline" class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline" style="background-color: rgb(255, 255, 255); color: rgb(239, 112, 20); height: 44px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #ef7014;">

                                                    <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea="" class="CoreButton__text">회원가입하기</span></div>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="BaseSnackbar__fadeOut !hidden BaseSnackbar" data-v-ac6313c6="">
                    <div class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]" data-v-ac6313c6="">
                        <div class="body1-regular-medium line-clamp-2 whitespace-pre-line" data-v-ac6313c6=""></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</template>

<script>
    import {
        mapStores
    } from 'pinia';
    import {
        useMemberStore
    } from '@/stores/useMemberStore';
    import {
        ref
    } from 'vue';

    export default {
        name: "SignupPage",
        data() {
            return {
                isData: false,
                inputData: ref(""),

                email: "",
                uuid : "",
                password: "",
                confirmPassword: "",
                nickname: "",
                birthday: "",
                cellPhone: "",
                defaultAddress : "",

                activeBtn : false,
                activeEmailInput : true,
                showPassword : false,
                showPasswordConfirm : false,
                showVerification : false,

                agreeAll: false, // Represents the state of "Agree All"
                agreeAge: false,
                agreePolicyService: false,
                agreePolicyPrivacy: false,
                agreeMarketingBenefit : false,
                // Add other agreement states here...


                validations: {
                  emailValid : true,
                  passwordValid : true,
                  uuidValid : false,
                  confirmPasswordValid : true,
                  nicknameValid : true,
                  birthdayValid : true,
                  cellPhoneValid : true,
                },

            };
        },
        computed: {
            ...mapStores(useMemberStore)
        },
        methods: {
            async signup() {

                const member = {
                    email : this.email,
                    password : this.password,
                    nickname : this.nickname,
                    birthday : this.birthday,
                    cellPhone : this.cellPhone,
                    defaultAddress : this.defaultAddress,
                }

                console.log(member);

                const response = await this.memberStore.signup(member);
                console.log(response);
                if(response === true){
                    alert("회원가입 성공");
                    this.$router.push("/login");
                }
                else{
                    console.log("회원가입 실패");
                }
            },

            async sendEmailRequest() {
                const result = await this.memberStore.emailRequest(this.email);
                if(result === 200){
                    alert("이메일이 성공적으로 보내졌습니다.");
                    this.showVerification = true;
                }else{
                    alert(result);
                }
            },
            
            async sendUuidRequest(){
                const result = await this.memberStore.verifyUuid(this.email,this.uuid);
                
                if(result.data === true){
                    alert("인증이 완료 되었습니다.");
                    this.activeBtn = false;
                    this.activeEmailInput = false;
                    this.uuidValid = true;
                }else{
                    alert("인증이 실패하였습니다.");
                }
            },

            clickShowPassword(){
                if(this.showPassword === false){
                    this.showPassword = true;
                    return false;
                }
                else{
                    this.showPassword = false;
                    return true;
                }
            },
            clickShowPasswordConfirm(){
                if(this.showPasswordConfirm === false){
                    this.showPasswordConfirm = true;
                    return false;
                }
                else{
                    this.showPasswordConfirm = false;
                    return true;
                }
            },

            checkAgreeAll(){
                if(this.agreeAll === false){
                    this.agreeAll
                        = this.agreeAge
                        = this.agreePolicyService
                        = this.agreePolicyPrivacy
                        = this.agreeMarketingBenefit
                        = true;
                }else{
                    this.agreeAll
                        = this.agreeAge
                        = this.agreePolicyService
                        = this.agreePolicyPrivacy
                        = this.agreeMarketingBenefit
                        = false;
                }
            },
            validateAgreeAll(){
                if(this.agreeAge && this.agreePolicyService && this.agreePolicyPrivacy && this.agreeMarketingBenefit){
                    this.agreeAll = true;
                }
            },

            checkAgreeAge(){
                if(this.agreeAge === false){
                    this.agreeAge = true;
                    this.validateAgreeAll();
                } else{
                    this.agreeAge = false;
                    this.agreeAll = false;
                }
            },
            checkAgreePolicyService(){
              if(this.agreePolicyService === false){
                  this.agreePolicyService = true;
                  this.validateAgreeAll();
              } else{
                  this.agreePolicyService = false;
                  this.agreeAll = false;
              }
            },
            checkAgreePolicyPrivacy(){
              if(this.agreePolicyPrivacy === false){
                  this.agreePolicyPrivacy = true;
                  this.validateAgreeAll();
                } else{
                  this.agreePolicyPrivacy = false;
                  this.agreeAll = false;
                }
            },
            checkAgreeMarketingBenefit(){
              if(this.agreeMarketingBenefit === false){
                  this.agreeMarketingBenefit = true;
                  this.validateAgreeAll();
              } else{
                  this.agreeMarketingBenefit = false;
                  this.agreeAll = false;
              }
            },

            validateEmail() {
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                this.validations.emailValid = emailPattern.test(this.email);
                this.activeBtn = emailPattern.test(this.email);
            },
            validUuid(){
                if(!this.uuidValid){
                    alert("이메일 인증을 완료해주세요.")
                }
            },
            validatePassword() {
                const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d).{8,}$/;
                this.validations.passwordValid = passwordPattern.test(this.password);
            },
            emptyPassword() {
                this.passwordValid = this.password !== '';
            },
            validConfirmPassword() {
                if(this.confirmPassword === this.password){
                    this.validations.confirmPasswordValid = true;
                } else {
                    this.validations.confirmPasswordValid = false;
                }
            },
            validNickname() {
                this.validations.nicknameValid = this.nickname !== '';
            },
            validBirthday(){
                const birthdayPattern = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])$/;
                this.validations.birthdayValid = birthdayPattern.test(this.birthday);
            },
            validCellPhone(){
              const cellphonePattern = /^\d{3}-\d{4}-\d{4}$/;
              this.validations.cellPhoneValid = cellphonePattern.test(this.cellPhone);
            },

            validateForm() {
                this.validateEmail();
                this.validUuid();
                this.validatePassword();
                this.validConfirmPassword();
                this.validBirthday();
                this.validCellPhone();
                this.emptyPassword();
                this.validNickname();

                if (this.validations.emailValid &&
                  this.uuidValid &&
                  this.validations.passwordValid &&
                  this.validations.confirmPasswordValid &&
                  this.validations.nicknameValid &&
                  this.validations.birthdayValid &&
                  this.validations.cellPhoneValid) {
                      if(this.agreeAge && this.agreePolicyService && this.agreePolicyPrivacy) {
                          let response = this.signup();
                          console.log(response);
                          this.$router.push("/login");
                      }
                      else{
                          alert("필수 동의에 체크해주세요.");
                      }
                }
            },
        },
    }
</script>

<style scoped>
.signupPadding{
  padding-right : 0;
}
.uuidInput{
  margin-top : 5px;
}

</style>