import { defineStore } from 'pinia';
import axios from 'axios';

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartList: [], // 장바구니 상품 리스트
    selectedItems: [], // 선택된 상품 리스트 (cartIdx, productIdx, atelierIdx 다)
    loading: false, // 로딩 상태
    totalPrice: 0, // 총 선택된 상품 가격
    totalQuantity: 0, // 총 선택된 상품 수량
    atelierTotals: {}, // 공방 별 가격과 수량
  }),
  actions: {
    // 장바구니 조회
    async fetchCartList() {
      try {
        this.loading = true;
        const response = await axios.get('/api/cart');
        this.cartList = response.data.result.atelierList;
        this.updateSelectedItems();
      } catch (error) {
        console.error('Error fetching cart list:', error);
      } finally {
        this.loading = false;
      }
    },

    // 선택된 아이템의 상태를 업데이트
    updateSelectedItems() {
      this.cartList.forEach((atelier) => {
        atelier.productList.forEach((product) => {
          product.optionList.forEach((option) => {
            const isSelected = this.selectedItems.some(
              (item) => item.cartIdx === option.cartIdx
            );
            option.selected = isSelected;
          });
        });
      });

      // 공방별로 선택된 상품의 가격 및 수량 계산
      this.atelierTotals = {};
      this.selectedItems.forEach((item) => {
        const { atelierIdx } = item;

        if (!this.atelierTotals[atelierIdx]) {
          this.atelierTotals[atelierIdx] = { totalPrice: 0, totalQuantity: 0 };
        }
        this.atelierTotals[atelierIdx].totalPrice += item.price * item.count;

        this.atelierTotals[atelierIdx].totalQuantity += item.count;
      });

      // 총 선택된 상품 가격 및 수량 계산
      this.totalPrice = this.selectedItems.reduce(
        (sum, item) => sum + item.price * item.count,
        0
      );
      const uniqueProducts = new Set(
        this.selectedItems.map((item) => item.productIdx)
      );
      this.totalQuantity = uniqueProducts.size;
    },

    toggleAll(selected) {
      this.selectedItems = [];
      if (selected) {
        this.cartList.forEach((atelier) => {
          atelier.productList.forEach((product) => {
            const isValid = this.verifyCart(product.productIdx);
            if (isValid) {
              product.optionList.forEach((option) => {
                this.selectedItems.push({
                  ...option,
                  productIdx: product.productIdx,
                  atelierIdx: atelier.atelierIdx,
                });
              });
            } else {
              console.warn(`ProductIdx: ${product.productIdx} verify failed`);
            }
          });
        });
      }
      this.updateSelectedItems();
    },

    toggleAtelier(products, selected, atelierIdx) {
      if (selected) {
        products.forEach((product) => {
          const isValid = this.verifyCart(product.productIdx); // 유효성 검증
          if (isValid) {
            product.optionList.forEach((option) => {
              if (
                !this.selectedItems.some(
                  (item) => item.cartIdx === option.cartIdx
                )
              ) {
                this.selectedItems.push({
                  ...option,
                  productIdx: product.productIdx,
                  atelierIdx: atelierIdx,
                });
              }
            });
          } else {
            console.warn(`Product with ID ${product.productIdx} is not valid.`);
          }
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

    toggleProduct(options, selected, productIdx, atelierIdx) {
      options.forEach((option) => {
        if (selected) {
          if (
            !this.selectedItems.some((item) => item.cartIdx === option.cartIdx)
          ) {
            const isValid = this.verifyCart(productIdx);
            if (isValid) {
              this.selectedItems.push({
                ...option,
                productIdx,
                atelierIdx,
              });
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
        });

        // selectedItems에서 수량 업데이트
        const item = this.selectedItems.find(
          (item) => item.cartIdx === cartIdx
        );
        if (item) {
          item.count = count;
        }
        await this.fetchCartList();
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
