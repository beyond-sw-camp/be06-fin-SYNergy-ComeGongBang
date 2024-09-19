<template>
    <div class="PageFavoriteListDesktop w-full pl-6">
      <p class="flex items-center headline4-bold-small mb-[36px]">관심</p>
      <!-----------------------------------------탭 부분------------------------------------------------------->
      <div
        class="BaseTabs BaseTabs__size--large BaseTabs--full BaseTabs__style--filled BaseTabs__border--bottom BaseTabs__align--left"
        style="--BaseTabs-item-length: 3; --BaseTabs-margin-x: 0"
        data-v-de0565e1=""
      >
        <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
          <!------------------------------탭의 제목 부분 [찜한상품, 팔로우하는 작가, 최근본상품]--------------------------------------->
          <div
            v-for="(tab, index) in tabs"
            :key="index"
            :class="[
              'BaseTab BaseTab--divider',
              { 'BaseTab--active': activeTab === index },
            ]"
            style=""
            border-top="false"
            border-bottom="true"
            data-v-47c662bd=""
            data-v-de0565e1=""
            role="tab"
            @click="handleTabClick(index)"
          >
            <div class="BaseTab__contents" data-v-47c662bd="">
              <div class="BaseTab__prefix" data-v-47c662bd=""></div>
              <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >{{ tab.title }}</span
                  ><span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
                    >{{ tab.title }}</span
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
      <!-------------------------------------각 탭의 하단 내용-------------------------------------------------------->
      <div v-if="activeTab === 0" class="tab-content">
        <p>좋아요상품목록이 여기에 표시됩니다.</p>
        <!-- <ProductComponent /> -->
      </div>
      <div v-else-if="activeTab === 1" class="tab-content">
        <p class="mt-[16px] mb-[10px] py-[12px] body1-regular-small"><span class="body1-bold-small">2명</span>의 작가를
              팔로우 중입니다.</p>
            <!-- 팔로우하는 공방 -->
            <div data-v-066b4a11="" class="DesktopFollowArtistItem">
              <div data-v-066b4a11="" class="flex w-[381px] py-[28px] pl-[31px] pr-[36px] cursor-pointer">
                <div data-v-066b4a11="" class="flex items-center w-[100px] relative mr-[32px]">
                  <div data-v-4bef34a0="" data-v-066b4a11="" class="BaseAvatarArtist"
                    style="--overlay-size: 134; --overlay-image: url();">
                    <div data-v-2fc5c54e="" data-v-4bef34a0="" class="BaseAvatar BaseAvatar--border"
                      style="--BaseAvatar-image: url(//image.idus.com/image/files/5c4323fe25a84c86864b6d6fd39fba79_320.jpg); --BaseAvatar-size: 96;">
                      <div data-v-2fc5c54e="" class="BaseAvatar__avatar">
                        <div data-v-2fc5c54e="" class="BaseAvatar__avatarImage"></div>
                      </div>
                      <div data-v-8f163f81="" data-v-2fc5c54e="" class="CoreBadge BaseAvatar__iconDot"
                        style="--CoreBadge-color-background: #ef7014; --CoreBadge-color-outline: #ffffff; --CoreBadge-size: 8; --CoreBadge-fontSize: 11; --CoreBadge-offset-x: 0; --CoreBadge-offset-y: 0; --CoreBadge-position: relative;">
                        <!----></div>
                      <div data-v-8f163f81="" data-v-2fc5c54e=""
                        class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
                        style="--CoreBadge-color-background: #000000; --CoreBadge-color-outline: #ffffff; --CoreBadge-size: 28; --CoreBadge-fontSize: 11; --CoreBadge-offset-x: 0; --CoreBadge-offset-y: 0; --CoreBadge-position: relative;">
                        <!----></div>
                    </div>
                    <div data-v-4bef34a0="" class="BaseAvatarArtist__overlay"></div>
                  </div>
                </div>
                <div data-v-066b4a11="" class="min-w-[182px] flex flex-col">
                  <p data-v-066b4a11="" class="subtitle3_bold_small mb-[8px] line-clamp-1">밤스스튜디오 </p>
                  <p data-v-066b4a11="" class="body3_regular_medium line-clamp-3 mb-[24px] min-h-[54px]">" Dogs save the
                    world "<br></p><button data-v-524f63ea="" data-v-7940d6dd="" data-v-066b4a11="" type="outline"
                    class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline min-w-[82px] mr-[1px]"
                    style="background-color: rgb(255, 255, 255); color: rgb(239, 112, 20); height: 32px; flex-direction: row; --core-button-padding-x: 8; --button-rectangle-border-color: #ef7014;"><!----><svg
                      data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                      xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                      style="width: 16px; height: 16px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-right: 2px;">
                      <g clip-path="url(#clip0_124_2960)">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                          d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z"></path>
                      </g>
                      <defs>
                        <clippath id="clip0_124_2960">
                          <rect width="24" height="24"></rect>
                        </clippath>
                      </defs>
                    </svg>
                    <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea=""
                        class="CoreButton__text">팔로우</span></div>
                  </button>
                </div>
              </div>
              <div data-v-066b4a11="" class="w-[100%] flex h-[198px] cursor-pointer">
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/84d6c440b46b4adeb37ed57975c70aa6_512.jpg&quot;);">
                    </div>
                </div>
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/f3bd345b75084b21ac77360a5cb379ad_512.jpg&quot;);">
                    </div>
                </div>
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/80646a65d8964feabb434e859281f6ed_512.jpg&quot;);">
                    </div>
                </div>
              </div>
            </div>
            <div data-v-066b4a11="" class="DesktopFollowArtistItem">
              <div data-v-066b4a11="" class="flex w-[381px] py-[28px] pl-[31px] pr-[36px] cursor-pointer">
                <div data-v-066b4a11="" class="flex items-center w-[100px] relative mr-[32px]">
                  <div data-v-4bef34a0="" data-v-066b4a11="" class="BaseAvatarArtist"
                    style="--overlay-size: 134; --overlay-image: url();">
                    <div data-v-2fc5c54e="" data-v-4bef34a0="" class="BaseAvatar BaseAvatar--border"
                      style="--BaseAvatar-image: url(//image.idus.com/image/files/50860a26e73648e1b8a7388112c2dd73_320.png); --BaseAvatar-size: 96;">
                      <div data-v-2fc5c54e="" class="BaseAvatar__avatar">
                        <div data-v-2fc5c54e="" class="BaseAvatar__avatarImage"></div>
                      </div>
                      <div data-v-8f163f81="" data-v-2fc5c54e="" class="CoreBadge BaseAvatar__iconDot"
                        style="--CoreBadge-color-background: #ef7014; --CoreBadge-color-outline: #ffffff; --CoreBadge-size: 8; --CoreBadge-fontSize: 11; --CoreBadge-offset-x: 0; --CoreBadge-offset-y: 0; --CoreBadge-position: relative;">
                        <!----></div>
                      <div data-v-8f163f81="" data-v-2fc5c54e=""
                        class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
                        style="--CoreBadge-color-background: #000000; --CoreBadge-color-outline: #ffffff; --CoreBadge-size: 28; --CoreBadge-fontSize: 11; --CoreBadge-offset-x: 0; --CoreBadge-offset-y: 0; --CoreBadge-position: relative;">
                        <!----></div>
                    </div>
                    <div data-v-4bef34a0="" class="BaseAvatarArtist__overlay"></div>
                  </div>
                </div>
                <div data-v-066b4a11="" class="min-w-[182px] flex flex-col">
                  <p data-v-066b4a11="" class="subtitle3_bold_small mb-[8px] line-clamp-1">레이문</p>
                  <p data-v-066b4a11="" class="body3_regular_medium line-clamp-3 mb-[24px] min-h-[54px]">인물화 무드등, 원목 소품
                    디자인을 전문으로 하고 있는 레이문입니다.
                    <br>궁금하신점은 문의주시면 빠르게 안내드리겠습니다 .^^
                  </p><button data-v-524f63ea="" data-v-7940d6dd="" data-v-066b4a11="" type="outline"
                    class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline min-w-[82px] mr-[1px]"
                    style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); height: 32px; flex-direction: row; --core-button-padding-x: 8; --button-rectangle-border-color: #acacac;"><!----><svg
                      data-v-6d2bd019="" data-v-524f63ea="" width="24" height="24" viewBox="0 0 24 24"
                      xmlns="http://www.w3.org/2000/svg" class="BaseIcon CoreButton__icon"
                      style="width: 16px; height: 16px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-right: 2px;">
                      <g clip-path="url(#clip0_124_2952)">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                          d="M19.4697 5.46973L20.5303 6.53039L9.53033 17.5304C9.26406 17.7967 8.8474 17.8209 8.55378 17.603L8.46967 17.5304L3.46967 12.5304L4.53033 11.4697L9 15.9391L19.4697 5.46973Z">
                        </path>
                      </g>
                      <defs>
                        <clippath id="clip0_124_2952">
                          <rect width="24" height="24"></rect>
                        </clippath>
                      </defs>
                    </svg>
                    <div data-v-524f63ea="" class="inline-flex items-center"><span data-v-524f63ea=""
                        class="CoreButton__text">팔로잉</span></div>
                  </button>
                </div>
              </div>
              <div data-v-066b4a11="" class="w-[100%] flex h-[198px] cursor-pointer">
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/b6eb35581f9947428e59ca8d7479912a_512.jpg&quot;);">
                    </div>
                </div>
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/45661490225e494a877f1390df56df22_512.jpg&quot;);">
                    </div>
                </div>
                <div data-v-24b1dfb3="" data-v-066b4a11="" class="BaseImage flex-[1_33%]"
                  style="--BaseImage-width: 0; --BaseImage-height: 0; --BaseImage-radius: 0;">
                  <div data-v-24b1dfb3="" class="BaseImage__image"
                    style="background-image: url(&quot;//image.idus.com/image/files/3507a5917f9943c5924f59fa58d08478_512.jpg&quot;);">
                    </div>
                </div>
              </div>
            </div>
        <p>팔로우하는 작가 목록이 여기에 표시됩니다.</p>
      </div>
      <div v-else-if="activeTab === 2" class="tab-content">
        <!-- 최근 본 작품 내용 -->
        <p>최근 본 작품 목록이 여기에 표시됩니다.</p>
      </div>
    </div>
  </template>
  
  <script>
  import { defineComponent, computed } from "vue";
  import { useRouter } from "vue-router";
  import { useSideBarStore } from "@/stores/useSidebarStore";
  
  export default defineComponent({
    name: "MyFollowListComponent",
    props: {
      initialTab: {
        type: Number,
        default: 0,
      },
    },
  
    setup(props) {
      const sideBarStore = useSideBarStore();
      const router = useRouter();
  
      const tabs = [
        { id: 1, title: "찜한 작품", path: "/mypage/favorite/likes" },
        {
          id: 2,
          title: "팔로우하는 작가",
          path: "/mypage/favorite/follow-artist",
        },
        { id: 3, title: "최근 본 작품", path: "/mypage/favorite/recent-view" },
      ];
  
      const activeTab = computed(() => sideBarStore.activeTab);
  
      //탭클릭시 탭변경함수
      const handleTabClick = (index) => {
        console.log(index);
        sideBarStore.setActiveTab(index); // 사이드바 스토어 업데이트
        router.push(tabs[index].path); // 경로 변경
        console.log(sideBarStore.activeTab);
        console.log("경로변경", tabs[index].path);
      };
  
      // 라우트가 바뀔 때 `activeTab` 동기화
      sideBarStore.setActiveTab(props.initialTab);
  
      return {
        tabs,
        activeTab,
        handleTabClick,
      };
    },
  });
  </script>
  
  <style>
  </style>