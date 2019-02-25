package com.websystique.maven;

import java.util.Scanner; 
import java.util.Timer;   
import java.util.TimerTask; 
import java.io.*;

    class App implements TicketService {
      public static void main(String[] args) throws Exception {
        Theater t = new Theater(50);
        App m = new App();
        Scanner scan =new Scanner(System.in);
        do {
	        System.out.println("Enter your email: ");
	        String Emailid = scan. nextLine();
	        System.out.println("Enter no of Tickets : ");
	        int tickets = Integer.parseInt(scan.nextLine());
	        System.out.println(m.numSeatsAvailable(t));
	        SeatHold s = m.findAndHoldSeats(t, tickets, Emailid);
	        Timer timer = new Timer();
	        String str = m.getInput(timer);
	        if( str.equals("") ){
	          System.out.println( "you input nothing. exit..." );
	          m.releaseSeats(t,s);
	        } else {
	        	timer.cancel();
	        }
	        System.out.println(m.numSeatsAvailable(t));
	        System.out.println("would you like to add more tickets: ");
	        String input = scan. nextLine();
	        if(input.equalsIgnoreCase("y")) {
	            m.findAndHoldSeats(t, tickets, Emailid);
	            System.out.println(m.numSeatsAvailable(t));
	        }  else {
	            	break;
	            }
	        
        } while (true);
        
        
        System.out.println("Your tickets are confirmed and confirmation is sent to your email");
      }
    
      private String str = "";

      

      public String getInput(Timer timer) throws Exception
      {
    	  TimerTask task = new TimerTask()
          {
              public void run()
              {
                if( str.equals("") )
                    {
                        System.out.println( "you input nothing. exit..." );
                    }
              }    
          };
         
          timer.schedule( task, 10*1000 );

          System.out.println( "Input a string within 10 seconds: " );
          BufferedReader in = new BufferedReader(
          new InputStreamReader( System.in ) );
          str = in.readLine();

          timer.cancel();
          System.out.println( "you have entered: "+ str ); 
          return str;
      }
      public int numSeatsAvailable(Theater t){
        return t.getNumberOfSeatsAvailable();
      }
      public SeatHold findAndHoldSeats(Theater t, int numSeats, String customerEmail) throws Exception {
        return t.holdSeats(numSeats, customerEmail);
      } 
      public String reserveSeats(Theater t, SeatHold s, String customerEmail){
        if(s.getCustomerEmail() != customerEmail) {
          return "FAILED";
        }
        return t.bookSeats(s);
      }
      public void releaseSeats(Theater t, SeatHold s){
        t.releaseSeats(s);
      }
    }
    

