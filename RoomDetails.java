package Project;

//RoomDetails class
class RoomDetails implements RoomBillComponent {
 private static int counter = 101;
 private int billId;
 private String customerName;
 private String typeOfRoom;
 private int noOfExtraPersons;
 private int noOfDaysOfStay;

 public RoomDetails(String customerName, String typeOfRoom, int noOfExtraPersons, int noOfDaysOfStay) {
     this.billId = counter++;
     this.customerName = customerName;
     this.typeOfRoom = typeOfRoom;
     this.noOfExtraPersons = noOfExtraPersons;
     this.noOfDaysOfStay = noOfDaysOfStay;
 }

 public int getBillId() {
     return billId;
 }

 public String getCustomerName() {
     return customerName;
 }

 public String getTypeOfRoom() {
     return typeOfRoom;
 }

 public int getNoOfExtraPersons() {
     return noOfExtraPersons;
 }

 public int getNoOfDaysOfStay() {
     return noOfDaysOfStay;
 }

 private boolean validateNoOfExtraPerson() {
     return noOfExtraPersons >= 0 && noOfExtraPersons <= 2;
 }

 private boolean validateTypeOfRoom() {
     return typeOfRoom.equals("Standard") || typeOfRoom.equals("Deluxe") || typeOfRoom.equals("Cottage");
 }

 private boolean validateNoOfDaysOfStay() {
     return noOfDaysOfStay >= 1 && noOfDaysOfStay <= 15;
 }

 public float calculateBill() {
     if (!validateTypeOfRoom()) {
         System.out.println("Invalid room type.");
         return -1;
     }

     if (!validateNoOfDaysOfStay()) {
         System.out.println("Invalid number of days of stay.");
         return -1;
     }

     if (!validateNoOfExtraPerson()) {
         System.out.println("Invalid number of extra persons.");
         return -1;
     }

     double baseRoomFare;
     switch (typeOfRoom) {
         case "Standard":
             baseRoomFare = 2500;
             break;
         case "Deluxe":
             baseRoomFare = 3500;
             break;
         case "Cottage":
             baseRoomFare = 5500;
             break;
         default:
             baseRoomFare = 0;
     }

     double totalBill = (noOfDaysOfStay * baseRoomFare) + (noOfDaysOfStay * FOOD_CHARGE) +
             (EXTRA_PERSON_CHARGE * noOfExtraPersons);
     totalBill += TAX * totalBill;

     return (float) totalBill;
 }
}