package me.lshare.cardnote.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import me.lshare.cardnote.R;
import me.lshare.common.ui.DimensionUtils;

/**
 * One and only one TitleBar in APP with several states.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class TitleBar extends FrameLayout {

  public static final int STATE_HOME = 0;
  public static final int STATE_EDIT = 1;
  public static final int STATE_VIEW = 2;
  private int currentState = STATE_HOME;
  private Context context;
  private TextView titleTextView;
  private ImageView backImageView;
  private ImageView rightShareImageView;
  private ImageView rightDoneImageView;
  private EditText titleEditView;

  public TitleBar(@NonNull Context context) {
    super(context);
    this.context = context;
    init();
  }

  private void init() {
    String title = context.getResources().getString(R.string.app_name);
    showCenterTitle(title);
  }

  public void home(String title) {
    switch (currentState) {
      case STATE_EDIT:
      case STATE_VIEW:
        showHome(title);
        break;
      case STATE_HOME:
        break;
    }
  }

  private void showHome(String title) {
    showCenterTitle(title);
    setCurrentState(STATE_HOME);
  }

  public void edit(String title) {
    switch (currentState) {
      case STATE_HOME:
      case STATE_VIEW:
        showEdit(title);
        break;
      case STATE_EDIT:
        break;
    }
  }

  private void showEdit(String title) {
    showBackImageView();
    showCenterEditTitle(title);
    showRightDoneImageView();
    setCurrentState(STATE_EDIT);
  }

  public void view(String title) {
    switch (currentState) {
      case STATE_HOME:
      case STATE_EDIT:
        showView(title);
        break;
      case STATE_VIEW:
        break;
    }
  }

  private void showView(String title) {
    showBackImageView();
    showCenterTitle(title);
    showRightShareImageView();
    setCurrentState(STATE_VIEW);
  }

  private void setCurrentState(int state) {
    currentState = state;
  }

  private void showBackImageView() {
    if (backImageView != null) {
      return;
    }
    backImageView = new ImageView(context);
    backImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    backImageView.setImageResource(R.drawable.ic_arrow_back_black_24dp);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams backImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    backImageViewLp.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
    int margin = DimensionUtils.dp2px(context, 16);
    backImageViewLp.leftMargin = margin;
    addView(backImageView, backImageViewLp);
  }

  private void showCenterTitle(String title) {
    if (titleTextView != null) {
      titleTextView.setText(title);
      return;
    }
    titleTextView = new TextView(context);
    titleTextView.setText(title);
    int height = DimensionUtils.dp2px(context, 48);
    LayoutParams titleTextViewLp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height);
    titleTextViewLp.gravity = Gravity.CENTER;
    addView(titleTextView, titleTextViewLp);
  }

  private void showCenterEditTitle(String title) {
    if (titleEditView != null) {
      titleEditView.setText(title);
      return;
    }
    titleEditView = new EditText(context);
    titleEditView.setText(title);
    int height = DimensionUtils.dp2px(context, 48);
    LayoutParams titleTextViewLp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height);
    titleTextViewLp.gravity = Gravity.CENTER;
    addView(titleEditView, titleTextViewLp);
  }

  private void showRightShareImageView() {
    if (rightShareImageView != null) {
      return;
    }
    rightShareImageView = new ImageView(context);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams rightShareImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    rightShareImageViewLp.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
    int margin = DimensionUtils.dp2px(context, 16);
    rightShareImageViewLp.rightMargin = margin;
    addView(rightShareImageView, rightShareImageViewLp);
  }

  private void showRightDoneImageView() {
    if (rightDoneImageView != null) {
      return;
    }
    rightDoneImageView = new ImageView(context);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams rightDoneImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    rightDoneImageViewLp.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
    int margin = DimensionUtils.dp2px(context, 16);
    rightDoneImageViewLp.rightMargin = margin;
    addView(rightDoneImageView, rightDoneImageViewLp);
  }
}
