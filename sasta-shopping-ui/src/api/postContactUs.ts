import axios from "@/plugins/axios";

const postContactUs = async () => {
  try {
    const response = await axios.post(process.env.VUE_APP_POST_CONTACT_US, {
      data: {},
    });
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
};

export default postContactUs;
