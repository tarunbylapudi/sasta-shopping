import axios from "@/plugins/axios";
import { addToCartPayload } from "./types";

const postAddToCart = async (payload: addToCartPayload) => {
  try {
    const baseurl = process.env.VUE_APP_API_URL;
    //console.log(payload);
    const response = await axios.post(
      `${baseurl}/cartitems/${payload.productId}/${payload.quantity}`
    );
    console.log(response);
    if (response.status === 200) return true;
  } catch (error) {
    console.error(error);
    return false;
  }
};

export default postAddToCart;
