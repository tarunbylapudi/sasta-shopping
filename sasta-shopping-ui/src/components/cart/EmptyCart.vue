<template>
  <div class="container-fluid mt-100">
    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body cart">
            <div class="col-sm-12 empty-cart-cls text-center">
              <img
                src="https://i.imgur.com/dCdflKN.png"
                width="130"
                height="130"
                class="img-fluid mb-4 mr-3"
              />
              <h3><strong>Your Cart is Empty</strong></h3>
              <h4>Add something to make me happy :)</h4>
              <v-btn color="blue" class="mt-5" @click="goToShop"
                >continue shopping</v-btn
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "EmptyCart",
  setup() {
    const router = useRouter();
    const goToShop = () => router.push({ name: "shop" });

    return {
      router,
      goToShop,
    };
  },
});
</script>

<style scoped>
@import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);

body {
  background-color: #eee;
  font-family: "Calibri", sans-serif !important;
}

.card {
  width: 890px;
  margin-bottom: 30px;
  border: 0;
  -webkit-transition: all 0.3s ease;
  transition: all 0.3s ease;
  letter-spacing: 0.5px;
  border-radius: 8px;
  -webkit-box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, 0.05);
  box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, 0.05);
}

.card .card-header {
  background-color: #fff;
  border-bottom: none;
  padding: 24px;
  border-bottom: 1px solid #f6f7fb;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
}

.card-header:first-child {
  border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;
}

.card .card-body {
  padding: 30px;
  background-color: transparent;
}

.btn-primary,
.btn-primary.disabled,
.btn-primary:disabled {
  background-color: #4466f2 !important;
  border-color: #4466f2 !important;
}
</style>
