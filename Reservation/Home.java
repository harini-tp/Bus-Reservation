

package Reservation;

import java.util.Scanner; 
import java.util.ArrayList;

public class Home {

	public static void main(String[] args) 
    {
		
	
		ArrayList<Data> buses = new ArrayList<Data>();
		ArrayList<Process> bookings = new ArrayList<Process>();
		
		buses.add(new Data(1,true,2));
		buses.add(new Data(2,false,50));
		buses.add(new Data(3,true,48));
		
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		
		for(Data b:buses) 
        {
			b.displayBusInfo();
		}
		
		while(userOpt==1) 
        {
			System.out.println("Enter 1 to Book and 2 to exit");
			userOpt = scanner.nextInt();
			if(userOpt == 1) {
				Process booking = new Process();
				if(booking.isAvailable(bookings,buses)) 
                {
					bookings.add(booking);
					System.out.println("Your booking is confirmed");
				}
				else
					System.out.println("Sorry. Bus is full. Try another bus or date.");
			}
		}
	}

}