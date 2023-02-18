const ImageByteProcesser = (byteArray: string) => {
  const typedArray = new Uint8Array(byteArray as unknown as ArrayBufferLike);
  const blob = new Blob([typedArray], { type: "image/jpeg" });
  const imageUrl = URL.createObjectURL(blob);
  return imageUrl;
};

export default ImageByteProcesser;
