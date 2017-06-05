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
public class UiManager implements MessageListener, CommandListener {

  private NativeLayer nativeLayer;
  private WebLayer webLayer;
  private UpperLayer upperLayer;
  private FrameLayout contentView;
  private Context context;
  private MainActivity parent;

  public UiManager(MainActivity activity) {
    this.context = activity;
    this.parent = activity;
    initLayers();
  }

  private void initLayers() {
    contentView = new FrameLayout(context);
    contentView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                             ViewGroup.LayoutParams.MATCH_PARENT));

    int topMarginForTitleBar = DimensionUtils.dp2px(context, 52);

    nativeLayer = new NativeLayer(context, this);
    FrameLayout.LayoutParams nativeLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    nativeLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(nativeLayer.layerView(), nativeLayerLp);

    webLayer = new WebLayer(context, this);
    FrameLayout.LayoutParams webLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    webLayerLp.topMargin = topMarginForTitleBar;
    contentView.addView(webLayer.layerView(), webLayerLp);

    upperLayer = new UpperLayer(context, this);
    FrameLayout.LayoutParams upperLayerLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    contentView.addView(upperLayer.layerView(), upperLayerLp);
  }

  public ViewGroup getContentView() {
    return contentView;
  }

  @Override
  public void onMessage(int msgType, Object extra) {
    switch (msgType) {
      case MessageListener.MSG_NATIVE_ADD_NOTE:
        upperLayer.onCommand(CommandListener.CMD_UPPER_SHOW_EDIT, extra);
        break;
      case MessageListener.MSG_NATIVE_BACK:
        nativeLayer.onCommand(CommandListener.CMD_UPPER_SHOW_HOME, extra);
        break;
    }
    parent.onMessage(msgType, extra);
  }

  @Override
  public void onCommand(int cmdType, Object extra) {

  }
}
