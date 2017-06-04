package me.lshare.cardnote.base;

import android.support.v7.app.AppCompatActivity;

import me.lshare.cardnote.ui.page.AddNotePageView;
import me.lshare.cardnote.ui.page.HomePageView;

public class MainActivity extends AppCompatActivity {

  private UiManager uiManager;

  public void start() {
    uiManager = new UiManager(this, App.instance().appController());
    setContentView(uiManager.getContentView());
  }

  public void showHome() {
    addPageToNativeLayer(new HomePageView(this));
  }

  public void showAddNote() {
    uiManager.upperLayer().titleBarPageView().edit("输入标题", true);
    addPageToNativeLayer(new AddNotePageView(this));
  }

  private void addPageToNativeLayer(PageView pageView) {
    uiManager.nativeLayer().addPage(pageView);
  }
}
