<template>
  <div class="w-full pl-6">
    <div>
      <div class="flex justify-between pb-[24px]">
        <h2 class="headline4-bold-small gray-333--text">배송지 관리</h2>
        <div>
          <!--배송지 추가 버튼-->
          <button
            v-if="deliveryStore.addresses.length !== 0"
            @click="openModal"
            data-v-524f63ea=""
            data-v-7940d6dd=""
            type="outline"
            class="CoreButton BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline"
            style="
              background-color: rgb(255, 255, 255);
              color: #000;
              height: 40px;
              flex-direction: row;
              --core-button-padding-x: 16;
              --button-rectangle-border-color: #000;
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
                width: 18px;
                height: 18px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-right: 2px;
              "
            >
              <g clip-path="url(#clip0_124_2960)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2960">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div data-v-524f63ea="" class="inline-flex items-center">
              <span data-v-524f63ea="" class="CoreButton__text"
                >배송지 추가하기</span
              >
            </div></button
          ><!---->
        </div>
        <AddAddressComponent
          v-if="isModalVisible"
          @close="closeModal"
          @address-added="fetchAddresses"
        />
      </div>

      <!--      배송지 없을 때, 띄워주는 div-->
      <div
        v-if="deliveryStore.addresses.length === 0"
        class="flex flex-col items-center justify-center h-[640px]"
        button-width="328"
      >
        <div class="subtitle3_bold_medium">등록된 배송지가 없습니다.</div>
        <div class="body1_regular_medium mt-[8px] mb-[16px]">
          배송지 추가하기 버튼을 눌러 주소를 입력해주세요.
        </div>
        <div>
          <button
            @click="openModal"
            data-v-524f63ea=""
            data-v-7940d6dd=""
            type="outline"
            class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline"
            style="
              background-color: rgb(255, 255, 255);
              color: rgb(239, 112, 20);
              height: 40px;
              flex-direction: row;
              --core-button-padding-x: 16;
              --button-rectangle-border-color: #ef7014;
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
                width: 18px;
                height: 18px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-right: 2px;
              "
            >
              <g clip-path="url(#clip0_124_2960)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2960">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div data-v-524f63ea="" class="inline-flex items-center">
              <span data-v-524f63ea="" class="CoreButton__text"
                >배송지 추가하기</span
              >
            </div></button
          ><!---->
        </div>
      </div>

      <div
        class="flex flex-col w-full rounded-sm border px-[16px] pt-[20px] pb-[8px] mb-[12px] last:mt-0"
      >
        <!-- 요게 반복       -->
        <div
          v-for="address in deliveryStore.addresses"
          :key="address.deliveryAddressIdx"
          style="
            border: 1px solid rgb(229, 231, 235);
            padding: 20px 8px 16px 16px;
            margin-bottom: 12px;
          "
          class="flex flex-col w-full"
        >
          <div class="w-full flex flex-col gap-[8px]">
            <div class="flex">
              <!--              기본 배송지 일 떄 기본 배송지 태그 붙여줌-->
              <div
                v-if="address.isDefault"
                data-v-24a9185e=""
                class="BaseBadgeBusiness BaseBadgeBusiness__colorType--black-500 BaseBadgeBusiness__size--medium mr-[4px] flex-none"
                style="
                  font-weight: bold;
                  color: #f5f5f5;
                  background-color: #000;
                "
              >
                <!---->
                기본배송지
              </div>

              <!--              배송지 이름-->
              <div class="flex break-all">
                <div class="body1-bold-small">
                  {{ address.recipient }} ({{ address.addressName }})
                  <!---->
                </div>
              </div>
            </div>
            <!--            전화번호-->
            <p class="body1-regular-medium text-left">
              {{ address.cellPhone }}
            </p>
            <!--            주소-->
            <p class="body1-regular-medium text-left break-all">
              ({{ address.postCode }}) {{ address.address }} ({{
                address.detailAddress
              }})
            </p>
          </div>
          <div class="flex justify-end mt-[4px]">
            <!--            삭제 버튼-->
            <button
              @click="deleteDeliveryAddress(address.deliveryAddressIdx)"
              data-v-524f63ea=""
              data-v-8493c3f2=""
              type="default"
              class="CoreButton BaseButtonText body3-regular-small"
              style="
                background-color: transparent;
                color: rgb(102, 102, 102);
                height: 30px;
                flex-direction: row-reverse;
                --core-button-padding-x: 8;
                font-weight: bold;
              "
            >
              <!----><!---->
              <div data-v-524f63ea="" class="inline-flex items-center">
                <span data-v-524f63ea="" class="CoreButton__text">삭제</span>
              </div>
            </button>
            <!--            수정 버튼-->
            <!-- <button
                data-v-524f63ea=""
                data-v-8493c3f2=""
                type="default"
                class="CoreButton BaseButtonText body3-regular-small ml-[12px]"
                style="
                  background-color: transparent;
                  color: rgb(102, 102, 102);
                  height: 30px;
                  flex-direction: row-reverse;
                  --core-button-padding-x: 8;
                  font-weight: bold;
                "
            >
              <div data-v-524f63ea="" class="inline-flex items-center">
                <span data-v-524f63ea="" class="CoreButton__text">수정</span>
              </div>
            </button> -->
          </div>
          <!---->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, ref } from "vue";
import { useDeliveryStore } from "@/stores/useDeliveryStore";
import AddAddressComponent from "./AddAddressComponent.vue";

export default {
  components: {
    AddAddressComponent,
  },

  setup() {
    const deliveryStore = useDeliveryStore();
    const isModalVisible = ref(false);

    const openModal = () => {
      isModalVisible.value = true;
    };

    const closeModal = () => {
      isModalVisible.value = false;
    };

    const fetchAddresses = () => {
      deliveryStore.fetchAddresses();
    };

    const deleteDeliveryAddress = (idx) => {
      const success = deliveryStore.deleteAddress(idx); // 주소 삭제
      if (success) {
        deliveryStore.fetchAddresses(); // 삭제 후 주소 목록 업데이트
      }
    };

    onMounted(() => {
      fetchAddresses();
    });

    return {
      openModal,
      fetchAddresses,
      closeModal,
      deleteDeliveryAddress,
      deliveryStore,
      isModalVisible,
    };
  },
};
</script>
