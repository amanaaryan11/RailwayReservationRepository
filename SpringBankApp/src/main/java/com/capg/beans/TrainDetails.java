package com.capg.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="TRAINS_DETAILS")
public class TrainDetails {

	@SequenceGenerator(name = "TrainId", sequenceName = "TrainIdSequence",allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TrainId")
	@Id
	private Integer trainId;
	private Integer trainNo;
	private String trainname;
	private String departureStation;  
	private	String arrivalStation;
	private Date departuredate;
	private Date  arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private Integer seatAvailable;
	private Integer fare;
	
	public TrainDetails() {
		super();
	}
	

	public TrainDetails(Integer trainNo, String trainname, String departureStation, String arrivalStation,
			Date departuredate, Date arrivalDate, String departureTime, String arrivalTime, Integer seatAvailable,
			Integer fare) {
		super();
		this.trainNo = trainNo;
		this.trainname = trainname;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.departuredate = departuredate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatAvailable = seatAvailable;
		this.fare = fare;
	}


	public TrainDetails(Integer trainId, Integer trainNo, String trainname, String departureStation,
			String arrivalStation, Date departuredate, Date arrivalDate, String departureTime, String arrivalTime,
			Integer seatAvailable, Integer fare) {
		super();
		this.trainId = trainId;
		this.trainNo = trainNo;
		this.trainname = trainname;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.departuredate = departuredate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatAvailable = seatAvailable;
		this.fare = fare;
	}


	public Integer getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public Date getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(Date departuredate) {
		this.departuredate = departuredate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Integer getTrainId() {
		return trainId;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainId=" + trainId + ", trainNo=" + trainNo + ", trainname=" + trainname
				+ ", departureStation=" + departureStation + ", arrivalStation=" + arrivalStation + ", departuredate="
				+ departuredate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", seatAvailable=" + seatAvailable + ", fare=" + fare + "]";
	}
	
	
	
}
