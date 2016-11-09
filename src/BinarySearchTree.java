import javax.xml.soap.Node;
import java.util.ArrayList;

/**
 * Created by derek on 11/7/16.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    //Variables
    BinaryNode<T> root;
    //Properties
    public BinaryNode<T> getRoot(){
        return this.root;
    }

    public boolean isEmpty(){
        if(this.getRoot() == null)
            return true;

        return false;
    }
 /*   public BinaryNode<T>[] getNodes(){
        return
    }
*/
    //Constructors
    public BinarySearchTree(){

    }

    //Functions and Methods
    //Add an element to the tree
    public void add(T elementToAdd){
        //Check if our root is empty
        if(this.isEmpty())
            this.root = new BinaryNode<T>(elementToAdd);

        this.addToNodes(elementToAdd, this.getRoot());
    }

    //Add to the list of elements
    private void addToNodes(T elementToAdd, BinaryNode<T> currentNode){
        T element = currentNode.getElement();

        //Check we the element is greater than, if so add to the right
        if(element.compareTo(elementToAdd) > 0) {
            //Check if it is null
            if(currentNode.getRight() == null) {
                currentNode.setRight(elementToAdd);
                return;
            }

            addToNodes(elementToAdd, currentNode.getRight());
        }
        //Check if the element is less than, if so add to the left element
        else if(element.compareTo(elementToAdd) < 0){
            //Check if it is null
            if(currentNode.getLeft() == null){
                currentNode.setLeft(elementToAdd);
                return;
            }

            addToNodes(elementToAdd, currentNode.getLeft());
        }

        //Do nothing if we are equal to
    }

    //Delete the selected element
    public void delete(T elementToDelete){
        //See if we can delete the element
        deleteElement(elementToDelete, this.getRoot());
    }
    private void deleteElement(T elementToDelete, BinaryNode<T> currentNode){
        //Check if the current node is equal to the element to delete
        if(currentNode.getElement().equals(elementToDelete)){
            //Sets the node to null
            System.out.println("Found element " + currentNode.getElement().toString() );
            currentNode.DeconstructNode();
        }
        //Check we the element is greater than, if so delete to the right
        else if(currentNode.getElement().compareTo(elementToDelete) > 0) {
            //Check if it is null
            if(currentNode.getRight() != null) {
                deleteElement(elementToDelete, currentNode.getRight());
            }
        }
        //Check if the element is less than, if so delete to the left element
        else if(currentNode.getElement().compareTo(elementToDelete) < 0){
            //Check if it is null
            if(currentNode.getLeft() != null){
                deleteElement(elementToDelete, currentNode.getLeft());
            }
        }
    }

    //Sort the data
    public ArrayList<T> sort(){
        //We will sort from less than to greater than
        return sortNodes(this.getRoot());
    }
    public ArrayList<T> sortNodes(BinaryNode<T> currentNode){
        ArrayList<T> tempList = new ArrayList<T>();

        //Check if our left is empty, if not add it
        if(currentNode.getLeft() != null)
            tempList.addAll(sortNodes(currentNode.getLeft()));
        //Add our current self
        tempList.add(currentNode.getElement());
        //Check if the right is empty, if not add it
        if(currentNode.getRight() != null)
            tempList.addAll(sortNodes(currentNode.getRight()));

        return tempList;
    }

    public boolean contains(T elementWeContain){
        //Start the chain to go through the elements to get the node
        return containsElement(elementWeContain, this.getRoot());
    }
    private boolean containsElement(T elementWeContain, BinaryNode<T> currentNode){
        if(currentNode.getElement().equals(elementWeContain)){
            return true;
        }
        //Check we the element is greater than, if so return contains to the right
        else if(currentNode.getElement().compareTo(elementWeContain) > 0) {
            //Check if it is null
            if(currentNode.getRight() == null) {
                return false;
            }

            return containsElement(elementWeContain, currentNode.getRight());
        }
        //Check if the element is less than, if so return contains to the left element
        else if(currentNode.getElement().compareTo(elementWeContain) < 0){
            //Check if it is null
            if(currentNode.getLeft() == null) {
                return false;
            }

            return containsElement(elementWeContain, currentNode.getLeft());
        }

        //This is impossible to reach but Java says we have to have it
            //Regardless if we change the top line to .compareTo or .equals
        return false;
    }
}
