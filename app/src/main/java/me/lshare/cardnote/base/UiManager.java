package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author Lshare
 * @date 2017/6/3
 */
public class UiManager {

  private FrameLayout nativeLayer;
  private FrameLayout webLayer;
  private FrameLayout notificationLayer;
  private FrameLayout contentView;
  private Context context;

  public UiManager(Context context) {
    this.context = context;
    initLayers();
  }

  private void initLayers() {
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT));

    nativeLayer = new FrameLayout(context);
    FrameLayout.LayoutParams nativeLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(nativeLayer, nativeLayerLp);

    webLayer = new FrameLayout(context);
    FrameLayout.LayoutParams webLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(webLayer, webLayerLp);

    notificationLayer = new FrameLayout(context);
    FrameLayout.LayoutParams notificationLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(notificationLayer, notificationLayerLp);
  }

  public ViewGroup getContentView() {
    return contentView;
  }
}
