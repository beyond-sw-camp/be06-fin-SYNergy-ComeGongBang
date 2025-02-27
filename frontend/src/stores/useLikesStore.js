import { defineStore } from 'pinia';
import axios from 'axios';
import swal from 'sweetalert2';

export const useLikesStore = defineStore('likes', {
    state: () => ({
        // toggleLikeProductsList: [],
        isLiked: false,
        productList: [],
    }),


    actions: {
        showAlert(content) {
            swal.fire({
                title: "Oops!",
                text: content,
                icon: "error",
            });
        },
        //클릭시 찜하기 
        async toggleLike(productIdx) {
            try {
                let productIndex = {
                    "productIdx": productIdx
                }
                //서버로 좋아요전송
                try {
                    const response = await axios.post('/api/likes/toggle', productIndex, { withCredentials: true });
                    return response.data.result;
                } catch (error) {
                    this.showAlert(error.response.data.message);
                    return false;
                }

                // productIdx로 상품 정보 불러오기
                // await this.getLikedProductsList();

            } catch (error) {
                console.error('Error toggling like:', error);
            }
        },

        //유저가찜한 상품목록리스트
        async getLikedProductsList() {
            try {
                const response = await axios.get('/api/likes/list', { withCredentials: true });

                //유저가 찜한 상품목록리스트받기
                this.productList = response.data.result
                // this.likedProducts = response.data.result.map(product => ({ ...product, liked: true })); // 응답 데이터로 업데이트

            } catch (error) {
                console.error('찜한 상품리스트 조회:', error);
            }
        },
    },
});
