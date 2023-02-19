import { GlobalState } from "@/store/types";
import {
  UPDATE_PRODUCTS,
  UPDATE_PRODUCT_DETAILS,
  UPDATE_PEODUCT_IMG_URL,
  SET_IS_AUTHENTICATED,
  SET_USER,
} from "./constants";
import { Product } from "@/api/types";

const mutations = {
  [UPDATE_PRODUCTS](state: GlobalState, products: Product[]) {
    state.products = products;
  },
  [UPDATE_PRODUCT_DETAILS](state: GlobalState, productDetails: Product) {
    state.ProductDetails = productDetails;
  },
  //t
  [SET_USER](state: GlobalState, user: any) {
    state.user = user;
  },

  [SET_IS_AUTHENTICATED](state: GlobalState, isAuthenticated: boolean) {
    state.isAuthenticated = isAuthenticated;
  },

  // [UPDATE_PEODUCT_IMG_URL](
  //   state: GlobalState,
  //   imageLink: string,
  //   index: number
  // ) {
  //   state.ProductDetails.images[index].bytes = imageLink;
  // },
};

export default mutations;
