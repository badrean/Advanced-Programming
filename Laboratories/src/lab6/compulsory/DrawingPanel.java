package lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO...
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        g.drawOval(W/4,100,20,20);
        g.fillOval(W/4,100,20,20);
        g.drawOval(W/4 - 100,H/2,20,20);
        g.fillOval(W/4 - 100,H/2,20,20);
        g.drawOval(W/4,H - 100,20,20);
        g.fillOval(W/4,H - 100,20,20);
        g.drawOval(W - W/4,100,20,20);
        g.fillOval(W - W/4,100,20,20);
        g.drawOval(W - (W/4 - 100),H/2,20,20);
        g.fillOval(W - (W/4 - 100),H/2,20,20);
        g.drawOval(W - W/4,H - 100,20,20);
        g.fillOval(W - W/4,H - 100,20,20);

        g.drawLine(75,75,225,175);
    }

    final void createBoard() {

    }
}

