package me.lshare.cardnote.ui.page;

import android.content.Context;

import me.lshare.cardnote.base.CommonPageView;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.ui.widget.InputBar;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class AddNotePageView extends CommonPageView {

  private InputBar inputBar;

  public AddNotePageView(Context context, UiLayer parent) {
    super(context, parent);
  }


  @Override
  protected void initView() {
    super.initView();
    inputBar = new InputBar(context);
    rootView.addView(inputBar);
  }
}
