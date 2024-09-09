<template>
<div class="product-list-container">
    <ProductComponentVue v-for="product in this.productStore.productList" :key="product.idx" :product="product"/>
</div>
<!-- <button @click="searchByCategory">요청</button> -->
  
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore"
import ProductComponentVue from './ProductComponent.vue'

export default {
    computed: {
        ...mapStores(useProductStore)
    },
    components:{
        ProductComponentVue
    },
    created(){
        this.searchByCategory()
    },
    data() {
        return {
        }
    },
    methods:{
        searchByCategory(){
            this.productStore.searchByCategory();
        }
    }
}
</script>

<style scoped>
.product-list-container{
    padding: 10px;
    display: grid;
    grid-template-columns: auto auto auto auto;
    gap: 10px;
}

</style>