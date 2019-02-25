package com.websystique.maven;

public interface TicketService {
  int numSeatsAvailable(Theater t);
  SeatHold findAndHoldSeats(Theater t, int numSeats, String customerEmail) throws Exception;
  String reserveSeats(Theater t,SeatHold seatHold, String customerEmail);
}