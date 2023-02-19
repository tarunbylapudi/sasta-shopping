<template>
  <router-link :to="productPageLink" class="text-decoration-none"
    ><v-card width="auto" height="auto">
      <v-img :src="imgLink" height="150" cover></v-img>
      <v-img src="imgLink"></v-img>

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
    images: {
      type: Map as PropType<Map<number, string[]>>,
      required: true,
    },
  },
  setup(props) {
    const productPageLink = computed(() => `/products/${props.product.id}`);
    const imgArray: string[] = props.images.get(props.product.id) as string[];
    const imgLink: string = imgArray[0];
    return { productPageLink, imgLink };
  },
});
</script>
