import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TextImageGenerator {

    public static void createImageWithText(String text, String fileName) {
        int width = 300;
        int height = 100;

        // Create a buffered image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the graphics object
        Graphics2D g2d = image.createGraphics();

        // Fill background with white color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Draw green border
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(0, 0, width - 1, height - 1);

        // Draw text
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));

        // Calculate text position to center it
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        int x = (width - textWidth) / 2;
        int y = (height + textHeight) / 2 - fm.getDescent();

        g2d.drawString(text, x, y);

        // Dispose graphics
        g2d.dispose();

        try {
            // Save as JPG file
            ImageIO.write(image, "jpg", new File(fileName));
            System.out.println("Image saved as " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        createImageWithText("tushar", "tushar_image.jpg");
    }
}
