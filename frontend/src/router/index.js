import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselComponent';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            component: App
        },

        {
            path: "/product-list",
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