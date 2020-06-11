import Utils.UIUtils;
import View.MainUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UI extends JFrame {
   String[] optionsString = {"Sinh viên", "Thời khóa biểu", "Danh sách lớp", "Bảng điểm", "Lịch phúc khảo", "Danh sách phúc khảo", "Tài khoản"};
   List<JButton> option;
   private JPanel optionPanel;
   private JPanel cardLayout;

   public UI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      initUI();
      setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
      pack();
   }
   private void initUI() {
      MainUI mainUI=new MainUI();
     getContentPane().add(mainUI.$$$getRootComponent$$$());
   }
   private void addComponentsToPane(Container pane) {
      pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      optionPanel = addButtonOption();
      cardLayout = new JPanel();
      cardLayout.setSize(new Dimension(400, 600));
      pane.add(optionPanel, BorderLayout.WEST);
      pane.add(cardLayout);
   }

   private JPanel addButtonOption() {
      JPanel sidePanel = new JPanel(new GridLayout(0, 1));
      option = new ArrayList<>();
      for (String str : optionsString) {
         JButton button = new JButton(str);
         button.setBackground(UIUtils.COLOR_OUTLINE);
         option.add(button);
         sidePanel.add(button);
      }
      return sidePanel;
   }

}
