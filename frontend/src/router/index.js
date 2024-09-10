import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
// import ProductComponent from "@/components/product/ProductComponent"
import ProductListComponent from "@/components/product/ProductListComponent"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/ProductCarouselComponent';

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
        {
            path: '/carousel',
            component: Carousel
        }
    ],
});

export default router;