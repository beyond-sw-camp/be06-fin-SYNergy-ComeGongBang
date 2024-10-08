<template>
  <div class="PageFavoriteListDesktop w-full pl-6">
    <p class="flex items-center headline4-bold-small mb-[36px]">관심</p>
    <!-----------------------------------------탭 부분------------------------------------------------------->
    <div
      class="BaseTabs BaseTabs__size--large BaseTabs--full BaseTabs__style--filled BaseTabs__border--bottom BaseTabs__align--left"
      style="--BaseTabs-item-length: 2; --BaseTabs-margin-x: 0"
      data-v-de0565e1=""
    >
      <div class="BaseTabs__inner" role="tablist" data-v-de0565e1="">
        <!------------------------------탭의 제목 부분 [작성 가능 후기, 작성한 후기]--------------------------------------->

          <div
          class="BaseTab BaseTab--divider"
          :class="{'BaseTab--active':tab.id === activeTabIdx}"
          @click="tabClick(tab.id)"
          v-for="tab in tabs" :key="tab.id"
          style=""
          border-top="false"
          border-bottom="true"
          data-v-47c662bd=""
          data-v-de0565e1=""
          role="tab"
        >
          <div class="BaseTab__contents" data-v-47c662bd="">
            <div class="BaseTab__prefix" data-v-47c662bd=""></div>
            <div class="BaseFontVariable" data-v-9dbc8be1="" data-v-47c662bd="">
              <router-link :to="tab.path">
                <div class="BaseFontVariable__text" data-v-9dbc8be1="">
                  <span
                    class="BaseFontVariable__text--hidden"
                    data-v-9dbc8be1=""
                    >{{tab.title}}</span
                  ><span
                    class="BaseFontVariable__text--display"
                    data-v-9dbc8be1=""
                    >{{tab.title}}</span
                  >
                </div>
              </router-link>
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
<!--    <div v-if="activeTab === 0" class="tab-content">-->
<!--      <WritableReviewComponent></WritableReviewComponent>-->
<!--    </div>-->
<!--    <div v-else-if="activeTab === 1" class="tab-content">-->
<!--      <WrittenReviewComponent></WrittenReviewComponent>-->
<!--    </div>-->
    <router-view></router-view>
  </div>
</template>

<script>
import { defineComponent, computed } from "vue";
import { useRouter } from "vue-router";
import { useSideBarStore } from "@/stores/useSidebarStore";

export default defineComponent({
  name: "ReviewOfPurposeComponent",
  components: {
  },
  props: {
    initialTab: {
      type: Number,
      default: 0,
    },
  },
  data(){
    return{
      activeTabIdx : this.initialTab,
    }
  },
  watch: {
    $route(to) {
      const foundTab = this.tabs.find(tab => tab.path === to.path);
      if (foundTab) {
        this.activeTabIdx = foundTab.id; // 해당 경로에 맞는 탭 활성화
      }
    }
  },
  methods:{
    tabClick(idx){
      this.activeTabIdx=idx;
    }
  },

  setup(props) {
    const sideBarStore = useSideBarStore();
    const router = useRouter();

    const tabs = [
      { id: 1, title: "작성 가능한 후기", path: "/review/writable" },
      {
        id: 2,
        title: "작성한 후기",
        path: "/review/written",
      },
    ];

    const activeTab = computed(() => sideBarStore.activeTab);

    //탭클릭시 탭변경함수
    const handleTabClick = (index) => {
      sideBarStore.setActiveTab(index); // 사이드바 스토어 업데이트
      router.push(tabs[index].path); // 경로 변경
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

<style scoped>
</style>
