import { createRouter, createWebHistory } from "vue-router";
import App from "@/App";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: "/", component: App },
    ],
});

export default router;