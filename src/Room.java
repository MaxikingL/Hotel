

public class Room{
	Guest guest;
	boolean occupied;
	int floor;
	int roomNumber;
	
	public Room(int floor, int roomNumber) {
		this.guest = null;
		this.occupied = false;
		this.floor = floor;
		this.roomNumber = roomNumber;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public int getFloor() {
		return floor;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
}
