<template>
    <div>
        <div class="product-list-container">
            <router-link 
                to="/"
                v-for="product in productList" :key="product.idx">
                <ProductComponent :product="product"/>
            </router-link>
        </div>
         <!-- <ObserverComponent @show="infiniteHandler"></ObserverComponent> -->
    </div>
</template>

<script>
import { mapStores } from "pinia";
import { useProductStore } from "@/stores/useProductStore";
import ProductComponent from './ProductComponent.vue'
// import ObserverComponent from './ObserverComponent.vue';

export default {
    components:{
        ProductComponent,
        // ObserverComponent
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
        // this.productStore.productList = [];
    },
    methods:{
        async searchByCategory(){
            await this.productStore.searchByCategory(1,this.page, 12);
        },
        async infiniteHandler(){
            if (this.loading) return; 
            this.loading = true; 

            if (this.page !== 0) {
                await new Promise((resolve) => setTimeout(resolve, 150));
            }

            try {
                await this.productStore.searchByCategory(1,this.page, 12);
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
}

</style>