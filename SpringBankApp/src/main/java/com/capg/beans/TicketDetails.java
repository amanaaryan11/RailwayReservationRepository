package com.capg.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class TicketDetails {

	private String firstName;
	private String lastName;

	private Integer trainNo;
	private String trainname;
	private String departureStation;
	private String arrivalStation;
	private Date departuredate;
	private Date arrivalDate;
	private String departureTime;
	private String arrivalTime;

	private Integer fare;

}
