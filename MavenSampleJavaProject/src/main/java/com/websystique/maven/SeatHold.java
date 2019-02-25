package com.websystique.maven;

public class SeatHold {
  int start;
  int end;
  String customerEmail;
  public SeatHold(int start, int end, String customerEmail) {
    this.start = start;
    this.end = end;
    this.customerEmail = customerEmail;
  }
  public String getCustomerEmail(){
    return this.customerEmail;
  }
}
