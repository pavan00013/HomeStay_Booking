package Project;

public class Main {
    public static void main(String[] args) {
        RoomDetails room = new RoomDetails("pavan", "Deluxe", 2, 5);
         float totalBill = room.calculateBill();
        if (totalBill != -1) {
            System.out.println("BillId: " + room.getBillId());
            System.out.println("Customer Name: " + room.getCustomerName());
            System.out.println("No. of days of Stay: " + room.getNoOfDaysOfStay());
            System.out.println("Total Bill: " + totalBill);
        }
    }
}
