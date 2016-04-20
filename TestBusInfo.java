import java.io.IOException;

public class TestBusInfo {

   public static void main(String[] args) {
   
      String a;
   
      try {
         a = BusInfo.getBusInfo("Vin_Num_001", "Online_Users");
         System.out.println(a);
      } 
      catch (IOException e) {
         System.out.println("IOE");
      }
   }

}