import { Cart, GlobalState } from "@/store/types";
import {
  BYTE_TO_IMAGE,
  IMAGE_CONVERSION,
  UPDATE_PEODUCT_IMG_URL,
  IS_AUTHENTICATED,
  CURRENT_USER,
  ETL_CART,
  CART_DETAILS,
} from "./constants";
import { Image } from "@/api/types";
import ImageByteProcesser from "@/Utils/ImageByteProcesser";
import state from "./state";

interface ImageConversionGetters {
  BYTE_TO_IMAGE: (byteString: string) => boolean;
}
interface cartEtl {
  ETL_CART: (
    state: GlobalState
  ) => Map<number, { productId: number; quantity: number }>;
}
interface CartMap {
  productId: number;
  quantity: number;
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

  [ETL_CART]: (state: GlobalState) => {
    const currentCart = state.cart.reduce((map, item: Cart) => {
      const productId = item.product.id;
      const quantity = item.quantity;
      if (map.has(productId)) {
        map.set(productId, [
          productId,
          map.get(productId)[quantity] + quantity,
        ]);
      } else {
        map.set(productId, [productId, quantity]);
      }

      return map;
    }, new Map());
    return currentCart;
  },

  // [CART_DETAILS]:
  //   (state: GlobalState) =>
  //   (currentCart: Map<number, { productId: number; quantity: number }>) => {
  //     currentCart.forEach((item) => {
  //       state.products.
  //     });

  //     return currentCart;
  //   },
};

export default getters;
