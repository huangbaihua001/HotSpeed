package com.github.hbh.hotspeed;

import com.github.hbh.hotspeed.ui.HotSpeedMainUI;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

public class HotSpeedToolWindowsFactory implements ToolWindowFactory {

  @Override
  public void createToolWindowContent(
    @NotNull Project project,
    @NotNull ToolWindow toolWindow
  ) {
    addInitContent(project, toolWindow);
  }

  private void addInitContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    HotSpeedMainUI mainUI = new HotSpeedMainUI();
    ContentManager contentManager = toolWindow.getContentManager();
    Content initContent = contentManager
      .getFactory()
      .createContent(mainUI.getMainPanel(), "Log", false);
    initContent.setCloseable(false);
    contentManager.addContent(initContent);
  }
}
