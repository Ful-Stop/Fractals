import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  Box Fractal, a recursive algorithm
 */

public class BoxFractal extends JPanel
{

    private int levels;

    public BoxFractal(int lev)
    {
        levels = lev;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int x = xCenter - 243;
        int y = yCenter - 243;
        g.setColor(Color.RED);

    }



    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {
        if (times > 0) {
            g.drawPolygon(x, y, 4);
            //drawAndSplit(g, midpoints(x), midpoints(y), times - 1);
        } else return;

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxFractal panel = new BoxFractal(5);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}
