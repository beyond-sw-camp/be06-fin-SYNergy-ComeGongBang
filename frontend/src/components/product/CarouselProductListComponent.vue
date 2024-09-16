<template>
<div class="product-list-container">
    <router-link 
        to="/"
        v-for="product in productList" :key="product.idx">
        <ProductComponentVue  :product="product"/>
    </router-link>
</div>
<!-- :to="{ name: 'product-detail', params: { product: product },}" -->
  
</template>

<script>
import ProductComponentVue from './ProductComponent.vue'

export default {
    components:{
        ProductComponentVue
    },
    props:{
        productList: {
            type: Object,
            required: true
        }
    }
}
</script>

<style scoped>
.product-list-container{
    padding: 10px;
    display: grid;
    gap: 10px;
    grid-template-columns: auto auto auto auto auto;
}
</style>