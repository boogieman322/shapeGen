import javax.swing.*;
import java.awt.*;

public class myPane extends JPanel {

    ShapeBox cont;
    private final int maxSize = 300;

    public myPane(ShapeBox container) {
        cont = container;
    }

    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr.create();
        Shape tmp;
        int[] propTmp;

        for(int i = 0; i < cont.getCount(); i++){
            tmp = cont.get(i);
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
        }
    }
}
