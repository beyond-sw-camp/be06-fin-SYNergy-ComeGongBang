import { defineStore } from 'pinia';
import axios from 'axios';

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartList: [], // 장바구니 상품 리스트
    selectedItems: [], // 선택된 상품 리스트 (cartIdx 기준)
    loading: false, // 로딩 상태
    totalPrice: 0, // 총 선택된 상품 가격
    totalQuantity: 0, // 총 선택된 상품 수량
  }),
  actions: {
    async fetchCartList() {
      try {
        this.loading = true;
        const response = await axios.get('/api/cart'); // 장바구니 API 호출
        this.cartList = response.data.result.atelierList; // atelierList 할당
        this.updateSelectedItems();
      } catch (error) {
        console.error('Error fetching cart list:', error);
      } finally {
        this.loading = false;
      }
    },

    updateSelectedItems() {
      // 장바구니 아이템을 기준으로 선택된 아이템 업데이트
      this.cartList.forEach((atelier) => {
        atelier.productList.forEach((product) => {
          product.optionList.forEach((option) => {
            const isSelected = this.selectedItems.some(
              (item) => item.cartIdx === option.cartIdx
            );
            option.selected = isSelected; // 선택된 상태로 표시
          });
        });
      });

      // 상품별 수량 계산
      const productQuantities = {};
      this.selectedItems.forEach((item) => {
        const { productIdx } = item;
        if (!productQuantities[productIdx]) {
          productQuantities[productIdx] = 0;
        }
        productQuantities[productIdx] += item.count;
      });

      // 총 선택된 상품 종류 수 계산 (고유한 productIdx의 갯수)
      this.totalQuantity = Object.keys(productQuantities).length;

      // 총 가격 계산
      this.totalPrice = this.selectedItems.reduce(
        (sum, item) => sum + item.price * item.count,
        0
      );
    },

    toggleAll(selected) {
      this.selectedItems = [];
      if (selected) {
        this.cartList.forEach((atelier) => {
          atelier.productList.forEach((product) => {
            product.optionList.forEach((option) => {
              this.selectedItems.push(option);
            });
          });
        });
      }
      this.updateSelectedItems();
    },

    toggleAtelier(products, selected) {
      if (selected) {
        products.forEach((product) => {
          product.optionList.forEach((option) => {
            if (
              !this.selectedItems.some(
                (item) => item.cartIdx === option.cartIdx
              )
            ) {
              this.selectedItems.push(option);
            }
          });
        });
      } else {
        this.selectedItems = this.selectedItems.filter(
          (item) =>
            !products
              .flatMap((product) => product.optionList)
              .some((option) => option.cartIdx === item.cartIdx)
        );
      }
      this.updateSelectedItems();
    },

    toggleProduct(options, selected, productIdx) {
      options.forEach((option) => {
        if (selected) {
          if (
            !this.selectedItems.some((item) => item.cartIdx === option.cartIdx)
          ) {
            const isValid = this.verifyCart(productIdx);
            if (isValid) {
              this.selectedItems.push(option);
            } else {
              console.warn(
                `Product with ID ${option.productIdx} is not valid.`
              );
            }
          }
        } else {
          this.selectedItems = this.selectedItems.filter(
            (item) => item.cartIdx !== option.cartIdx
          );
        }
      });
      this.updateSelectedItems();
    },

    async updateQuantity(cartIdx, count) {
      try {
        this.loading = true;
        await axios.post(`/api/cart/updateCount`, {
          cartIdx,
          count,
        }); // 수량 업데이트 API 요청

        // selectedItems에서 수량 업데이트
        const item = this.selectedItems.find(
          (item) => item.cartIdx === cartIdx
        );
        if (item) {
          item.count = count;
        }

        // 장바구니 전체를 다시 불러와서 최신 상태 반영
        await this.fetchCartList();

        // 총 가격 및 수량 재계산
        this.updateSelectedItems();
      } catch (error) {
        console.error('Error updating quantity:', error);
      } finally {
        this.loading = false;
      }
    },

    next() {
      return {
        selectedItems: this.selectedItems.map((item) => ({
          cartIdx: item.cartIdx,
          count: item.count,
          price: item.price,
        })),
        totalPrice: this.totalPrice,
        totalQuantity: this.totalQuantity,
      };
    },

    async verifyCart(productIdx) {
      this.loading = true;
      console.log('productIdx: ' + productIdx);
      try {
        const response = await axios.post(`/api/cart/verify`, { productIdx });
        return response.data.isSuccess;
      } catch (error) {
        console.error('Error verify Cart:', error);
        return false;
      } finally {
        this.loading = false;
      }
    },
  },
});
