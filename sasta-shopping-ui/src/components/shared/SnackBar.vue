<template>
  <div class="text-center">
    <v-snackbar :timeout="2000" v-model="snackbar">
      {{ text }}

      <template #actions>
        <v-btn color="blue" variant="text" @click="snackbar = false">
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "SnackBar",
  props: {
    text: {
      type: String,
      required: true,
    },
    snack: {
      type: Boolean,
      required: true,
    },
  },
  setup() {
    return {};
  },
  data() {
    return {
      snackbar: this.snack,
      timeout: 4000,
    };
  },
});
</script>
