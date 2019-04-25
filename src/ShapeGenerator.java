public class ShapeGenerator{

    public ShapeGenerator() { }

    public Shape generateShape(){

        float[] shapeProp = new float[4]; // {x, y, width, height}
        shapeProp[0] = (float)(Math.random());
        shapeProp[1] = (float)(Math.random());
        shapeProp[2] = (float)(Math.random());
        shapeProp[3] = (float)(Math.random());

                                             // 0 is arc,
                                             // 1 is oval/circle,
        byte type = (byte)(Math.random()*4); // 2 is rectangle,
                                             // 3 is triangle


        float[] colors = new float[3];
        colors[0] = (float)(Math.random());
        colors[1] = (float)(Math.random());
        colors[2] = (float)(Math.random());


        return new Shape(shapeProp, type, colors);
    }






}
