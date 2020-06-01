import Login.LoginUI;

import javax.swing.*;

class Main {
   public static void main(String[] args) {
      LoginUI loginUI = new LoginUI();

      loginUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      loginUI.pack();
      loginUI.setVisible(true);
   }
}
