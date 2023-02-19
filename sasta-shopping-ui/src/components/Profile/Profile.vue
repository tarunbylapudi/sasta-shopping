<template>
  <v-card class="mx-auto my-auto pa-5" max-width="700"><profile-card /></v-card>

  <v-card class="mx-auto my-auto pa-5" max-width="700">
    <v-form validate-on="submit" @submit.prevent="">
      <div class="d-flex align-content-end justify-end">
        <v-btn
          v-if="!editProfile"
          color="green"
          class="mr-1"
          @click="editProfileHandller"
          >Edit Profile</v-btn
        >
        <v-btn
          v-if="editProfile"
          color="green"
          class="mr-1"
          @click="saveProfileHandler"
          >Save</v-btn
        >
        <v-btn
          v-if="editProfile"
          color="red"
          class="mr-1"
          @click="cancelEditProfileHandler"
          >Cancel</v-btn
        >
      </div>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="name"
              label="Name"
              variant="underlined"
              :clearable="!readonly"
              :readonly="readonly"
              :rules="[rules.required]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="email"
              label="Email"
              variant="underlined"
              :clearable="!readonly"
              :readonly="readonly"
              :rules="[rules.required, rules.email]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="phone"
              type="tel"
              variant="underlined"
              label="Phone"
              :clearable="!readonly"
              :readonly="readonly"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <div class="text-center">
              <v-menu open-on-hover>
                <template #activator="{ props }">
                  <!--  -->
                  <v-text-field
                    v-model="gender"
                    variant="underlined"
                    label="Gender"
                    append-inner-icon="mdi-chevron-down"
                    :clearable="!readonly"
                    :readonly="readonly"
                    v-bind="props"
                    :rules="[rules.required]"
                  ></v-text-field>
                </template>

                <v-list nav>
                  <v-list-item
                    v-for="(item, index) in items"
                    :key="index"
                    :title="item.title"
                    @click="updategender(item.title)"
                  >
                  </v-list-item>
                </v-list>
              </v-menu>
            </div>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </v-card>
</template>
<script lang="ts">
import axios from "@/plugins/axios";
import { defineComponent, ref } from "vue";
import ProfileCard from "./ProfileCard.vue";

export default defineComponent({
  name: "Profile",
  components: { ProfileCard },
  setup() {
    const name = ref("mhvjjv");
    const email = ref("");
    const phone = ref<number>();
    const gender = ref("");
    const readonly = ref(true);
    const editProfile = ref(false);

    const editProfileHandller = () => {
      editProfile.value = true;
      readonly.value = false;
    };
    const saveProfileHandler = async () => {
      editProfile.value = false;
      readonly.value = true;
      try {
        const response = await axios.post(process.env.VUE_APP_POST_CONTACT_US, {
          name: name.value,
          email: email.value,
          mobile: phone.value,
        });

        console.log(response.status);
      } catch (error) {
        console.error(error);
      }
    };

    const cancelEditProfileHandler = () => {
      editProfile.value = false;
      readonly.value = true;
    };

    const rules = {
      required: (value: any) => !!value || "Required.",
      min: (value: string) => value.length >= 8 || "Min 8 characters",
      phone: (value: string) => {
        const pattern = /"^\\d{10}$"/;
        return pattern.test(value) || "Invalid Phone Number";
      },
      email: (value: string) => {
        const pattern =
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return pattern.test(value) || "Invalid e-mail.";
      },
    };

    const items = [{ title: "Male" }, { title: "Female" }, { title: "Others" }];
    const updategender = (title: string) => {
      gender.value = title;
    };
    return {
      name,
      email,
      phone,
      gender,
      saveProfileHandler,
      readonly,
      items,
      updategender,
      rules,
      editProfileHandller,
      editProfile,
      cancelEditProfileHandler,
    };
  },
  data() {
    return {};
  },
});
</script>
