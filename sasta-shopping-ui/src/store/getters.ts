import { GlobalState } from "@/store/types";
import {
  BYTE_TO_IMAGE,
  IMAGE_CONVERSION,
  UPDATE_PEODUCT_IMG_URL,
  IS_AUTHENTICATED,
  CURRENT_USER,
} from "./constants";
import { Image } from "@/api/types";
import ImageByteProcesser from "@/Utils/ImageByteProcesser";
import state from "./state";

interface ImageConversionGetters {
  BYTE_TO_IMAGE: (byteString: string) => boolean;
}

const getters = {
  [IMAGE_CONVERSION](state: GlobalState, getters: ImageConversionGetters) {
    const ProductImagesMap = new Map();
    state.products.forEach((product) => {
      ProductImagesMap.set(
        product.id,
        product.images.map((image) => getters.BYTE_TO_IMAGE(image.bytes))
      );
    });
    console.log(ProductImagesMap);
    return ProductImagesMap;

    // return state.products.map((product) =>
    //   product.images.map((image) => getters.BYTE_TO_IMAGE(image.bytes))
    // );
  },
  [BYTE_TO_IMAGE]: (state: GlobalState) => (byteString: string) => {
    const binaryString = window.atob(byteString);
    const len = binaryString.length;
    const bytes = new Uint8Array(len);
    for (let i = 0; i < len; i++) {
      bytes[i] = binaryString.charCodeAt(i);
    }
    const blob = new Blob([bytes], { type: "image/jpeg" });
    const imageUrl = URL.createObjectURL(blob);

    return imageUrl;
  },

  [CURRENT_USER]: (state: GlobalState) => {
    return state.user;
  },
  [IS_AUTHENTICATED]: (state: GlobalState) => {
    return state.isAuthenticated;
  },
};

export default getters;
