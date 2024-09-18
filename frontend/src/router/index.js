import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"
import DeliveryComponent from '@/components/member/DeliveryComponent.vue';
import Carousel from '@/components/product/CarouselComponent';
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import UpdateMemberInfoComponent from "@/components/member/UpdateMemberInfoComponent.vue";
import CartComponent from '@/components/order/CartComponent.vue';
import OrderListComponent from '@/components/order/OrderListComponent';
import MyFavoriteListComponent from "@/components/mypage/MyFavoriteListComponent.vue";
import MyPage from "@/pages/mypage/MyPage.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: "/login", component: LoginPage },
        { path: "/signup", component: SignupPage },
        // { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/cart', component: CartComponent },
        // { path: '/mypage/order-list', name: "MyOrderList", component: OrderListComponent },
        { path: '/member/info', component: MemberInfoPage },
        { path: '/update/member/info', component: UpdateMemberInfoComponent },

        //마이페이지 안에 router되도록
        {
            path: '/mypage',
            component: MyPage, // 고정
            // 마이페이지/관심/~~~
            children: [
                { path: '/favorite/likes', name: 'likes', component: MyFavoriteListComponent, props: { initialTab: 0 } },
                { path: '/favorite/follow-artist', name: 'follow-artist', component: MyFavoriteListComponent, props: { initialTab: 1 } },
                { path: '/favorite/recent-view', name: 'recent-view', component: MyFavoriteListComponent, props: { initialTab: 2 } },
                { path: '/order-list', name: 'order-list', component: OrderListComponent },
                { path: '/deliveryAddress', name: 'deliveryAddress', component: DeliveryComponent },
            ],
        },
    ],
});

export default router;