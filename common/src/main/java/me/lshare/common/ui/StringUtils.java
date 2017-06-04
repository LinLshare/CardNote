package me.lshare.common.ui;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class StringUtils {
  public static String getString(Context context, @StringRes int stringRes) {
    return context.getResources().getString(stringRes);
  }

  public static String getString(Context context, @StringRes int stringRes, Object... formatArgs) {
    return context.getResources().getString(stringRes, formatArgs);
  }
}
