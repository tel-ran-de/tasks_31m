package task1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        // DataOutputStream && DataInputStream

        Person john = new Person("John", 20, 175.5, false);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("c:/soft/1.txt"))) {
            dos.writeUTF(john.getName());
            dos.writeInt(john.getAge());
            dos.writeDouble(john.getHeight());
            dos.writeBoolean(john.isMarried());
            System.out.println("Data has been written");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("c:/soft/1.txt"))) {
            String name = dis.readUTF();
            int age = dis.readInt();
            double height = dis.readDouble();
            boolean isMarried = dis.readBoolean();
            System.out.println(name + ", " + age + ", " + height + ", " + isMarried);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
