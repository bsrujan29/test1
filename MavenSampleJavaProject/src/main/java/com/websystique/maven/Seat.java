package com.websystique.maven;
import java.util.HashMap;

public class Seat {
  HashMap statusEnum = new HashMap<Integer, String>();
  int seatNum;
  String status;
  public Seat(int seatNum,int status) {
    this.statusEnum.put(0, "OCCUPIED");
    this.statusEnum.put(1, "VACANT");
    this.statusEnum.put(2, "PENDING");
    this.seatNum = seatNum;
    this.status = (String)this.statusEnum.get(status);
  }
  public String getStatus(){
    return this.status;
  }
  public void setStatus(int status){
    this.status = (String)this.statusEnum.get(status);
  }
}