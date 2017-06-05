package me.lshare.cardnote.ui.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import me.lshare.cardnote.R;
import me.lshare.common.ui.DimensionUtils;

/**
 * a bar for input msg conveniently.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class InputBar extends LinearLayout {
  private Context context;

  public InputBar(Context context) {
    super(context);
    this.context = context;
    init();
  }

  private void init() {
    setOrientation(HORIZONTAL);
    // image
    addImage(R.drawable.ic_add_photo_white_24dp);
    // map
    addImage(R.drawable.ic_add_location_white_24dp);
    // headline
    addImage(R.drawable.ic_title_white_24dp);
    // text field
    addImage(R.drawable.ic_text_fields_white_24dp);
  }

  private void addImage(@DrawableRes int drawableRes) {
    ImageView imageView = new ImageView(context);
    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    imageView.setImageResource(drawableRes);
    int widthAndHeight = DimensionUtils.dp2px(context, 48);
    LinearLayout.LayoutParams imageViewLp =
        new LinearLayout.LayoutParams(widthAndHeight, widthAndHeight);
    imageViewLp.gravity = Gravity.CENTER_VERTICAL;
    imageViewLp.weight = 1;
    addView(imageView, imageViewLp);
  }
}
