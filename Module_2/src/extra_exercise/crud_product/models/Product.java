package extra_exercise.crud_product.models;

public class Product {
    private int id;
    private String name;
    private String label;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String label, int price) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Product "+this.id+
                ", Name "+this.name+
                ", Label "+this.label+
                ", Price "+this.price;
    }
}
