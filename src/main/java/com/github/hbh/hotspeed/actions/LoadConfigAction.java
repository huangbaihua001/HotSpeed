package com.github.hbh.hotspeed.actions;

import com.github.hbh.hotspeed.icons.HotSpeedPluginIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class LoadConfigAction extends AnAction {

  public LoadConfigAction() {
    super("Plugin Preference", "HotSpeed plugin preferences page", HotSpeedPluginIcons.SETTING_ICON);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    Project project = e.getProject();
    if (project == null) {
      return;
    }
    //TODO show setting editor
  }
}
