import axios from "axios";
import router from "@/router";

axios.interceptors.response.use(

    function (response) {
        return response;
    },

    function (error) {
        if (error.response) {
            const status = error.response.status;
            if (status === 404) {
                router.push("/notFound")
            }
            if (status === 401) {
                const redirectUrl = error.response.data.redirectUrl;
                window.location.href = redirectUrl
            }
            // 로컬 스토리지에는 남아있지만, 토큰은 사라진 상태 (로그아웃 처리)
            if(status === 600){
                const redirectUrl = error.response.data.redirectUrl;
                window.location.href = redirectUrl
            }
        }
        return Promise.reject(error);
    }
);