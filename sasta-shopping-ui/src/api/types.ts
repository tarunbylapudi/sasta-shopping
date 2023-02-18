export interface Product {
  id: number;
  name: string;
  description: String;
  price: number;
  quantity: number;
  images: Image[];
}

export interface Image {
  id: number;
  name: string;
  type: string;
  bytes: string;
}
