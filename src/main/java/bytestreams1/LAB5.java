package bytestreams1;

import java.io.*;
import java.util.ArrayList;

public class LAB5 {

    public static void main(String[] args) {
        Demo demo1 = new Demo(111,"one");
        Demo demo2 = new Demo(222,"two");
        Demo demo3 = new Demo(333,"three");
        Demo demo4 = new Demo(444,"four");
        Demo demo5 = new Demo(555,"five");
        ArrayList<Demo> demoList1 = new ArrayList<>();
        ArrayList<Demo> demoList2;
        demoList1.add(demo1);
        demoList1.add(demo2);
        demoList1.add(demo3);
        demoList1.add(demo4);
        demoList1.add(demo5);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(demoList1);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            demoList2 = (ArrayList<Demo>) objectInputStream.readObject();
            for (Demo demo : demoList2) {
                System.out.println(demo.getId() + " " + demo.getName());
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
