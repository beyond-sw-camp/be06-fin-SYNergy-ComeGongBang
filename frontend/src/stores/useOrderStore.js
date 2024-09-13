import { defineStore } from "pinia";
// import axios from "axios";

export const useOrderStore = defineStore("order", {
    state: () => ({
        orderList:[
            {
                idx : 1,
                date : "2024.09.04",
                price : 10500,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 2,
                date : "2023.08.02",
                price : 20000,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 3,
                date : "2023.02.08",
                price : 20500,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            },
            {
                idx : 4,
                date : "2022.01.30",
                price : 10800,
                imgae_url : "",
                name : "100%과일&amp;채소 동결건조 강아지간식 과채믹스",
                state : "취소 완료",
                atelier : "건강하게 먹개"
            }
        ],
        years:[
            {
                idx : 1,
                year : "전체"
            },
            {
                idx : 2,
                year : 2024
            },
            {
                idx : 3,
                year : 2023
            },
            {
                idx : 4,
                year : 2022
            }
        ]
    }),
    actions:{
        async getOrderList(year){
            if(year===null){
                alert("nn");
            }else if(year!==null){
                alert(year);
            }
            // let url = `/api/order/list?year=${year}&keyword=${keyword}&page=0&size=10`;

            // let response = await axios.get(url);
            // // console.log(response);

            // if(response.status===200){
            //     this.orderList = response.data;
            // }
        }
    }
})