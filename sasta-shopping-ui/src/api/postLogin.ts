import axios from "@/plugins/axios";
import { SET_USER, SET_IS_AUTHENTICATED } from "@/store/constants";
import { User } from "@/store/types";
import { setToken, decodeToken } from "@/Utils/auth/jwtHelper";
import { LoginResponse } from "./types";
import { useStore } from "vuex";
import { LoginPayload } from "./types";
import { Commit } from "vuex";

const postLogin = async (context: any, payload: LoginPayload) => {
  try {
    console.log(payload);
    const baseUrl = process.env.VUE_APP_API_URL;
    const response = await axios.post<LoginResponse>(
      `${baseUrl}/api/auth/authenticate`,
      payload
    );
    console.log(response.data);
    const token = response.data.token;
    const isAdmin = response.data.isAdmin;

    setToken(token);

    const user = decodeToken(token) as User;
    localStorage.setItem("user", JSON.stringify(user));
    localStorage.setItem("role", user.role);

    context.commit(SET_USER, user);
    context.commit(SET_IS_AUTHENTICATED, true);
    return true;
  } catch (error) {
    console.log(error);
    return false;
  }
};

export default postLogin;
