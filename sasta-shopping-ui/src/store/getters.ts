import { GlobalState } from "@/store/types";
import { BYTE_TO_IMAGE, IMAGE_CONVERSION } from "./constants";
import { Image } from "@/api/types";
import ImageByteProcesser from "@/Utils/ImageByteProcesser";

interface ImageConversionGetters {
  BYTE_TO_IMAGE: (byteArray: Image[]) => boolean;
}

const getters = {
  [IMAGE_CONVERSION](state: GlobalState, getters: ImageConversionGetters) {
    state.ProductDetails.forEach((product) =>
      getters.BYTE_TO_IMAGE(product.images)
    );
    return state;
  },
  [BYTE_TO_IMAGE]: (state: GlobalState) => (byteArray: Image[]) => {
    const imageURLArray: any = [];
    byteArray.forEach((bytearray) => {
      const binaryString = window.atob(bytearray.bytes);
      const len = binaryString.length;
      const bytes = new Uint8Array(len);
      for (let i = 0; i < len; i++) {
        bytes[i] = binaryString.charCodeAt(i);
      }
      const blob = new Blob([bytes], { type: "image/jpeg" });
      const url = URL.createObjectURL(blob);
      imageURLArray.push(url);
    });
    return imageURLArray;
  },
};

export default getters;
