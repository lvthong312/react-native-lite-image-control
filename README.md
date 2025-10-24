# react-native-lite-image-control

Support for Image

## Installation


```sh
npm install react-native-lite-image-control
```


## Usage


```js
import {
  preload,
  getAllCache,
  clearDiskCache,
  clearMemoryCache,
} from 'react-native-lite-image-control';

// 1️⃣ Preload multiple image URLs into cache
preload([
  'https://example/img1.png',
  'https://example/img2.png',
]);

// 2️⃣ Get all cached image files
getAllCache().then((cacheList) => {
  console.log('Cache files:', cacheList);
});

// 3️⃣ Clear disk cache
clearDiskCache();

// 4️⃣ Clear memory cache
clearMemoryCache();

```


| Function                  | Description                                | Parameters                   | Returns                                         |
| ------------------------- | ------------------------------------------ | ---------------------------- | ----------------------------------------------- |
| `preload(uris: string[])` | Preloads a list of images into Glide cache | `uris` - Array of image URLs | `void`                                          |
| `getAllCache()`           | Gets all cached files info (key + path)    | none                         | `Promise<Array<{ key: string; path: string }>>` |
| `clearMemoryCache()`      | Clears Glide's **memory** cache            | none                         | `void`                                          |
| `clearDiskCache()`        | Clears Glide's **disk** cache (async)      | none                         | `void`                                          |

## 🪪 License
MIT © 2025 Luong Thong
