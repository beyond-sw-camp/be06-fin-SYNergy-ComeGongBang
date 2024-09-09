import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";
// import ProductComponent from "@/components/product/ProductComponent"
import ProductListComponent from "@/components/product/ProductListComponent"
import LoginPage from "@/pages/member/LoginPage.vue"
import SignupPage from "@/pages/member/SingupPage.vue"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
        { path: "/product", component : ProductListComponent},
        { path: "/login", component : LoginPage},
        { path: "/signup", component: SignupPage},
    ],
});

export default router;