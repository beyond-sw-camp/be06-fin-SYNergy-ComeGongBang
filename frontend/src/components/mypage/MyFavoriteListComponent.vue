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
      <ProductListComponent :product-list="likedProducts" />
    </div>
    <div v-else-if="activeTab === 1" class="tab-content">
      <!-- 팔로우하는 작가 내용 -->
      <p>팔로우하는 작가 목록이 여기에 표시됩니다.</p>
    </div>
    <div v-else-if="activeTab === 2" class="tab-content">
      <!-- 최근 본 작품 내용 -->
      <p>최근 본 작품 목록이 여기에 표시됩니다.</p>
    </div>
  </div>
</template>

<script>
import { defineComponent, computed, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useSideBarStore } from "@/stores/useSidebarStore";
import { useLikesStore } from "@/stores/useLikesStore";
import ProductListComponent from "../product/ProductList4LayoutComponent.vue";

export default defineComponent({
  name: "MyFavoriteListComponent",
  components: {
    ProductListComponent,
  },
  props: {
    initialTab: {
      type: Number,
      default: 0,
    },
  },

  setup(props) {
    const sideBarStore = useSideBarStore();
    const likesStore = useLikesStore();
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
    //찜한 상품리스트 가져오기
    const likedProducts = computed(() => likesStore.likedProducts);

    //탭클릭시 탭변경함수
    const handleTabClick = (index) => {
      console.log(index);
      sideBarStore.setActiveTab(index); // 사이드바 스토어 업데이트
      router.push(tabs[index].path); // 경로 변경
      console.log(sideBarStore.activeTab);
      console.log("경로변경", tabs[index].path);
    };

    // 컴포넌트가 마운트될 때 찜한 상품 리스트 가져오기
    onMounted(() => {
      likesStore.getLikedProductsList();
    });

    // 라우트가 바뀔 때 `activeTab` 동기화
    sideBarStore.setActiveTab(props.initialTab);

    return {
      tabs,
      activeTab,
      handleTabClick,
      likedProducts, // likedProducts 추가
    };
  },
});
</script>

<style>
</style>