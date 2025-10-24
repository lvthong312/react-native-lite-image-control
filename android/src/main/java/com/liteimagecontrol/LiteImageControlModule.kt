package com.liteimagecontrol

import com.bumptech.glide.Glide
import com.facebook.react.bridge.*
import com.facebook.react.module.annotations.ReactModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.widget.Toast
@ReactModule(name = LiteImageControlModule.NAME)
class LiteImageControlModule(reactContext: ReactApplicationContext) :
  NativeLiteImageControlSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

   // MARK: - Preload images
  @ReactMethod
  override fun preload(uris: ReadableArray) { // ✅ đổi từ preloadWithUris -> preload
    if (uris.size() == 0) return

    val list = mutableListOf<String>()
    for (i in 0 until uris.size()) {
      val url = uris.getString(i)
      if (!url.isNullOrEmpty()) list.add(url)
    }

    if (list.isEmpty()) return

    val context = reactApplicationContext
    CoroutineScope(Dispatchers.IO).launch {
      list.forEach { url ->
        try {
          Glide.with(context).load(url).preload()
        } catch (_: Exception) { }
      }

      // context.currentActivity?.runOnUiThread {
      //       Toast.makeText(
      //         context,
      //         "LiteImageModule: preload(${list.size}) called",
      //         Toast.LENGTH_SHORT
      //       ).show()
      // }
      
      println("✅ Preloaded ${list.size} images")
    }
  }

  // MARK: - Get all cache info
  @ReactMethod
  override fun getAllCache(promise: Promise) { // ✅ đổi từ getAllCacheWithResolver -> getAllCache
    try {
      val cacheDir = Glide.getPhotoCacheDir(reactApplicationContext)
      val result = Arguments.createArray()

      if (cacheDir != null && cacheDir.exists()) {
        val files = cacheDir.listFiles()
        files?.forEach { file ->
          val map = Arguments.createMap()
          map.putString("key", file.name)
          map.putString("path", file.absolutePath)
          result.pushMap(map)
        }
      }

      promise.resolve(result)
    } catch (e: Exception) {
      promise.reject("E_GET_CACHE", e)
    }
  }

  // MARK: - Clear memory cache
  @ReactMethod
  override fun clearMemoryCache() {
    try {
      Glide.get(reactApplicationContext).clearMemory()
      println("🧠 Glide memory cache cleared.")
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  // MARK: - Clear disk cache
  @ReactMethod
  override fun clearDiskCache() {
    CoroutineScope(Dispatchers.IO).launch {
      try {
        Glide.get(reactApplicationContext).clearDiskCache()
        println("🧹 Glide disk cache cleared.")
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }


  companion object {
    const val NAME = "LiteImageControl"
  }
}
