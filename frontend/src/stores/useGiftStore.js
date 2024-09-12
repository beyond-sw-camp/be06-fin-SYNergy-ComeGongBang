import { defineStore } from "pinia";
import axios from "axios";

export const useGiftStore = defineStore("gift", {
    state: () => ({
        giftGiveList:[],
            // {
            //     idx : 1,
            //     count : 2,
            //     date : "2024.09.12",
            //     toUser : "요아정완",
            //     products:[
            //         {
            //             idx : 1,
            //             state : "취소 완료",
            //             name : "도라지 정과",
            //             atelier : "한길로 그대로",
            //             image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-09-12+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+4.11.19.png"
            //         },
            //         {
            //             idx : 2,
            //             state : "취소 완료",
            //             name : "머랭쿠키",
            //             atelier : "짱맛있어",
            //             image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%82%E1%85%A9%E1%84%82%E1%85%A9.png"
            //         }
            //     ]
            // },
            // {
            //     idx : 2,
            //     count : 1,
            //     date : "2024.09.13",
            //     toUser : "야동현",
            //     products:[
            //         {
            //             idx : 1,
            //             state : "작가 발송 완료",
            //             name : "마님은 왜 돌쇠에게 소고기 뭇국을 주었는가",
            //             atelier : "야동현 야동 그만봐",
            //             image_url : "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-09-12+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+4.09.35.png"
            //         }
            //     ]
            // }
        giftTakeList:[],

    }),
    actions:{
        async getGivePresentList(){
            let url = '/api/present/give';

            let response = await axios.get(url);

            if(response.status===200){
                this.giftGiveList= response.data;
            }
        },
        async getTakePresentList(){
            let url = '/api/present/take';

            let response = await axios.get(url);

            if(response.status===200){
                this.giftTakeList= response.data;
            }
        }
    }
})