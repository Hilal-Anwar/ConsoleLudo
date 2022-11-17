package org.game.ludo;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;


public final class ASCII {

    public String convert(final BufferedImage image) {

        var sb = new AttributedStringBuilder(100);
        int width= image.getWidth();
        int height=image.getHeight();
        for (int y = 0; y < height; y++) {
            if (sb.length() != 0) sb.append("\n");
            for (int x = 0; x < width; x++) {
                sb.style(AttributedStyle.DEFAULT.foregroundRgb(image.getRGB(x, y))).append("██");
                //x=x+4;
            }
            //y=y+9;
        }

        return sb.toAnsi();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "gif", "png"));
            while (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = fileChooser.getSelectedFile();
                    final BufferedImage image = ImageIO.read(f);
                    if (image == null) throw new IllegalArgumentException(f + " is not a valid image.");
                    final String ascii = new ASCII().convert(image);
                    System.out.println(ascii.indent(300));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            System.exit(0);
        });
    }

}