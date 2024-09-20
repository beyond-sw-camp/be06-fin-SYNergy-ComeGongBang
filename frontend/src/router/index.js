import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SignupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import CartComponent from '@/components/order/CartComponent.vue';
import MyFavoriteListComponent from "@/components/mypage/MyFavoriteListComponent.vue";
import MyPage from "@/pages/mypage/MyPage.vue";
import MainPage from '@/pages/MainPage'
import OrderPayment from '@/pages/payment/OrderPaymentPage';
import PresentPayment from '@/pages/payment/PresentPaymentPage';
import AtelierPage from '@/pages/atelier/AtelierPage';
import AtelierProducts from '@/components/atelier/AtelierProductListComponent';
import AtelierProfile from '@/components/atelier/AtelierProfileComponent';
import AtelierReview from '@/components/atelier/AtelierReviewComponent';
import AskCommentComponent from "@/components/AskCommentComponent.vue";
import EmailFindPage from "@/pages/member/MemberEmailFindPage";
import GradeComponent from '@/components/mypage/GradeComponent.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/mypage',
            component: MyPage, // 고정
            children: [
                { path: 'favorite/likes', name: 'likes', component: MyFavoriteListComponent, props: { initialTab: 0 } },
                { path: 'favorite/follow-artist', name: 'follow-artist', component: MyFavoriteListComponent, props: { initialTab: 1 } },
                { path: 'favorite/recent-view', name: 'recent-view', component: MyFavoriteListComponent, props: { initialTab: 2 } },
                { path: '/deliveryAddress', name: 'deliveryAddress', component: DeliveryComponent },
                { path: '/grade', name: 'grade', component: GradeComponent },
            ],
        },

        { path: "/main", component: MainPage },

        { path: '/cart', component: CartComponent },
        { path: '/order/payment', component: OrderPayment },
        { path: '/present/payment', component: PresentPayment },

        {
            path: '/atelier', component: AtelierPage,
            children: [
                { path: '/products', component: AtelierProducts },
                { path: '/profile', component: AtelierProfile },
                { path: '/review', component: AtelierReview }
            ]
        },
        { path: '/ask', component: AskCommentComponent },

        //member
        { path: "/login", component: LoginPage },   // 로그인 페이지
        { path: "/signup", component: SignupPage }, // 회원가입 페이지
        { path: '/member/info', component: MemberInfoPage },    //회원 수정 페이지
        { path: '/member/find', component: EmailFindPage },    //회원 찾기 페이지

    ],
});

export default router;