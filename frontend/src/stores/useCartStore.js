import { defineStore } from 'pinia';
import axios from 'axios';

export const useCartStore = defineStore('cart', {
  state: () => ({
    selectedProductIdxList: [], // 선택된 상품 idx 리스트
    loading: false,
    atelierTotalPrice: {},
    totalPrice: 0,
    cartList: [],
  }),
  actions: {
    async fetchCartList() {
      try {
        const response = await axios.get('/api/cart', {
          params: { userIdx: 2, withCredentials: true },
        });
        console.log('Response:', response.data.result);

        this.cartList = response.data.result.atelierList;
      } catch (error) {
        console.error('Error fetching cartList:', error);
      }
    },
    async updateQuantity(cartIdx, count) {
      this.loading = true;
      try {
        await axios.post(`/api/cart/updateCount`, {
          cartIdx,
          count,
        });
        console.log('count:' + count);
        await this.fetchCartList;
      } catch (error) {
        console.error('Error updating quantity:', error);
      } finally {
        this.loading = false;
      }
    },
  },
});
