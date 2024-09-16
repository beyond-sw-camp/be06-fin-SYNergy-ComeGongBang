<template>
  <div class="MyPageSideBar">
    <div data-v-095dc081="" class="MyPageSidebarDesktop w-[180px]">
      <div
        data-v-095dc081=""
        class="MyPageProfileDesktop h-fit flex flex-col items-center py-[28px] border-t-[1px] border-x-[1px] border-b-[0] border-[#ff7b30]"
      >
        <label
          data-v-b4eb4e33=""
          for="profileImageInput"
          class="MyProfileImageUploader group"
          style="
            --profile-image: url(https://image.idus.com/image/files/40c493d070b94d0d9e7203246b33cac3.jpg);
          "
        >
          <div data-v-b4eb4e33="" class="MyProfileImageUploader__image"></div>
          <input
            data-v-b4eb4e33=""
            id="profileImageInput"
            hidden=""
            type="file"
            name="image"
            accept=".png, .jpg, .jpeg"
          /><span
            data-v-b4eb4e33=""
            class="MyProfileImageUploader__edit group-hover:inline-block"
            for="profileImageInput"
            >수정</span
          > </label
        ><!---->
        <div class="flex justify-center align-middle mt-[20px]">
          <img
            src="@/assets/logo.png"
            width="24"
            height="24"
            class="flex my-auto"
          /><button
            data-v-524f63ea=""
            data-v-8493c3f2=""
            type="default"
            class="CoreButton BaseButtonText body1-regular-small !pr-0"
            style="
              background-color: transparent;
              color: black;
              height: 32px;
              flex-direction: row-reverse;
              --core-button-padding-x: 8;
              font-weight: bold;
            "
          >
            <!----><svg
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
                margin-left: 0px;
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
            <div data-v-524f63ea="" class="inline-flex items-center">
              <span data-v-524f63ea="" class="CoreButton__text">{{
                memberStore.grade
              }}</span>
            </div>
          </button>
        </div>
        <p
          class="body1-bold-small text-center my-[10px] break-all w-[140px] text-ellipsis overflow-hidden whitespace-nowrap"
        >
          {{ memberStore.idx }}
        </p>
        <!---->
      </div>
      <p
        data-v-095dc081=""
        class="block px-[16px] py-[9px] text-white bg-[#ff7b30] body1-bold-medium"
      >
        MY MENU
      </p>
      <!---------------------------사이드바 목록------------------------------------->
      <!-- href="https://localhost:3000/order-list" -->
      <nav data-v-095dc081="" class="bg-[#fbfafa]">
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">주문 배송</span>
          <router-link to="/주문배송내역" data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <span
                data-v-095dc081=""
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >주문/배송 내역</span
              >
            </div>
          </router-link>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">알림</span>
          <div data-v-095dc081="">
            <router-link to="/알림" data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >알림</a
              >
              <!-- href="https://www.idus.com/v2/mypage/notification"  -->
            </router-link>
          </div>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">선물함</span>
          <div data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/gift/receive"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >받은 선물함</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/gift/send"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >보낸 선물함</a
              >
            </div>
          </div>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium"
            >나의 구매후기</span
          >
          <div data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/review/writable"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >작성 가능한 후기</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/review/written"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >작성한 후기</a
              >
            </div>
          </div>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">관심</span>
          <div data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/favorite/favorite-list"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >찜한 작품</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/favorite/follow-artist"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >팔로우하는 작가</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/favorite/recently-view"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >최근 본 작품</a
              >
            </div>
          </div>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">할인혜택</span>
          <div data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/coupon"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >쿠폰함</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/point"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >적립금</a
              >
            </div>
          </div>
        </div>
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">내 정보</span>
          <div data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/grade"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >회원 등급</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/edit-user-info"
                class="router-link-active router-link-exact-active body3-regular-small MyPageSidebarDesktop__menu activate"
                aria-current="page"
                >회원 정보 및 배송지 관리</a
              >
            </div>
            <div data-v-095dc081="" class="flex flex-col">
              <a
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/payment-management"
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >신용카드 및 환불계좌 관리</a
              >
            </div>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "MyPageSideBarComponent",
  computed: {},
  components: {},
  created() {
    // this.searchByCategory();
  },
  methods: {
    // searchByCategory() {
    //   this.productStore.searchByCategory(); //Todo 현재는 카테고리 상품 리스트만 조회 가능하므로 추후 다른 종류의 상품리스트에도 사용할 수 있도록 리팩토링
    // },
  },
});
</script>       

<style>
</style>