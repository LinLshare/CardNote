package me.lshare.common.ui;

import android.content.Context;

/**
 * a tool set for ui dimension.
 *
 * @author Lshare
 * @date 2017/6/4
 */
public class DimensionUtils {
  public static int dp2px(Context context, int dp) {
    return (int) (context.getResources().getDisplayMetrics().density * dp);
  }
}
