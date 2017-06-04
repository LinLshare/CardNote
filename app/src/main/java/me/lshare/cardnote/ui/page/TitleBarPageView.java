package me.lshare.cardnote.ui.page;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.base.CommonPageView;
import me.lshare.cardnote.base.EventCallback;
import me.lshare.cardnote.ui.TitleBar;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class TitleBarPageView extends CommonPageView implements TitleBar.Listener {

  private TitleBar titleBar;

  public TitleBarPageView(Context context) {
    super(context);
  }

  @Override
  protected void initView() {
    super.initView();
    int height = DimensionUtils.dp2px(context, 52);
    FrameLayout.LayoutParams titleBarLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
    titleBar = new TitleBar(context);
    rootView.addView(titleBar, titleBarLp);
    titleBar.setListener(this);
  }

  public void home(String title) {
    titleBar.home(title);
  }

  public void edit(String title, boolean isHint) {
    titleBar.edit(title, isHint);
  }

  public void view(String title) {
    titleBar.view(title);
  }

  @Override
  public void onRightDoneImageViewClick() {
    postEvent(EventCallback.EVENT_EDIT_DONE);
  }

  @Override
  public void onRightShareImageViewClick() {
    postEvent(EventCallback.EVENT_SHARE);
  }

  @Override
  public void onLeftBackImageClick() {
    postEvent(EventCallback.EVENT_SHOW_HOME);
  }
}
