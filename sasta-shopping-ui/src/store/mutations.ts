import { GlobalState } from "@/store/types";
import { UPDATE_PRODUCTS } from "./constants";
import { Product } from "@/api/types";

const mutations = {
  [UPDATE_PRODUCTS](state: GlobalState, products: Product[]) {
    state.products = products;
  },
};

export default mutations;
