package com.brymanco.test;

import com.brymanco.matrixrotator.IMatrixRotator;
import com.brymanco.matrixrotator.MatrixRotator;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;

public class RotatorTests {

    @Test
    public void displayRotatedImage() throws IOException, InterruptedException {
        JPanel panel = new JPanel();

        URL resource = this.getClass().getResource("/image.jpg");

        BufferedImage image = ImageIO.read(resource);

        int[][] pixels = convertTo2D(image);

        IMatrixRotator rotator = new MatrixRotator();

        rotator.rotate90(pixels);

        int[] rgbArray = flatten(pixels);

        image.setRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());

        JLabel label = new JLabel(new ImageIcon(image));

        panel.add(label);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("FRAME");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
        Thread.sleep(5000);

    }

    private static int[] flatten(int[][] pixels) {
        int[] ret = new int[pixels.length * pixels[0].length];
        int pos = 0;

        for (int col = 0; col < pixels.length; col++) {
            for (int row = 0; row < pixels[0].length; row++) {
                int pixel = pixels[col][row];
                ret[pos++] = pixel;
            }
        }
        return ret;
    }

    private static int[][] convertTo2D(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];

        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

}
