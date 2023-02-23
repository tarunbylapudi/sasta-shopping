import axios from "@/plugins/axios";

const deleteClearCart = async () => {
  try {
    const baseurl = process.env.VUE_APP_API_URL;
    const response = await axios.delete(`${baseurl}/cartitems`);
    // Item successfully deleted
    console.log(response);
    return true;
  } catch (error) {
    console.error(error);
    // Handle error
    return false;
  }
};

export default deleteClearCart;
