import { defineStore } from "pinia";
import axios from "axios";

export const useMemberStore = defineStore('member', {
    state: () => ({
        member : {
            idx : "",
            nickname : "",
            email : "",
            cellphone : "",
            defaultAddress : "",
            profileImageUrl : "",
            gradeIdx : "",
            gradeName : "",
            gradeImageUrl : "@/assets/cgb.png",
        },

        newMemberInfo : {
            nickname : "",
        },

        status : 0,
        isLogined : false,

        electedMyCategories: [],  // 빈 배열로 초기화
        selectedLikeCategories: [],  // 빈 배열로 초기화

        userCategories:[]
    }),
    // persist: true,
    persist:{
        storage: sessionStorage,
    },
    actions:{
        async login(member){
            try {
                let url = `/api/login`;
                let response = await axios.post(url, member, {withCredentials: false}); //응답 받아서 저장

                console.log(response);
                console.log(response.status)
                if(response.status === 200){
                    this.isLogined = true;

                    console.log(this.member);
                }
            }catch(error){
                console.error('로그인 실패', error);
                return false;
            }

            return this.isLogined;
        },

        kakaoLogin(){
            // window.location.href = "/api/oauth2/authorization/kakao";
            window.location.href = "/social/oauth2/authorization/kakao";

            this.isLogined = true;
        },

        async getMemberInfo(){
            let url = `/api/member/login`;
            let response = await axios.get(url,{withCredentials:true});

            console.log(response);
            this.member.idx = response.data.result.idx;
            this.member.email = response.data.result.email;
            this.member.nickname = response.data.result.nickname;
            this.member.cellphone = response.data.result.cellphone;
            this.member.defaultAddress = response.data.result.defaultAddress;
            this.member.profileImageUrl = response.data.result.profileImageUrl;
            this.member.gradeIdx = response.data.result.gradeIdx;
            this.member.gradeName = response.data.result.gradeName;
            this.member.gradeImageUrl = response.data.result.gradeImageUrl;
        },

        async signup(member){
            let url = '/api/member/signup';
            console.log("회원가입 스토어 들어옴")

            let response = await axios.post(url, member, {withCredentials:false});

            if(response.status === 200){
                return true;
            }

            return false;
        },

        async emailRequest(email){
            console.log(email);
            this.member.email = email;

            let emailAuthReq = {
                email : email,
                uuid : "",
            }
            // let errorResponse;
            try {
                let url = `/api/email/request`
                let response = await axios.post(url, emailAuthReq);

                return response.status;
            }catch (error) {
                let errorResponse = error.response.data;

                console.log(errorResponse);
                if(errorResponse.code === 2003){
                    return errorResponse.message;
                    // return errorResponse.isSuccess;
                }
            }
        },

        async verifyUuid(email, uuid){
            
            this.member.uuid= uuid;

            let emailAuthReq={
                email: email,
                uuid: uuid,
            };

            let url = `/api/email/verify`;

            let response = await axios.post(url, emailAuthReq);
            console.log(response);
            return response;
        },

        // async getMemberInfo(){
        //     await axios.get()
        // },

        async logout() {
            let url = '/api/logout';
            await axios.post(url, {withCredentials:true});

            this.isLogined = false;
            this.member.idx = "";
            this.member.email = "";
            this.member.nickname = "";
            this.member.cellPhone = "";
            this.member.defaultAddress = "";
            this.member.profileImageUrl = "";
            return true;

        },

        async getUserCategories(){
            let url = `/proxy/my/category`;

            let response = await axios.get(url,{withCredentials:true});
            console.log(response);
            this.userCategories = response.data.result;
        },
        async modify(member){
            let url = `/proxy/member/modify`;

            let response = await axios.post(url, member);
            console.log(response);
        },

        async findEmail(email){
            let url = `/api/member/find/email`;

            let response = await axios.post(url,email);

            console.log(response);
        },
        async updateMemberInfo(req){
            let url = `/api/member/info`;

            console.log(req);
            let response = await axios.put(url,req,{withCredentials:true});
            console.log(response);
            this.member.nickname = response.data.result.nickname;

            return response;
        }
    }
})