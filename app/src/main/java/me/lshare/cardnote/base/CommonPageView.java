package me.lshare.cardnote.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * PageView's common usage.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class CommonPageView extends PageView {
  protected FrameLayout rootView;

  public CommonPageView(Context context, UiLayer parent) {
    super(context, parent);
  }

  @Override
  protected void initView() {
    rootView = new FrameLayout(context);
    rootView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                          ViewGroup.LayoutParams.MATCH_PARENT));
  }

  @Override
  public ViewGroup view() {
    return rootView;
  }
}
