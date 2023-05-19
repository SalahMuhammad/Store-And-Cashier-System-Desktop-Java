/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

/**
 *
 * @author Salah
 */
public class MyScrollPane extends JScrollPane {

    private JTable table;

    public MyScrollPane() {
//        super(table);
//        this.table = table;

        // Customize the scroll pane
        setPreferredSize(new Dimension(300, 200));
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add a custom viewport
//        CustomViewport viewport = new CustomViewport();
//        setViewport(viewport);
    }

    private class CustomViewport extends JViewport {

        public CustomViewport() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Paint a gradient background
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradient = new GradientPaint(0, 0, Color.WHITE, getWidth(), getHeight(), Color.LIGHT_GRAY);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Call the super method to paint the table
            super.paintComponent(g);
        }
    }

    
}
