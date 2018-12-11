package th.ac.kmitl.a59070098.mobilefinal;

public class Contact {
    String id_name, name, password,text;
    int age;

    public Contact() {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.age = age;
    }

    public String getId() {
        return id_name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id_name = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMyText() {
        return text;
    }

    public void setMyText(String text) {
        this.text = text;
    }
}
