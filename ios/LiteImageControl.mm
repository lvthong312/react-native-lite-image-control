#import "LiteImageControl.h"
#import "LiteImageControl-Swift.h"
@implementation LiteImageControl {
  LiteImageControlModule *moduleImpl;
}

-(instancetype) init {
  self = [super init];
  if(self) {
    moduleImpl = [LiteImageControlModule new];
  }
  return self;
}


- (void)preload:(nonnull NSArray<NSString *> *)uris {
  [moduleImpl preloadWithUris:uris];
}

- (void)getAllCache:(RCTPromiseResolveBlock)resolve
             reject:(RCTPromiseRejectBlock)reject {
  [moduleImpl getAllCacheWithResolver:^(NSArray<NSDictionary *> * _Nonnull result) {
    resolve(result);
  }];
}

- (void)clearMemoryCache {
  [moduleImpl clearMemoryCache];
}

- (void)clearDiskCache {
  [moduleImpl clearDiskCache];
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeLiteImageControlSpecJSI>(params);
}

+ (NSString *)moduleName
{
  return @"LiteImageControl";
}

@end
