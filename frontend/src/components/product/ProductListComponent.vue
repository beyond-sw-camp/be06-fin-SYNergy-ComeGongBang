<template>
    <div class="product-list-container">
        <ProductComponent v-for="product in this.productStore.productList" :key="product.idx" :product="product"/>
        
    </div>
    <InfiniteLoading @infinite="infiniteHandler"></InfiniteLoading>
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";
import ProductComponent from './ProductComponent.vue'
import { InfiniteLoading } from '../../../node_modules/v3-infinite-loading/lib/v3-infinite-loading.es.js';
import "v3-infinite-loading/lib/style.css";

export default {
    components:{
        ProductComponent,
        InfiniteLoading
    },
    data(){
        return{
            page:0
        }
    },
    computed:{
        ...mapStores(useProductStore)
    },
    // created(){
    //     this.searchByCategory();
    // },
    methods:{
        // searchByCategory(){
        //     this.productStore.searchByCategory(this.page);
        // },
        infiniteHandler($state){
            try {
                this.productStore.searchByCategory(this.page);
                $state.loaded();
                this.page++;
                console.log("page : "+this.page);
            } catch (error) {
                $state.error()
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
    height: 100vh;
}

</style>