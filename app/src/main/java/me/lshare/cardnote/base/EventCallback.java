package me.lshare.cardnote.base;


public interface EventCallback {

  void onEvent(int eventType, Object extra);
}