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
       /* Shape tmp;
        int[] propTmp;

        for(int i = 0; i < container.getCount(); i++){
            tmp = container.get(i);
            propTmp = tmp.getPropertiesArr(getWidth(), getHeight(), maxSize);

            g.setColor(tmp.getColorObj());
            switch(tmp.getType()){

                case 0: //arc
                    g.drawArc(propTmp[1],propTmp[2],propTmp[3],propTmp[4],
                            0, 180);
                break;

                case 1: //oval/circle
                    g.drawOval(propTmp[1],propTmp[2],propTmp[3],propTmp[4]);
                break;

                case 2: //rectangle
                    g.drawRect(propTmp[1],propTmp[2],propTmp[3],propTmp[4]);
                break;

                case 3: //triangle
                    int[][] trianglePoint = tmp.getTrainglePoints(getWidth(), getHeight(), maxSize);
                    g.drawPolygon(trianglePoint[0], trianglePoint[1], 3);
                break;

            }

        } */

    }

    public void createContainer(){
        container = new ShapeBox();
    }

    public ShapeBox getContainer(){
        return container;
    }


    }






