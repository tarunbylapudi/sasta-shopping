<template>
  <v-app id="inspire">
    <v-app-bar>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Application</v-toolbar-title>
      <v-btn icon>
        <v-icon icon="mdi-store" size="large"></v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon icon="mdi-cart" size="large"></v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon icon="mdi-cart" size="large"></v-icon>
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-badge dot floating color="red">
          <v-icon icon="mdi-cart" size="large"></v-icon>
        </v-badge>
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
        >
          <template v-slot:prepend>
            <v-icon :icon="item.icon"></v-icon>
          </template>

          <v-list-item-title v-text="item.text"></v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main class="bg-grey-lighten-2">
      <v-container>
        <router-view />
      </v-container>
    </v-main>
    <foooter />
  </v-app>
</template>

<script>
import Foooter from "@/components/shared/Foooter.vue";
export default {
  name: "App",
  components: { Foooter },
  data: () => ({
    drawer: false,
    selectedItem: 0,
    items: [
      { text: "Shop", icon: "mdi-store", path: "/shop" },
      { text: "Cart", icon: "mdi-cart", path: "/cart" },
      {
        text: "Contact Us",
        icon: "mdi-human-greeting-proximity",
        path: "/contact",
      },
    ],
  }),
};
</script>
