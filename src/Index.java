/**
 * Created by derek on 11/7/16.
 */
import java.util.Random;
public class Index {
    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        int loopMax = 100;
        Random rand = new Random();

        //Add random numbers to the tree
        for(int i = 0;i < loopMax;i++)
            tree.add(new Integer(rand.nextInt(loopMax) - Math.round(loopMax / 2)));

        //Print out the sorted list
        for(Integer myInt : tree.sort()){
            System.out.println(myInt.toString());
        }

        //Delete the 20th element
        System.out.println("Deleting : " + tree.sort().get(20).toString());
        tree.delete(tree.sort().get(20));

        //Print out the sorted list
        for(Integer myInt : tree.sort()){
            System.out.println(myInt.toString());
        }

        Integer nextInt = new Integer(rand.nextInt(loopMax) - Math.round(loopMax / 2));
        //Check if we contain a random element
        System.out.println("We contain: " + nextInt.toString() + " : " + tree.contains(nextInt));
    }
}
