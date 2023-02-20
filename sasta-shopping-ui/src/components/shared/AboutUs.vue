<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <v-card class="p-5">
          <v-card-title class="text-center text-h4"
            >About Sasta Shopping</v-card-title
          >
          <v-card-text>
            <p class="font-weight-bold">
              Welcome to Sasta Shopping! We are a small e-commerce website
              dedicated to bringing you quality products at affordable prices.
              Our goal is to make online shopping easy and accessible for
              everyone.
            </p>
            <p>
              Our team at Sasta Shopping is committed to providing you with the
              best shopping experience possible. We work hard to ensure that our
              website is user-friendly and easy to navigate, so you can find the
              products you need quickly and easily. We also offer a wide range
              of payment options and fast, reliable shipping, so you can get
              your items delivered to your doorstep in no time.
            </p>
            <v-img
              src="https://www.example.com/images/about_us_1.jpg"
              alt="Sasta Shopping Team"
              width="400"
              height="267"
            ></v-img>
            <p>
              At Sasta Shopping, we believe in providing our customers with
              high-quality products at affordable prices. We work directly with
              manufacturers and suppliers to bring you the best deals on a
              variety of products, including clothing, electronics, home goods,
              and more. We are constantly updating our inventory, so be sure to
              check back often for new items and special deals.
            </p>
            <v-img
              src="https://www.example.com/images/about_us_2.jpg"
              alt="Sasta Shopping Warehouse"
              width="400"
              height="267"
            ></v-img>
            <p>
              We value our customers and are always looking for ways to improve
              our service. If you have any questions or concerns, please don't
              hesitate to reach out to us. We are here to help and are committed
              to providing you with the best possible shopping experience.
            </p>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "AboutUS",
  setup() {
    return {};
  },
});
</script>
<style scoped>
.v-list-item__title,
.v-list-item__subtitle {
  white-space: normal !important;
}
</style>
