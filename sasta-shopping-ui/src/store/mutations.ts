import { GlobalState } from "@/store/types";
import { UPDATE_PRODUCTS, UPDATE_PRODUCT_DETAILS } from "./constants";
import { Product } from "@/api/types";

const mutations = {
  [UPDATE_PRODUCTS](state: GlobalState, products: Product[]) {
    state.products = products;
  },
  [UPDATE_PRODUCT_DETAILS](state: GlobalState, productDetails: Product) {
    state.ProductDetails = productDetails;
  },
};

export default mutations;
