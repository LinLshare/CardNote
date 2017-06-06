package me.lshare.cardnote.ui.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import me.lshare.cardnote.base.CommonPageView;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.ui.widget.InputBar;
import me.lshare.cardnote.ui.widget.NoteItemView;
import me.lshare.common.ui.DimensionUtils;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class AddNotePageView extends CommonPageView implements NoteItemView.Listener {

  private InputBar inputBar;

  public AddNotePageView(Context context, UiLayer parent) {
    super(context, parent);
  }

  @Override
  protected void initView() {
    super.initView();

    ScrollView scrollView = new ScrollView(context);
    FrameLayout.LayoutParams scrollViewLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.WRAP_CONTENT);
    final int margin = DimensionUtils.dp2px(context, 8);
    scrollViewLp.setMargins(margin, margin, margin, margin);
    rootView.addView(scrollView, scrollViewLp);

    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    FrameLayout.LayoutParams linearLayoutLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.MATCH_PARENT);
    scrollView.addView(linearLayout, linearLayoutLp);

    final NoteItemView noteItemView = new NoteItemView(context) {
      @Override
      public View setNoteContentView(FrameLayout parent) {
        TextView textView = new TextView(context);
        textView.setText("jslfjowiefjalfjiow;jef;adfkja;foejfalekfjlkfaklfjieofjalefkjl");
        parent.addView(textView);
        return textView;
      }
    };
    noteItemView.setListener(this);
    linearLayout.addView(noteItemView);

    inputBar = new InputBar(context);
    FrameLayout.LayoutParams inputBarLp =
        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                     ViewGroup.LayoutParams.WRAP_CONTENT);
    linearLayout.addView(inputBar, inputBarLp);
  }

  @Override
  public void onInsertFront() {

  }

  @Override
  public void onInsertAfter() {

  }

  @Override
  public void onDelete() {

  }

  @Override
  public void onMove() {

  }
}