import { Commit } from "vuex";
import {
  FETCH_PRODUCTS,
  FETCH_PRODUCT_DETAILS,
  UPDATE_PRODUCTS,
  UPDATE_PRODUCT_DETAILS,
} from "./constants";
import getProducts from "@/api/getProducts";
import getProductDetails from "@/api/getProductDetails";

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
};

export default actions;
