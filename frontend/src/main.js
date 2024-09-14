import { createApp } from 'vue'
import App from './App.vue'
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const pinia = createPinia();
pinia.use(piniaPersistedState);

const app = createApp(App);

app.use(pinia);
app.use(router);
app.mount('#app')
