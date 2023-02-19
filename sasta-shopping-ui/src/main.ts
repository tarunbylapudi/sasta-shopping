import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import SnackBar from "./components/shared/SnackBar.vue";
import { loadFonts } from "./plugins/webfontloader";

router.beforeEach((to, from, next) => {
  const requiresAuth = to.meta.requiresAuth;
  const requiresRole = to.meta.requiresRole as string;

  if (requiresAuth && !userIsLoggedIn()) {
    next("/login");
  } else if (requiresRole && !userHasRole(requiresRole)) {
    next("/accessDenied");
  } else {
    next();
  }
});

function userIsLoggedIn() {
  // Implement your own logic to check if the user is logged in, e.g. by checking if there is a token in local storage
  return !!localStorage.getItem("token");
}

function userHasRole(role: string) {
  // Implement your own logic to check if the user has the required role, e.g. by checking the user's role in local storage or making a request to an API
  return localStorage.getItem("role") === role;
}

loadFonts();

createApp(App)
  .component("SnackBar", SnackBar)
  .use(router)
  .use(store)
  .use(vuetify)
  .mount("#app");
