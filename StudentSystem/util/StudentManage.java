package StudentSystem.util;

import java.util.LinkedList;

public class StudentManage {
    public StudentManage() {
        maxNums = Config.nums;
        outFile = Config.outFile;
        studentList = new LinkedList<Student>();
    }
    public StudentManage(int nums) {
        maxNums = nums;
        outFile = Config.outFile;
        studentList = new LinkedList<Student>();
    }
    public StudentManage(int nums, boolean state) {
        maxNums = nums;
        outFile = state;
        studentList = new LinkedList<Student>();
    }

    public void setMaxNums(int nums) {
        maxNums = nums;
    }
    public void setOutToFile(boolean state) {
        outFile = state;
    }

    public void insert(String name, String id, int age, String sex) {
        Student st = new Student(name, id, age, sex);
        if (studentList.size() >= maxNums) {
            studentList.removeFirst();
        }
        studentList.addLast(st);
        System.out.println("insert Success!, student size = [ " + size() + " ]");
    }

    public void remove() {
        studentList.removeFirst();
        System.out.println("remove Success!, student size = [ " + size() + " ]");
    }

    public Student searchFromName(String name) {
        Student st = null;
        for (int i = 0; i < studentList.size(); i++) {
            if (name.equals(studentList.get(i).getName())) {
                st = studentList.get(i);
                break;
            }
        }
        return st;
    }
    public Student searchFromId(String id) {
        Student st = null;
        for (int i = 0; i < studentList.size(); i++) {
            if (id.equals(studentList.get(i).getId())) {
                st = studentList.get(i);
                break;
            }
        }
        return st;
    }

    public void printAllStudentInfo() {
        Student st = null;
        for (int i = 0; i < studentList.size(); i++) {
            st = studentList.get(i);
            st.formatPrint();
        }
    }

    public int size() {
        return studentList.size();
    }

    public void clear() {
        studentList.clear();
    }

    int maxNums;
    boolean outFile;
    private LinkedList<Student> studentList;
}
