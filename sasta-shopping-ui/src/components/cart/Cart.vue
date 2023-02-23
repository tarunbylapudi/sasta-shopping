<template>
  <v-container class="">
    <v-row v-if="currentCart.size === 0"><empty-cart /></v-row>
    <v-row v-else>
      <v-col cols="12" md="8">
        <v-card>
          <v-card-text v-for="(item, key) in cartItems" :key="key">
            <cart-item-layout :item="item[1]" />
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
            <v-btn block color="blue" class="mt-5">Checkout</v-btn>
            <v-btn block color="blue" class="mt-5">Clear cart</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
  <v-snackbar v-model="snack" :color="snackColor" :timeout="2000">{{
    text
  }}</v-snackbar>
</template>

<script lang="ts">
// interface CartItem {
//   items: Map<number, { productId: number; quantity: number }>;
// }

import { Product } from "@/api/types";
import {
  usecurrentCart,
  useFetchCart,
  UseFetchProducts,
  useImageConversion,
} from "@/store/composables";

//import { Cart } from "@/store/types";
import { computed, defineComponent, onMounted, ref } from "vue";
import { useStore } from "vuex";
import CartItemLayout from "./CartItemLayout.vue";
import EmptyCart from "./EmptyCart.vue";

export default defineComponent({
  name: "Cart",
  components: { CartItemLayout, EmptyCart },
  setup() {
    const store = useStore();
    onMounted(UseFetchProducts);
    onMounted(useFetchCart);

    const snack = ref(false);
    const text = ref("cart Cleared!");
    const snackColor = ref("green");

    const Images = useImageConversion();
    const products = computed<Product[]>(() => store.state.products);
    const currentCart = usecurrentCart();
    // const clearCart = async () => {
    //   const result = await UseClearCart();
    //   if (result) {
    //     useFetchCart();
    //     snack.value = true;
    //   } else {
    //     snackColor.value = "red";
    //     text.value = "Some thing is worng, Please try again after sometime!";
    //     console.log("clear cart failed");
    //     snack.value = true;
    //   }
    // };

    const cartItems = computed(() => {
      const Items = new Map<number, object>();
      currentCart.value.forEach((item) => {
        const imgArray: string[] = Images.value.get(item[0]) as string[];
        const imgLink: string = imgArray[0];

        const productId: number = products.value[item[0] - 1].id;
        const productName: string = products.value[item[0] - 1].name;
        const productPrice: number = products.value[item[0] - 1].price;
        const quantity: number = item[1];

        Items.set(item[0], {
          productId: productId,
          productName: productName,
          imgLink: imgLink,
          productPrice: productPrice,
          quantity: quantity,
        });
      });
      console.log(Items);
      return Items;
    });

    const forecast = [
      {
        text: "Cart Price",
        number: 2,
      },
      {
        text: "Shipping Charges",
        number: 20,
      },
      { text: "Total Price", number: 124 },
    ];
    return {
      cartItems,
      forecast,
      Images,
      products,
      currentCart,

      snack,
      snackColor,
      text,
    };
  },
});
</script>

<!-- <script>
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
</script> -->
