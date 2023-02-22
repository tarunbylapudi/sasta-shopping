<template>
  <v-row>
    <v-col cols="12" md="4" class="">
      <v-card width="170" height="auto">
        <v-img :src="cartItem.item.value.imgLink" height="125" cover></v-img>
        <div class="ma-3 font-weight-bold">
          <v-text class=""> {{ cartItem.item.value.productName }} </v-text>
        </div>

        <v-card-subtitle class="font-weight-bold mb-3"
          >Price : ₹ {{ cartItem.item.value.productPrice }} /-</v-card-subtitle
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
              <div>
                <v-btn color="blue" class="ml-3" @click="removeItemFromCart"
                  >Remove item</v-btn
                >
              </div>
            </v-list>
          </v-col>
        </v-row>
      </v-card>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { defineComponent, toRefs } from "vue";
export default defineComponent({
  name: "CartItemLayout",
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  setup(props) {
    const removeItemFromCart = () => {};

    const cartItem = toRefs(props);

    const forecast = [
      {
        text: "Selected Quantity",
        number: cartItem.item.value.quantity,
      },
      {
        text: "Price per quantity",
        number: cartItem.item.value.productPrice,
      },
      {
        text: "Price",
        number: `${Math.ceil(
          +cartItem.item.value.quantity * +cartItem.item.value.productPrice
        )}`,
      },
    ];

    return { forecast, removeItemFromCart, cartItem };
  },
});
</script>
