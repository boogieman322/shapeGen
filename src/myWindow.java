import javax.swing.*;
import java.awt.*;

public class myWindow extends JFrame {

   public ShapeBox container;
   private final int maxSize = 300;

    public myWindow(String title, int startX, int startY){
        super(title);
        this.setSize(startX,startY);
        this.setResizable(true);
        this.createContainer();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(new myPane(container));
        this.setVisible(true);
    }

    public void addToContainer(Shape s){
        container.add(s);
    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void createContainer(){
        container = new ShapeBox();
    }

    public ShapeBox getContainer(){
        return container;
    }

}