package modals;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TransparentScrollBarUI extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ScrollBar.track", new ColorUIResource(new Color(0, 0, 0, 0)));
        UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(new Color(0, 0, 0, 0)));
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        Dimension zeroDim = new Dimension(0, 0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }
    
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(new Color(0, 0, 0, 0));
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(new Color(0, 0, 0, 0));
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
    }
}