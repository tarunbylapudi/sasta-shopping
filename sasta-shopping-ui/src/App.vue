<template>
  <v-app id="inspire">
    <v-app-bar>
      <v-app-bar-nav-icon
        v-show="isAuthenticated"
        @click="drawer = !drawer"
      ></v-app-bar-nav-icon>

      <v-toolbar-title>Sasta Shopping</v-toolbar-title>
      <v-list :lines="false" density="compact" class="displayNone">
        <v-list-item
          v-for="item in items"
          :key="item.path"
          :to="item.path"
          active-color="primary"
          class="horizontal-list-item"
          @click="mainNavSnackHandler(item.text)"
        >
          <v-list-item-content>
            {{ item.text }}
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-spacer></v-spacer>

      <v-btn v-show="isAuthenticated" icon>
        <v-badge dot floating color="red">
          <v-icon icon="mdi-cart" size="large"></v-icon>
        </v-badge>
      </v-btn>

      <v-btn
        v-show="isAuthenticated"
        color="red"
        variant="tonal"
        @click="LogoutHandler"
      >
        Logout
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" temporary>
      <v-list>
        <v-list-item
          prepend-avatar="https://cdn.vuetifyjs.com/images/john.png"
          title="John Leider"
          subtitle="john@google.com"
        >
        </v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list :lines="false" density="compact" nav>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          :value="item"
          :to="item.path"
          active-color="primary"
          @click="mainNavSnackHandler(item.text)"
        >
          <template #prepend>
            <v-icon :icon="item.icon"></v-icon>
          </template>

          <v-list-item-title>{{ item.text }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main class="bg-grey-lighten-2">
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
    <foooter v-show="isAuthenticated" />
  </v-app>
  <v-snackbar v-model="snack" :color="snackColor" :timeout="2000">{{
    text
  }}</v-snackbar>
</template>

<script lang="ts">
import { computed, defineComponent, ref } from "vue";
import { useStore } from "vuex";
import { LOGOUT } from "./store/constants";
import Foooter from "@/components/shared/Foooter.vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "App",
  components: { Foooter },
  setup() {
    const store = useStore();
    const router = useRouter();
    //const route = useRoute();

    const snack = ref(false);
    const text = ref("");
    const snackColor = ref("");

    const drawer = ref(false);
    const selectedItem = ref(0);
    const items = [
      { text: "Home", icon: "mdi-home-account", path: "/" },
      { text: "Profile", icon: "mdi-account", path: "/profile" },
      { text: "Shop", icon: "mdi-store", path: "/shop" },
      { text: "Cart", icon: "mdi-cart", path: "/cart" },

      {
        text: "Contact Us",
        icon: "mdi-human-greeting-proximity",
        path: "/contact",
      },
    ];
    const isAuthenticated = computed(() => store.state.isAuthenticated);

    const mainNavSnackHandler = (routeToGo: string) => {
      if (!isAuthenticated.value && routeToGo !== "Contact Us") {
        console.log(routeToGo);
        snack.value = true;
        text.value = "Please Login First!";
        snackColor.value = "red";
      }
    };

    const LogoutHandler = () => {
      store.dispatch(LOGOUT);
      router.push("/login");
    };
    return {
      drawer,
      selectedItem,
      items,
      LogoutHandler,
      isAuthenticated,
      mainNavSnackHandler,
      snack,
      text,
      snackColor,
    };
  },
});
</script>
<style scoped>
.horizontal-list-item {
  display: inline-block;
  /* margin-right: 16px; adjust this to your desired spacing */
}

@media only screen and (max-width: 768px) {
  .displayNone {
    display: none !important;
  }
}
</style>
