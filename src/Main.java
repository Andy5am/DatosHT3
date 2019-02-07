import java.util.ArrayList;
import java.util.Random;

import static java.util.Collections.swap;

public class Main {

    final static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static void main(String args[]){


        ArrayList<Comparable> lista = new ArrayList();

        for (int i = 0; i<30; i++){
            lista.add(randomAlphaNumeric(5));
        }

        for (int a = 0; a<lista.size();a++){
            System.out.print(lista.get(a)+", ");
        }
        System.out.println("\n \n--------------------------- \n \n");
        ArrayList<Comparable> lista0;
        lista0 = mergeSortRecursive(lista,new ArrayList<Comparable>(),1,lista.size()-1);
        for (int i = 0; i<lista0.size() ;i++){
            System.out.print(lista0.get(i)+", ");
        }
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> lista){
        int numUnsorted = lista.size();
        int index;
        int max;
        while (numUnsorted >0){
            //determine maximum value of the array
            max = 0;
            for (index = 1; index < numUnsorted;index ++){
                if(lista.get(max)< lista.get(index)){
                    max = index;
                }
            }
            swap(lista, max, numUnsorted-1);
            numUnsorted -- ;
        }
        return lista;
    }

    public static ArrayList<Comparable> gnomeSort(ArrayList<Comparable> lista){
        int size = lista.size();
        int i = 0;
        while(i<size){
            if( i==0){
                i++;
            }else if(lista.get(i).compareTo(lista.get(i-1))>=0){
                i++;
            }else{
                Comparable temp = 0;
                temp = lista.get(i);
                lista.set(i,lista.get(i-1));
                lista.set(i-1,temp);
                i--;
            }
        }
        return lista;
    }

    private static ArrayList<Comparable> merge (ArrayList<Comparable> data, ArrayList<Comparable> temp, int low, int middle, int high){
        int ri = low;
        int ti = low;
        int di = middle;

        // while two lists are not empty merge smaller value
        while(ti < middle && di <= high){
            if(data.get(di).compareTo(temp.get(ti))<0){
                data.set(ri++, data.get(di++));
            }else{
                data.set(ri++, temp.get(ti++));
            }
        }
        while(ti<middle){
            data.set(ri++, temp.get(ti++));
        }
        return data;
    }

    private static ArrayList<Comparable> mergeSortRecursive (ArrayList<Comparable> data, ArrayList<Comparable> temp, int low, int high){
        int n = high -low +1;
        int middle =  low + n/2;

        for (int i = low; i < middle && i<0; i++) {
            temp.set(i, data.get(i));
        }

        // sort lower half of array
        mergeSortRecursive(temp,data,low,middle-1);
        // sort upper half of array
        mergeSortRecursive(data,temp,middle,high);
        // merge halves together
        merge(data,temp,low,middle,high);
        return data;
    }
}