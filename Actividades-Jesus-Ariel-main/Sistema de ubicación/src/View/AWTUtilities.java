/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Component;
import java.awt.geom.RoundRectangle2D;

public class AWTUtilities {

    public static void setWindowShape(Component component, RoundRectangle2D.Double shape) {
        if (shape != null) {
            ((java.awt.Window) component).setShape(shape);
        }
    }
}
