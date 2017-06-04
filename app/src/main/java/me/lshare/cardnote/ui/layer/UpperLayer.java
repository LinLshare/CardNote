package me.lshare.cardnote.ui.layer;

import android.content.Context;

import me.lshare.cardnote.base.EventCallback;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.ui.page.TitleBarPageView;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class UpperLayer extends UiLayer {

  private final TitleBarPageView titleBarPageView;

  public UpperLayer(Context context, EventCallback eventCallback) {
    super(context, eventCallback);
    titleBarPageView = new TitleBarPageView(context);
    addPage(titleBarPageView);
  }

  public TitleBarPageView titleBarPageView() {
    return titleBarPageView;
  }
}
