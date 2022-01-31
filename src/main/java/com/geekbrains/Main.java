package com.geekbrains;

import com.geekbrains.exceptions.MyArrayDataException;
import com.geekbrains.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        // нормальный блок
        System.out.println("Обработка нормального массива.");
        String stringArray[][] = new String[4][];
        stringArray[0] = new String[]{"1", "2", "3", "4"};
        stringArray[1] = new String[]{"5", "6", "7", "8"};
        stringArray[2] = new String[]{"9", "10", "11", "12"};
        stringArray[3] = new String[]{"13", "14", "15", "13"};
        System.out.println(arraySummary(stringArray));
        System.out.println();

        // ошибка в данных
        System.out.println("Обработка массива с ошибкой в данных.");
        stringArray[2][3] = "g";
        stringArray[3][1] = null;
        System.out.println(arraySummary(stringArray));
        System.out.println();

        // ошибочный блок
        System.out.println("Обработка массива с неверной размерностью.");
        stringArray = new String[3][];
        stringArray[0] = new String[]{"1", "2", "3"};
        stringArray[1] = new String[]{"4", "5", "6"};
        stringArray[2] = new String[]{"7", "8", "9"};
        System.out.println(arraySummary(stringArray));
    }

    private static String arraySummary(String[][] array) {
        try {
            if (array.length != 4) {
                throw new MyArraySizeException("Неверная размерность массива по строкам - " + array.length +
                        ", должна быть - 4");
            }
            for (String[] arrayLine : array) {
                if (arrayLine.length != 4) {
                    throw new MyArraySizeException("Неверная размерность массива по столбцам - " + arrayLine.length +
                            ", должна быть - 4");
                }
            }
        } catch (MyArraySizeException e) {
            return e.toString();
        }
        int result = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                String[] arrayLine = array[i];
                for (int j = 0; j < arrayLine.length; j++) {
                    try {
                        result = result + Integer.parseInt(arrayLine[j]);
                    } catch (RuntimeException e) {
                        StringBuffer stringException = new StringBuffer();
                        stringException.append("Ошибка в ячейке i=" + i);
                        stringException.append(", j=" + j);
                        stringException.append("\n");
                        stringException.append(e.toString());
                        stringException.append("\n");
                        stringException.append("Массив не просуммирован.");
                        throw new MyArrayDataException(stringException.toString());
                    }
                }
            }
        } catch (MyArrayDataException e) {
            return e.toString();
        }
        return "Нормальный блок, сумма массива = " + result;
    }
}
