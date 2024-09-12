<template>
    <div>
        <GiftTakeComponent v-for="gift in giftStore.giftTakeList" :key="gift.idx" :gift="gift"/>
    </div>
</template>

<script>
import GiftTakeComponent from './GiftTakeComponent.vue'
import { mapStores } from "pinia";
import { useGiftStore } from "@/stores/useGiftStore"

export default {
    computed:{
        ...mapStores(useGiftStore)
    },
    components:{
        GiftTakeComponent
    }

}
</script>

<style>

</style>