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
                router.push("/error");
            }
        }
        return Promise.reject(error);
    }
);