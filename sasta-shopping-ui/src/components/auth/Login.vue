<template>
  <v-container fluid class="bg-deep-purple pa-12 h-100" rounded>
    <v-img cover src="" width="150"></v-img>
    <v-card class="mx-auto px-6 py-8 mt-16" max-width="344">
      <v-form v-model="form" @submit.prevent="onSubmit">
        <v-text-field
          v-model="email"
          variant="underlined"
          :readonly="loading"
          :rules="[rules.required, rules.email]"
          class="mb-2"
          clearable
          label="Email"
        ></v-text-field>

        <!-- <v-text-field
          v-model="password"
          :readonly="loading"
          :rules="[required]"
          clearable
          label="Password"
          placeholder="Enter your password"
        ></v-text-field> -->

        <v-text-field
          v-model="password"
          :readonly="loading"
          variant="underlined"
          :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
          :rules="[rules.required, rules.min]"
          :type="show1 ? 'text' : 'password'"
          name="input-10-1"
          label="Password"
          hint="At least 8 characters"
          counter
          clearable
          @click:append="show1 = !show1"
        ></v-text-field>

        <br />

        <v-btn
          :disabled="!form"
          :loading="loading"
          block
          color="success"
          size="large"
          type="submit"
          variant="elevated"
        >
          Sign In
        </v-btn>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>
// import axios from "axios";
export default {
  name: "Login",
  data: () => ({
    form: false,
    email: null,
    password: null,
    loading: false,
    show1: false,
    rules: {
      required: (value) => !!value || "Required.",
      min: (value) => value.length >= 8 || "Min 8 characters",
      email: (value) => {
        const pattern =
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return pattern.test(value) || "Invalid e-mail.";
      },
    },
  }),

  methods: {
    onSubmit() {
      if (!this.form) return;

      this.loading = true;

      setTimeout(() => (this.loading = false), 2000);
    },
    required(v) {
      return !!v || "Field is required";
    },
  },
};
</script>
