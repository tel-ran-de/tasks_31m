package task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        // Сериализация и Десериализация
        // ObjectOutputStream и ObjectInputStream

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            Person p1 = new Person("Jack", 45, 12.3, true);
            oos.writeObject(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person p2 = (Person)ois.readObject();
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
