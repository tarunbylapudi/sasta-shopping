import { GlobalState } from "@/store/types";

const state = (): GlobalState => {
  return {
    user: JSON.parse(localStorage.getItem("user") as string),
    isAuthenticated: localStorage.getItem("user") ? true : false,
    products: [],
    ProductDetails: {
      id: 0,
      name: "",
      description: "",
      price: 0,
      quantity: 0,
      images: [{ id: 0, name: "", type: "", bytes: "" }],
    },
  };
};

export default state;
