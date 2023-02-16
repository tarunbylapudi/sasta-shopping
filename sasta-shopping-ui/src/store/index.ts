import { createStore, Store } from "vuex";
import { InjectionKey } from "vue";
import { GlobalState } from "@/store/types";

import state from "@/store/state";
import mutations from "@/store/mutations";
import actions from "@/store/actions";
import getters from "@/store/getters";

export const key: InjectionKey<Store<GlobalState>> = Symbol();

const store = createStore({
  state,
  mutations,
  actions,
  getters,
  strict: process.env.NODE_ENV !== "Production",
});

export default store;
