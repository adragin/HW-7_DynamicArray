package org.example;

import java.util.Arrays;

public class MainDynamicArray {
    public static void main(String[] args) {
        DynamicIntArray array = new DynamicIntArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());
        array.printArray();

        array.add(6);
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());
        array.printArray();

        System.out.println("Add {1,2,3} :");
        array.addArray(new int[]{1, 2, 3});
        array.printArray();
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());
        System.out.println("Ещё раз Add {1,2,3} :");
        array.addArray(new int[]{1, 2, 3});
        array.printArray();
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());

        System.out.println(array.getIndex(6));
        array.printArray();
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());
        int removeValue = 1;
        System.out.println("We are removing >> " + removeValue);
        System.out.println(array.removeValue(removeValue) ? "Удаление произошло" : "Элемент не найден");
        array.printArray();
        System.out.println("We are removing >> " + removeValue);
        System.out.println(array.removeValue(removeValue) ? "Удаление произошло" : "Элемент не найден");
        array.printArray();
        System.out.println("We are removing >> " + removeValue);
        System.out.println(array.removeValue(removeValue) ? "Удаление произошло" : "Элемент не найден");
        array.printArray();
        System.out.println("We are removing >> " + removeValue);
        System.out.println(array.removeValue(removeValue) ? "Удаление произошло" : "Элемент не найден");
        array.printArray();

        System.out.println("Добавим {9,9} c индекса 5 >> ");
        array.addAtArray(5, new int[] {9, 9});
        array.printArray();
        System.out.println("Добавим {7,7} c индекса 0 >> ");
        array.addAtArray(0, new int[] {7, 7});
        array.printArray();
        System.out.println("Добавим {0, 0} c индекса 0 >> ");
        array.addAtArray(0, new int[] {0, 0});
        array.printArray();
        System.out.println("count = "+array.getCount()+" ---- size = "+ array.getSize());
        System.out.println("Добавим {9, 9} c последнего индекса  >> ");
        array.addAtArray(array.getCount(), new int[] {9, 9});
        array.printArray();




//        array.clean();
//        System.out.print("Array после 'clean' >> ");
//        array.printArray();
//        System.out.print("Array пустой? >> ");
//        System.out.println(array.isEmpty());
    }
}
