/*
 * Copyright Denys Lebediev
 */
package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * @author Denis Lebedev
 */
public class SwingTest
{

    static class DataModel
    {
        private java.util.List<Shape> allShapes_;

        public DataModel()
        {
            allShapes_ = new ArrayList<>();
        }

        void addShape(int x, int y)
        {
            Shape s = new Shape();
            s.setX(x);
            s.setY(y);
            allShapes_.add(s);
        }

        java.util.List<Shape> getAllShapes()
        {
            return allShapes_;
        }
    }

    static class Shape
    {
        private int x_;
        private int y_;

        public int getX()
        {
            return x_;
        }

        public void setX(int x)
        {
            x_ = x;
        }

        public int getY()
        {
            return y_;
        }

        public void setY(int y)
        {
            y_ = y;
        }
    }

    static class VisualComponent extends JPanel
    {
        private final DataModel model_;

        public VisualComponent(DataModel model)
        {
            model_ = model;
        }

        @Override
        public void paint(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
            g.setColor(Color.BLACK);
            for (Shape s : model_.getAllShapes())
            {
                g.fillRect(s.getX(), s.getY(), 20, 20);
            }
        }
    }

    static class Controller extends MouseAdapter
    {
        private final DataModel model_;
        private final JComponent visualComponent_;

        private Shape pressedShape_ = null;
        private int pressedX_;
        private int pressedY_;

        public Controller(DataModel model, JComponent visualComponent)
        {
            model_ = model;
            visualComponent_ = visualComponent;
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            for (Shape s : model_.getAllShapes())
            {
                int sw = 20;
                int sh = 20;
                if (e.getX() >= s.getX() && e.getX() <= (s.getX() + sw) &&
                        e.getY() >= s.getY() && e.getY() <= (s.getY() + sh))
                {
                    pressedShape_ = s;
                    pressedX_ = e.getX();
                    pressedY_ = e.getY();
                    break;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            pressedShape_ = null;
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            if (pressedShape_ != null)
            {
                int dx = e.getX() - pressedX_;
                int dy = e.getY() - pressedY_;
                pressedShape_.setX(pressedShape_.getX() + dx);
                pressedShape_.setY(pressedShape_.getY() + dy);
                pressedX_ = e.getX();
                pressedY_ = e.getY();
                visualComponent_.repaint();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            model_.addShape(e.getX(), e.getY());
            visualComponent_.repaint();
        }
    }


    public static void main(String[] args)
    {
        DataModel model = new DataModel();
        model.addShape(30, 40);
        model.addShape(60, 40);
        JComponent paintComponent = new VisualComponent(model);
        Controller controller = new Controller(model, paintComponent);
        paintComponent.addMouseListener(controller);
        paintComponent.addMouseMotionListener(controller);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(new JLabel("test"), BorderLayout.NORTH);
        contentPanel.add(paintComponent, BorderLayout.CENTER);

        JFrame frame = new JFrame("Paint Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);
        frame.setBounds(50, 50, 600, 400);
        frame.setVisible(true);
    }
}
