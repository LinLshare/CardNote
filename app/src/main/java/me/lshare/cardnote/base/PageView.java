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
  protected UiLayer parent;
  protected Context context;

  public PageView(Context context, UiLayer parent) {
    this.context = context;
    this.parent = parent;
    initView();
  }

  protected abstract void initView();

  public abstract ViewGroup view();

  public void postEvent(int msgType, Object extra) {
    if (parent == null) {
      throw new IllegalStateException("!!! parent shouldn't be null");
    }
    parent.onMessage(msgType, extra);
  }

  public void postEvent(int msgType) {
    postEvent(msgType, null);
  }
}
