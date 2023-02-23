import { Commit } from "vuex";
import { User } from "./types";
import { signUp, contactUspayload, addToCartPayload } from "@/api/types";
import {
  FETCH_PRODUCTS,
  FETCH_PRODUCT_DETAILS,
  UPDATE_PRODUCTS,
  UPDATE_PRODUCT_DETAILS,
  LOGIN,
  SIGN_UP,
  LOGOUT,
  SET_IS_AUTHENTICATED,
  SET_USER,
  CONTACT_US,
  ADD_TO_CART,
  FETCH_CART,
  UPDATE_CART,
  CLEAR_CART,
} from "./constants";
import { LoginPayload, LoginResponse } from "@/api/types";
import getProducts from "@/api/getProducts";
import getProductDetails from "@/api/getProductDetails";
import postContactUs from "@/api/postContactUs";
import postSignUp from "@/api/postSignUp";
import postLogin from "@/api/postLogin";
import postAddToCart from "@/api/postAddToCart";
import deleteClearCart from "@/api/deleteClearCart";
import { decodeToken, removeToken, setToken } from "@/Utils/auth/jwtHelper";
import axios from "@/plugins/axios";
import getCart from "@/api/getCart";

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
  [FETCH_CART]: async (context: Context) => {
    const cart = await getCart();
    context.commit(UPDATE_CART, cart);
  },
  [CLEAR_CART]: async (context: Context) => {
    return await deleteClearCart();
  },
  [LOGIN]: async (context: Context, payload: LoginPayload) => {
    return await postLogin(context, payload);
  },

  [SIGN_UP]: async (context: Context, payload: signUp) => {
    console.log(payload);
    return await postSignUp(payload);
  },

  [LOGOUT]: async (context: Context) => {
    removeToken();
    localStorage.removeItem("role");
    localStorage.removeItem("user");
    context.commit(SET_USER, null);
    context.commit(SET_IS_AUTHENTICATED, false);
  },
  [CONTACT_US]: async (context: Context, payload: contactUspayload) => {
    return await postContactUs(payload);
  },
  [ADD_TO_CART]: async (context: Context, payload: addToCartPayload) => {
    return await postAddToCart(payload);
  },
};

export default actions;
