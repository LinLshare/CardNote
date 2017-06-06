package me.lshare.cardnote.ui.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import me.lshare.cardnote.R;
import me.lshare.cardnote.base.App;
import me.lshare.common.ui.ColorUtils;
import me.lshare.common.ui.DimensionUtils;

/**
 * NoteItemView is a View represented a item of a note, which has STATE_VIEW and STATE_EDIT.
 *
 * @author Lshare
 * @date 2017/6/6
 */
public abstract class NoteItemView extends FrameLayout {
  public static final int STATE_VIEW = 0;
  public static final int STATE_EDIT = 1;
  private static final int MAX_HEIGHT;
  private static final int MIN_HEIGHT;
  private int currentState = STATE_VIEW;
  private Context context;
  private FrameLayout coverLayout;

  public NoteItemView(@NonNull Context context) {
    super(context);
    this.context = context;
    init();
  }

  static {
    MIN_HEIGHT = DimensionUtils.dp2px(App.instance(), 56);
    MAX_HEIGHT = DimensionUtils.dp2px(App.instance(), 120);
  }

  private void init() {
    // config rootView
    setMinimumHeight(MIN_HEIGHT);
    this.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        switch (currentState) {
          case STATE_VIEW:
            edit();
            break;
          case STATE_EDIT:
            view();
            break;
        }
      }
    });

    // set contentView
    View noteContentView = setNoteContentView(this);
    ViewGroup.LayoutParams noteContentViewLp = noteContentView.getLayoutParams();
    if (noteContentViewLp.height >= MAX_HEIGHT) {
      noteContentViewLp.height = MAX_HEIGHT;
      noteContentView.requestLayout();
    }

    // set cover layout
    coverLayout = new FrameLayout(context);
    coverLayout.setBackgroundColor(ColorUtils.getColor(context, R.color.bgColorGray));
    LayoutParams coverLayoutLp =
        new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    addView(coverLayout, coverLayoutLp);

    // config cover action button
    ImageView insertFrontImageView =
        addImageViewToCoverLayout(R.drawable.ic_add_circle_accent_24dp, Gravity.LEFT | Gravity.TOP);
    insertFrontImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        checkListener();
        listener.onInsertFront();
      }
    });
    ImageView insertAfterImageView = addImageViewToCoverLayout(R.drawable.ic_add_circle_accent_24dp,
                                                               Gravity.LEFT | Gravity.BOTTOM);
    insertAfterImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        checkListener();
        listener.onInsertAfter();
      }
    });
    ImageView moveImageView =
        addImageViewToCoverLayout(R.drawable.ic_move_accent_24dp, Gravity.RIGHT | Gravity.TOP);
    moveImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        checkListener();
        listener.onMove();
      }
    });

    ImageView deleteImageView =
        addImageViewToCoverLayout(R.drawable.ic_delete_accent_24dp, Gravity.RIGHT | Gravity.BOTTOM);
    deleteImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        checkListener();
        listener.onDelete();
      }
    });
    coverLayout.setVisibility(GONE);
  }

  private void checkListener() {
    if (listener == null) {
      throw new IllegalStateException("!!! listener should not be null");
    }
  }

  private ImageView addImageViewToCoverLayout(@DrawableRes int drawableRes, int gravity) {
    final int imgWidthAndHeight = DimensionUtils.dp2px(context, 24);
    final int verticalMargin = DimensionUtils.dp2px(context, 2);
    final int horizontalMargin = DimensionUtils.dp2px(context, 8);
    ImageView imageView = new ImageView(context);
    imageView.setImageResource(drawableRes);
    LayoutParams imageViewLp = new LayoutParams(imgWidthAndHeight, imgWidthAndHeight);
    imageViewLp.gravity = gravity;
    final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;
    switch (verticalGravity) {
      case Gravity.TOP:
        imageViewLp.topMargin = verticalMargin;
        break;
      case Gravity.BOTTOM:
        imageViewLp.bottomMargin = verticalMargin;
        break;
    }
    final int horizontalGravity = gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
    switch (horizontalGravity) {
      case Gravity.LEFT:
        imageViewLp.leftMargin = horizontalMargin;
        break;
      case Gravity.RIGHT:
        imageViewLp.rightMargin = horizontalMargin;
        break;
    }
    coverLayout.addView(imageView, imageViewLp);
    return imageView;
  }

  public abstract View setNoteContentView(FrameLayout parent);

  public void view() {
    switch (currentState) {
      case STATE_VIEW:
        break;
      case STATE_EDIT:
        showView();
        break;
    }
  }

  private void showView() {
    coverLayout.setVisibility(GONE);
    setCurrentState(STATE_VIEW);
  }

  public void edit() {
    switch (currentState) {
      case STATE_VIEW:
        showEdit();
        break;
      case STATE_EDIT:
        break;
    }
  }

  private void showEdit() {
    coverLayout.setVisibility(VISIBLE);
    setCurrentState(STATE_EDIT);
  }

  private void setCurrentState(int state) {
    checkState(state);
    currentState = state;
  }

  private void checkState(int state) {
    if (state == STATE_VIEW || state == STATE_EDIT) {
      return;
    }
    throw new IllegalArgumentException("!!! state " + state + " not defined");
  }

  private Listener listener;

  public void setListener(Listener listener) {
    this.listener = listener;
  }

  public interface Listener {
    void onInsertFront();

    void onInsertAfter();

    void onDelete();

    void onMove();
  }
}
