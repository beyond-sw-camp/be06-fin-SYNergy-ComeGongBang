import {createRouter, createWebHistory} from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselComponent';
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import UpdateMemberInfoComponent from "@/components/member/UpdateMemberInfoComponent.vue"
import CartComponent from '@/components/order/CartComponent.vue';
import OrderListComponent from '@/components/order/OrderListComponent';
import ProductDetailPaymentComponent from '@/components/product/ProductDetailPaymentComponent'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: "/login", component : LoginPage},
        { path: "/signup", component: SignupPage},
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/cart', component: CartComponent },
        { path: '/order-list', component: OrderListComponent },
        { path: '/member/info', component : MemberInfoPage},
        { path: '/update/member/info', component: UpdateMemberInfoComponent},
        { path: '/cart', component: CartComponent },
        { path: '/payment', component: ProductDetailPaymentComponent }
    ],
});

export default router;
