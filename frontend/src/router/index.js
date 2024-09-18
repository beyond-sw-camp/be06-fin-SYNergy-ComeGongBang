import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import CartComponent from '@/components/order/CartComponent.vue';
import AskCommentComponent from "@/components/AskCommentComponent.vue";
import EmailFindPage from "@/pages/member/MemberEmailFindPage";
import HeaderComponent from "@/components/common/HeaderComponent";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
        { path: "/product-list", component: ProductListComponent },
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/cart', component: CartComponent },
        { path: '/ask', component: AskCommentComponent },

        //member
        { path: "/login", component : LoginPage},   // 로그인 페이지
        { path: "/signup", component: SignupPage}, // 회원가입 페이지
        { path: '/member/info', component : MemberInfoPage},    //회원 수정 페이지
        { path: '/member/find', component : EmailFindPage},    //회원 찾기 페이지

        //common
        { path: '/header', component : HeaderComponent},

    ],
});

export default router;