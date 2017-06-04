package me.lshare.cardnote.base;


public interface EventCallback {

  int EVENT_ADD_NOTE_CLICK = 101;

  int EVENT_SHARE = 201;
  int EVENT_EDIT_DONE = 202;
  int EVENT_SHOW_HOME = 203;

  void onEvent(int eventType, Object extra);
}