package Aston.main;
import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );
        double averageAge = calculateAverageAgeOfMaleStudents(students);
        System.out.println("Средний возраст студентов мужского пола: " + averageAge);
        List<Student> potentialConscripts = findPotentialConscripts(students);
        System.out.println("Студенты, которым грозит получение повестки:");
        for (Student student : potentialConscripts) {
            System.out.println(student);
        }
    }
    private enum Gender {
        MAN,
        WOMAN
    }
    private static class Student {
        private final String name;
        private final int age;
        private final Gender gender;
        public Student(String name, int age, Gender gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public Gender getGender() {
            return gender;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
    private static double calculateAverageAgeOfMaleStudents(Collection<Student> students) {
        int sumAge = 0;
        int countMaleStudents = 0;
        for (Student student : students) {
            if (student.getGender() == Gender.MAN) {
                sumAge += student.getAge();
                countMaleStudents++;
            }
        }
        if (countMaleStudents > 0) {
            return (double) sumAge / countMaleStudents;
        } else {
            return 0;
        }
    }
    private static List<Student> findPotentialConscripts(Collection<Student> students) {
        List<Student> potentialConscripts = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Student student : students) {
            if (student.getGender() == Gender.MAN && student.getAge() >= 18 && student.getAge() <= 27) {
                potentialConscripts.add(student);
            }
        }
        return potentialConscripts;
    }
}
