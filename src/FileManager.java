import java.io.*;

public class FileManager {
    private File database;
    private FileWriter writer;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private FileReader reader;

    private Object lock;

    public FileManager(Object lock){

        String filename = "data_"+System.currentTimeMillis()+".txt";
        database = new File("C:\\s19818\\"+filename);
        this.lock = lock;


        try {
            database.createNewFile();
            writer = new FileWriter(database);
            bufferedWriter = new BufferedWriter(writer);
        } catch(IOException e2){
            e2.printStackTrace();
        }

    }

    public void saveShape(Shape s){
        try {
            synchronized(lock) {
                bufferedWriter.write(s.toString());
                bufferedWriter.flush();
                System.out.println("Saving...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Shape translateIntoShape(String[] props){

        float[] propArray = new float[4];
        float[] colorArray = new float[3];

        propArray[0] = Float.parseFloat(props[0]);
        propArray[1] = Float.parseFloat(props[1]);
        propArray[2] = Float.parseFloat(props[2]);
        propArray[3] = Float.parseFloat(props[3]);

        colorArray[0] = Float.parseFloat(props[4]);
        colorArray[1] = Float.parseFloat(props[5]);
        colorArray[2] = Float.parseFloat(props[6]);

        byte shapeType = Byte.parseByte(props[7]);

        return new Shape(propArray, shapeType, colorArray);
    }


        public void readFile(ShapeBox container, File data) throws IOException{

            String line = "";
            reader = new FileReader(data);
            bufferedReader = new BufferedReader(reader);

            synchronized(lock){
                line = bufferedReader.readLine();
            }

            if(!container.isEmpty())
            container.removeAllElements();

            while(line != null){
                 container.add(translateIntoShape(line.split(" ")));
            synchronized(lock){
                     line = bufferedReader.readLine();
                 }
            }

        }

        public File getCurrentFile(){
        return database;
        }


    }



