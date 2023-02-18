import { Product } from "@/api/types";
import { Image } from "@/api/types";

export interface GlobalState {
  isLoggedIn: boolean;
  products: Product[];
  ProductDetails: {
    id: number;
    name: string;
    description: String;
    price: number;
    quantity: number;
    images: Image[];
  };
}
