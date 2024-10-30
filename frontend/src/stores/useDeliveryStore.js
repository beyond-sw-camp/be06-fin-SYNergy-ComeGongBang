import { defineStore } from "pinia";
import axios from "axios";
import swal from 'sweetalert2';

export const useDeliveryStore = defineStore("delivery", {
  state: () => ({
    addresses: [],
    selectedAddress: null,
    selectedIndex: null,
    isModalVisible: false,//배송지 선택 모달
  }),
  actions: {
    showAlert(content) {
      swal.fire({
        title: "Oops!",
        text: content,
        icon: "error",
      });
    },
    showSuccessAlert(content) {
      swal.fire({
        title: "Success!",
        text: content,
        icon: "success",
      });
    },
    async fetchAddresses() {
      try {
        const response = await axios.get("/api/member/deliveryAddressList", {
          withCredentials: true,
        });
        this.addresses = response.data.result;

        if (this.selectedAddress == null) {
          this.selectedIndex = 0;
          this.selectedAddress = this.addresses[0]
        }
      } catch (error) {
        console.error("Error fetching addresses:", error);
      }
    },
    async addAddress(address) {
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
          this.showSuccessAlert(response.data.message);
          return true;
        } else {
          console.error("Error:", response.data.message);
          this.showAlert("삭제에 실패했습니다.");
        }
      } catch (error) {
        console.error("Error delete address:", error);
      }
    },
  },
});
