

package Reservation;
import Reservation.Process;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.*;
public class Process 
{
	String passengerName;
	int busNo;
	Date date;
	
	Process()
    {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter bus no: ");
		busNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try 
        {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Process> bookings, ArrayList<Data> buses) 
    {
		int capacity = 0;
		for(Data bus:buses) 
        {
			if(bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		
		int booked = 0;
		for(Process b:bookings) 
        {
			if(b.busNo == busNo && b.date.equals(date)) 
            {
				booked++;
			}
		}
		
		return booked<capacity?true:false;
		
	}
}