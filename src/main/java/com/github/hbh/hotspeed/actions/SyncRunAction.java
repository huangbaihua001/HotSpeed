package com.github.hbh.hotspeed.actions;

import com.github.hbh.hotspeed.icons.HotSpeedPluginIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class SyncRunAction extends AnAction {

  public SyncRunAction() {
    super("Sync", "Sync changed code", HotSpeedPluginIcons.PLAY_ICON);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    Project project = e.getProject();
    if (project == null) {
      return;
    }
    //TODO sync changed code.
  }
}
