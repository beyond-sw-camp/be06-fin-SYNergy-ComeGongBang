<template>
  <div>
    <button>리다이렉트중...</button>
  </div>
</template>

<script>
import {mapStores} from "pinia/dist/pinia";
import {useMemberStore} from "@/stores/useMemberStore";

export default {
  computed: {
    ...mapStores(useMemberStore)
  },
  async mounted(){
    await this.memberStore.getMemberInfo();
    this.memberStore.isLogined = true;
    window.location.href = "http://localhost:3000/"; // 로그인 페이지 메인페이지 리다이렉트
  }
}
</script>

<style scoped>

</style>