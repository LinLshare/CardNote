package me.lshare.cardnote.base;

/**
 * A PageView is a full page added to a layer.
 *
 * @author Lshare
 * @date 2017/6/3
 */
public abstract class PageView {
  protected EventCallback eventCallback;

  public void setEventCallbacK(EventCallback eventCallbacK) {
    this.eventCallback = eventCallbacK;
  }
}
