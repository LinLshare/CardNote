package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.ui.layer.NativeLayer;
import me.lshare.cardnote.ui.layer.UpperLayer;
import me.lshare.cardnote.ui.layer.WebLayer;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class UiManager {

  private NativeLayer nativeLayer;
  private WebLayer webLayer;
  private UpperLayer upperLayer;
  private FrameLayout contentView;
  private Context context;
  private EventCallback eventCallback;

  public UiManager(Context context, EventCallback eventCallback) {
    this.context = context;
    this.eventCallback = eventCallback;
    initLayers();
  }

  public NativeLayer nativeLayer() {
    return nativeLayer;
  }

  public WebLayer webLayer() {
    return webLayer;
  }

  public UpperLayer upperLayer() {
    return upperLayer;
  }

  private void initLayers() {
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT));

    int topMarginForTitleBar = DimensionUtils.dp2px(context, 52);

    nativeLayer = new NativeLayer(context, eventCallback);
    FrameLayout.LayoutParams nativeLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    nativeLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(nativeLayer.layerView(), nativeLayerLp);

    webLayer = new WebLayer(context, eventCallback);
    FrameLayout.LayoutParams webLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    webLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(webLayer.layerView(), webLayerLp);

    upperLayer = new UpperLayer(context, eventCallback);
    FrameLayout.LayoutParams upperLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(upperLayer.layerView(), upperLayerLp);
  }

  public ViewGroup getContentView() {
    return contentView;
  }
}
