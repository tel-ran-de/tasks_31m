package task1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Предположим имеется коллекция вида:
        // Arrays.asList( new Student("Дмитрий", 17, Gender.MAN),
        // new Student("Максим", 20, Gender.MAN), new Student("Екатерина",
        // 20, Gender.WOMAN), new Student("Михаил", 28, Gender.MAN)
        // Создать необходимые классы самостоятельно и потом создать
        // подобную коллекцию. Найти в этой коллекции средний возраст
        // студентов мужского пола. Использовать Stream API.
        List<Student> students = Arrays.asList(
                new Student("Dmitry", 17, Gender.MAN),
                new Student("Maksim", 20, Gender.MAN),
                new Student("Kate", 20, Gender.WOMAN),
                new Student("Michel", 28, Gender.MAN)
        );
        double avg = students.stream()
                .filter(s -> s.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average().orElse(0.0);
        System.out.println(avg);

    }

}
