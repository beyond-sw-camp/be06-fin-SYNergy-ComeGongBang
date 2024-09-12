import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselComponent';
import CartComponent from '@/components/order/CartComponent.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: "/login", component : LoginPage},
        { path: "/signup", component: SignupPage},
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/cart', component: CartComponent }
    ],
});

export default router;