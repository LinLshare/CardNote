package me.lshare.cardnote.ui.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.lshare.cardnote.R;
import me.lshare.common.ui.ColorUtils;
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
    int padding = DimensionUtils.dp2px(context, 8);
    setPadding(0, padding, 0, padding);
    setBackgroundColor(ColorUtils.getColor(context, R.color.bgColorGray));
    // image
    addImage(R.drawable.ic_add_photo_white_24dp, R.string.image);
    // map
    addImage(R.drawable.ic_add_location_white_24dp, R.string.map);
    // headline
    addImage(R.drawable.ic_title_white_24dp, R.string.headline);
    // text field
    addImage(R.drawable.ic_text_fields_white_24dp, R.string.text_field);
  }

  private void addImage(@DrawableRes int drawableRes, @StringRes int stringRes) {

    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(VERTICAL);
    linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
    LinearLayout.LayoutParams linearLayoutLp =
        new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                      ViewGroup.LayoutParams.WRAP_CONTENT);
    linearLayoutLp.weight = 1;

    ImageView imageView = new ImageView(context);
    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    imageView.setImageResource(drawableRes);
    int widthAndHeight = DimensionUtils.dp2px(context, 24);
    LinearLayout.LayoutParams imageViewLp =
        new LinearLayout.LayoutParams(widthAndHeight, widthAndHeight);
    imageViewLp.gravity = Gravity.CENTER_HORIZONTAL;
    linearLayout.addView(imageView, imageViewLp);

    TextView textView = new TextView(context);
    textView.setText(stringRes);
    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
    LinearLayout.LayoutParams textViewLp =
        new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    textViewLp.gravity = Gravity.CENTER_HORIZONTAL;
    linearLayout.addView(textView, textViewLp);

    addView(linearLayout, linearLayoutLp);
  }
}
