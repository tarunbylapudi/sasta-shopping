import { NavigationGuard } from "vue-router";
import { useStore } from "vuex";

const store = useStore();

const isAuthenticated = () => store.getters.isAuthenticated;
const currentUser = () => store.getters.currentUser;

const isAdmin = () => {
  const user = currentUser();
  return user && user.role === "admin";
};

export const requiresAuth: NavigationGuard = (to, from, next) => {
  const store = useStore();

  const isAuthenticated = () => store.getters.isAuthenticated;
  if (isAuthenticated()) {
    next();
  } else {
    next({ name: "login" });
  }
};

export const requiresAdmin: NavigationGuard = (to, from, next) => {
  if (!isAdmin()) {
    next({ name: "home" });
  } else {
    next();
  }
};
