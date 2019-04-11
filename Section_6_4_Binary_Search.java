
import java.util.Arrays;

public class Section_6_4_Binary_Search {
    
    private static int[] list = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
    
    private static boolean myBinarySearch(final int[] array, final int toSearch){
        int first = 0;
        int last = array.length - 1;
        int middle = last / 2;
        while(first <= last){
            if(array[middle] < toSearch){
                first = middle + 1;
            }else if(array[middle] == toSearch){
                return(true);
            }else{
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return(false);
    }
    
    public static void main(String[] arguments){
        
        // Searching elements with 'myBinarySearch' own method.
        
        if(myBinarySearch(list, 70)){
            System.out.println("¡Found 70!");
        }else{
            System.out.println("¡70 not found!");
        }
        
        if(myBinarySearch(list, 12)){
            System.out.println("¡Found 12!");
        }else{
            System.out.println("¡12 not found!");
        }
        
        System.out.println(" ----------------------------------------------- ");
        
        // Searching elements with 'binarySearch' method from 'Arrays' class.
        
        int index70 = Arrays.binarySearch(list, 70);
        int index12 = Arrays.binarySearch(list, 12);
        
        if(index70 >= 0){
            System.out.println("¡Found 70 in " + index70 + " index!");
        }else{
            System.out.println("Arrays.binarySearch result: " + index70 + ".");
        }
        
        if(index12 >= 0){
            System.out.println("¡Found 12 in " + index12 + " index!");
        }else{
            System.out.println("Arrays.binarySearch result: " + index12 + ".");
        }
    }
}
