import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent.vue"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselProductListComponent.vue';
import AskCommentComponent from "@/components/AskCommentComponent.vue";
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import UpdateMemberInfoComponent from "@/components/member/UpdateMemberInfoComponent.vue"
import CartComponent from '@/components/order/CartComponent.vue';
import OrderListComponent from '@/components/order/OrderListComponent'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/ask', component: AskCommentComponent },
        { path: "/login", component: LoginPage },
        { path: "/signup", component: SignupPage },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/ask', component: AskCommentComponent },
        { path: '/carousel', component: Carousel },
        { path: '/cart', component: CartComponent },
        { path: '/order-list', component: OrderListComponent },
        { path: '/member/info', component: MemberInfoPage },
        { path: '/update/member/info', component: UpdateMemberInfoComponent },
    ],
});

export default router;