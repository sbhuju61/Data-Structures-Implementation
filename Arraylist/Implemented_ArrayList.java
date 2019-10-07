import java.util.Arrays;



class Implemented_ArrayList<E>{
    private int arraySize;
    private Object array[];
    private int arrayCount;

    Implemented_ArrayList(){
        this.arraySize = 10;
        this.arrayCount = 0;

        this.array = new Object [this.arraySize];
    }

    private void expandArraySize(){
        if (this.arraySize == this.arrayCount){
            this.arraySize *= 2;
        }
        this.array = Arrays.copyOf(this.array, this.arraySize);
       
    }

    public void add(E value){
        expandArraySize();
        this.array[this.arrayCount] = value;
        this.arrayCount++;
    }

    public int size (){
        return this.arraySize;
    }

    public void print (){
        for (int i = 0; i < this.arrayCount; i++){
            System.out.print(this.array[i] + " ");
        }
    }
    
    @SuppressWarnings("unchecked")
    public E get (int index){
        if (index < 0 || index > this.arrayCount){
            throw new IndexOutOfBoundsException(index);
        }
        return (E) this.array[index];
    }

  public static void main(String[] args) {
        Implemented_ArrayList <Integer> intArrayList = new Implemented_ArrayList<Integer>();
        intArrayList.add(1);
        System.out.println(intArrayList.get(0));
        
        System.out.print("Print ArrayList: "); intArrayList.print();
        
    }
}