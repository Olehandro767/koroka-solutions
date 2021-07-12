package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = -1;
        String[] array = null;
        String keyWord = null;
        int indexForWhile = 0;
        while ((line = reader.readLine()) != null) {
            if (array == null) {
                length = Integer.parseInt(line);
                array = new String[length];
            } else if (keyWord == null) {
                keyWord = line;
            } else {
                if (length > indexForWhile) {
                    array[indexForWhile] = line;
                    ++indexForWhile;
                    if (length > indexForWhile)
                        continue;
                }

                int[][] ints = new int[length][1];
                int[] usualArray = new int[length];
                for (int i = 0; i < length; i++)
                    ints[i][0] = array[i].lastIndexOf(keyWord);

                for (int i = 0; i < length; i++)
                    usualArray[i] = ints[i][0];

                Arrays.sort(usualArray);

                String[] strings = new String[length];

                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                        if (usualArray[i] == ints[j][0]) {
                            strings[i] = array[j];
                        }
                    }
                }

                for (String s : strings)
                    System.out.println(s);

                array = null;
                keyWord = null;

            }
        }
    }

}
