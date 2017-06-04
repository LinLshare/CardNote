package me.lshare.cardnote.ui.page;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import me.lshare.cardnote.R;
import me.lshare.cardnote.adapter.HomeRecyclerAdapter;
import me.lshare.cardnote.base.EventCallback;
import me.lshare.cardnote.base.PageView;
import me.lshare.common.ui.DimensionUtils;
import me.lshare.common.ui.recyclerview.CommonItemDecoration;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class HomePageView extends PageView {

  private FrameLayout rootView;

  public HomePageView(Context context) {
    super(context);
  }

  @Override
  protected void initView() {
    rootView = new FrameLayout(context);
    rootView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                          ViewGroup.LayoutParams.MATCH_PARENT));

    // note stream
    {
      RecyclerView recyclerView = new RecyclerView(context);
      recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                                                                   StaggeredGridLayoutManager.VERTICAL));

      recyclerView.setAdapter(new HomeRecyclerAdapter(context));
      final int offset = DimensionUtils.dp2px(context, 8);
      recyclerView.addItemDecoration(new CommonItemDecoration(offset));
      FrameLayout.LayoutParams recyclerViewLp =
          new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                       ViewGroup.LayoutParams.MATCH_PARENT);
      rootView.addView(recyclerView, recyclerViewLp);
    }

    // add note button
    {
      FloatingActionButton addNoteButton = new FloatingActionButton(context);
      addNoteButton.setSize(FloatingActionButton.SIZE_NORMAL);
      addNoteButton.setImageResource(R.drawable.ic_add_white_24dp);
      addNoteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          postEvent(EventCallback.EVENT_ADD_NOTE_CLICK);
        }
      });
      FrameLayout.LayoutParams addNoteButtonLp =
          new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                       ViewGroup.LayoutParams.WRAP_CONTENT);
      addNoteButtonLp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
      final int margin = DimensionUtils.dp2px(context, 16);
      addNoteButtonLp.bottomMargin = margin;
      addNoteButtonLp.rightMargin = margin;
      rootView.addView(addNoteButton, addNoteButtonLp);
    }

  }

  @Override
  public ViewGroup view() {
    return rootView;
  }
}
