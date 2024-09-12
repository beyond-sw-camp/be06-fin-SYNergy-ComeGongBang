<template>
    <div>
        <GiftGiveComponent v-for="gift in giftStore.giftGiveList" :key="gift.idx" :gift="gift"/>
    </div>
    <button @click="getGivePresentList">조회</button>
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
    },
    methods:{
        getGivePresentList(){
            this.giftStore.getGivePresentList();
        }
    }

}
</script>

<style>

</style>