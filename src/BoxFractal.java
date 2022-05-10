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
        int width = 486;
        int height = 486;

        g.setColor(Color.RED);

        drawAndSplit(g, x, y, 486, levels);

    }



    public void drawAndSplit(Graphics g, int x, int y, int size, int times)
    {


        if (times == 1){
            g.fillRect(x, y, size, size);
            return;
        }

        int newSize = size / 3;

        if (times > 1) {
            drawAndSplit(g, x, y, newSize, times - 1);
            drawAndSplit(g, x + newSize * 2, y, newSize, times - 1);
            drawAndSplit(g, x, y + newSize * 2, newSize, times - 1);
            drawAndSplit(g, x + newSize, y + newSize, newSize, times - 1);
            drawAndSplit(g, x + newSize * 2, y + newSize * 2, newSize, times - 1);
        }

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
