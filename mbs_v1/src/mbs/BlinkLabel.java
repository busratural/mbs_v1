//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BlinkLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    private static final int BLINKING_RATE = 800;
    private boolean blinkingOn = true;

    public BlinkLabel(String text) {
        super(text);
        Timer timer = new Timer(800, new BlinkLabel.TimerListener(this));
        timer.setInitialDelay(0);
        timer.start();
    }

    public void setBlinking(boolean flag) {
        this.blinkingOn = flag;
    }

    public boolean getBlinking(boolean flag) {
        return this.blinkingOn;
    }

    private class TimerListener implements ActionListener {
        private BlinkLabel bl;
        private Color bg;
        private Color fg;
        private boolean isForeground = true;

        public TimerListener(BlinkLabel bl) {
            this.bl = bl;
            this.fg = Color.RED;
            this.bg = new Color(255, 255, 255);
        }

        public void actionPerformed(ActionEvent e) {
            if (this.bl.blinkingOn) {
                if (this.isForeground) {
                    this.bl.setForeground(this.fg);
                } else {
                    this.bl.setForeground(this.bg);
                }

                this.isForeground = !this.isForeground;
            } else if (this.isForeground) {
                this.bl.setForeground(this.fg);
                this.isForeground = false;
            }

        }
    }
}
