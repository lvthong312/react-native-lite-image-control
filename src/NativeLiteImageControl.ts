import { type TurboModule, TurboModuleRegistry } from 'react-native';

// Define TypeScript interface (Spec)
export interface Spec extends TurboModule {
  /**
   * Preload a list of image URIs into cache
   */
  preload(uris: string[]): void;

  /**
   * Get all cached image keys & paths
   */
  getAllCache(): Promise<{ key: string; path: string }[]>;

  /**
   * Clear all disk cache
   */
  clearDiskCache(): void;
  /**
   * Clear all MemoryCache
   */
  clearMemoryCache(): void;
}

// Export TurboModule instance
export default TurboModuleRegistry.getEnforcing<Spec>('LiteImageControl');
