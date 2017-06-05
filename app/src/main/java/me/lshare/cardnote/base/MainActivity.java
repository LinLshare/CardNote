package me.lshare.cardnote.base;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
    implements MessageListener, CommandListener {

  private UiManager uiManager;
  private AppController parent;

  public void start() {
    uiManager = new UiManager(this);
    setContentView(uiManager.getContentView());
    parent = App.instance().appController();
  }


  @Override
  public void onMessage(int msgType, Object extra) {
    parent.onMessage(msgType, extra);
  }

  @Override
  public void onCommand(int cmdType, Object extra) {
    uiManager.onCommand(cmdType, extra);
  }
}
