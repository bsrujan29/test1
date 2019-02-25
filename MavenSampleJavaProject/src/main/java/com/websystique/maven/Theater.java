package com.websystique.maven;



import java.util.HashMap;


public class Theater {
  HashMap<Integer, Seat> theaterSeats = new HashMap<Integer, Seat>();
  int totalSeats;
  int latestAvailableIndex = 0;
  public Theater(int seats) throws Exception {
    if(seats == 0) {
        throw new Exception("need seat number greater than 0");
    }
    this.totalSeats = seats;
    for(int j=0; j< seats; j++){
      this.theaterSeats.put(j, new Seat(j, 1));
    }
  }
  public String bookSeats(SeatHold sh){
    for(int i = sh.start; i<sh.end; i++ ){
      Seat s = (Seat)this.theaterSeats.get(i);
      s.setStatus(0);
    }
    return "BOOKED";
  }
  public int getNumberOfSeatsAvailable() {
    int total = 0;
    for(int j=0; j< this.totalSeats; j++){
      Seat s = (Seat)this.theaterSeats.get(j);
      String status = s.getStatus();
      if(status == "VACANT") {
        total += 1;
      }
    }
    return total;
  }
  public SeatHold holdSeats(int seats, String customerEmail) throws Exception{
    int i = 0;
    if(seats < 0 || seats > this.totalSeats) {
        throw new Exception("column should be in bound");
    }
    SeatHold sh = new SeatHold(this.latestAvailableIndex, this.latestAvailableIndex+seats, customerEmail);
    for(i = this.latestAvailableIndex; i<this.latestAvailableIndex+seats; i++ ){
      Seat s = (Seat)this.theaterSeats.get(i);
      s.setStatus(2);
    }
    this.latestAvailableIndex = i+1;
    return sh; 
  }
  public void releaseSeats(SeatHold sh) {
    for(int i = sh.start; i<sh.end; i++ ){
      Seat s = (Seat)this.theaterSeats.get(i);
      s.setStatus(1);
    }
  }
}