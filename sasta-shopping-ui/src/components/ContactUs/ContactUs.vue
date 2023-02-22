<template>
  <v-card class="mx-auto my-auto pa-5" max-width="700">
    <v-form v-model="valid" @submit.prevent="contactUsHandler">
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="name"
              label="Name"
              variant="underlined"
              clearable
              :rules="[rules.required]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="email"
              label="Email"
              variant="underlined"
              clearable
              :rules="[rules.required, rules.email]"
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <v-text-field
              v-model="phone"
              type="tel"
              variant="underlined"
              label="Phone"
              clearable
            ></v-text-field>
          </v-col>

          <v-col cols="12" sm="6">
            <div class="text-center">
              <v-menu open-on-hover>
                <template #activator="{ props }">
                  <!--  -->
                  <v-text-field
                    v-model="issueCategory"
                    variant="underlined"
                    label="Issue Catogeory"
                    append-inner-icon="mdi-chevron-down"
                    clearable
                    v-bind="props"
                    :rules="[rules.required]"
                  ></v-text-field>
                </template>

                <v-list nav>
                  <v-list-item
                    v-for="(item, index) in items"
                    :key="index"
                    :title="item.title"
                    @click="updateIssueCategory(item.title)"
                  >
                  </v-list-item>
                </v-list>
              </v-menu>
            </div>
          </v-col>

          <v-col cols="12" sm="12"
            ><v-textarea
              v-model="issueDiscription"
              counter
              label="Issue Discription"
              clearable
              :rules="[rules.required]"
            ></v-textarea
          ></v-col>
        </v-row>
      </v-container>
      <v-card-actions>
        <v-btn type="submit" :disabled="!valid" variant="elevated" color="blue">
          Submit
        </v-btn>
      </v-card-actions>
    </v-form>
  </v-card>

  <v-snackbar v-model="snack" :color="snackColor" :timeout="2000">{{
    text
  }}</v-snackbar>
</template>
<script lang="ts">
import { defineComponent, ref } from "vue";
//import { UseContactUs } from "@/store/composables";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { CONTACT_US } from "@/store/constants";

export default defineComponent({
  name: "ContactUs",

  setup() {
    const router = useRouter();
    const store = useStore();

    const snack = ref(false);
    const snackColor = ref("green");
    const text = ref(
      "Your Query has been submited !, We will get back you ASAP!"
    );

    const progress = ref(false);
    const valid = ref(false);
    const name = ref("");
    const email = ref("");
    const phone = ref();
    const issueCategory = ref("");
    const issueDiscription = ref("");

    // const clearAllFeilds = () => {
    //   name.value = "";
    //   email.value = "";
    //   phone.value = "";
    //   issueCategory.value = "";
    //   issueDiscription.value = "";
    //   valid.value = false;
    // };

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

    const items = [{ title: "Orders" }, { title: "Returns" }];
    const updateIssueCategory = (title: string) => {
      issueCategory.value = title;
    };

    const contactUsHandler = async () => {
      const result = await store.dispatch(CONTACT_US, {
        name: name.value,
        email: email.value,
        mobile: phone.value,
        type: issueCategory.value,
        description: issueDiscription.value,
      });
      if (result) {
        snack.value = true;
        //clearAllFeilds();
        setTimeout(() => {
          router.push({ name: "home" });
        }, 1000);
      } else {
        text.value = "Something went wrong, Please try again!";
        snack.value = true;
        snackColor.value = "red";
        setTimeout(() => {
          router.push({ name: "home" });
        }, 1000);
        console.log("ContactUs failed");
      }
    };

    return {
      items,
      updateIssueCategory,
      name,
      email,
      phone,
      issueCategory,
      issueDiscription,
      contactUsHandler,
      rules,
      snack,
      text,
      progress,
      valid,
      snackColor,
    };
  },
});
</script>
