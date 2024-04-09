package Project2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Forest implements Serializable{



    private String name;
    private String fileName;
    private ArrayList<Tree> listOfTrees = new ArrayList<Tree>();


    public Forest (){
        name = "";
    }// end of default constructor

    public Forest(String name, String fileName, ArrayList<Tree> Trees){
        this();
        this.name = name;
        this.fileName = fileName;
    }// end of Forrest CONSTRUCTOR




    public void addTree(Tree tree){
        listOfTrees.add(tree);
    }// end of addTree METHOD

    public void cutTree(Tree tree){
        listOfTrees.remove(tree);
    }// end of cutTree METHOD

    public  boolean saveForest(String fileName , Forest theForest){
        ObjectOutputStream toStream = null;
        try {
            toStream = new ObjectOutputStream(new FileOutputStream(fileName));
            toStream.writeObject(theForest);
            return true;
        }catch(IOException e){
            System.out.println("ERROR Saving fix yo shit!");
            return false;

        }finally {
            if (toStream != null){
                try{
                    toStream.close();
                }catch(IOException e){
                    System.out.println("Error closing fix yo shit!");

                }
            }
        }

    }// end of saveForest

    public String getName(){
        return this.name;
    }// end of getName

    public  Forest loadForest(String fileName){
        ObjectInputStream fromStream = null;
        Forest local;
        try {
            fromStream = new ObjectInputStream(new FileInputStream(fileName));
            local = (Forest)fromStream.readObject();
            return(local);
        }catch(IOException e){
            System.out.println("ERROR loading fix yo shit! " + e.getMessage());
            return(null);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return(null);
        }finally{
            if (fromStream != null){
               try{ fromStream.close();
            }catch (IOException e){
                   System.out.println("ERROR Closing fix yo shit!" + e.getMessage());

               }
        }

    }// end of loadForest











}// end of the Forrest CLASS
