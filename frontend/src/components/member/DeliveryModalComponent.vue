<template>
  <div data-v-6e7483a5=""
       class="BaseDialog__size--medium BaseDialog flex justify-center items-center fixed top-0 left-0 modal"
       style="--dialog-footer: 0; --dialog-header-height: 48px; --dialog-footer-height: 0px;">
    <div data-v-6e7483a5="" tabindex="0" class="BaseDialog__container modal-container">
      <div data-v-899a28fb="" data-v-6e7483a5="">
        <div data-v-899a28fb="" class="BaseCommonHeader--divider w-full flex justify-center items-center">
          <span
            data-v-899a28fb="" class="BaseCommonHeader__slot flex shrink-0 items-center justify-center grow-0 mx-[8px]">
            <span @click="toggleModal" data-v-6e7483a5="" class="BaseDialog__close flex justify-center items-center">
              <button data-v-524f63ea="" data-v-778c1d9b="" data-v-6e7483a5="" type="button" class="CoreButton BaseButtonIcon"
                  style="background-color: transparent; color: rgb(51, 51, 51); height: 40px; width: 40px; flex-direction: column;"><!---->
            <svg
            data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
            xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
            style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;"><g
            clip-path="url(#clip0_124_2945)"><path fill-rule="evenodd" clip-rule="evenodd"
                                                   d="M18.4697 4.46973L19.5303 5.53039L13.0597 11.9997L19.5303 18.4697L18.4697 19.5304L11.9997 13.0597L5.53033 19.5304L4.46967 18.4697L10.9397 11.9997L4.46967 5.53039L5.53033 4.46973L11.9997 10.9397L18.4697 4.46973Z"></path></g><defs><clipPath
            id="clip0_124_2945"><rect width="24" height="24"></rect></clipPath></defs></svg><div data-v-524f63ea=""
                                                                                                 class="inline-flex items-center"><!----></div></button></span></span><span
            data-v-899a28fb="" class="flex items-center grow"><span data-v-899a28fb=""
                                                                    class="subtitle3-bold-small grow gray-333--text text-center break-all line-clamp-1">배송지 변경</span></span><span
            data-v-899a28fb=""
            class="BaseCommonHeader__slot flex shrink-0 items-center justify-center grow-0 mx-[8px]"></span></div>
      </div>
      <div data-v-6e7483a5="" class="BaseDialog__contents"><!---->
        <div data-v-6e7483a5="" class="BaseDialog__contentsInner">
          <div class="h-[496px] pt-[50px]" v-if="addressesLength===0">
            <div class="flex flex-col items-center justify-center">
              <div class="subtitle3_bold_medium">등록된 배송지가 없습니다.</div>
              <div class="body1_regular_medium mt-[8px] mb-[16px]"> 배송지 추가하기 버튼을 눌러 주소를 입력해주세요.</div>
              <div>
                <button @click="openAddAddressModal"
                    data-v-524f63ea="" data-v-7940d6dd="" type="outline"
                        class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline"
                        style="background-color: rgb(73, 73, 73); color: rgb(255, 255, 255); height: 40px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #ffffff;">
                  <!---->
                  <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                       xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                       style="width: 18px; height: 18px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-right: 2px;">
                    <g clip-path="url(#clip0_124_2960)">
                      <path fill-rule="evenodd" clip-rule="evenodd"
                            d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"></path>
                    </g>
                    <defs>
                      <clipPath id="clip0_124_2960">
                        <rect width="24" height="24"></rect>
                      </clipPath>
                    </defs>
                  </svg>
                  <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea=""
                                                                                 class="CoreButton__text">배송지 추가하기</span>
                  </div>
                </button><!----></div>
            </div>
          </div>
          <div class="h-[496px]">
            <div class="p-[16px]">
              <button data-v-524f63ea="" data-v-7940d6dd="" type="outline"
                      class="CoreButton CoreButton--block BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline"
                      style="background-color: rgb(73, 73, 73); color: rgb(255, 255, 255); height: 44px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #ffffff;">
                <!---->
                <svg data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                     xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                     style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-right: 2px;">
                  <g clip-path="url(#clip0_124_2960)">
                    <path fill-rule="evenodd" clip-rule="evenodd"
                          d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"></path>
                  </g>
                  <defs>
                    <clipPath id="clip0_124_2960">
                      <rect width="24" height="24"></rect>
                    </clipPath>
                  </defs>
                </svg>
                <div @click="openAddAddressModal" data-v-524f63ea="" class="inline-flex items-center">
                  <span data-v-524f63ea="" class="CoreButton__text">배송지 추가하기</span>
                </div>
              </button><!---->
            </div>
