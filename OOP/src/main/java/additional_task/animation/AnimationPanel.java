package additional_task.animation;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class AnimationPanel extends JComponent implements Runnable {
    private Thread animationThread = null;
    private Vector<MovingShape> shapes;
    private int defaultShapeType,
            defaultPath,
            defaultWidth = 20,
            defaultHeight = 20;
    private Color defaultFill = Color.blue,
            defaultBorder = Color.black;
    private int delay = 30;
    JPopupMenu popup;


    public AnimationPanel() {
        shapes = new Vector<MovingShape>();
        popup = new JPopupMenu();
        makePopupMenu();


        addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            public void mouseClicked( MouseEvent e ) {
                if (animationThread != null) {
                    boolean found = false;
                    MovingShape currentShape = null;
                    for (int i = 0; i < shapes.size(); i++) {
                        currentShape = (MovingShape) shapes.elementAt(i);
                        if ( currentShape.contains( e.getPoint()) ) {
                            found = true;
                            currentShape.setSelected( ! currentShape.isSelected() );
                            System.out.println(currentShape);
                        }
                    }
                    if (! found) createNewShape(e.getX(), e.getY());
                }
            }
        });
    }


    protected void createNewShape(int x, int y) {

        Insets insets = getInsets();
        int marginWidth = getWidth() - insets.left - insets.right;
        int marginHeight = getHeight() - insets.top - insets.bottom;

        switch (defaultShapeType) {
            case 0: {
                shapes.add( new MovingCircle(x, y, defaultWidth, defaultHeight, marginWidth, marginHeight, defaultFill, defaultBorder, defaultPath));
                break;
            }
            case 1: {
                shapes.add( new MovingRectangle(x, y, defaultWidth, defaultHeight, marginWidth, marginHeight, defaultFill, defaultBorder, defaultPath));
                break;
            }
            case 2: {
                shapes.add( new MovingPacMan(x, y, defaultWidth, defaultHeight, marginWidth, marginHeight, defaultFill, defaultBorder, defaultPath));
                break;
            }
            case 3: {
                shapes.add( new MovingBowTie(x, y, defaultWidth, defaultHeight, marginWidth, marginHeight, defaultFill, defaultBorder, defaultPath));
                break;
            }
        }
    }


    public void setDefaultShapeType(int s) {
        defaultShapeType = s;
    }


    public void setDefaultPathType(int t) {
        defaultPath = t;
        MovingShape currentShape = null;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.get(i);
            if ( currentShape.isSelected())
                currentShape.setPath(defaultPath);
        }
    }


    public void setDefaultWidth(int w) {
        MovingShape currentShape = null;
        defaultWidth = w;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.get(i);
            if ( currentShape.isSelected())
                currentShape.setWidth(defaultWidth);
        }
    }


    public int getDefaultWidth(){
        return this.defaultWidth;
    }


    public void setDefaultHeight(int h) {
        MovingShape currentShape = null;
        defaultHeight = h;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.get(i);
            if ( currentShape.isSelected())
                currentShape.setHeight(defaultHeight);
        }
    }


    public int getDefaultHeight(){
        return this.defaultHeight;
    }


    public void setDefaultFill(Color f){
        MovingShape currentShape = null;
        defaultFill = f;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.get(i);
            if ( currentShape.isSelected())
                currentShape.setFillColor(defaultFill);
        }
    }


    public void setDefaultBorder(Color b){
        MovingShape currentShape = null;
        defaultBorder = b;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.get(i);
            if ( currentShape.isSelected())
                currentShape.setBorderColor(defaultBorder);
        }
    }


    public void clearAllShapes() {
        shapes.clear();
    }


    protected void makePopupMenu() {
        JMenuItem menuItem;

        menuItem = new JMenuItem("Clear All");
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllShapes();
            }
        });
        popup.add(menuItem);
    }

    public void resetMarginSize() {
        Insets insets = getInsets();
        int marginWidth = getWidth() - insets.left - insets.right;
        int marginHeight = getHeight() - insets.top - insets.bottom ;
        for (int i = 0; i < shapes.size(); i++)
            ((MovingShape) shapes.elementAt(i)).setMarginSize(marginWidth, marginHeight);
    }


    public void update(Graphics g){
        paint(g);
    }


    public void paintComponent(Graphics g) {
        MovingShape currentShape;
        for (int i = 0; i < shapes.size(); i++) {
            currentShape = (MovingShape) shapes.elementAt(i);
            currentShape.move();
            currentShape.draw(g);
        }
    }


    public void adjustSpeed(int newValue) {
        if (animationThread != null) {
            stop();
            delay = newValue;
            start();
        }
    }

    public void start() {
        animationThread = new Thread(this);
        animationThread.start();
    }


    public void stop() {
        if (animationThread != null) {
            animationThread = null;
        }
    }


    public void run() {
        Thread myThread = Thread.currentThread();
        while(animationThread==myThread) {
            repaint();
            pause(delay);
        }
    }


    private void pause(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch(InterruptedException ie) {}
    }
}
