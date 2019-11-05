

import java.util.Scanner;

public class Demo {
    public static void printMenu() {
        System.out.println("Menu: ");
        System.out.println("1 - Dodaj gościa");
        System.out.println("2 - Wydrukuj pokoje");
        System.out.println("3 - wydrukuj zajęte pokoje");
        System.out.println("4 - znajdz pokój po nazwisku");
        System.out.println("5 - wydrukuj menu");
        System.out.println("6 - zakończ");
        System.out.println("7 - usuń gościa");
    }


    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        String name = "";
        int desiredRoomNumber = -1;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerSwitch = new Scanner(System.in);
        boolean end = false;
        int x = 0;

        printMenu();
        while (!end) {
            System.out.println("Wybór: ");
            x = scannerSwitch.nextInt();
            scannerSwitch.nextLine();

            switch (x) {
                case 1:
                    System.out.println("Podaj imię: ");
                    name = scanner.nextLine();
                    System.out.println("Podaj numer pokoju: ");
                    desiredRoomNumber = scanner.nextInt();
                    scanner.nextLine();

                    hotel.addGuest(new Guest(name), desiredRoomNumber);
                    continue;
                case 2:
                    hotel.printAllRooms();
                    continue;
                case 3:
                    hotel.printOccupiedRooms();
                    continue;
                case 4:
                    System.out.println("Podaj nazwisko: ");
                    name = scanner.nextLine();
                    System.out.println(name + " zajmuje pokoj numer " + hotel.fetchRoomNumber(name));
                    continue;
                case 5:
                    printMenu();
                    continue;
                case 6:
                    end = true;
                    scanner.close();
                    scannerSwitch.close();
                    System.out.println("Kończymy");
                    continue;
                case 7:
                    System.out.println("podaj imie");
                    name = scanner.nextLine();
                    hotel.deleteGuest(name);
                    break;

                default:
                    System.err.println("Domyślnie - kontynuacja");
                    continue;
            }
        }

    }
}
