#import "RootViewBackgroundColor.h"

@implementation RootViewBackgroundColor

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(setBackground:(float)red green:(float)green blue:(float)blue alpha:(float)alpha)
{
    dispatch_async( dispatch_get_main_queue(), ^{
        UIViewController *rootViewController = [UIApplication sharedApplication].delegate.window.rootViewController;
        rootViewController.view.backgroundColor = [[UIColor alloc] initWithRed:red/255 green:green/255 blue:blue/255 alpha:alpha];
    });
}

@end
