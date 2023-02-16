import { useStore } from "vuex";
import { computed } from "vue";
import { key } from ".";
import { FETCH_PRODUCTS } from "./constants";

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
