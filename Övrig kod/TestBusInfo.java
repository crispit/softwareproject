import java.io.IOException;

public class TestBusInfo {

   public static void main(String[] args) {

      System.out.println(BusInfo.getAllBusInfo("Vin_Num_001").get("At_Stop"));
      
   }

}