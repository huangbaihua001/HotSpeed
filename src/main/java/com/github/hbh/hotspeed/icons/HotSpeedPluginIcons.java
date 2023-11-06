package com.github.hbh.hotspeed.icons;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

public interface HotSpeedPluginIcons {

  Icon PLAY_ICON = icon("/icons/play.svg");

  Icon SETTING_ICON = icon("/icons/settings.svg");

  static Icon icon(String path) {return IconLoader.getIcon(path, HotSpeedPluginIcons.class);}
}
