import java.awt.*;

public class Game extends Canvas implements Runnable{
    public static final int WIDTH = 609, HEIGHT = 452;

    private Thread thread;
    private boolean running = false;

    public Game(){
        Window win = new Window(WIDTH, HEIGHT,"NumberQuest", this);
        win.mainPage(WIDTH, HEIGHT, this);
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run() {

    }

    public static void main(String[] args) {
        new Game();
    }
}
