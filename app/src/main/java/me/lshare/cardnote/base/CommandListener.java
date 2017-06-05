package me.lshare.cardnote.base;

/**
 * parent node post command to child.
 */
public interface CommandListener {

  int CMD_UPPER_SHOW_HOME = 1001;
  int CMD_UPPER_SHOW_EDIT = 1002;
  int CMD_UPPER_SHOW_VIEW = 1003;

  void onCommand(int cmdType, Object extra);
}
