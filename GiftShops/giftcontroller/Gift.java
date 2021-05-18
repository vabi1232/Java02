package GiftShops.giftcontroller;


public class Gift {
    public int id,qty;
    public double price;
    public String name;
    public Gift(){
        id=0;
        qty=0;
        price=0.0;
        name="";
    }
    public Gift(int id, int qty, double price, String name) {
        this.id = id;
        this.qty = qty;
        this.price = price;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("%-30d%-30s%-30s%-30d%-30d%-30d%-30d%-30.2f%-30s%-30s\n",id,qty,price,name);
    }
}
