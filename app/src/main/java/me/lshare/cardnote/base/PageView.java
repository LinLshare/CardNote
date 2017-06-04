package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;

/**
 * A PageView is a full page added to a layer.
 *
 * @author Lshare
 * @date 2017/6/3
 */
public abstract class PageView {
  protected EventCallback eventCallback;
  protected Context context;

  public PageView(Context context) {
    this.context = context;
    initView();
  }

  protected abstract void initView();

  public abstract ViewGroup view();

  public void setEventCallback(EventCallback eventCallbacK) {
    this.eventCallback = eventCallbacK;
  }

  public void postEvent(int eventType, Object extra) {
    if (eventCallback == null) {
      throw new IllegalStateException("!!! eventCallback shouldn't be null");
    } eventCallback.onEvent(eventType, extra);
  }

  public void postEvent(int eventType) {
    postEvent(eventType, null);
  }
}
