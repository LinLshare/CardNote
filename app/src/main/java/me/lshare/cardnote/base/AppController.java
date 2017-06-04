package me.lshare.cardnote.base;

import android.content.Context;

/**
 * The one and only one Controller for APP.
 *
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
    mainActivity.showHome();
  }

  @Override
  public void onEvent(int eventType, Object extra) {
    switch (eventType) {
      case EVENT_ADD_NOTE_CLICK:
        mainActivity.showAddNote();
        break;
      default:
        break;
    }
  }
}
