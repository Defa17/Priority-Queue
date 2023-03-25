package task1;

import java.util.ArrayList;
import java.util.Comparator;

class Heap<T> {
    private final ArrayList<T> list;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        list = new ArrayList<>();
    }

    //родительский элемент
    private int parent(int i) {
        if (i == 0) {
            return 0;
        }
        return (i - 1) / 2;
    }

    private void checkHeapDown(int i) {

        // проверка: i и два его потомка на свойство кучи

        // Находим самое большое значение среди
        // корневого, правого и левого дочернего элемента
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if ((left < size()) && (comparator.compare(list.get(left), list.get(largest)) > 0)) {
            largest = left;
        }

        if ((right < size()) && (comparator.compare(list.get(right), list.get(largest)) > 0)) {
            largest = right;
        }

        if (largest != i) {
            T temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            checkHeapDown(largest);
        }
    }

    //проверяем, нарушает ли i и его родитель св-во кучи
    private void checkHeapUp(int i) {
        if ((i > 0) && (comparator.compare(list.get(i), list.get(parent(i))) > 0)) {
            T temp = list.get(i);
            list.set(i, list.get(parent(i)));
            list.set(parent(i), temp);

            checkHeapUp(parent(i));
        }
    }

    //размер
    public int size() {
        return list.size();
    }

    //добавление элемента
    public void add(T num) {
        list.add(num);

        int index = size() - 1;
        checkHeapUp(index);
    }

    //возвращение и удаление элемента, который имеет наибольший приоритет
    public T poll() {
        try {
            if (size() == 0) {
                throw new Exception("Exception: queue is empty");
            }

            T root = list.get(0);

            list.set(0, list.get(size() - 1));
            list.remove(size() - 1);

            checkHeapDown(0);

            return root;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    //верхний элемент
    public T peek() {
        try {
            if (size() == 0) {
                throw new Exception("Exception: queue is empty");
            }
            return list.get(0);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    //очещение очереди
    public void clear() {
        System.out.print("Очещена очередь: ");
        while (!list.isEmpty()) {
            System.out.print(poll() + " ");
        }
        System.out.println();
    }


}
