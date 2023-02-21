<template>
  <v-row>
    <v-col cols="12" md="4" class="">
      <v-card width="170" height="auto">
        <v-img
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          height="100"
          cover
        ></v-img>

        <v-card-title> dhhds </v-card-title>
        <v-card-subtitle class="font-weight-bold mb-3"
          >Price : ₹ sdjkj /-</v-card-subtitle
        >
      </v-card>
    </v-col>
    <v-col cols="12" md="8">
      <v-card width="auto" height="auto">
        <v-row no-gutters>
          <v-col cols="12">
            <v-list>
              <v-list-item v-for="x in forecast" :key="x.number">
                <v-list-item-content>
                  <v-list-item-title>{{ x.text }}</v-list-item-title>
                </v-list-item-content>
                <template #append>
                  <v-list-item-title>{{ x.number }}</v-list-item-title>
                </template>
              </v-list-item>
              <div><v-btn color="blue" class="ml-3">Remove item</v-btn></div>
            </v-list>
          </v-col>
        </v-row>
      </v-card>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { computed, defineComponent, PropType } from "vue";
import { Product } from "@/api/types";
export default defineComponent({
  name: "CartItemLayout",
  props: {
    product: {
      type: Object as PropType<Product>,
      required: true,
    },
  },
  setup(props) {
    const productPageLink = computed(() => `/products/${props.product.id}`);
    const forecast = [
      {
        text: "Selected Quantity",
        number: 2,
      },
      {
        text: "Price per quantity",
        number: 2,
      },
      { text: "Price", number: 2 },
    ];
    return { forecast, productPageLink };
  },
  data() {
    return {};
  },
});
</script>
