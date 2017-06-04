package me.lshare.cardnote.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import me.lshare.cardnote.ui.AddNotePageView;
import me.lshare.cardnote.ui.HomePageView;

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
    addPageToNativeLayer(new AddNotePageView(this));
  }

  private void addPageToNativeLayer(PageView pageView) {
    uiManager.nativeLayer().addPage(pageView);
  }
}
