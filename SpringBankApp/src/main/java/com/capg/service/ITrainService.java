package com.capg.service;

import java.sql.Date;
import java.util.List;

import com.capg.beans.BookingDetails;
import com.capg.beans.TicketDetails;
import com.capg.beans.TrainDetails;
import com.capg.beans.User;


public interface ITrainService {

	TrainDetails addNewTrainDetails(TrainDetails trainobj);

	TrainDetails deleteTrainDetails(Integer trainNo, String departureStation, String arrivalStation);

	User registerUserDetails(User userObj);

	User getUserDetails(Long phoneNumber) ;

	List<User> checkUserExists(Long phoneNumber);

	List<TrainDetails> getTrainsList(String departureStation, String arrivalStation,Date departureDate);

	

	BookingDetails bookTrain(Integer trainNo, Date departureDate, Date arrivalDate,Long phoneNumber) ;

	TicketDetails getBookingDetails(Long pnr);

	Integer checkWalletBalanceExists(Long phoneNumber);





}
