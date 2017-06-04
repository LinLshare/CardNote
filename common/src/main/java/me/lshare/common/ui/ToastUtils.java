package me.lshare.common.ui;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class ToastUtils {

  private static Toast sToast;

  private static void show(Context context, @StringRes int resId) {
    show(context, Toast.LENGTH_SHORT, false, StringUtils.getString(context, resId));
  }

  private static void show(Context context, @StringRes int resId, Object... args) {
    show(context, Toast.LENGTH_SHORT, false, StringUtils.getString(context, resId, args));
  }

  public static void show(Context context, int duration, boolean cancelBefore, CharSequence text) {
    if (text == null || text.length() == 0) {
      return;
    }
    if (cancelBefore) {
      cancel();
    }
    if (sToast == null) {
      sToast = android.widget.Toast.makeText(context, text, duration);
    } else {
      sToast.setText(text);
      sToast.setDuration(duration);
    }
    sToast.show();
  }

  private static void cancel() {
    if (sToast != null) {
      sToast.cancel();
      sToast = null;
    }
  }
}
