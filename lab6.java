import java.io.*;
import java.util.*;

public class lab6{
    public static void main(String[] args){
        System.out.println("How big of a world would you like it to be?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        char[] array = generateUniverse(s);
        System.out.println(java.util.Arrays.toString(array));

        int j=0;

        while(j==0) {
            System.out.println("Q for quit, A for advance, S for save");
            Scanner sc2 = new Scanner (System.in);
            String op = sc2.nextLine();
            if (op.equals("Q") || op.equals("q")) {
                j=1;
            } else if (op.equals("A") || op.equals("a")) {
                array = advance(array,s);
                System.out.println(java.util.Arrays.toString(array));
            } else if (op.equals("S") || op.equals("s")) {
                save(array,s);
            } else {
                System.out.println("Entered invalid value");
            }
        }
    }
    public static char[] generateUniverse(int size){
        char[] b;
        int i;
        b = new char[size];
        for (i=0;i<size;i++) {
            if(i%7==0) {
                b[i]='0';
            }else if(i%5==0) {
                b[i]='^';
            }else {
                b[i] = '.';
            }
        }
        return b;
    }
    public static char[] advance(char[] b,int size){
        int i;
        for (i=size-1;i>=0;i--) {
            if (b[i]=='0') {
                b[i]='1';
            }else if(b[i]=='1'){
                b[i]='2';
            }else if(b[i]=='2') {
                if (i==size-1){
                }else if(b[i+1]=='2'||b[i+1]=='1'||b[i+1]=='0') {
                }else if(b[i+1]=='^'){
                    b[i+1]='0';
                    b[i]='.';
                }else{
                    b[i+1]='2';
                    b[i]='.';
                }
            }else{
            }
        }
        return b;
    }

    public static void save(char[] c,int size){
        int i;
        int b=0;
        int ch=0;
        int ad=0;
        for (i=0;i<size;i++) {
            if(c[i]=='0') {
                b++;
            }else if(c[i]=='1') {
                ch++;
            }else if(c[i]=='2'){
                ad++;
            }else{
            }
        }
        try {
            FileWriter writer = new FileWriter("universe.txt", true);
            writer.write(java.util.Arrays.toString(c));
            writer.write("\r\n");   // write new line
            writer.write("Babies: " + b);
            writer.write("\r\n");
            writer.write("Children: " + ch);
            writer.write("\r\n");
            writer.write("Adults: " + ad);
            writer.write("\r\n");
            writer.close();
        }catch(Exception e){

        }
    }
}