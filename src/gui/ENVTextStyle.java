package gui;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class ENVTextStyle extends SimpleAttributeSet {

    public ENVTextStyle(int textSize) {
        StyleConstants.setBackground(this, Color.decode("#36383c"));
        StyleConstants.setForeground(this, Color.decode("#F5F5F5"));
        StyleConstants.setFontFamily(this, "Calibri");
        StyleConstants.setFontSize(this, textSize);
        StyleConstants.setAlignment(this, StyleConstants.ALIGN_CENTER);

    }

}
