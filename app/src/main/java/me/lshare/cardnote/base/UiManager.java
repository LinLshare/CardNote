package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class UiManager {

  private UiLayer nativeLayer;
  private UiLayer webLayer;
  private UiLayer notificationLayer;
  private FrameLayout contentView;
  private Context context;
  private EventCallback eventCallback;

  public UiManager(Context context, EventCallback eventCallback) {
    this.context = context;
    this.eventCallback = eventCallback;
    initLayers();
  }

  public UiLayer nativeLayer() {
    return nativeLayer;
  }

  public UiLayer webLayer() {
    return webLayer;
  }

  public UiLayer notificationLayer() {
    return notificationLayer;
  }

  private void initLayers() {
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT));

    nativeLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams nativeLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(nativeLayer.layerView(), nativeLayerLp);

    webLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams webLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(webLayer.layerView(), webLayerLp);

    notificationLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams notificationLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(notificationLayer.layerView(), notificationLayerLp);
  }

  public ViewGroup getContentView() {
    return contentView;
  }
}
