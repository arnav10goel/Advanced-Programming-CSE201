public abstract class Store_Item {
    private String name;
    private double id;

    Store_Item(String name, double id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }
}
