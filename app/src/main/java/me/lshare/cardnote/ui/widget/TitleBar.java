package me.lshare.cardnote.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import me.lshare.cardnote.R;
import me.lshare.common.ui.ColorUtils;
import me.lshare.common.ui.DimensionUtils;
import me.lshare.common.ui.StringUtils;

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
    setBackgroundColor(ColorUtils.getColor(context, R.color.colorPrimary));
    showCenterTitle(StringUtils.getString(context, R.string.app_name));
  }

  public String getTitle() {
    String title = "";
    switch (currentState) {
      case STATE_EDIT:
        title = titleEditView.getText().toString();
        break;
      case STATE_HOME:
      case STATE_VIEW:
        title = titleTextView.getText().toString();
        break;
    }
    return title;
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

    if (backImageView != null) {
      backImageView.setVisibility(GONE);
    }
    if (titleEditView != null) {
      titleEditView.setVisibility(GONE);
    }
    if (rightDoneImageView != null) {
      rightDoneImageView.setVisibility(GONE);
    }
    if (rightShareImageView != null) {
      rightShareImageView.setVisibility(GONE);
    }

    setCurrentState(STATE_HOME);
  }

  public void edit(String title, boolean isHint) {
    switch (currentState) {
      case STATE_HOME:
      case STATE_VIEW:
        showEdit(title, isHint);
        break;
      case STATE_EDIT:
        break;
    }
  }

  private void showEdit(String title, boolean isHint) {
    showBackImageView();
    showCenterEditTitle(title, isHint);
    showRightDoneImageView();

    if (titleTextView != null) {
      titleTextView.setVisibility(GONE);
    }
    if (rightShareImageView != null) {
      rightShareImageView.setVisibility(GONE);
    }

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

    if (titleEditView != null) {
      titleEditView.setVisibility(GONE);
    }
    if (rightDoneImageView != null) {
      rightDoneImageView.setVisibility(GONE);
    }

    setCurrentState(STATE_VIEW);
  }

  private void setCurrentState(int state) {
    currentState = state;
  }

  private void showBackImageView() {
    if (backImageView != null) {
      backImageView.setVisibility(VISIBLE);
      return;
    }
    backImageView = new ImageView(context);
    backImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    backImageView.setImageResource(R.drawable.ic_arrow_white_black_24dp);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams backImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    backImageViewLp.gravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
    addView(backImageView, backImageViewLp);

    backImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (listener == null) {
          throw new IllegalStateException("!!! should set listener first");
        }
        listener.onLeftBackImageClick();
      }
    });
  }

  private void showCenterTitle(String title) {
    if (titleTextView != null) {
      titleTextView.setVisibility(VISIBLE);
      titleTextView.setText(title);
      return;
    }
    titleTextView = new TextView(context);
    titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    titleTextView.setTextColor(ColorUtils.getColor(context, R.color.textColorWhite));
    titleTextView.setText(title);
    LayoutParams titleTextViewLp =
        new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    titleTextViewLp.gravity = Gravity.CENTER;
    addView(titleTextView, titleTextViewLp);
  }

  private void showCenterEditTitle(String title, boolean isHint) {
    if (titleEditView != null) {
      titleEditView.setVisibility(VISIBLE);
      if (isHint) {
        titleEditView.setHint(title);
      } else {
        titleEditView.setText(title);
      }
      return;
    }
    titleEditView = new EditText(context);
    titleEditView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    titleEditView.setGravity(Gravity.CENTER);
    titleEditView.setTextColor(ColorUtils.getColor(context, R.color.textColorWhite));
    titleEditView.setWidth(DimensionUtils.dp2px(context, 160));
    if (isHint) {
      titleEditView.setHint(title);
    } else {
      titleEditView.setText(title);
    }
    LayoutParams titleTextViewLp =
        new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    titleTextViewLp.gravity = Gravity.CENTER;
    addView(titleEditView, titleTextViewLp);
  }

  private void showRightShareImageView() {
    if (rightShareImageView != null) {
      rightShareImageView.setVisibility(VISIBLE);
      return;
    }
    rightShareImageView = new ImageView(context);
    rightShareImageView.setImageResource(R.drawable.ic_share_white_24dp);
    rightShareImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams rightShareImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    rightShareImageViewLp.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
    addView(rightShareImageView, rightShareImageViewLp);

    rightShareImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (listener == null) {
          throw new IllegalStateException("!!! should set listener first");
        }
        listener.onRightShareImageViewClick();
      }
    });
  }

  private void showRightDoneImageView() {
    if (rightDoneImageView != null) {
      rightDoneImageView.setVisibility(VISIBLE);
      return;
    }
    rightDoneImageView = new ImageView(context);
    rightDoneImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    rightDoneImageView.setImageResource(R.drawable.ic_check_white_24dp);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LayoutParams rightDoneImageViewLp = new LayoutParams(widthAndHeight, widthAndHeight);
    rightDoneImageViewLp.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
    addView(rightDoneImageView, rightDoneImageViewLp);

    rightDoneImageView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (listener == null) {
          throw new IllegalStateException("!!! should set listener first");
        }
        listener.onRightDoneImageViewClick();
      }
    });
  }

  private Listener listener;

  public void setListener(Listener listener) {
    this.listener = listener;
  }

  public interface Listener {
    void onRightDoneImageViewClick();

    void onRightShareImageViewClick();

    void onLeftBackImageClick();
  }
}
