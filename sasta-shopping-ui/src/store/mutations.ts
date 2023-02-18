import { GlobalState } from "@/store/types";
import {
  UPDATE_PRODUCTS,
  UPDATE_PRODUCT_DETAILS,
  UPDATE_PEODUCT_IMG_URL,
} from "./constants";
import { Product } from "@/api/types";

const mutations = {
  [UPDATE_PRODUCTS](state: GlobalState, products: Product[]) {
    state.products = products;
  },
  [UPDATE_PRODUCT_DETAILS](state: GlobalState, productDetails: Product) {
    state.ProductDetails = productDetails;
  },
  [UPDATE_PRODUCT_DETAILS](state: GlobalState, imageLink: string) {
    state.console.log();
  },
};

export default mutations;
