<template>
  <router-link :to="productPageLink" class="text-decoration-none"
    ><v-card class="mx-auto" width="140" height="200">
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="100px"
        cover
      ></v-img>

      <v-card-title> Top western road trips </v-card-title>

      <v-card-actions>
        <v-btn color="orange-lighten-2" variant="text"> Buy </v-btn>

        <v-spacer></v-spacer>
        <v-btn icon>
          <v-icon>mdi-cart-plus</v-icon>
        </v-btn>

        <!-- <v-btn
        :icon="show ? 'mdi-chevron-up' : 'mdi-chevron-down'"
        @click="show = !show"
      ></v-btn> -->
      </v-card-actions>
    </v-card>
  </router-link>
</template>
<script lang="ts">
import { computed, defineComponent, PropType } from "vue";
import { Product } from "@/api/types";

export default defineComponent({
  name: "ProductCardLayout",
  props: {
    product: {
      type: Object as PropType<Product>,
      required: true,
    },
  },
  setup(props) {
    const productPageLink = computed(() => `/products/${props.product.id}`);
    return { productPageLink };
  },
});
</script>
