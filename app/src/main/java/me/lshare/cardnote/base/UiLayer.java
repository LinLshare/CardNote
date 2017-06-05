package me.lshare.cardnote.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Stack;

/**
 * a UiLayer is a manager of pageViews.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public abstract class UiLayer implements MessageListener, CommandListener {
  private FrameLayout layerView;
  protected Context context;
  protected UiManager parent;
  private Stack<PageView> pageViewStack;

  public UiLayer(Context context, UiManager parent) {
    this.context = context;
    this.parent = parent;
    initLayer();
  }

  public FrameLayout layerView() {
    return layerView;
  }

  private void initLayer() {
    layerView = new FrameLayout(context);
    pageViewStack = new Stack<>();
  }

  public void addPage(PageView pageView) {
    layerView.addView(pageView.view());
    pageViewStack.push(pageView);
  }

  public void removeCurrentPage() {
    if (!pageViewStack.isEmpty()) {
      PageView pageView = pageViewStack.pop();
      layerView.removeView(pageView.view());
    }
  }

  public void addView(View view, FrameLayout.LayoutParams layoutParams) {
    layerView.addView(view, layoutParams);
  }

  @Override
  public void onMessage(int msgType, Object extra) {
    parent.onMessage(msgType, extra);
  }

  @Override
  public void onCommand(int cmdType, Object extra) {
  }
}
