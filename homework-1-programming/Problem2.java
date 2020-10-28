import java.util.Arrays;

public class Problem2{
    public static void main(String[] args){
        
        //build an array of Rectangle objects
        Rectangle[] rectangle = new Rectangle[6];
        
        rectangle[0] = new Rectangle(0,0); //0+0=0
        rectangle[1] = new Rectangle(4,6); //8+12=20
        rectangle[2] = new Rectangle(5,6); //10+12=22
        rectangle[3] = new Rectangle(4,6); //8+12=20
        rectangle[4] = new Rectangle(5,7); //10+14=24
        rectangle[5] = new Rectangle(6,7); //12+14=26
        
        //demonstrate linearSearch functionality on the array
        GenericMethods x = new GenericMethods();
        int linearR = x.linearSearch(rectangle, new Rectangle(4,6));
        System.out.println(linearR);
        
        //sort the array with Arrays.sort
        Arrays.sort(rectangle);
        
        //demonstrate binarySearch functionality on the array
        int binaryR = x.binarySearch(rectangle, new Rectangle(4,6));
        System.out.println(binaryR);
        
    }
}