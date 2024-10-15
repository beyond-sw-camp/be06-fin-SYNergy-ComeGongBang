<template>
  <!-- 마이페이지 -->
  <div class="flex items-center justify-center w-full relative">
    <div class="flex-row flex w-desktop justify-between">
      <!-- 왼쪽 사이드바는 고정 -->
      <MyPageSideBarComponent />
      <!-- 오른쪽 컴포넌트만 동적으로 변경 -->
      <div class="main-content">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import MyPageSideBarComponent from "@/components/sidebar/MyPageSideBarComponent.vue";

export default defineComponent({
  name: "MyPage",
  computed: {},
  components: {
    MyPageSideBarComponent,
  },
  created() {},
  methods: {},
});
</script>

<style scoped>
.my-page {
  display: flex;
  max-width: 1260px;
}

.main-content {
  flex-grow: 1;
  padding: 20px;
}
</style>