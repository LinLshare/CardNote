package me.lshare.cardnote.base;


public interface EventCallback {

  int EVENT_ADD_NOTE_CLICK = 101;

  void onEvent(int eventType, Object extra);
}