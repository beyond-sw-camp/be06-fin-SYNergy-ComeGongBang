import { defineStore } from "pinia";
import axios from "axios";

export const useProductStore = defineStore("product", {
    state: () => ({
        productList:[],

        testProductList:[
            {
                idx:1,
                atelier : "건강하게 먹개1",
                score : 5.0,
                price : 14000,
                percent : 25,
                lank : 2,
                delivery : 2500,
                options : [
                    {
                        idx : 1,
                        name : "option01",
                        selects : [
                            {
                                idx : 1,
                                name : "select01"
                            },
                            {
                                idx : 2,
                                name : "select02"
                            },
                            {
                                idx : 3,
                                name : "select03"
                            },
                        ]
                    },
                    {
                        idx : 2,
                        name : "option02",
                        selects : [
                            {
                                idx : 1,
                                name : "select01"
                            },
                            {
                                idx : 2,
                                name : "select02"
                            },
                            {
                                idx : 3,
                                name : "select03"
                            },
                        ]
                    },
                    {
                        idx : 3,
                        name : "option03",
                        selects : [
                            {
                                idx : 1,
                                name : "select01"
                            },
                            {
                                idx : 2,
                                name : "select02"
                            },
                            {
                                idx : 3,
                                name : "select03"
                            },
                        ]
                    },
                ]
            },
            {
                idx:2,
                atelier : "건강하게 먹개2",
                score : 4.0,
                price : 14000,
                percent : 25,
                lank : 2,
                delivery : 3000
            },
            {
                idx:3,
                atelier : "건강하게 먹개3",
                score : 4.8,
                price : 14000,
                percent : 25,
                lank : 2,
                delivery : 2700
            },
            {
                idx:4,
                atelier : "건강하게 먹개4",
                score : 4.9,
                price : 14000,
                percent : 25,
                lank : 2,
                delivery : 3500
            }
        ],

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
                    selects : [
                        {
                            idx : 1,
                            name : "select01"
                        },
                        {
                            idx : 2,
                            name : "select02"
                        },
                        {
                            idx : 3,
                            name : "select03"
                        },
                    ],
                    selectedIdx : ""
                },
                {
                    idx : 2,
                    name : "option02",
                    selects : [
                        {
                            idx : 1,
                            name : "select01"
                        },
                        {
                            idx : 2,
                            name : "select02"
                        },
                        {
                            idx : 3,
                            name : "select03"
                        },
                    ],
                    selectedIdx : ""
                },
                {
                    idx : 3,
                    name : "option03",
                    selects : [
                        {
                            idx : 1,
                            name : "select01"
                        },
                        {
                            idx : 2,
                            name : "select02"
                        },
                        {
                            idx : 3,
                            name : "select03"
                        },
                    ],
                    selectedIdx : ""
                },
            ]
        },

        selectedIdx: new Map(),
        selectedOptions : []

    }),
    actions:{
        async searchByCategory(){
            let url = '/api/search?categoryIdx=1';

            let response = await axios.get(url);
            // console.log(response);

            if(response.status===200){
                this.productList = response.data;
            }
        }
    }
})
