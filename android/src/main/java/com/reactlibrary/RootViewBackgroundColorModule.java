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
    public void setBackground(final int red, final int green, final int blue, final float alpha) {
        final Activity activity = getCurrentActivity();

        if (activity == null) {
          return;
        }

        final int alphaInt = (int) alpha * 255;

        activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            View rootView = activity.getWindow().getDecorView();
            int parsedColor = Color.argb(alphaInt, red, green, blue);
            rootView.getRootView().setBackgroundColor(parsedColor);
          }
        });
    }
}
