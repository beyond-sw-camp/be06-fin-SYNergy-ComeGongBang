import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
// import ProductComponent from "@/components/product/ProductComponent"
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/ProductCarouselComponent';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
        { path: "/product", component : ProductListComponent},
        { path: "/login", component : LoginPage},
        { path: "/signup", component: SignupPage},
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel }
    ],
});

export default router;