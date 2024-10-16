<template>
  <div>
    <button>로그아웃중...</button>
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
    const memberStore = useMemberStore();
    const response = await memberStore.logout();
    if(response === true){
      window.location.href = "/login";
    }
  }
}
</script>

<style scoped>

</style>