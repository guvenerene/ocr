
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This RfidListener implements an interface between the python write and java.
 * @author Sacredgamer
 */
public class RfidListener {

    private long id;
    private final StringBuilder content;

    private Scanner scanner;
    private boolean tryAgain;

    public RfidListener() {
        content = new StringBuilder();
        id = 0;
        tryAgain = true;
    }

    /**
     * Start RFID reader and wait till tag is in range.
     * 
     * @throws IOException 
     * If the Interface read file was not found or is not python.
     */
    public synchronized void read() throws IOException {

        while (tryAgain) {
            Interface.clear();
            tryAgain = false;

            Process p = Runtime.getRuntime().exec("python3 " + Interface.getReadPath());
            scanner = new Scanner(new BufferedReader(new InputStreamReader(p.getInputStream())));

            System.out.println("python3 " + Interface.getReadPath());

            handleScanner();

            scanner.close();
            p.destroy();
        }

    }

    public long getId(){
        return id;
    }

    private void handleScanner() {
        while (scanner.hasNext() && !tryAgain) {
            if (errorFeedBack()) {
                cancel();
            } else {
                contentRead();
            }
        }
    }

    private boolean errorFeedBack() {
        if (scanner.hasNext(".*Error.*") || scanner.hasNext(".*AUTH.*")) {

            return true;
        }
        return false;
    }

    private void cancel() {
        content.setLength(0);
        id = 0;
        tryAgain = true;
    }

    private void contentRead() {
        if (id == 0) {
            id = Long.parseLong(scanner.next());
        } else {
            content.append(scanner.next());
        }
    }

}
