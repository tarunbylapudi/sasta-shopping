<template>
  <router-link :to="productPageLink" class="text-decoration-none"
    ><v-card width="auto" height="auto">
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="150"
        cover
      ></v-img>

      <v-card-title class="text"> {{ product.name }} </v-card-title>
      <v-card-subtitle class="text-subtitle-2 font-weight-bold"
        >Price : ₹ {{ product.price }} /-</v-card-subtitle
      >

      <v-card-actions>
        <v-btn color="orange-lighten-2" variant="text"> Buy </v-btn>

        <v-spacer></v-spacer>
        <v-btn icon>
          <v-icon>mdi-cart-plus</v-icon>
        </v-btn>
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
