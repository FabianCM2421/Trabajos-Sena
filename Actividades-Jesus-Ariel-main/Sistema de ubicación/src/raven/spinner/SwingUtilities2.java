/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.spinner;

import java.awt.FontMetrics;
import javax.swing.JProgressBar;

/**
 *
 * @author supap
 */
public class SwingUtilities2 {

    public static int stringWidth(JProgressBar progressBar, FontMetrics fontSizer, String progString) {
        return fontSizer.stringWidth(progString);
    }
}
