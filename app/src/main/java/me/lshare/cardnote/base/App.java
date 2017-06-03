package me.lshare.cardnote.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class App extends Application {
  private AppController appController;
  public static App INSTANCE;

  public AppController appController() {
    if (appController == null) {
      throw new IllegalStateException("!!! AppController not init yet");
    }
    return appController;
  }

  public static App instance() {
    if (INSTANCE == null) {
      throw new IllegalStateException("!!! App not init yet");
    }
    return INSTANCE;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    INSTANCE = this;
    initController();
  }

  private void initController() {
    appController = new AppController(this);
    registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter() {
      @Override
      public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        super.onActivityCreated(activity, savedInstanceState);
        if (activity instanceof MainActivity) {
          MainActivity mainActivity = (MainActivity) activity;
          appController.attachMainActivity(mainActivity);
          appController.start();
        }
      }
    });
  }
}
