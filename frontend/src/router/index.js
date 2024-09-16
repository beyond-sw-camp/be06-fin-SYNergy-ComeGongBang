import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselComponent';
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import CartComponent from '@/components/order/CartComponent.vue';
import OrderListComponent from '@/components/order/OrderListComponent'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
        { path: "/product-list", component: ProductListComponent },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/cart', component: CartComponent },
        { path: '/order-list', component: OrderListComponent },
        { path: '/cart', component: CartComponent },

        //member
        { path: "/login", component : LoginPage},   // 로그인 페이지
        { path: "/signup", component: SignupPage}, // 회원가입 페이지
        { path: '/member/info', component : MemberInfoPage},    //회원 수정 페이지
    ],
});

export default router;