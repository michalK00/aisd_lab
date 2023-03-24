package L2.z1;

import java.io.*;
import java.util.ArrayList;

public class ListSerialize {

    public static void save(OneWayLinkedListWithHead list){

        try{

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("list.ser"));
            out.writeObject(list);
            out.close();
            System.out.println("Zapisano!");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static OneWayLinkedListWithHead read(){

        OneWayLinkedListWithHead list;
        list = null;

        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("list.ser"));

            list = (OneWayLinkedListWithHead) read.readObject();

            read.close();
            System.out.println("Odczytano!");

        }catch (EOFException eofe){

        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return list;

    }

}
