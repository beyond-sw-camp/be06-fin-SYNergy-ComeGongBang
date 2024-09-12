<template>
    <div>
        <GiftGiveComponent v-for="gift in giftStore.giftGiveList" :key="gift.idx" :gift="gift"/>
    </div>
</template>

<script>
import GiftGiveComponent from './GiftGiveComponent.vue'
import { mapStores } from "pinia";
import { useGiftStore } from "@/stores/useGiftStore"

export default {
    computed:{
        ...mapStores(useGiftStore)
    },
    components:{
        GiftGiveComponent
    }

}
</script>

<style>

</style>