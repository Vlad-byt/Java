import java.io.*;
import java.lang.*;
import java.util.*; 

public class Main
{
    public static void main(String[] args) {
        int index = 1; 
        int x = 50;
        String element = "1";
        int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 4 }; 
        HubList hub = new HubList(arr);
        hub.add(x);
        hub.removeAt(index);
        hub.sort();
        hub.find(element);
    }
}
       
       class HubList implements HubList_IT{
        int x;
        int arr[]; 
        int index;
        String element;
        
        public HubList(int arr[]) {
            this.arr = arr;
        }
        
       public void add(int x) {
            this.x = x;
            int newarr[] = new int[this.arr.length + 1];

            for (int i = 0; i < this.arr.length; i++) {
                newarr[i] = this.arr[i];
            }
            newarr[this.arr.length] = this.x;
            this.arr = newarr;
            System.out.print(Arrays.toString(this.arr));
        }
        
        public void removeAt(int index){
            this.index = index;
            if (this.arr == null || this.index < 0 || this.index >= this.arr.length) {
           System.out.print(Arrays.toString(this.arr));
        } 
        else {
        int[] newarr = new int[this.arr.length - 1];
        
        for (int i = 0, k = 0; i < this.arr.length; i++) {
            if (i == this.index) {
                continue;
            }
            newarr[k++] = this.arr[i];
        }
        this.arr = newarr;
        System.out.print(Arrays.toString(this.arr));
            
        }
        } 
        
        public void sort(){
            for (int i = 1; i < this.arr.length; i++) {
                if (this.arr[i] < this.arr[i - 1]) {
                     Arrays.sort(this.arr); 
                }
            }
            System.out.print(Arrays.toString(this.arr));
        }
        
        public void find(String element) {
            this.element = element;
            if (Objects.isNull(this.arr)) {
                System.out.print("Элемента не существуут");
            } 
            else {
                for (int i = 0; i < this.arr.length; i++) {
                    String str = String.valueOf(this.arr[i]);
                    if (Objects.equals(str, this.element) == true) {
                         System.out.print(this.arr[i]);
                         break;
                    } else {continue; }
                }
            }
        }
    }
    interface HubList_IT{
        public void add(int x);
        public void removeAt(int index);
        public void sort();
        public void find(String element);
        
    }
