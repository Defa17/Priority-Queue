package task1;

import java.util.Comparator;

class Main {
    public static void main(String[] args) {

        // пример на работы на классе Планшеты (таск 10)

        Tablet tablet3 = new Tablet("Oppo", 4, 3, 28000);
        Tablet tablet5 = new Tablet("Xiaomi", 5, 3, 25000);
        Tablet tablet6 = new Tablet("Samsung", 8, 2, 10000);
        Tablet tablet7 = new Tablet("Honor", 3, 4, 30000);
        Tablet tablet8 = new Tablet("Lenovo", 6, 2, 10000);
        Comparator<Tablet> comparator = Comparator.comparing(Tablet::getMemory); //в компараторе задаем приоритет: память
        Heap<Tablet> pq = new Heap<>(comparator);

        pq.add(tablet3);
        pq.add(tablet5);
        pq.add(tablet6);
        pq.add(tablet7);
        pq.add(tablet8);

        System.out.println("Размер: " + pq.size());

        System.out.println("\nPeek: (элемент с наибольшим приоритетом, заданным компаратором)");
        System.out.println(pq.peek());
        System.out.println();
        System.out.println("Poll: (удаление элемента с наибольшим приоритетом) " + pq.poll());

        // peek уменьшится, т к был удален элемент большего приоритета
        System.out.println("\nPeek: ");
        System.out.println(pq.peek());
        System.out.println();

        //очещение очереди
        pq.clear();

    }
}
