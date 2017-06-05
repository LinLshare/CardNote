package me.lshare.cardnote.ui.page;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.base.MessageListener;
import me.lshare.cardnote.base.CommonPageView;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.ui.widget.TitleBar;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class TitleBarPageView extends CommonPageView implements TitleBar.Listener {

  private TitleBar titleBar;

  public TitleBarPageView(Context context, UiLayer parent) {
    super(context, parent);
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
    postEvent(MessageListener.MSG_NATIVE_EDIT_DONE, titleBar.getTitle());
  }

  @Override
  public void onRightShareImageViewClick() {
    postEvent(MessageListener.MSG_SHARE);
  }

  @Override
  public void onLeftBackImageClick() {
    postEvent(MessageListener.MSG_NATIVE_BACK);
  }
}
