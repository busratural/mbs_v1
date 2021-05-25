//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.swing.event.EventListenerList;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class MBSPlayer implements BasicPlayerListener {
    BasicPlayer player = new BasicPlayer();
    BasicController control;
    protected EventListenerList listenerList = new EventListenerList();

    public void addMyEventListener(MyEventListener listener) {
        this.listenerList.add(MyEventListener.class, listener);
    }

    public void removeMyEventListener(MyEventListener listener) {
        this.listenerList.remove(MyEventListener.class, listener);
    }

    void fireMyEvent(BasicPlayerEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == MyEventListener.class) {
                ((MyEventListener)listeners[i + 1]).myEventOccurred(evt);
            }
        }

    }

    public MBSPlayer() {
        this.control = this.player;
        this.player.addBasicPlayerListener(this);
    }

    public void Play(String filePath) {
        try {
            this.player.addBasicPlayerListener(this);

            try {
                this.control.open(new URL("file:///" + filePath));
                this.control.play();
                System.out.println("anons yapýldý");
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }
        } catch (BasicPlayerException var4) {
            var4.printStackTrace();
        }

    }

    public void Stop() {
        try {
            this.control.stop();
        } catch (BasicPlayerException var2) {
            var2.printStackTrace();
        }

    }

    public void opened(Object stream, Map properties) {
    }

    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
    }

    public void setController(BasicController controller) {
    }

    public void stateUpdated(BasicPlayerEvent event) {
        this.fireMyEvent(event);
    }
}
