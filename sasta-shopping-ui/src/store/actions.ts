import { Commit } from "vuex";
import { User } from "./types";
import { contactUs } from "@/api/types";
import {
  FETCH_PRODUCTS,
  FETCH_PRODUCT_DETAILS,
  UPDATE_PRODUCTS,
  UPDATE_PRODUCT_DETAILS,
  LOGIN,
  LOGOUT,
  SET_IS_AUTHENTICATED,
  SET_USER,
  CONTACT_US,
} from "./constants";
import { LoginPayload, LoginResponse } from "@/api/types";
import getProducts from "@/api/getProducts";
import getProductDetails from "@/api/getProductDetails";
import postContactUs from "@/api/postContactUs";
import { decodeToken, removeToken, setToken } from "@/Utils/auth/jwtHelper";
import axios from "@/plugins/axios";

interface Context {
  commit: Commit;
}

const actions = {
  [FETCH_PRODUCTS]: async (context: Context) => {
    const products = await getProducts();
    context.commit(UPDATE_PRODUCTS, products);
  },
  [FETCH_PRODUCT_DETAILS]: async (context: Context, ProductId: string) => {
    const productDetails = await getProductDetails(ProductId);
    context.commit(UPDATE_PRODUCT_DETAILS, productDetails);
  },
  [LOGIN]: async (context: Context, payload: LoginPayload) => {
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
  },

  [LOGOUT]: async (context: Context) => {
    removeToken();
    localStorage.removeItem("role");
    localStorage.removeItem("user");
    context.commit(SET_USER, null);
    context.commit(SET_IS_AUTHENTICATED, false);
  },
  [CONTACT_US]: async (context: Context, payload: contactUs) => {
    return await postContactUs(payload);
  },
};

export default actions;
