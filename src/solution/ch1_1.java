package solution;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ch1_1 {
    public static void main(String[] args)
    {
        /*System.out.println((0+15)/2);
        System.out.println(2.0e-6*100000000.1);
        System.out.println(true&&false||true&&false);
        //练习1.1.1

        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1+2+"3");
        //练习1.1.2

        Scanner scan1 = new Scanner(System.in);
        int a = scan1.nextInt();
        int b = scan1.nextInt();
        int c = scan1.nextInt();
        if(a == b && a == c)
            System.out.println("equal");
        else
            System.out.println("not equal");
        //练习1.1.3

        String s = "";
        int N = scan1.nextInt();
        for(int n = N; n > 0; n /= 2){
            s = (n%2) + s;
        }
        System.out.println(s);
        //练习1.1.9
        */
        printPrimeArray(10);
    }

    //练习1.1.13
    public void tranArray(int[][] array){
        int M = array.length;
        if(M == 0)
            return;
        int N = array[0].length;
        if(N == 0)
        {
            for(int i = 0; i < M; i++)
                System.out.print(array[i]+" ");
        }
        else
        {
            for(int x = 0; x < N; x++)
                for(int y = 0; y < M; y++)
                    System.out.print(array[y][x]+" ");
                System.out.println();
        }
    }

    //练习1.1.14
    public static int lg(int N)
    {
        int m = 0;
        while(N > 1)
        {
            m++;
            N = N/2;
        }
        return m;
    }

    //练习1.1.15
    public static int[] histogram(int[] a, int M)
    {
        int[] result = new int[M];
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] >= 0 && a[i] <a.length)
                result[a[i]]++;
        }
        return result;
    }

    //练习1.1.20
    public static int mathLn(int N)
    {
        if(N == 1)
            return 0;
        int r = 0;
        int n = N;
        while(n >= 10)
        {
            r++;
            n = n%10;
        }
        return r + mathLn(N-1);
    }

    //练习1.1.21
    public static void printTable(){
        Scanner scanner = new Scanner(System.in);
        String string;
        double i,j;
        while(scanner.hasNext()){
            string = scanner.nextLine();
            if(string.split(" ").length >= 3) {
                try {
                    System.out.print(string.split(" ")[0].trim() + " ");
                    i = Double.parseDouble(string.split(" ")[1].trim());
                    j = Double.parseDouble(string.split(" ")[2].trim());
                    System.out.print(i + " " + j + " " + " " + (int)i/(int)j + "." + (int)(1000 * i) / (int)j % 1000);
                }catch (NumberFormatException e)
                {
                    System.out.println("输入错误");
                    continue;
                }
            }
        }
    }

    //练习1.1.22
    public static void printBinarySearch(){
        int key = 8;
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        rank(key, a, 0, 9, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth){
        String str = "";
        for(int i = 0; i < depth; i++)
            str += " ";
        str += lo +" "+ hi;
        System.out.println(str);
        if(key == a[(lo + hi)/2]) return (lo + hi)/2;
        else if(key > a[(lo + hi)/2]) return rank(key, a, (lo + hi)/2, hi, depth+1);
        else return rank(key, a, lo, (lo + hi)/2, depth+1);
    }

    //练习1.1.26
    public static void sort(){
        Scanner scanner = new Scanner(System.in);
        int a,b,c,t;
        try {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        }catch (NumberFormatException e)
        {
            System.out.print("输入格式错误");
            return;
        }
        if(a > b) { t = a; a = b; b = t;}
        if(a > c) { t = a; a = c; c = t;}
        if(b > c) { t = b; b = c; c = t;}
        System.out.print(a+" "+b+" "+c);
    }

    //练习1.1.27
    public static double binomial(int N, int k, double p){
        if(N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    //练习1.1.28
    public static void binarySearch(){
        int[] a = {1,1,2,3,4,4,4,5,6,7,8,9,10,10,10};
        int p = 0, q = 0;
        for(; q < a.length-1; q++ ){
            if(a[q] != a[q+1]){
                if(p == q)
                    p++;
                else
                    a[p++] = a[q];
            }
            else{
            }
        }
        a[p] = a[a.length-1];
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }


    public static Object arrayAddLength(Object oldArray,int addLength) {
        Class c = oldArray.getClass();
        if(!c.isArray())return null;
        Class componentType = c.getComponentType();
        int length = Array.getLength(oldArray);
        int newLength = length + addLength;
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(oldArray,0,newArray,0,length);
        return newArray;
    }
   public static Object arrayReduceLength(Object oldArray,int reduceLength) {
        Class c = oldArray.getClass();
        if(!c.isArray())return null;
        Class componentType = c.getComponentType();
        int length = Array.getLength(oldArray);
        int newLength = length - reduceLength;
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(oldArray,0,newArray,0,newLength);
        return newArray;
    }

    //练习1.1.30
    public static void printPrimeArray(int N){
        boolean[][] array = new boolean[N][N];
        int k;
        for(int i = 1; i < array.length; i++){
            for(int j = 1; j < i; j++){
                k = j;
                array[i][j] = true;
                while(k != 1 && i%(k--) ==0){
                    array[i][j] = false;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < i; j++)
                System.out.print(array[i][j] + "  ");
            System.out.println();
        }
    }

    //练习1.1.31
    public static void

}
