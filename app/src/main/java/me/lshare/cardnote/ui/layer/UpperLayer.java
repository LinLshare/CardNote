package me.lshare.cardnote.ui.layer;

import android.content.Context;

import me.lshare.cardnote.R;
import me.lshare.cardnote.base.CommandListener;
import me.lshare.cardnote.base.MessageListener;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.base.UiManager;
import me.lshare.cardnote.ui.page.TitleBarPageView;
import me.lshare.common.ui.StringUtils;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class UpperLayer extends UiLayer {

  private TitleBarPageView titleBarPageView;

  public UpperLayer(Context context, UiManager parent) {
    super(context, parent);
    showTitleBarPage();
  }

  private void showTitleBarPage() {
    if (titleBarPageView == null) {
      titleBarPageView = new TitleBarPageView(context, this);
      addPage(titleBarPageView);
    }
  }

  @Override
  public void onMessage(int msgType, Object extra) {
    switch (msgType) {
      case MessageListener.MSG_NATIVE_EDIT_DONE:
        titleBarPageView.view((String) extra);
        break;
      case MessageListener.MSG_NATIVE_BACK:
        titleBarPageView.home(StringUtils.getString(context, R.string.app_name));
        break;
    }
    super.onMessage(msgType, extra);
  }

  @Override
  public void onCommand(int cmdType, Object extra) {
    switch (cmdType) {
      case CommandListener.CMD_UPPER_SHOW_EDIT:
        titleBarPageView.edit("输入标题", true);
        break;
      case CommandListener.CMD_UPPER_SHOW_VIEW:
        titleBarPageView.view((String) extra);
        break;
      case CommandListener.CMD_UPPER_SHOW_HOME:
        titleBarPageView.home((String) extra);
        break;
    }
  }
}
