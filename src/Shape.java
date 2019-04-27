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

        float scaleX = ((float)currentWindowWidth/512);
        float scaleY = ((float)currentWindowHeight/384);
        int maxSizeX = (int)(maxSize*scaleX);
        int maxSizeY = (int)(maxSize*scaleY);

        if(type == 3){
            int[] trianglePropArr = new int[7];

            trianglePropArr[0] = type; //set shape type

            trianglePropArr[1] = (int)(properties[0]*currentWindowWidth);   // x1
            trianglePropArr[2] = trianglePropArr[1]+(int)(maxSize*properties[3]*scaleX);   // x2
            trianglePropArr[3] = trianglePropArr[1]+(int)(scaleX*maxSize*properties[3]/2);                         // x3

            trianglePropArr[4] = (int)(properties[1]*currentWindowHeight);   // y1
            trianglePropArr[5] = trianglePropArr[4];                         // y2
            trianglePropArr[6] = trianglePropArr[4]-(int)(properties[3]*maxSize*0.86F*scaleY);   // y3

            return trianglePropArr;
        }

        int[] propArr = new int[5];
        propArr[0] = type;
        propArr[1] = (int)(properties[0]*currentWindowWidth);   // x
        propArr[2] = (int)(properties[1]*currentWindowHeight);  // y
        propArr[3] = (int)(properties[2]*maxSizeX);   // width
        propArr[4] = (int)(properties[3]*maxSizeY);   // height
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

    public byte getType(){
        return type;
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
