import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


/**
 * This class provides the mapping between the python files.
 *
 * @author Sacredgamer
 */
public class Interface {


    private static String[] procPaths;
    
    public static void init(String readPath) {
        procPaths = new String[]{readPath};
    }

    /**
     * Kills all runnig read and write processes.
     *
     * @throws IOException If the Interface read file was not found or is not
     * python.
     */
    public static void clear() throws IOException {
        for (String path : procPaths) {
            ProcessBuilder builder = new ProcessBuilder("bash", "-c", "pkill -f " + path + "\n");
            builder.directory(new File(path.substring(0, path.lastIndexOf("/"))));
            Process p = builder.start();

            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                
            }

        }
    }
    public static String getReadPath() {
        return procPaths[0];
    }


}
