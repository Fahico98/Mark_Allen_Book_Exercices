
public class Section_8_Sorting_Algorithms {
    
    public static void main(String[] args) {
        
        int[] toSort = {56, 2, 90, 21, 66, 73, 43, 12, 89, 23, 49, 55, 81};
        toSort = shellSort(toSort);
        
        System.out.print("[");
        for (int i = 0; i < toSort.length; i++) {
            System.out.print(toSort[i]);
            if(i != (toSort.length - 1)){
                System.out.print(", ");
            }else{
                System.out.println("]");
            }
        }
    }
    
    public static int[] shellSort(int[] toSort){
        for (int gap = (toSort.length / 2); gap > 0; gap = (gap == 2) ? 1 : (int)(gap / 2.2)){
            for (int i = gap; i < toSort.length; i++) {
                int temp = toSort[i];
                int j = i;
                for ( ; j >= gap && temp < toSort[j - gap]; j -= gap){
                    toSort[j] = toSort[j - gap];
                }
                toSort[j] = temp;
            }
        }
        return toSort;
    }
}
