<template>
<div class="product-list-container">
    <div><ProductComponentVue/></div>
    <div><ProductComponentVue/></div>
    <div><ProductComponentVue/></div>
    <div><ProductComponentVue/></div>
    <div><ProductComponentVue/></div>
    <div><ProductComponentVue/></div>
</div>
  
</template>

<script>
import ProductComponentVue from './ProductComponent.vue'

export default {
    components:{
        ProductComponentVue
    },
    data() {
        return {
            products:[
                {
                    idx : 1,
                    
                }
            ]
        }
    },
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