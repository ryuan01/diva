import java.util.*;
import java.text.*;

public class DateDemo {
   public static void main(String args[]) {

	  //date -> print 
      Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

      System.out.println("Current Date: " + ft.format(dNow));
      //expect : Current Date: Thu 2016.03.31 at 01:04:01 AM PDT

      //print -> date
      ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss zzz");
      
      String input = "2006-5-1 22:00:00 PDT";
      
      Date t;
      
      try {
    	  t = ft.parse(input);
          System.out.println("Parsed Date: " + t);
      } catch (ParseException e) {
    	  System.err.println(e);
      }
   }
}