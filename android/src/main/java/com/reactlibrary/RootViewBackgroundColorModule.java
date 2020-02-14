package com.reactlibrary;

import android.app.Activity;
import android.view.View;
import android.graphics.Color;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RootViewBackgroundColorModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RootViewBackgroundColorModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RootViewBackgroundColor";
    }

    @ReactMethod
    public void setBackground(final float red, final float green, final float blue, final float alpha) {
        final Activity activity = getCurrentActivity();

        if (activity == null) {
          return;
        }

        activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            View rootView = activity.getWindow().getDecorView();
            int parsedColor = Color.argb(alpha, red / 255, green / 255, blue / 255);
            rootView.getRootView().setBackgroundColor(parsedColor);
          }
        });
    }
}
