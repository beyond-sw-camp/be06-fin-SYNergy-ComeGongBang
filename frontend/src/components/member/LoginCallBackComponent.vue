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
    window.location.href = "/";
  }
}
</script>

<style scoped>

</style>