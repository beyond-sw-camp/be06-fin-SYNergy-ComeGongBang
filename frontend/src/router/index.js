import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
// import ProductComponent from "@/components/product/ProductComponent"
import ProductListComponent from "@/components/product/ProductListComponent"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/ProductCarouselComponent';
import AskCommentComponent from "@/components/AskCommentComponent.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
        { path: "/product", component: ProductListComponent },
        { path: '/', component: App },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/ask', component: AskCommentComponent }
    ],
});

export default router;