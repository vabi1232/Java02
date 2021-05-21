package BaiThi2;

import java.util.ArrayList;

public class StudenList {
    private String studentid;
    private ArrayList<Student>myStudent;
    public StudenList(String studentid){
        this.studentid=studentid;
        this.myStudent=new ArrayList<Student>();
    }
    public boolean addNewStudent(Student student){
        if (findStudent(student.getName())>=0){
            System.out.println("Student is already on file");
            return false;
        }
        myStudent.add(student);
        return true;
    }
    private int findStudent(String studentName){
        for (int i=0;i<this.myStudent.size();i++){
            Student student = this.myStudent.get(i);
            if (student.getName().equals(studentName)){
                return i;
            }
        }
        return -1;
    }
    public void printStudent(){
        System.out.println("Student List:"+myStudent);
        for (int i=0;i<this.myStudent.size();i++){
            System.out.println(i+1+"."+this.myStudent.get(i).getId()+" , "+this.myStudent.get(i).getName()+" , "+this.myStudent.get(i).getAddress()+" , "+this.myStudent.get(i).getNumber());
        }
    }
}
