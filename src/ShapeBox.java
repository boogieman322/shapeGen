import java.util.ArrayList;

public class ShapeBox {

    private ArrayList<Shape> list;

    public ShapeBox(){
        list = new ArrayList<>();
    }

    public void removeAllElements(){list.clear();}

    public boolean isEmpty(){return list.isEmpty();}

    public void add(Shape e){
        list.add(e);
    }

    public Shape get(int index){
      return list.get(index);
    }

    public int getCount(){
        return list.size();
    }
}
