package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void print(int integer) {
        System.out.println(integer);
    }

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = 0;
        int[] array = null;
        while ((line = reader.readLine()) != null && !line.equals("")) {
            if (array == null) {
                length = Integer.parseInt(line);
                array = new int[length];
            } else {
                for (int i = 0; i < length; i++) {
                    if (line.indexOf(' ') == -1) {
                        array[i] = Integer.parseInt(line);
                    } else {
                        array[i] = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                        line = line.substring(line.indexOf(' ') + 1);
                    }
                }
                int min = (length == 0) ? 0 : (length == 1) ? array[0] : Math.abs(array[0]-array[1]);
                f1 : for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                        if (i != j) {
                            int buffMin = Math.abs(array[i]-array[j]);
                            if (buffMin < min) {
                                min = buffMin;
                                if (min == 0)
                                    break f1;
                            }
                        }
                    }
                }
                print(min);
                array = null;
            }
        }
    }

}
