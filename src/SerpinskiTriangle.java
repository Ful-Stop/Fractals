import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  Serpinski's Triangle, a recursive algorithm
 */

public class SerpinskiTriangle extends JPanel
{
    private int levels;

    public SerpinskiTriangle(int lev)
    {
        levels = lev;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;


        int [] xcoord = {xCenter - 128, xCenter, xCenter + 128};
        int [] ycoord = {yCenter, yCenter - 128, yCenter};

        g.setColor(Color.RED);
        drawAndSplit(g, xcoord, ycoord, levels);

    }

    public int [] midpoints(int [] x)
    {
        int [] m = new int [3];

        m[0] = (x[0] + x[1])/2;
        m[1] = (x[1] + x[2])/2;
        m[2] = (x[2] + x[0])/2;

        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {
        if (times == 1){
            g.drawPolygon(x, y, 3);
        }

        if (times > 1) {
            g.drawPolygon(x, y, 3);

            int [] midX = midpoints(x);
            int [] midY = midpoints(y);

            drawAndSplit(g, new int[] {midX[0], midX[2], x[0]}, new int[] {midY[0], midY[2], y[0]}, times - 1);
            drawAndSplit(g, new int[] {midX[2], midX[1], x[2]}, new int[] {midY[2], midY[1], y[2]}, times - 1);
            drawAndSplit(g, new int[] {midX[1], midX[0], x[1]}, new int[] {midY[1], midY[0], y[1]}, times - 1);

        } else return;

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SerpinskiTriangle panel = new SerpinskiTriangle(5);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}

