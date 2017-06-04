package me.lshare.cardnote.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/**
 * a UiLayer is a manager of pageViews.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class UiLayer {
  private FrameLayout layerView;
  private Context context;
  private EventCallback eventCallback;

  public UiLayer(Context context, EventCallback eventCallback) {
    this.context = context;
    this.eventCallback = eventCallback;
    initLayer();
  }

  public FrameLayout layerView() {
    return layerView;
  }

  private void initLayer() {
    layerView = new FrameLayout(context);
  }

  public void addPage(PageView pageView) {
    layerView.addView(pageView.view());
    pageView.setEventCallback(eventCallback);
  }

  public void addView(View view, FrameLayout.LayoutParams layoutParams){
    layerView.addView(view,layoutParams);

  }
}
