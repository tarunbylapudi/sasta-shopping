import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";

const ProfileView = () =>
  import(/* webpackChunkName:"profile" */ "@/views/ProfileView.vue");
const LoginView = () =>
  import(/* webpackChunkName:"login" */ "@/views/LoginView.vue");
const ShopView = () =>
  import(/* webpackChunkName:"shop" */ "@/views/ShopView.vue");

const ProductPageView = () =>
  import(/* webpackChunkName:"productPage" */ "@/views/ProductPageView.vue");

const CartView = () =>
  import(/* webpackChunkName:"cart" */ "@/views/CartView.vue");

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "profile",
    component: ProfileView,
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  {
    path: "/shop",
    name: "shop",
    component: ShopView,
  },
  {
    path: "/products/:id",
    name: "productPage",
    component: ProductPageView,
  },
  {
    path: "/cart",
    name: "cart",
    component: CartView,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
  scrollBehavior() {
    return { top: 0, left: 0, behavior: "smooth" };
  },
});

export default router;
