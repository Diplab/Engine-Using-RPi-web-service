package client;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class BeepSound {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			java.awt.Toolkit.getDefaultToolkit().beep();
			try {
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
