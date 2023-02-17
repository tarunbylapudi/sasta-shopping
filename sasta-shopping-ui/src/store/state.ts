import { GlobalState } from "@/store/types";

const state = (): GlobalState => {
  return {
    isLoggedIn: false,
    products: [],
    ProductDetails: {},
  };
};

export default state;
