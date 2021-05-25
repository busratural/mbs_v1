//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;

public class JGradientButton extends JButton {
    private static final long serialVersionUID = 1L;
    private Color c1;
    private Color c2;

    public JGradientButton() {
        super("Gradient Button");
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setForeground(Color.white);
    }

    public JGradientButton(String text) {
        super("Gradient Button");
        this.setText(text);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        Tema seciliTema = new Tema(Color.GRAY);
        this.setForeground(seciliTema.gradientButtonForeground);
        this.c1 = seciliTema.gradientButtonBackground1;
        this.c2 = seciliTema.gradientButtonBackground2;
    }

    public JGradientButton(String text, boolean isTextCentered, String command, boolean isFocusable, Font font, ActionListener listener) {
        super("Gradient Button");
        if (!isTextCentered) {
            this.setText(text);
        } else {
            this.setText("<html><center>" + text + "</center></html>");
        }

        this.setActionCommand(command);
        this.setFocusable(isFocusable);
        this.setFont(font);
        this.addActionListener(listener);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        Tema seciliTema = new Tema(Color.GRAY);
        this.setForeground(seciliTema.gradientButtonForeground);
        this.c1 = seciliTema.gradientButtonBackground1;
        this.c2 = seciliTema.gradientButtonBackground2;
    }

    public JGradientButton(String text, boolean isTextCentered, String command, boolean isFocusable, Font font, ActionListener listener, Icon icon, int x, int y, int w, int h) {
        super("Gradient Button");
        if (!isTextCentered) {
            this.setText(text);
        } else {
            this.setText("<html><center>" + text + "</center></html>");
        }

        this.setActionCommand(command);
        this.setFocusable(isFocusable);
        this.setFont(font);
        this.setBounds(x, y, w, h);
        this.setIcon(icon);
        this.addActionListener(listener);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        Tema seciliTema = new Tema(Color.GRAY);
        this.setForeground(seciliTema.gradientButtonForeground);
        this.c1 = seciliTema.gradientButtonBackground1;
        this.c2 = seciliTema.gradientButtonBackground2;
    }

    public void setColors(Color c1, Color c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void setForeColors(Color c1) {
        this.setForeground(c1);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(new GradientPaint(new Point(0, 0), this.c1, new Point(0, this.getHeight() / 2), this.c2));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight() / 2);
        g2.setPaint(new GradientPaint(new Point(0, this.getHeight() / 2), this.c2, new Point(0, this.getHeight()), this.c1));
        g2.fillRect(0, this.getHeight() / 2, this.getWidth(), this.getHeight());
        g2.dispose();
        super.paintComponent(g);
        super.paintComponent(g);
    }

    public static final JGradientButton newInstance() {
        return new JGradientButton();
    }
}
