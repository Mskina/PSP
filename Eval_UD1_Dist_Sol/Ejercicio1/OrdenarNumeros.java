package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        int num;
        do {
            num = sc.nextInt();
            if (num != -999) arrayNum.add(num);

        } while (num != -999);

        Collections.sort(arrayNum);

        System.out.println(arrayNum.toString());
    }
}
