import { Commit } from "vuex";
import { FETCH_PRODUCTS, UPDATE_PRODUCTS } from "./constants";
import getProducts from "@/api/getProducts";

interface Context {
  commit: Commit;
}

const actions = {
  [FETCH_PRODUCTS]: async (context: Context) => {
    //context.commit(LOADING, true);
    const products = await getProducts();
    //context.commit(LOADING, false);
    context.commit(UPDATE_PRODUCTS, products);
  },
};

export default actions;
