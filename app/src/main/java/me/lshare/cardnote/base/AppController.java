package me.lshare.cardnote.base;

import android.content.Context;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class AppController implements EventCallback {
  protected Context appContext;
  protected MainActivity mainActivity;

  public AppController(Context appContext) {
    this.appContext = appContext;
  }

  public void attachMainActivity(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  public void start() {
    mainActivity.start();
  }

  @Override
  public void onEvent(int what, Object extra) {

  }
}
