//
//  LiteImageControlModule.swift
//  LiteImageControl
//
//  Created by Thong Luong on 23/10/25.
//

import Foundation
import SDWebImage

@objc(LiteImageControlModule)
public class LiteImageControlModule: NSObject {

  // MARK: - Preload images
  @objc public func preloadWithUris(_ uris: [String]) {
    let urls = uris.compactMap { URL(string: $0) }
    guard !urls.isEmpty else { return }
    SDWebImagePrefetcher.shared.prefetchURLs(urls)
    print("✅ Preloaded \(urls.count) images")
  }

  // MARK: - Get all cache info
  @objc public func getAllCacheWithResolver(
    _ resolver: @escaping (NSArray) -> Void
  ) {
    var results: [[String: String]] = []

    let diskCachePath = SDImageCache.shared.diskCachePath

    let fm = FileManager.default
    if let files = try? fm.contentsOfDirectory(atPath: diskCachePath) {
      for fileName in files {
        let fullPath = (diskCachePath as NSString).appendingPathComponent(fileName)
        results.append([
          "key": fileName,
          "path": fullPath
        ])
      }
    }

    resolver(results as NSArray)
  }
  
  @objc public func clearMemoryCache() {
    SDImageCache.shared.clearMemory()
  }
  // MARK: - Clear disk cache
  @objc public func clearDiskCache() {
    SDImageCache.shared.clear(with: .all) {
      print("🧹 SDWebImage disk cache cleared.")
    }
  }
}
