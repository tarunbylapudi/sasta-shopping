<template>
  <v-row>
    <v-col cols="12" md="8">
      <v-card>
        <v-card-text v-for="item in cartItems" :key="item.id">
          <cart-item-layout />
        </v-card-text>
      </v-card>
    </v-col>
    <v-col cols="12" md="4">
      <v-card>
        <v-card-title>Order Summary</v-card-title>
        <v-card-text>
          <v-list>
            <v-list-item v-for="x in forecast" :key="x.number">
              <v-list-item-content>
                <v-list-item-title>{{ x.text }}</v-list-item-title>
              </v-list-item-content>
              <template #append>
                <v-list-item-title>{{ x.number }}</v-list-item-title>
              </template>
            </v-list-item>
          </v-list>
          <v-btn block color="primary" class="mt-5">Checkout</v-btn>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import CartItemLayout from "@/components/cart/CartItemLayout.vue";
export default {
  name: "Cart",
  components: { CartItemLayout },
  data() {
    return {
      cartItems: [
        {
          name: "Product 1",
          description: "Lorem ipsum dolor sit amet",
          price: 29.99,
        },
        {
          name: "Product 2",
          description: "Consectetur adipiscing elit",
          price: 19.99,
        },
        {
          name: "Product 3",
          description: "Sed do eiusmod tempor incididunt",
          price: 39.99,
        },
      ],
      forecast: [
        {
          text: "Cart Price",
          number: 2,
        },
        {
          text: "Shipping Charges",
          number: 20,
        },
        { text: "Total Price", number: 124 },
      ],

      shipping: 9.99,
      taxes: 4.5,
    };
  },
  computed: {
    subtotal() {
      return this.cartItems.reduce((total, item) => total + item.price, 0);
    },
    total() {
      return this.subtotal + this.shipping + this.taxes;
    },
  },
  methods: {
    removeFromCart(index) {
      this.cartItems.splice(index, 1);
    },
  },
};
</script>
