import java.awt.*;

public class Shape {

    private float[] properties;
    private byte type;
    private float[] color;


    public Shape(float[] propArr, byte shapeType, float[] color){
        properties = propArr;
        type = shapeType;
        this.color = color;
    }


    public Color getColorObj(){
        return new Color(
                        (int)(256*color[0]),
                        (int)(256*color[1]),
                        (int)(256*color[2])
                        );
    }

    public int[] getPropertiesArr(int currentWindowWidth, int currentWindowHeight,
                                  int maxSize){


        int maxSizeX = (maxSize*currentWindowHeight/1024);
        int maxSizeY = (maxSize*currentWindowHeight/768);



        if(type == 3){
            int[] trianglePropArr = new int[7];

            trianglePropArr[0] = type;

            trianglePropArr[1] = (int)(properties[0]*currentWindowWidth);   // x1
            trianglePropArr[2] = trianglePropArr[0]+(int)(properties[2]*maxSizeX);   // x2
            trianglePropArr[3] = trianglePropArr[0];                         // x3

            trianglePropArr[4] = (int)(properties[1]*currentWindowHeight);   // y1
            trianglePropArr[5] = trianglePropArr[3];                         // y2
            trianglePropArr[6] = trianglePropArr[3]+(int)(properties[2]*maxSizeY);   // y3

            return trianglePropArr;
        }

        int[] propArr = new int[5];
        propArr[0] = type;
        propArr[1] = (int)(properties[0]*currentWindowWidth);   // x
        propArr[2] = (int)(properties[1]*currentWindowHeight);  // y
        propArr[3] = (int)(properties[2]*maxSizeX+(maxSizeX/10));   // width
        propArr[4] = (int)(properties[3]*maxSizeY+(maxSizeY/10));   // height
        return propArr;

    }

    public int[][] getTrainglePoints(int windX, int windY, int size){
        int[] tmpX = new int[3];
        int[] tmpY = new int[3];
        int[] tmpProp = this.getPropertiesArr(windX, windY, size);
        int[][] pointsArr = new int[2][1];

        tmpX[0] = tmpProp[1];
        tmpX[1] = tmpProp[2];
        tmpX[2] = tmpProp[3];

        tmpY[0] = tmpProp[4];
        tmpY[1] = tmpProp[5];
        tmpY[2] = tmpProp[6];

        pointsArr[0] = tmpX;
        pointsArr[1] = tmpY;

    return pointsArr;
    }


    public float[] getProperties(){
        return properties;
    }

    public byte getType(){
        return type;
    }

    public float[] getColor(){
        return color;
    }

    @Override
    public String toString(){
        String obj = (properties[0])+" "+
                     (properties[1])+" "+
                     (properties[2])+" "+
                     (properties[3])+" "+
                     (color[0])+" "+
                     (color[1])+" "+
                     (color[2])+" "+
                     type+"\n";

        return obj;
    }

}
