import { createApp } from 'vue';
import App from './App.vue';
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

import { createPinia } from 'pinia';
import piniaPersistedState from 'pinia-plugin-persistedstate'

import router from './router';

const pinia = createPinia();
pinia.use(piniaPersistedState);

const app = createApp(App);

app.use(pinia);
app.use(router);
app.use(VueSweetalert2);
app.mount('#app')
