public class Item {

    public double size;
    public double value;


    public Item(int size, int value){
        this.size=size;
        this.value=value;
    }

    public String toString(){
        double ratio = new Double(value)/size;
        return "Item val: "+ value + " size: "+ size + " ratio: " + ratio;
    }
}
