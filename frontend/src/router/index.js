import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/ProductCarouselComponent';
import AskCommentComponent from "@/components/AskCommentComponent.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: "/product", component: ProductListComponent },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/ask', component: AskCommentComponent },
        { path: "/login", component: LoginPage },
        { path: "/signup", component: SignupPage },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/ask', component: AskCommentComponent },
    ],
});

export default router;