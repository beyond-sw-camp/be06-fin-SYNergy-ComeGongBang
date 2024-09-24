import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[],

        //-----상세 페이지 결제용 더미데이터 - 나중에 삭제------
        product : {
            idx:1,
            name : "강아지 인식표",
            atelier : "건강하게 먹개1",
            score : 5.0,
            reviewCount : 234,
            price : 14000,
            percent : 25,
            lank : 2,
            delivery : 2500,
            options : [
                {
                    idx : 1,
                    name : "option01",
                    subOptions : [
                        {
                            idx : 1,
                            name : "select01",
                            addPrice : 1000
                        },
                        {
                            idx : 2,
                            name : "select02",
                            addPrice : 2000
                        },
                        {
                            idx : 3,
                            name : "select03",
                            addPrice : 1000
                        },
                    ],
                },
                {
                    idx : 2,
                    name : "option02",
                    subOptions : [
                        {
                            idx : 1,
                            name : "select01",
                            addPrice : 3000
                        },
                        {
                            idx : 2,
                            name : "select02",
                            addPrice : 1000
                        },
                        {
                            idx : 3,
                            name : "select03",
                            addPrice : 1500
                        },
                    ],
                },
                {
                    idx : 3,
                    name : "option03",
                    subOptions : [
                        {
                            idx : 1,
                            name : "select01",
                            addPrice : 0
                        },
                        {
                            idx : 2,
                            name : "select02",
                            addPrice : 1000
                        },
                        {
                            idx : 3,
                            name : "select03",
                            addPrice : 1000
                        },
                    ],
                },
            ]
        },

        selectedOptions : [],
        //---------------------------------------------

        //----------싱세페이지 캐러셀용 더미데이터-------------
        imageUrl:[
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/1.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/2.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/3.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/4.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/5.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/6.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/7.png",
            "https://springprac2024-s3.s3.ap-northeast-2.amazonaws.com/8.png"
        ],
        //---------------------------------------------

        //----------해시태그용 더미데이터-------------
        hashtag:[
            "인식표", "강아지 인식표", "고양이 인식표", "반려동물 목걸이"
        ]
        //---------------------------------------------

    }),
    actions:{
        async searchByCategory(idx, page, size){

            let url = `/api/product/search?categoryIdx=${idx}&page=${page}&size=${size}`;

            let response = await axios.get(url, {withCredentials : false});
            console.log(response);

            if(response.status===200){
                // this.productList = response.data;
                this.productList.push(...response.data);
            }
        }
    }
})
