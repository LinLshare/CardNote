package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.ui.TitleBarPageView;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class UiManager {

  private UiLayer nativeLayer;
  private UiLayer webLayer;
  private UiLayer upperLayer; // for TitleBar and Dialog
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
    return upperLayer;
  }

  private void initLayers() {
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT));

    int topMarginForTitleBar = DimensionUtils.dp2px(context, 56);

    nativeLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams nativeLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    nativeLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(nativeLayer.layerView(), nativeLayerLp);
  
    webLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams webLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    webLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(webLayer.layerView(), webLayerLp);

    upperLayer = new UiLayer(context, eventCallback);
    FrameLayout.LayoutParams notificationLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(upperLayer.layerView(), notificationLayerLp);

    upperLayer.addPage(new TitleBarPageView(context));
  }

  public ViewGroup getContentView() {
    return contentView;
  }
}
