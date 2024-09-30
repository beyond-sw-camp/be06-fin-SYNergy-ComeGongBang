<template>
  <div class="PageFavoriteListDesktop w-full pl-6">
    <p class="flex items-center headline4-bold-small mb-[36px]">관심</p>
    <!-----------------------------------------탭 부분------------------------------------------------------->
    <!-- BaseTabsComponent 추가 -->
    <BaseTabsComponent
      :tabs="tabs"
      :activeTab="activeTab"
      @update:activeTab="handleTabClick"
    />

    <!-------------------------------------각 탭의 하단 내용-------------------------------------------------------->
    <div v-if="activeTab === 0" class="tab-content">
      <ProductListComponent :productList="likesStore.productList" />
    </div>
    <div v-else-if="activeTab === 1" class="tab-content">
      <!-- 팔로우하는 작가 내용 -->
      <FollowAtelierList :productList="followStore.followList" />
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
import FollowAtelierList from "./FollowAtelierListComponent.vue";
import BaseTabsComponent from "./BaseTabComponent.vue";
import { useFollowStore } from "@/stores/useFollowStore";

export default defineComponent({
  name: "MyFavoriteListComponent",
  components: {
    ProductListComponent,
    FollowAtelierList,
    BaseTabsComponent,
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
    const followStore = useFollowStore();
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
      followStore.fetcchFollow();
    });

    // 라우트가 바뀔 때 `activeTab` 동기화
    sideBarStore.setActiveTab(props.initialTab);

    return {
      tabs,
      activeTab,
      handleTabClick,
      likedProducts, // likedProducts 추가
      likesStore,
    };
  },
});
</script>

<style>
</style>