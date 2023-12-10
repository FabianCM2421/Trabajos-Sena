
import java.awt.FontMetrics;
import javax.swing.JProgressBar;

public class SwingUtilities2 {

    public static int stringWidth(JProgressBar progressBar, FontMetrics fontSizer, String progString) {
        return fontSizer.stringWidth(progString);
    }
}
