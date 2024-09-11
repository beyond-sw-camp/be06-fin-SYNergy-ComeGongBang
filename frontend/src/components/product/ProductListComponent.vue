<template>
    <div class="product-list-container">
        <ProductComponent v-for="product in productStore.productList" :key="product.idx" :product="product"/>
    </div>
     <ObserverComponent @show="infiniteHandler"></ObserverComponent>
    <!-- <InfiniteLoading @infinite="infiniteHandler" :distance="50"></InfiniteLoading> -->
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";
import ProductComponent from './ProductComponent.vue'
// import { InfiniteLoading } from '../../../node_modules/v3-infinite-loading/lib/v3-infinite-loading.es.js';
// import "../../../node_modules/v3-infinite-loading/lib/style.css";
import ObserverComponent from './ObserverComponent.vue';

export default {
    components:{
        ProductComponent,
        ObserverComponent
        // InfiniteLoading
    },
    data(){
        return{
            page:0,
            loading: false //로딩 관리
        }
    },
    computed:{
        ...mapStores(useProductStore)
    },
    created(){
        this.productStore.productList = [];
        // this.searchByCategory();
        // this.page++;
    },
    methods:{
        async searchByCategory(){
            await this.productStore.searchByCategory(this.page, 12);
        },
        async infiniteHandler(){
            if (this.loading) return; 
            this.loading = true; 

            if (this.page !== 0) {
                await new Promise((resolve) => setTimeout(resolve, 150));
            }

            try {
                await this.productStore.searchByCategory(this.page, 12);
                this.page++;
            } catch (error) {
                console.error("Failed to fetch data:", error);
            } finally {
                this.loading = false; 
            }
        }
    }
}
</script>

<style scoped>
.product-list-container{
    padding: 10px;
    display: grid;
    gap: 10px;
    grid-template-columns: auto auto auto auto;
    /* border: solid red 1px; */
}

</style>