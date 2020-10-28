import java.util.Arrays;

public class GenericMethods implements GenericMethodsInterface{
    
    
    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x){
        for(int i = 0; i < a.length; i++){
            if(a[i].compareTo(x) == 0){
                return i;
            }
        }
        return -1;
    }
    
    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
        return binarySearch(a, x, 0, a.length - 1);   
    }
    
    private <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x, int low, int high){
        //object not found in array
        if(low > high){
            return -1;
        }
        
        int middle = (low + high) / 2;
        
        if(a[middle].compareTo(x) == 0){ //if object is in the middle index
            return middle;
        }
        else if(a[middle].compareTo(x) > 0){ //if object is on the left side of the middle
            return binarySearch(a, x, low, middle - 1);
        }
        else{ //if object is on the right side of the middle
            return binarySearch(a, x, middle + 1, high);
        }
    }
    
}