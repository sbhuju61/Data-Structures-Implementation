import java.util.Arrays;
import java.lang.StringBuilder;

class Implemented_ArrayList<E>{

    private int arrayCapacity;
    private int arraySize;
    private Object array[];
    

    Implemented_ArrayList(){

        this.arrayCapacity = 1;
        this.array = new Object [this.arrayCapacity];
    }

    private void expandArrayCapacity(int index){

        if (this.arrayCapacity <= index){
            
            this.arrayCapacity  = (this.arrayCapacity * 3)/2 + 1;
            
        }
        this.array = Arrays.copyOf(this.array, this.arrayCapacity);
    }

    public void add(E value){

        expandArrayCapacity(this.arraySize);
        this.array[this.arraySize] = value;
        this.arraySize++;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, E value){

        get(index);
        expandArrayCapacity(this.arraySize);
        for(int i = this.arrayCapacity-this.arraySize+1; i>index; i--) { 
            this.array[i] = this.array[i-1];
        }
        this.array[index] = value; 
        this.arraySize++;
    }

    public int size (){

        return this.arrayCapacity;
    }

    public void print (){

        for (int i = 0; i < this.arraySize; i++){
            System.out.print(" " + i + ":" + this.array[i] + " |");
        }
    }

    public String toString(){

        StringBuilder toString = new StringBuilder();

        for (int i = 0; i < this.arraySize; i++){
            toString.append(" " + i + ":" + this.array[i] + " |");
        }
        
        return toString.toString();
    }
    
    @SuppressWarnings("unchecked")
    public E get (int index){

        if (index < 0 || index > this.array.length){
            throw new IndexOutOfBoundsException(index);
        }
        return (E) this.array[index];
    }

  public static void main(String[] args) {

        Implemented_ArrayList <Integer> intArrayList = new Implemented_ArrayList<Integer>();
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.add(32);
        intArrayList.add(1,45);
        intArrayList.add(32);
        intArrayList.add(33423);
        intArrayList.add(323);
        intArrayList.add(945);
        
        
        
        //intArrayList.add(10,49);
        //System.out.println(intArrayList.get(1));
        
        System.out.print("Print ArrayList: "+ intArrayList.toString()); 
        
    }
}