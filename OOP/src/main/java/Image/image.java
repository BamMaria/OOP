package Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;





    public class image extends JFrame {
        private JPanel outputImagePanel;
        public image() {
            outputImagePanel = new JPanel() {
                public void paintComponent(Graphics g) {
                    try {
                        BufferedImage bi = ImageIO.read( new File("D:\\Pict.bmp") );
                        BufferedImage bufferedImage =
                                new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_BYTE_INDEXED );
                        g.drawImage( bi, 0, 0, outputImagePanel );
                        byte[] dd = ( (DataBufferByte) bufferedImage.getRaster().getDataBuffer() ).getData();

                        for(int i=0; i < bi.getWidth(); i++) {
                            for(int j=0; j < bi.getHeight(); j++) {
                                WritableRaster raster = bi.getRaster();
                                ColorModel model = bi.getColorModel();
                                Object data = raster.getDataElements(i, j, null);
                                int argb = model.getRGB(data);
                                Color color = new Color(argb, true);

                                int k = filterRGB(argb);
                                double[] pixels = new double[3];
                                for(int t=0; t < pixels.length; t++)
                                    pixels[t] = k;

                                raster.setPixels(i, j, 1, 1, pixels);
                            }
                        }
                        g.drawImage( bi, 0, 0, outputImagePanel );
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            add(outputImagePanel, BorderLayout.CENTER);
        }
        public int filterRGB(int argb) {
            int r = (argb >> 16) & 0xff ;
            int g = (argb >> 8) & 0xff;
            int b = argb & 0xff;;
            int k = (int) (0.56*g + 0.33*r + 0.11*b);
            return (0xff000000) | k << 16 | k << 8 | k;
        }
        public static void main(String[] args) {
            image test = new image();
            test.setSize(640, 640);
            test.setLocationRelativeTo(null);
            test.setDefaultCloseOperation(test.EXIT_ON_CLOSE);
            test.setVisible(true);
        }
    }




