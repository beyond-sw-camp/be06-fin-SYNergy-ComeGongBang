import axios from "axios";
import router from "@/router";

axios.interceptors.response.use(

    function (response) {
        console.log("메롱");
        return response;
    },

    function (error) {
        console.log("error:::", error)
        if (error.response) {
            const code = error.response.data.code;
            if (code === 404) {
                router.push("/error");
            }
        } else {
            router.push("/error");
        }
        return Promise.reject(error);
    }
);