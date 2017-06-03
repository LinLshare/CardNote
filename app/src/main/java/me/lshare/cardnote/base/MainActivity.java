package me.lshare.cardnote.base;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private UiManager uiManager;

  public void start() {
    uiManager = new UiManager(this);
    setContentView(uiManager.getContentView());
  }
}
