import { defineStore } from 'pinia';
import axios from 'axios';

export const useLikesStore = defineStore('likes', {
    state: () => ({
        toggleLikeProductsList: [],
        isLiked: false,
        productList: [],
    }),


    actions: {
        //클릭시 찜하기 
        async toggleLike(productIdx) {
            try {
                let productIndex = {
                    "productIdx": productIdx
                }
                //서버로 좋아요전송
                try{
                    this.toggleLikeProductsList = await axios.post('/api/likes/toggle', productIndex, { withCredentials: true });
                    console.log("togglelike 들어왔다", this.toggleLikeProductsList)
                    return true;

                }catch(error){
                    alert(error.response.data.message);
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
                console.log("useLikeStore 상품목록리스트 시작:")
                const response = await axios.get('/api/likes/list', { withCredentials: true });

                //유저가 찜한 상품목록리스트받기
                this.productList = response.data.result
                // this.likedProducts = response.data.result.map(product => ({ ...product, liked: true })); // 응답 데이터로 업데이트

                console.log(this.productList)
            } catch (error) {
                console.error('찜한 상품리스트 조회:', error);
            }
        },
    },
});
