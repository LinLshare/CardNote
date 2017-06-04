package me.lshare.common.ui;

import android.content.Context;
import android.support.annotation.ColorRes;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class ColorUtils {
  public static int getColor(Context context, @ColorRes int colorRes) {
    return context.getResources().getColor(colorRes);
  }
}
