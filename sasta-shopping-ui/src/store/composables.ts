import { useStore } from "vuex";
import { computed } from "vue";
import { key } from ".";
import { FETCH_PRODUCTS, FETCH_PRODUCT_DETAILS } from "./constants";

//getters

// export const useFilteredJobs = () => {
//   const store = useStore(key);
//   return computed<Job[]>(() => store.getters[FILTERED_JOBS]);
// };

//actions

export const UseFetchProducts = () => {
  const store = useStore();
  return store.dispatch(FETCH_PRODUCTS);
};

export const UseFetchProductDetails = (productId: string) => {
  const store = useStore();
  return store.dispatch(FETCH_PRODUCT_DETAILS, productId);
};
