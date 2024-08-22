package org.example;
//1) Завершить реализацию Динамического массива (если не завершили в классе):
//     + clean() - удаляет все элементы
//     + contains(data) - проверяет существует ли элемент
//     + isEmpty() - вернет false, если в структуре есть элемент
//     + создать метод добавления массива данных в конец нашего Динамического массива - addArray(int[] arrAdd)
//     + создать метод удаления элемента по его значению в нашем Динамическом массиве boolean removeValue(int value),
//       который возвращает true, если объект найден и удален, иначе false.
//
//    ++ создать метод добавления массива данных по индексу в наш Динамический массив - addAtArray(int index, int[] arrAdd)

import java.util.Arrays;

public class DynamicIntArray {
    private int[] array;
    private int count; //количество добавленных элементов в массиве
    private int size; //размер нашего массива

    private float increment; // коэф. приращения размера массива

    public DynamicIntArray() {
        size = 5;
        increment = 2;
        array = new int[size];
    }

    public DynamicIntArray(int size, float increment) {
        this.size = size;
        this.increment = increment;
        array = new int[size];
    }

    // добавляет в конец массива
    public void add(int data) {
        if(count == size) {
            growSize();
        }
        array[count] = data;
        count++;
    }

    // добавление элемента в массив по индексу
    public void addAt(int index, int data) {
        if(index > size)
            System.out.println("Индекс не должен быть больше размера массива");

        if(count == size) {
            growSize();
        }

        for (int i = count-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = data;
        count++;
    }

    // удаляем последний элемент массива
    public void remove() {
        array[count-1] = 0;
        count--;
    }

    // удаление по индексу
    public void removeAt(int index) {
        if (count > 0) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1]; // shift all element of right side from given index in left
            }
            array[count - 1] = 0;
            count--;
        }
    }

    //измененние элемента массива
    public void set(int index, int data) {
        if(index < size) {
            array[index] = data;
        }
    }

    // расширям массив
    private void growSize() {
        int nSize = (int) (size * increment);
        int[] temp = new int[nSize];

        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        size = nSize;
    }
    /////////////    Homework    ////////////////

    // удаляет все элементы
    public void clean() {
        count = 0;
        array = new int[size];
    }

    // проверяет, существует ли элемент
    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if(array[i] == data)
                return true;
        }
        return false;
    }

    // isEmpty() - вернет false, если в структуре есть элемент
    public boolean isEmpty() {
        return count == 0;
    }

    // создать метод добавления массива данных в конец нашего Динамического массива - addArray(int[] arrAdd)
    public void addArray(int[] arrAdd) {
        if (count + arrAdd.length > size) {         // если под входящий массив не достаточно мест,
            int newSize = size + arrAdd.length;     // то увеличиваем ёмкость массива на кол-во входящих элементов
            int[] temp = new int[newSize];
            System.arraycopy(array, 0, temp, 0, count);
            System.arraycopy(arrAdd, 0, temp, count, arrAdd.length);
            array = temp;
            size = newSize;
        } else {                      // иначе (если мест хватает) добавляем без увеличения ёмкости массива
            System.arraycopy(arrAdd, 0, array, count, arrAdd.length);
        }
        count += arrAdd.length;
    }

    // создать метод удаления элемента по его значению в нашем Динамическом массиве
    public boolean removeValue(int value) {        // реализовано со сдвигом элементов,
        if (count == 0) {                          // но без изменения size
            return false;
        }
        if (this.contains(value)) {
            int indexToDelete = this.getIndex(value);
            System.arraycopy(array, indexToDelete + 1, array, indexToDelete, count - indexToDelete);
            count--;
            return true;
        }
        return false;
    }

    public int getIndex(int value) {    // метод получения индекса первого найденного элемента
        if (this.contains(value)) {     // (если нет такого - возвращает -1)
            for (int i = 0; i < count; i++)
                if (array[i] == value)
                    return i;
        }
        return -1;
    }

    // метод добавления массива данных по индексу
    public void addAtArray(int index, int[] arrAdd) {
        if (count + arrAdd.length > size) {         // если под входящий массив не достаточно мест,
            int newSize = size + arrAdd.length;     // то увеличиваем ёмкость массива на кол-во входящих элементов
            int[] temp = new int[newSize];
            System.arraycopy(array, 0, temp, 0, index);      // часть исходного массиво до индекса вставки
            System.arraycopy(arrAdd, 0, temp, index, arrAdd.length); // вставляемый массив
            System.arraycopy(array, index, temp, index + arrAdd.length, count - index); // остаток исходного массива
            array = temp;
            size = newSize;
        } else {            // иначе (если мест хватает) добавляем без увеличения ёмкости массива
            System.arraycopy(array, index, array,index + arrAdd.length, count - index);  // сначала сдвигаем остаток исходного на количество добавляемых
            System.arraycopy(arrAdd, 0, array, index, arrAdd.length);                           // добавляем новые элементы
        }
        count += arrAdd.length;
    }

    ///////////////////////////////////////////////


    //печатать массив
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return size;
    }
}
