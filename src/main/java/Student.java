import java.util.*;

public class Student {
    String name;
    String group;
    int  course;
    TreeMap<String, Integer> subjectWithGrade;

    public Student(String name, String group, int course ){
        this.name = name;
        this.group = group;
        this.course = course;
        this.subjectWithGrade = new TreeMap<>();
    }
    public Student(String name, String group, int course , String subject, int grade){
        this.name = name;
        this.group = group;
        this.course = course;
        this.subjectWithGrade = new TreeMap<>();
        subjectWithGrade.put(subject, grade);
    }
    public static Student createStudent(String name, String group, int course){
        Student student = new Student(name, group, course);
        return student;
    }
    public static Student createStudent(String name, String group, int course, String subject, int grade) {
        Student student = new Student(name, group, course, subject, grade);
        return student;
    }
    public void addSubjectWithGrade(String subject, int grade){
        subjectWithGrade.put(subject, grade);
    }
    public void info(){
        System.out.println("Студент: " + name + ", группа - " + group + ", курс - " + course);
        System.out.print("Предметы: ");
        for (Map.Entry<String, Integer> sg: subjectWithGrade.entrySet()){
            System.out.print(sg.getKey() + " - " + sg.getValue() + "; ");
        }
        System.out.println();
    }
    public float averageScoreStudent(){
        int sum = 0;
        for (Map.Entry<String, Integer> grade: subjectWithGrade.entrySet()){
            sum += grade.getValue();
        }
        return (float) sum/subjectWithGrade.size();
    }


    public static void deleteBadStudent(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).averageScoreStudent() < 3)
            {   students.remove(i);}
        }
    }
    public static void transferStudent(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).averageScoreStudent() >= 3)
                students.get(i).course ++;
        }
    }
    public static void printStudents(ArrayList<Student> students, int course){
        for (Student student: students) {
            if (student.course == course)
                student.info();
        }
    }




    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(createStudent("Иванов Иван", "23/2",2));
        students.get(0).addSubjectWithGrade("Математика", 2);
        students.get(0).addSubjectWithGrade("Английский язык", 3);
        students.get(0).addSubjectWithGrade("Экономика", 3);
        students.add(createStudent("Иванов Виктор", "Н-2.4",2,"Математика", 3));
        students.add(createStudent("Петров Сергей", "3/2",3,"Информатика", 5));
        students.add(createStudent("Волк Виктория", "13",1,"Физика", 5));

        for (int i = 0; i < students.size(); i++) {
            students.get(i).info();}
        System.out.println();

        transferStudent(students);
        deleteBadStudent(students);

        for (int i = 0; i < students.size(); i++) {
            students.get(i).info();}
        System.out.println();
        printStudents(students,4);

    }
}
