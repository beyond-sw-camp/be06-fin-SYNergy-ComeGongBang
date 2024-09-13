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
import ProductDetailPage from "@/pages/product/ProductDetailPage";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/product-list", component: ProductListComponent },
        { path: "/", component: App },
        { path: "/login", component : LoginPage},
        { path: "/signup", component: SignupPage},
        { path: '/deliveryAddress', component: DeliveryComponent },
        { path: '/carousel', component: Carousel },
        { path: '/member/info', component : MemberInfoPage},
        { path: '/update/member/info', component: UpdateMemberInfoComponent},
        { path: '/cart', component: CartComponent },


        //product
        { name:"productDetailPage", path: '/product/detail/:productIdx', component: ProductDetailPage},
    ],
});

export default router;