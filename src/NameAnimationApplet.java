import java.applet.Applet;
import java.awt.*;

public class NameAnimationApplet extends Applet implements Runnable {
    private String name = "Surbhi Kudiwal";
    private int x = 0;
    private int y = 100;
    private boolean running = true;

    @Override
    public void init() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(name, x, y);
    }

    @Override
    public void run() {
        while (running) {
            x += 5;  // to move the name horizontally
            if (x > getWidth()) {  // Reset position if it moves out of bounds
                x = -100;
            }
            repaint();  // Request the applet to repaint itself
            try {
                Thread.sleep(100);  // Pause for a short time to create animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        running = false;
    }
}
