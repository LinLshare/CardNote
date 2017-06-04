package me.lshare.common.ui.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * a common ItemDecoration for RecyclerView with any LayoutManager.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class CommonItemDecoration extends RecyclerView.ItemDecoration {
  private int offset;

  public CommonItemDecoration(int offset) {
    this.offset = offset;
  }

  @Override
  public void getItemOffsets(Rect outRect,
                             View view,
                             RecyclerView parent,
                             RecyclerView.State state) {
    outRect.left += offset;
    outRect.top += offset;
    int childAdapterPosition = parent.getChildAdapterPosition(view);

    RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
    if (layoutManager instanceof GridLayoutManager) {
      handleGridLayoutOffset(outRect,
                             parent,
                             childAdapterPosition,
                             (GridLayoutManager) layoutManager);
    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
      handleStaggeredGridLayoutOffset(outRect,
                                      parent,
                                      childAdapterPosition,
                                      (StaggeredGridLayoutManager) layoutManager);
    } else if (layoutManager instanceof LinearLayoutManager) {
      handleLinearLayoutOffset(outRect,
                               parent,
                               childAdapterPosition,
                               (LinearLayoutManager) layoutManager);
    }
  }

  private void handleLinearLayoutOffset(Rect outRect,
                                        RecyclerView parent,
                                        int childAdapterPosition,
                                        LinearLayoutManager layoutManager) {
    LinearLayoutManager linearLayoutManager = layoutManager;
    outRect.top += offset;
    outRect.left += offset;
    outRect.right += offset;
    int itemCount = parent.getAdapter().getItemCount();
    if (childAdapterPosition == itemCount - 1) {
      outRect.bottom += offset;
    }
  }

  private void handleStaggeredGridLayoutOffset(Rect outRect,
                                               RecyclerView parent,
                                               int childAdapterPosition,
                                               StaggeredGridLayoutManager layoutManager) {
    StaggeredGridLayoutManager staggeredGridLayoutManager = layoutManager;
    int spanCount = staggeredGridLayoutManager.getSpanCount();
    if ((childAdapterPosition + 1) % spanCount == 0) {
      outRect.right += offset;
    }
    int itemCount = parent.getAdapter().getItemCount();
    if (childAdapterPosition == itemCount - 1 || childAdapterPosition == itemCount - 2) {
      outRect.bottom += offset;
    }
  }

  private void handleGridLayoutOffset(Rect outRect,
                                      RecyclerView parent,
                                      int childAdapterPosition,
                                      GridLayoutManager layoutManager) {
    GridLayoutManager gridLayoutManager = layoutManager;
    int spanCount = gridLayoutManager.getSpanCount();
    if ((childAdapterPosition + 1) % spanCount == 0) {
      outRect.right += offset;
    }
    int itemCount = parent.getAdapter().getItemCount();
    if (childAdapterPosition == itemCount - 1 || childAdapterPosition == itemCount - 2) {
      outRect.bottom += offset;
    }
  }
}
