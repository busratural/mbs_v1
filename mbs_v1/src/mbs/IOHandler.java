//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.io.IOException;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialFactory;

public class IOHandler {
    GpioController gpio;
    Serial serial;
    GpioPinDigitalInput kapiButonu;
    GpioPinDigitalInput takometre;

    public IOHandler() {
    }

    public void Initialize() {
        this.gpio = GpioFactory.getInstance();
        this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
        this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
        Serial serial = SerialFactory.createInstance();
        this.kapiButonu.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> KAPI BUTONU: " + event.getPin() + " = " + event.getState());
            }
        }});
        this.takometre.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> TAKOMETRE: " + event.getPin() + " = " + event.getState());
            }
        }});
   
    }

    public void WriteTOSP(String data) {
        try {
            if (this.serial.isOpen()) {
                this.serial.write(data);
            } else {
                System.out.println("Seri port kapalý olduðu için yazma iþlemi gerçekleþtirilemedi!");
            }
        } catch (IllegalStateException var3) {
            var3.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
