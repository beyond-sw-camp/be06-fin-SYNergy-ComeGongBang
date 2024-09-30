import { defineStore } from 'pinia';
import axios from 'axios';

export const useDeliveryStore = defineStore('delivery', {
  state: () => ({
    addresses: [],
  }),
  actions: {
    async fetchAddresses() {
      try {
        const response = await axios.get('/api/member/deliveryAddressList');
        this.addresses = response.data.result;
      } catch (error) {
        console.error('Error fetching addresses:', error);
      }
    },
    async addAddress(address) {
      console.log(address);
      try {
        let response = await axios.post('/api/member/deliveryAddress', address);
        await this.fetchAddresses();
        return response.data;
      } catch (error) {
        console.error('Error adding address:', error);
      }
    },
  },
});
