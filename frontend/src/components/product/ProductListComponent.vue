<template>
<div class="product-list-container" :class="layoutClass">
    <ProductComponentVue v-for="product in productList" :key="product.idx" :product="product"/>
</div>
  
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
        },
        layout:{
            type : Number,
            required: true
        }
    },
    computed:{
        layoutClass() {
            return this.layout === 4 ? 'layout-4' : 'layout-5';
        }
    }
}
</script>

<style scoped>
.product-list-container{
    padding: 10px;
    display: grid;
    gap: 10px;
}
.layout-4{
    grid-template-columns: auto auto auto auto;
}
.layout-5{
    grid-template-columns: auto auto auto auto auto;
}

</style>