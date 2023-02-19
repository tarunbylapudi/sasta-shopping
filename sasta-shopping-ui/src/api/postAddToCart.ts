import axios from "@/plugins/axios";

const postAddToCart = async () => {
  try {
    const response = await axios.post("https://example.com/api/data", {
      //data: this.data,
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
};

export default postAddToCart;
