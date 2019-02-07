import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Collections.swap;

public class Main {

    public static void main(String args[]){
        Comparable [] lista = new Comparable[30];
        //ArrayList<Comparable> lista = new ArrayList();
        int[] listaNum = new int[30];

        Random r = new Random();

        for (int i = 0; i<30; i++){
            lista[i]=(randomAlphaNumeric(5));
            listaNum[i]= r.nextInt(500)+1;
        }
        //Ordenados por quicksort
        System.out.println("Datos: \n");
        for (int i = 0;i < lista.length;i++){
            System.out.print(lista[i]+", ");
        }
        quickSort(lista,lista.length);
        System.out.println();
        for (int i = 0;i < lista.length;i++){
            System.out.print(lista[i]+", ");
        }
/*
        //Ordenados por Merge
        System.out.println("Lista de Números: ");
        for (int i = 0;i<lista.length;i++){
            System.out.print(lista[i]+ ", ");
        }
        MergeSort ob = new MergeSort();
        ob.sort(lista,0 ,listaNum.length-1);
        System.out.println("\nLista Ordenada de Números: \n");
        for (int i = 0;i<lista.length;i++){
            System.out.print(lista[i]+ ", ");
        }

        //Ordenados por gnomeSort
        for (int a = 0; a<lista.length;a++){
            System.out.print(lista[a]+", ");
        }
        System.out.println("\n \n--------------------------- \n \n");
        Comparable[] lista0 = new Comparable[lista.length];
        lista0 = gnomeSort(lista);
        for (int i = 0; i<lista0.length ;i++){
            System.out.print(lista0[i]+", ");
        }*/
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

    public static Comparable [] gnomeSort(Comparable[] lista){
        int size = lista.length;
        int i = 0;
        while(i<size){
            if( i==0){
                i++;
            }else if(lista[i].compareTo(lista[i-1])>=0){
                i++;
            }else{
                Comparable temp = 0;
                temp = lista[i];
                lista[i] =lista[i-1];
                lista[i-1] =temp;
                i--;
            }
        }
        return lista;
    }

    public static int partition(Comparable data [] ,int left, int right){
        while(true){
            while (left < right && data[left].compareTo(data[right])<0) right--;
            if (left < right) swap(Arrays.asList(data),left++,right);
            else return left;

            while (left < right && data[left].compareTo(data[right])<0) left++;
            if (left < right) swap(Arrays.asList(data),left,right--);
            else return right;
        }
    }
    public static void quickSort(Comparable data [], int n){
        quickSortRecursive(data,0,n-1);
    }
    public static void quickSortRecursive(Comparable data[], int left, int right){
        int pivot;
        if (left >= right) return;
        pivot = partition(data,left,right);
        quickSortRecursive(data, left, pivot-1);
        quickSortRecursive(data, pivot +1 ,right);
    }



    final static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}