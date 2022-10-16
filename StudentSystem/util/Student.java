package StudentSystem.util;

public class Student {
    private String nameInfo;
    private String idInfo;
    private int ageInfo;
    private String sexInfo;

    public Student(String name, String id, int age, String sex) {
        nameInfo = name;
        idInfo = id;
        ageInfo = age;
        sexInfo = sex;
    }
    
    public Student() {
        nameInfo = "";
        idInfo = "";
        ageInfo = 0;
        sexInfo = "";
    }

    public String getName() {
        return nameInfo;
    }
    public String getId() {
        return idInfo;
    }
    public int getAge() {
        return ageInfo;
    }
    public String getSex() {
        return sexInfo;
    }

    public void setName(String name) {
        nameInfo = name;
    }
    public void setId(String id) {
        idInfo = id;
    }
    public void setAge(int age) {
        ageInfo = age;
    }
    public void setSex(String sex) {
        sexInfo = sex;
    }

    public void formatPrint() {
        System.out.println("name: " + getName() + ", Id: " + getId() + ", Age: " + getAge() + ", Sex: " + getSex());
    }
}
