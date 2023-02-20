import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import { requiresAuth } from "@/Utils/auth/gaurd";

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

const PageNotFound = () =>
  import(/* webpackChunkName:"404" */ "@/components/shared/PageNotFound.vue");

const AccessDenied = () =>
  import(
    /* webpackChunkName:"accessDenied" */ "@/components/shared/AccessDenied.vue"
  );

const ContactUs = () =>
  import(
    /* webpackChunkName:"contactUs" */ "@/components/ContactUs/ContactUs.vue"
  );

const HomeView = () =>
  import(/* webpackChunkName:"home" */ "@/views/HomeView.vue");

const AboutUs = () =>
  import(/* webpackChunkName:"aboutUS" */ "@/components/shared/AboutUs.vue");

const routes: Array<RouteRecordRaw> = [
  {
    path: "/profile",
    name: "profile",
    component: ProfileView,
    meta: { requiresAuth: true },
  },
  {
    path: "/",
    name: "home",
    component: HomeView,
    meta: { requiresAuth: true },
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
    meta: { requiresAuth: true },
  },
  {
    path: "/products/:id",
    name: "productPage",
    component: ProductPageView,
    meta: { requiresAuth: true },
  },
  {
    path: "/cart",
    name: "cart",
    component: CartView,
    meta: { requiresAuth: true, requiresRole: "ADMIN" },
  },
  {
    path: "/contact",
    name: "contact",
    component: ContactUs,
  },
  {
    path: "/accessDenied",
    name: "accessDenied",
    component: AccessDenied,
    meta: { requiresAuth: true },
  },

  {
    path: "/:pathMatch(.*)*",
    name: "not-found",
    component: PageNotFound,
    meta: { requiresAuth: true },
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
