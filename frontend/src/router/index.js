import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "@/pages/member/LoginPage.vue";
import SignupPage from "@/pages/member/SignupPage.vue";
import DeliveryComponent from "@/components/member/DeliveryComponent.vue";
import MemberInfoPage from "@/pages/member/MemberInfoPage.vue";
import ProductDetailPage from '@/pages/product/ProductDetailPage';
import CartComponent from "@/components/order/CartComponent.vue";
import MyFavoriteListComponent from "@/components/mypage/MyFavoriteListComponent.vue";
import MyPage from "@/pages/mypage/MyPage.vue";
import MainPage from "@/pages/MainPage";
import OrderPayment from "@/pages/payment/OrderPaymentPage";
import PresentPayment from "@/pages/payment/PresentPaymentPage";
import AtelierPage from "@/pages/atelier/AtelierPage";
import AtelierProducts from "@/components/atelier/AtelierProductListComponent";
import AtelierProfile from "@/components/atelier/AtelierProfileComponent";
import AskCommentComponent from "@/components/AskCommentComponent.vue";
import EmailFindPage from "@/pages/member/MemberEmailFindPage";
import GradeComponent from '@/components/mypage/GradeComponent.vue';
import ProductDetailPayementComponent from '@/components/product/ProductDetailPaymentComponent'
import LoginCallBackComponent from "@/components/member/LoginCallBackComponent";
import { useMemberStore } from "@/stores/useMemberStore";
import CategoryProductListPage from "@/pages/product/CategoryProductListPage.vue";

const requireLogin = async (to, from, next) => {
  const memberStore = useMemberStore();

  // await memberStore.verify(); // TODO

  if (memberStore.isLogined) {
    return next();
  }

  next({
    path: "/login",
    query: { redirect: to.fullPath },
  });
};

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/mypage",
      component: MyPage, // 고정
      children: [
        {
          path: "favorite/likes",
          name: "likes",
          component: MyFavoriteListComponent,
          props: { initialTab: 0 },
        },
        {
          path: "favorite/follow-artist",
          name: "follow-artist",
          component: MyFavoriteListComponent,
          props: { initialTab: 1 },
        },
        {
          path: "favorite/recent-view",
          name: "recent-view",
          component: MyFavoriteListComponent,
          props: { initialTab: 2 },
        },
        {
          path: "/deliveryAddress",
          name: "deliveryAddress",
          component: DeliveryComponent,
        },
        { path: "/grade", name: "grade", component: GradeComponent },
      ],
    },

    { path: "/main", component: MainPage },

    //카테고리
    { path: "/category/:categoryIdx", component: CategoryProductListPage },

    // 장바구니, 구매, 선물
    {
      path: "/cart",
      name: "Cart",
      component: CartComponent,
      beforeEnter: requireLogin,
      props: { pageType: "cart" },
    },
    {
      path: "/cart/direct/:encryptedCartIdx",
      name: "OrderPage",
      component: CartComponent,
      beforeEnter: requireLogin,
      props: (route) => ({
        pageType: "order",
        encryptedCartIdx: route.params.encryptedCartIdx,
      }),
    },
    {
      path: "/cart/gift/:encryptedCartIdx",
      name: "GiftPage",
      component: CartComponent,
      beforeEnter: requireLogin,
      props: (route) => ({
        pageType: "gift",
        encryptedCartIdx: route.params.encryptedCartIdx,
      }),
    },

    { path: "/order/payment", component: OrderPayment },
    { path: "/present/payment", component: PresentPayment },

    { name: "productDetail", path: '/product-detail/:idx', component: ProductDetailPage },
    { path: "/detail-payment", component: ProductDetailPayementComponent},

    {
      path: "/atelier",
      component: AtelierPage,
      children: [
        { path: "", redirect: "/profile" },
        { path: "/products", component: AtelierProducts },
        { path: "/profile", component: AtelierProfile },
      ],
    },
    { path: "/ask", component: AskCommentComponent },

    //member
    { path: "/login", component: LoginPage }, // 로그인 페이지
    { path: "/login-callback", component: LoginCallBackComponent }, // 소셜 로그인 콜백
    { path: "/signup", component: SignupPage }, // 회원가입 페이지
    { path: "/member/info", component: MemberInfoPage }, //회원 수정 페이지
    { path: "/member/find", component: EmailFindPage }, //회원 찾기 페이지
  ],
});

export default router;
