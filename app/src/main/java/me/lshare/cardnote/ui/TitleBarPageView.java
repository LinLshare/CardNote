package me.lshare.cardnote.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.base.CommonPageView;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class TitleBarPageView extends CommonPageView {
  public TitleBarPageView(Context context) {
    super(context);
  }

  @Override
  protected void initView() {
    super.initView();
    int height = DimensionUtils.dp2px(context, 52);
    FrameLayout.LayoutParams titleBarLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
    rootView.addView(new TitleBar(context), titleBarLp);
  }
}
