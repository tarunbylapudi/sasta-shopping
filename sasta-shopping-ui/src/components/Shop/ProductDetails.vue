<template>
  <v-card class="mx-auto my-12" max-width="374">
    <v-card-title>Cafe Badilico sfdsfE</v-card-title>

    <v-card-subtitle>
      <span class="me-1">Ratings</span>
      <v-icon color="error" icon="mdi-fire" size="small"></v-icon>
    </v-card-subtitle>

    <v-card-text>
      <v-row align="center" class="mx-0">
        <rating />
        <div class="text-grey ms-4">4.5 (413)</div>
      </v-row>

      <div class="my-4 text-subtitle-1">₹ 70 /-</div>

      <div>
        Small plates, salads & sandwiches - an intimate setting with 12 indoor
        seats plus patio seating. Small plates, salads & sandwiches - an
        intimate setting with 12 indoor seats plus patio seating. Small plates,
        salads & sandwiches - an intimate setting with 12 indoor seats plus
        patio seating.
      </div>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Rating from "../shared/Rating.vue";

export default defineComponent({
  name: "ProductDetails",
  components: { Rating },
  setup() {
    return {};
  },
});
</script>
