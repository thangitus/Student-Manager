package Login;

import Utils.TextFieldPassword;
import Utils.TextFieldUsername;
import Utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {
   JPanel mainJPanel;
   TextFieldUsername usernameField;
   TextFieldPassword passwordField;
   public LoginUI() throws HeadlessException {
      mainJPanel = getMainJPanel();
      addImg();
      addSeparator();
      addUsernameTextField();
      addPasswordTextField();
      addLoginButton();
      add(mainJPanel);

      this.add(mainJPanel);
      this.pack();
      this.setVisible(true);
      this.toFront();

      Dimension screenSize = Toolkit.getDefaultToolkit()
                                    .getScreenSize();
      setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
   }

   private JPanel getMainJPanel() {
      Dimension size = new Dimension(800, 400);
      JPanel jPanel = new JPanel();
      jPanel.setSize(size);
      jPanel.setPreferredSize(size);
      jPanel.setBackground(UIUtils.COLOR_BACKGROUND);
      jPanel.setLayout(null);
      return jPanel;
   }

   private void addImg() {
      JLabel jLabel = new JLabel();
      jLabel.setFocusable(true);
      ImageIcon icon = new ImageIcon("res/Asset.png");
      jLabel.setIcon(icon);
      jLabel.setBounds(55, 100, 209, 173);
      mainJPanel.add(jLabel);
   }

   private void addSeparator() {
      JSeparator separator1 = new JSeparator();
      separator1.setOrientation(SwingConstants.VERTICAL);
      separator1.setForeground(UIUtils.COLOR_OUTLINE);
      mainJPanel.add(separator1);
      separator1.setBounds(310, 80, 2, 240);
   }
   private void addUsernameTextField() {
      usernameField = new TextFieldUsername();

      usernameField.setBounds(423, 109, 250, 44);
      usernameField.addFocusListener(new FocusListener() {
         @Override
         public void focusGained(FocusEvent e) {
            onFocusChangeUserName("", UIUtils.COLOR_INTERACTIVE);
         }

         @Override
         public void focusLost(FocusEvent e) {
            onFocusChangeUserName(UIUtils.PLACEHOLDER_TEXT_USERNAME, UIUtils.COLOR_OUTLINE);
         }
      });

      mainJPanel.add(usernameField);
   }
   private void onFocusChangeUserName(String placeholderTextUsername, Color colorOutline) {
      usernameField.setText(placeholderTextUsername);
      usernameField.setBorderColor(colorOutline);
   }
   private void addPasswordTextField() {
      passwordField = new TextFieldPassword();

      passwordField.setBounds(423, 168, 250, 44);
      passwordField.addFocusListener(new FocusListener() {
         @Override
         public void focusGained(FocusEvent e) {
            passwordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            onFocusChangeUserName(UIUtils.PLACEHOLDER_TEXT_USERNAME, UIUtils.COLOR_OUTLINE);
         }

         @Override
         public void focusLost(FocusEvent e) {
            passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
         }
      });

      passwordField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
            //            if (e.getKeyChar() == KeyEvent.VK_ENTER)
            //               loginEventHandler();
         }
      });

      mainJPanel.add(passwordField);
   }
   private void addLoginButton() {
      final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

      JLabel loginButton = new JLabel() {
         @Override
         protected void paintComponent(Graphics g) {
            Graphics2D g2 = UIUtils.get2dGraphics(g);
            super.paintComponent(g2);

            Insets insets = getInsets();
            int w = getWidth() - insets.left - insets.right;
            int h = getHeight() - insets.top - insets.bottom;
            g2.setColor(loginButtonColors[0]);
            g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

            FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
            int x2 = (getWidth() - metrics.stringWidth("Login")) / 2;
            int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
            g2.setFont(UIUtils.FONT_GENERAL_UI);
            g2.setColor(loginButtonColors[1]);
            g2.drawString("Login", x2, y2);
         }
      };

      loginButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {

         }

         @Override
         public void mouseEntered(MouseEvent e) {
            loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
            loginButtonColors[1] = UIUtils.OFFWHITE;
            loginButton.repaint();
         }

         @Override
         public void mouseExited(MouseEvent e) {
            loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
            loginButtonColors[1] = Color.white;
            loginButton.repaint();
         }
      });

      loginButton.setBounds(423, 247, 250, 44);
      loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      mainJPanel.add(loginButton);
   }

}
