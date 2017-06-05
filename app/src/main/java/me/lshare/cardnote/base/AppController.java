package me.lshare.cardnote.base;

import android.content.Context;

/**
 * The one and only one Controller for APP.
 *
 * @author Lshare
 * @date 2017/6/3
 */
public class AppController implements MessageListener {
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
  public void onMessage(int msgType, Object extra) {
    switch (msgType) {
      case MSG_SHARE:
        break;
      default:
        break;
    }
  }
}
