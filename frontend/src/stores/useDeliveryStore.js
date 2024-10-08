import { defineStore } from "pinia";
import axios from "axios";

export const useDeliveryStore = defineStore("delivery", {
  state: () => ({
    addresses: [],
    selectedAddress : null,
    selectedIndex : null,
    isModalVisible : false,//배송지 선택 모달
  }),
  actions: {
    async fetchAddresses() {
      try {
        const response = await axios.get("/api/member/deliveryAddressList", {
          withCredentials: true,
        });
        this.addresses = response.data.result;
        console.log(this.addresses);
        if(this.selectedAddress==null){
          this.selectedIndex = 0;
          this.selectedAddress = this.addresses[0]
        }
      } catch (error) {
        console.error("Error fetching addresses:", error);
      }
    },
    async addAddress(address) {
      console.log(address);
      try {
        let response = await axios.post(
          "/api/member/deliveryAddress",
          address,
          {
            withCredentials: true, // 필요시 추가
          }
        );
        await this.fetchAddresses();
        return response.data;
      } catch (error) {
        console.error("Error adding address:", error);
      }
    },
    async deleteAddress(idx) {
      try {
        const response = await axios.delete(`/api/member/delivery/${idx}`, {
          withCredentials: true,
        });

        if (response.data.isSuccess) {
          alert(response.data.message);
          return true;
        } else {
          console.error("Error:", response.data.message);
          alert("삭제에 실패했습니다.");
        }
      } catch (error) {
        console.error("Error delete address:", error);
      }
    },
  },
});
