/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package histgram;

/**
 *
 * @author tucker.stone061
 */
import javax.swing.*;
import java.awt.*;

public class DrawHist extends JPanel {
  // Count of occurrences of each category
  private int[] count;
  // Name of each category
  private String[] countname;

  /** Set the count and display histogram */
  public void showHistogram(int[] count, String[] countname) {
    this.count = count;
    this.countname = countname;
    repaint();
  }

  /** Paint the histogram */
  protected void paintComponent(Graphics g) {
    if (count == null) return; // No display if count is null

    super.paintComponent(g);

    // Find the panel size and bar width and interval dynamically
    int width = getWidth();
    int height = getHeight();
    int interval = (width - 40) / count.length;
    int individualWidth = (int)(((width - 40) / count.length) * 0.60);

    // Find the maximum count. The maximum count has the highest bar
    int maxCount = 0;
    for (int i = 0; i < count.length; i++) {
      if (maxCount < count[i])
        maxCount = count[i];
    }

    // x is the start position for the first bar in the histogram
    int x = 30;

    // Draw a horizontal base line
    g.drawLine(10, height - 45, width - 10, height - 45);
    for (int i = 0; i < count.length; i++) {
      // Find the bar height
      int barHeight =
        (int)(((double)count[i] / (double)maxCount) * (height - 85));

      // Display a bar (i.e. rectangle)
      g.setColor(Color.blue);
      g.fillRect(x, height - 45 - barHeight, individualWidth,
        barHeight);


      g.setColor(Color.black);
      // Display a letter under the base line
      g.drawString(countname[i], x, height - 30);

      // Display count (turned into a string) over each bar
      g.drawString(""+count[i], x, height - barHeight - 55 );

      // Move x for displaying the next character
      x += interval;
    }
  }

  /** Override getPreferredSize */
  public Dimension getPreferredSize() {
    return new Dimension(500, 300);
  }
}
