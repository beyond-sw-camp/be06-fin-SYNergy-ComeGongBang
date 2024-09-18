<template>
  <!-- 마이페이지 -->
  <div class="my-page">
    <!-- 왼쪽 사이드바는 고정 -->
    <MyPageSideBarComponent />
    <!-- 오른쪽 컴포넌트만 동적으로 변경 -->
    <div class="main-content">
      <router-view />
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
}

.main-content {
  flex-grow: 1;
  padding: 20px;
}
</style>