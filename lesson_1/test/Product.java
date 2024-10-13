
public class Product {
    protected String name;
    protected double price;

    // void add_name(){
    //     name += "_New";
    // }
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Product{" + 
               "name = '" + name + '\'' + 
               ", price = " + price + '}';
    }



}

