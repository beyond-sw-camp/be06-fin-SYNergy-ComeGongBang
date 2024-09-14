import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent.vue"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselProductListComponent.vue';
import AskCommentComponent from "@/components/AskCommentComponent.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/ask', component: AskCommentComponent },
        { path: "/login", component: LoginPage },
        { path: "/signup", component: SignupPage },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/ask', component: AskCommentComponent },
        { path: '/carousel', component: Carousel },
    ],
});

export default router;