<!--            </div>-->
            <div class="">
              <div class="flex flex-col gap-[10px] bg-[#f5f5f5]">
                <div v-for="(address, index) in deliveryStore.addresses" :key="index"
                     @click="addressClick(index)"
                     class="flex w-full p-[16px] !pt-[20px] bg-white">
                  <div class="DeliveryListItem__prepend mr-[8px]">
                    <label data-v-02c06866="" class="BaseRadio BaseRadio__verticalAlign--center BaseRadio__state--checked"
                           style="--BaseRadio--label-margin: 4;">
                      <input data-v-02c06866="" type="radio" class="BaseRadio__input" value="5142006">
                        <span data-v-02c06866="" class="BaseRadio__button">
                          <span data-v-02c06866="" class="BaseRadio__buttonOuterCircle" :class="{'inActiveBorder':index!=this.deliveryStore.selectedIndex}">
                            <span data-v-02c06866="" class="BaseRadio__buttonInnerCircle" :class="{'inActiveBack':index!=this.deliveryStore.selectedIndex}">
                            </span>
                          </span>
                        </span>
                      <span data-v-02c06866="" class="BaseRadio__text" style="color: rgb(51, 51, 51);">
                      </span>
                    </label>
                  </div>
                  <div class="flex flex-col w-full">
                    <div class="w-full flex flex-col gap-[8px]">
                      <div class="flex">
                        <div v-if="address.isDefault===true" data-v-24a9185e="" class="BaseBadgeBusiness BaseBadgeBusiness__colorType--orange-500 BaseBadgeBusiness__size--medium mr-[4px] flex-none"
                             style="font-weight: bold; color: rgb(239, 112, 20); background-color: rgb(255, 247, 242);">
                          <!----> 기본배송지
                        </div>
                        <div class="flex break-all">
                          <div class="body1-bold-small">{{address.recipient}} <span class="body1-regular-small">({{address.addressName}})</span></div>
                        </div>
                      </div>
                      <p class="body1-regular-medium text-left">010-7280-0916</p>
                      <p class="body1-regular-medium text-left break-all">{{address.address }}{{address.detailAddress}}</p>
                    </div>
                    <div class="flex justify-end mt-[4px]"><!---->
                      <button data-v-524f63ea="" data-v-8493c3f2="" type="default"
                              class="CoreButton BaseButtonText body3-regular-small ml-[12px]"
                              style="background-color: transparent; color: rgb(102, 102, 102); height: 30px; flex-direction: row-reverse; --core-button-padding-x: 8; font-weight: bold;">
                        <!----><!---->
                      </button>
                    </div><!----></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <button data-v-cdb47598="" data-v-6e7483a5="" type="button"
              class="BaseButtonFab BaseButtonFab--small BaseButtonFab__icon--small !absolute BaseDialog__moveTop"
              style="--BaseButtonFab-color: #333333; display: none;">
        <svg data-v-6d2bd019="" data-v-cdb47598="" width="24" height="24" viewBox="0 0 24 24"
             xmlns="http://www.w3.org/2000/svg" class="BaseIcon BaseButtonFab__icon"
             style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333;">
          <g clip-path="url(#clip0_124_2944)">
            <path
                d="M3.96869 11.7197L11.4687 4.21967C11.7616 3.92678 12.2365 3.92678 12.5293 4.21967L20.0293 11.7197L18.9687 12.7803L12.749 6.5606V20H11.249V6.56072L5.02935 12.7803L3.96869 11.7197Z"></path>
          </g>
          <defs>
            <clipPath id="clip0_124_2944">
              <rect width="24" height="24"></rect>
            </clipPath>
          </defs>
        </svg>
      </button><!----></div>
    <AddAddressComponent
        v-if="isModalVisible"
        @close="closeModal"
        @address-added="fetchAddresses"
    />
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useDeliveryStore } from "@/stores/useDeliveryStore";
import AddAddressComponent from "@/components/member/AddAddressComponent.vue";

export default {
  components: {AddAddressComponent},
  computed: {
    ...mapStores(useDeliveryStore)
  },
  created() {
    //배송지
    this.getAddressList();
  },
  data(){
    return{
      addressesLength : 0,
      selectedIndex : 0,
      isModalVisible:false,
    }
  },
  methods: {
    //배송지 조회
    async getAddressList(){
      await this.deliveryStore.fetchAddresses();
      this.addressesLength=this.deliveryStore.addresses.length;
    },
    //배송지 추가
    async addAddress(){
      await this.deliveryStore.addAddress();
    },
    fetchAddresses (){
      this.deliveryStore.fetchAddresses();
    },
    toggleModal() {
      this.deliveryStore.isModalVisible = !this.deliveryStore.isModalVisible; // 모달 상태를 토글
    },
    openAddAddressModal(){ //배송지 추가 모달
      this.isModalVisible = !this.isModalVisible;
    },
    closeModal(){
      this.isModalVisible = false;
    },
    addressClick(index){
      this.deliveryStore.selectedIndex=index;
      this.deliveryStore.selectedAddress = this.deliveryStore.addresses[index];
      setTimeout(() => {
        this.deliveryStore.isModalVisible = false;
      }, 500);
    }
  }
};
</script>

<style>
.modal{
  z-index: 5000;
  margin-left: 50%;
  margin-top: 50vh;
  transform: translate(-50%,-50%);
  width: 100%;
  height: 100vh;
  background-color: rgba(0,0,0,0.5);
}
.modal-container{
  background-color: white;
  width: 640px;
}
.inActiveBorder{
  border: 1px solid #aeabab !important;
}
.inActiveBack{
  background-color:  #aeabab !important;
}
</style>
