//RAND AJANJI 230404920
public class Student {
    String name;
    String department;
    double grade;


    public Student(String name, String department, double grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;
    }


    public void printInfo() {
        System.out.println("Öğrenci Adı: " + name);
        System.out.println("Bölüm: " + department);
        System.out.println("Not: " + grade);
    }


    public boolean passed() {
        return grade >= 50;
    }
}
