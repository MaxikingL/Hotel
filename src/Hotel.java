

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	private ArrayList<Room> rooms;

	public Hotel() {
		rooms = new ArrayList<>();
		generateRooms();
	}

	private void generateRooms() {
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 4; j++) {
				rooms.add(new Room(i,j));
			}
		}
	}

	private void printSingleRoom(Room room) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Pokój numer:" + room.getRoomNumber() + ", piętro: " + room.getFloor());
		if(room.occupied) sBuilder.append(", zajęty: tak");
		else sBuilder.append(", zajęty: nie");
		if(room.getGuest() != null) sBuilder.append(", gość: " + room.getGuest().getName());
		
		System.out.println(sBuilder.toString());
	}

	public void printAllRooms() {
		for (Room room : rooms) {
			printSingleRoom(room);
		}
	}

	public void printOccupiedRooms() {
		for (Room room : rooms) {
			if (room.occupied == true)
				printSingleRoom(room);
		}
	}

	public void addGuest(Guest guest, int desiredRoomNumber) {
		Scanner scannerSSS = new Scanner(System.in);
		int tempCounter = 0;
		boolean end = false;

		while (!end) {
			if (rooms.get(tempCounter).getRoomNumber() == desiredRoomNumber) {
				rooms.get(tempCounter).guest = guest;
				rooms.get(tempCounter).occupied = true;
				end = true;
			} else if (tempCounter == 30) {
				System.out.println("Pokój zajęty, wybierz inny: "); 
				desiredRoomNumber = scannerSSS.nextInt();
				scannerSSS.nextLine();
				addGuest(guest, desiredRoomNumber);
			} else
				tempCounter++;
		}

	}

	public int fetchRoomNumber(String name) {
		int counter = 0;
		while (true) {
			Guest guestToCheck = rooms.get(counter).getGuest();
			if (guestToCheck != null && guestToCheck.getName().equals(name)) {
				break;
			}
			counter++;
		}
		return counter + 1;
	}
	public void deleteGuest(String name){
		int counter=0;
		while(true){
			Guest deleteGuest = rooms.get(counter).getGuest();
			if(deleteGuest != null && deleteGuest.getName().equals(name)){
				rooms.remove(counter);
				break;
			}
			counter++;
		}

	}
}

