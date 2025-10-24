import LiteImageControl from './NativeLiteImageControl';

export const preload = (uris: string[]) => {
  if (Array.isArray(uris) && uris.length > 0) {
    LiteImageControl?.preload(uris);
  }
};

// 🔹 Get all cache
export const getAllCache = async () => {
  const files = await LiteImageControl.getAllCache();
  return files;
};

// 🔹 Clear memory cache
export const clearMemoryCache = async () => {
  await LiteImageControl.clearMemoryCache();
};

// 🔹 Clear disk cache
export const clearDiskCache = async () => {
  await LiteImageControl.clearDiskCache();
};
