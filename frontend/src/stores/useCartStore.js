import { defineStore } from 'pinia';
import axios from 'axios';

// import { useProductStore } from "./useProductStore";

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartList: [], // 장바구니 상품 리스트
    selectedItems: [], // 선택된 상품 리스트 (cartIdx, productIdx, atelierIdx 다)
    loading: false, // 로딩 상태
    totalPrice: 0, // 총 선택된 상품 가격
    totalQuantity: 0, // 총 선택된 상품 수량
    atelierTotals: {}, // 공방 별 가격과 수량

    selectedOptions: [],
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

    async deleteCartItem(cartIdxList) {
      try {
        const response = await axios.delete('/api/cart', {
          data: {
            cartIdx: cartIdxList,
          },
        });
        if (response.data.isSuccess) {
          await this.fetchCartList();
          this.updateSelectedItems();
        } else {
          throw new Error(response.data.message);
        }
      } catch (error) {
        console.error('Error delete cartIdx List:', error);
        throw error;
      }
    },

    async purchaseCartList(encrypt) {
      try {
        this.loading = true;
        console.log('이거 실행됨?');

        const response = await axios.get(`/api/cart/direct/${encrypt}`);
        this.cartList = response.data.result.atelierList;
        console.log('cartList::', this.cartList);
        this.updateSelectedItems();
      } catch (error) {
        console.error('Error fetching cart list:', error);
      } finally {
        this.loading = false;
      }
    },

    //================장바구니에 추가================//
    async addCart(productIdx) {
      try {
        this.loading = true;
        //프로덕트 스토어에 저장된 상품 선택리스트를 req에 맞게 가공
        const req = this.transformSelectedOptions(productIdx);
        console.log(req);
        this.selectedOptions = [];

        const response = await axios.post(`/api/cart`, req, {
          withCredentials: true,
        });

        if (!response.data.isSuccess) {
          console.log(response.data.message);
          return false;
        }

        return true;
      } catch (error) {
        console.error(
          '장바구니에 상품을 담는 중 문제가 발생하였습니다.',
          error
        );
      } finally {
        this.loading = false;
      }
    },
    async buyNow(productIdx) {
      try {
        const req = this.transformSelectedOptions(productIdx);
        console.log('req : ');
        console.log(req);
        this.selectedOptions = [];

        const response = await axios.post(`/api/cart/purchase`, req, {
          withCredentials: true,
        }); //임호화 코드
        return response.data.result;
      } catch (error) {
        console.error(
          '장바구니에 상품을 담는 중 문제가 발생하였습니다.',
          error
        );
      }
    },
    //prodictStore에 있는 정보를 addCart 요청을 보낼 수 있는 데이터로 가공
    transformSelectedOptions(productIdx) {
      console.log('옵션 : ', this.selectedOptions);

      return this.selectedOptions.map((selectedOption) => {
        // majorOption과 subOption을 addCartOptions 리스트로 변환
        const addCartOptions = selectedOption.option.map((subOption, index) => {
          const optionData = {
            majorOption: index + 1, // 대분류는 index + 1
            subOption: subOption, // 소분류는 배열의 값
          };
          return optionData;
        });

        // 백엔드가 요구하는 AddCartReq 형식으로 변환
        const requestData = {
          productIdx: productIdx,
          count: selectedOption.count,
          optionSummary: selectedOption.optionString,
          addCartOptions: addCartOptions,
        };

        return requestData;
      });
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

    async saveOrderMessage(cartIdx, message) {
      try {
        this.loading = true;
        await axios.patch('/api/cart/order-message', {
          cartIdx: cartIdx,
          message: message,
        });
        await this.fetchCartList();
        this.updateSelectedItems();
      } catch (error) {
        console.error('Error save orderMessage:', error);
      } finally {
        this.loading = false;
      }
    },
  },
});
