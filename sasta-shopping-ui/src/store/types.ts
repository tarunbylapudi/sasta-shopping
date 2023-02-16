import { Product } from "@/api/types";

export interface GlobalState {
  isLoggedIn: boolean;
  products: Product[];
}
