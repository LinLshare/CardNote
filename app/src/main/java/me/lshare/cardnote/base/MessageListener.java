package me.lshare.cardnote.base;

/**
 * child node post msg to parent
 */
public interface MessageListener {

  int MSG_SHARE = 201;
  int MSG_NATIVE_ADD_NOTE = 300;
  int MSG_NATIVE_EDIT_DONE = 301;
  int MSG_NATIVE_SHOW_HOME = 302;
  int MSG_NATIVE_BACK = 303;

  void onMessage(int msgType, Object extra);
}
