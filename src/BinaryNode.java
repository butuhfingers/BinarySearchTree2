/**
 * Created by derek on 11/7/16.
 */
public class BinaryNode<T extends Comparable<T>> {
    //Variables
    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;

    //Properties
    public T getElement(){
        return this.element;
    }
    public BinaryNode<T> getLeft(){
        return this.left;
    }
    public void setLeft(T value){this.left = new BinaryNode<T>(value);}
    public BinaryNode<T> getRight(){
        return this.right;
    }
    public void setRight(T value){this.right = new BinaryNode<T>(value);}
    public boolean isEmpty(){
        if(element == null)
            return true;

        return false;
    }
    public void emptyRightNode(){
        this.right = null;
    }
    public void emptyLeftNode(){
        this.left = null;
    }

    //Constructors
    public BinaryNode(T element){
        this.element = element;
    }

    public void DeconstructNode(){
        if(this.getRight() != null) {
            this.element = this.getRight().getElement();

            //Set the node to our right to us
            this.getRight().DeconstructNode();
        } else if(this.getLeft() != null){
            this.element = this.getLeft().getElement();

            this.getLeft().DeconstructNode();
        }
    }
}
