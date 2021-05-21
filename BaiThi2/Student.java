package BaiThi2;


public class Student {
    public String id;
    public String name;
    public String address;
    public int number;

    public Student(String id, String name, String address, int number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public static Student createStudent(String id,String name,String address,int phone){
        return new Student(id,name,address,phone);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
