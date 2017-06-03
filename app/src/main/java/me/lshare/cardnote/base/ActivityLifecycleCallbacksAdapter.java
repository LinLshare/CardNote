package me.lshare.cardnote.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * 以便使用时只实现需要的接口方法
 */
public abstract class ActivityLifecycleCallbacksAdapter
    implements Application.ActivityLifecycleCallbacks {
  @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

  }

  @Override public void onActivityStarted(Activity activity) {

  }

  @Override public void onActivityResumed(Activity activity) {

  }

  @Override public void onActivityPaused(Activity activity) {

  }

  @Override public void onActivityStopped(Activity activity) {

  }

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

  }

  @Override public void onActivityDestroyed(Activity activity) {

  }
}
