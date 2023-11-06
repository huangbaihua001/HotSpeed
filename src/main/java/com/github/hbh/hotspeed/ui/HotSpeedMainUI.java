package com.github.hbh.hotspeed.ui;

import com.github.hbh.hotspeed.actions.LoadConfigAction;
import com.github.hbh.hotspeed.actions.SyncRunAction;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;


public class HotSpeedMainUI {

  private JPanel mainPanel;

  public HotSpeedMainUI() {
    initUI();
  }

  private void initUI() {
    DefaultActionGroup actionGroup = new DefaultActionGroup("HotSpeedActionGroup", false);
    actionGroup.add(new SyncRunAction());
    actionGroup.add(new LoadConfigAction());

    ActionManager actionManager = ActionManager.getInstance();

    ActionToolbar actionToolbar = actionManager.createActionToolbar(
      "HotSpeedToolbar",
      actionGroup,
      false
    );

    mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(actionToolbar.getComponent(), BorderLayout.WEST);

    JTextPane center = new JTextPane();
    mainPanel.add(new JScrollPane(center), BorderLayout.CENTER);
    mainPanel.repaint();

    actionToolbar.setTargetComponent(center);
  }

  public JPanel getMainPanel() {
    return mainPanel;
  }
}
