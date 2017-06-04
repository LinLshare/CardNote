package me.lshare.cardnote.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import me.lshare.cardnote.base.PageView;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class AddNotePageView extends PageView {
  private FrameLayout rootView;

  public AddNotePageView(Context context) {
    super(context);
  }

  @Override
  protected void initView() {
    rootView = new FrameLayout(context);
    rootView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                          ViewGroup.LayoutParams.MATCH_PARENT));
    {

    }

  }

  @Override
  public ViewGroup view() {
    return rootView;
  }
}
