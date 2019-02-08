import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Main {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.println("Cuantos elementos desea ordenar?");

        Integer sortNum = input.nextInt();
        Comparable [] lista = new Comparable[sortNum];
        //ArrayList<Comparable> lista = new ArrayList();
        int[] listaNum = new int[sortNum];

        Random r = new Random();

        for (int i = 0; i<sortNum; i++){
            lista[i]=(randomAlphaNumeric(5));
            listaNum[i]= r.nextInt(500)+1;
        }

        //crear archivo
        try {
            String direccion = System.getProperty("user.dir")+"/lista.txt";
            String contenido = Arrays.toString(lista);
            File file = new File(direccion);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }




        //Ordenados por quicksort
        System.out.println("Quicksort: \n");
        for (int i = 0;i < lista.length;i++){
            System.out.print(lista[i]+", ");
        }
        quickSort(lista,lista.length);
        System.out.println("\n Ordenados:");
        for (int i = 0;i < lista.length;i++){
            System.out.print(lista[i]+", ");
        }

        //Ordenados por Radix
        System.out.println("\n\nRadix: \n");
        for (int i = 0;i < listaNum.length;i++){
            System.out.print(listaNum[i]+", ");
        }
        Radix rad = new Radix();
        rad.radixsort(listaNum, listaNum.length);
        System.out.println("\nOrdenados:");
        //quickSort(lista,lista.length);
        for (int i =0;i<listaNum.length;i++){
            System.out.print(listaNum[i]+", ");
        }
        System.out.println("\n");
        //Ordenados por Merge
        System.out.println("Mergesort: ");


            for (int j = 0; j < lista.length; j++) {
                System.out.print(lista[j] + ", ");
            }

            MergeSort ob = new MergeSort();
            ob.sort(lista, 0, listaNum.length - 1);
            System.out.println("\nOrdenados: ");
            for (int j = 0; j < lista.length; j++) {
                System.out.print(lista[j] + ", ");
            }

        //Ordenados por gnomeSort
            System.out.println("\n\nGnomeSort: ");
        for (int a = 0; a<lista.length;a++){
            System.out.print(lista[a]+", ");
        }
        System.out.println("\nordenados");
        Comparable[] lista0 = new Comparable[lista.length];
        lista0 = gnomeSort(lista);
        for (int a = 0; a<lista0.length ;a++){
            System.out.print(lista0[a]+", ");
        }

        //Ordenados por selectionsort+
        System.out.println("\n\nSelectionSort: ");
        for (int i = 0; i<lista.length;i++){
            System.out.print(lista[i]+", ");
        }
        System.out.println("\n");
        Comparable[] lista1 = new Comparable[lista.length];
        lista1 = selectionSort(lista);
        System.out.println("Ordenados: ");
        for (int i =0; i<lista1.length;i++){
            System.out.print(lista1[i]+", ");
        }

    }

    public static Comparable[] selectionSort(Comparable[] lista){
        int numUnsorted = lista.length;
        int index;
        int max;
        while (numUnsorted >0){
            //determine maximum value of the array
            max = 0;
            for (index = 1; index < numUnsorted;index ++){
                if(lista[max].compareTo(lista[index])<0){
                    max = index;
                }
            }
            swap(Arrays.asList(lista), max, numUnsorted-1);
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