package me.lshare.cardnote.ui.layer;

import android.content.Context;

import me.lshare.cardnote.base.MessageListener;
import me.lshare.cardnote.base.UiLayer;
import me.lshare.cardnote.base.UiManager;
import me.lshare.cardnote.ui.page.AddNotePageView;
import me.lshare.cardnote.ui.page.HomePageView;

/**
 * @author Lshare
 * @date 2017/6/4
 */
public class NativeLayer extends UiLayer {

  private HomePageView homePageView;
  private AddNotePageView addNotePageView;

  public NativeLayer(Context context, UiManager parent) {
    super(context, parent);
    showHomePage();
  }

  @Override
  public void onMessage(int msgType, Object extra) {
    switch (msgType) {
      case MessageListener.MSG_NATIVE_ADD_NOTE:
        showAddNotePage();
        break;
      case MessageListener.MSG_NATIVE_SHOW_HOME:
        showHomePage();
        break;
      case MessageListener.MSG_NATIVE_BACK:
        showHomePage();
        break;
    }
    super.onMessage(msgType, extra);
  }

  @Override
  public void onCommand(int cmdType, Object extra) {
    switch (cmdType) {
      case CMD_UPPER_SHOW_HOME:
        showHomePage();
        break;
    }
  }

  private void showHomePage() {
    removeCurrentPage();
    if (homePageView == null) {
      homePageView = new HomePageView(context, this);
    }
    addPage(homePageView);
  }

  private void showAddNotePage() {
    removeCurrentPage();
    if (addNotePageView == null) {
      addNotePageView = new AddNotePageView(context, this);
    }
    addPage(addNotePageView);
  }
}
