import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
// import ProductComponent from "@/components/product/ProductComponent"
import ProductListComponent from "@/components/product/ProductListComponent"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            component: App
        },

        {
            path: "/product",
            component: ProductListComponent
        },

        {
            path: '/',
            component: App,
        },

        {
            path: '/deliveryAddress',
            component: DeliveryComponent,
        },
    ],
});

export default router;