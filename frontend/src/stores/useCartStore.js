import { defineStore } from 'pinia';
import axios from 'axios';

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartList: [],
  }),
  actions: {
    async fetchCartList() {
      try {
        const response = await axios.get('/api/cart', {
          params: { userIdx: 2, withCredentials: true },
        });
        console.log('Response:', response.data.result);

        this.cartList = response.data.result;
      } catch (error) {
        console.error('Error fetching cartList:', error);
      }
    },
  },
});
