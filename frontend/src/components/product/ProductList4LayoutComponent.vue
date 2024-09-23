<template>
    <div>
        <div class="product-list-container">
            <router-link :to="{ name: 'productDetail', params: { idx: product.idx },}" v-for="product in productList" :key="product.idx">
                <ProductComponent :product="product"/>
            </router-link>
        </div>
    </div>
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";
import ProductComponent from './ProductComponent.vue'

export default {
    components:{
        ProductComponent,
    },
    data(){
        return{
            page:0,
            loading: false //로딩 관리
        }
    },
    props:{
        productList : {
            type: Object,
            required: true
        }
    },
    computed:{
        ...mapStores(useProductStore)
    },
    created(){
    },
    methods:{
    }
}
</script>

<style scoped>
.product-list-container{
    padding: 10px;
    display: grid;
    gap: 10px;
    grid-template-columns: auto auto auto auto;
}

</style>