//import java.util.LinkedList;
//
//public class Main {
//
//    //inisialisasi linkedlist
//    private LinkedList<String> antrian = new LinkedList<>();
//
//    //method enqueue()
//    public void enqueue(String nama) {
//        antrian.addLast(nama);
//    }
//
//    public String dequeue() {
//        if (antrian.isEmpty()) {
//            return "Antrian kosong!";
//        } else {
//            String nama = antrian.getFirst();
//            antrian.removeFirst();
//            return nama;
//        }
//    }
//
//    public String peek() {
//        if (antrian.isEmpty()) {
//            return "Antrian kosong!";
//        } else {
//            return antrian.getFirst();
//        }
//    }
//
//    public boolean isEmpty() {
//        return antrian.isEmpty();
//    }
//
//    public int size() {
//        return antrian.size();
//    }
//
//    //main method
//    public static void main(String[] args) {
//        Main antrian = new Main();
//
//        //memasukkan data ke antrian
//        antrian.enqueue("Sarah");
//        antrian.enqueue("John");
//        antrian.enqueue("Megan");
//        antrian.enqueue("Mike");
//
//        //mengambil data dari antrian
//        System.out.println(antrian.dequeue()); //Sarah
//        System.out.println(antrian.dequeue()); //John
//
//        //melihat data terdepan pada antrian
//        System.out.println(antrian.peek()); //Megan
//
//        //melihat jumlah data pada antrian
//        System.out.println(antrian.size());
//
//        //mengecek apakah antrian kosong
//        System.out.println(antrian.isEmpty());
//    }
//}

import java.util.Scanner;

public class Kegiatan2 {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Kegiatan2() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return head.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kegiatan2 tiket = new Kegiatan2();

        boolean stop = false;

        while (!stop) {
            System.out.println("Menu : ");
            System.out.println("1. Tambah antrian");
            System.out.println("2. Panggil antrian");
            System.out.println("3. Cek antrian");
            System.out.println("4. Keluar");

            System.out.print("Tiket Wahana Festival ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nomor antrian : ");
                    int nomorAntrian = scanner.nextInt();
                    tiket.enqueue(nomorAntrian);
                    System.out.println("Nomor antrian " + nomorAntrian + " berhasil ditambahkan");
                    break;
                case 2:
                    if (tiket.isEmpty()) {
                        System.out.println("Antrian kosong");
                    } else {
                        int antrian = tiket.dequeue();
                        System.out.println("Antrian " + antrian + " dipanggil");
                    }
                    break;
                case 3:
                    if (tiket.isEmpty()) {
                        System.out.println("Antrian kosong");
                    } else {
                        System.out.println("Jumlah antrian : " + tiket.size());
                        System.out.println("Nomor antrian terdepan : " + tiket.peek());
                    }
                    break;
                case 4:
                    System.out.println("Keluar");
                    stop = true;
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid");
            }

            System.out.println();
        }
    }
}

