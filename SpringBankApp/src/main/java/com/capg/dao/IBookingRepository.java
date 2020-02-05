package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.beans.BookingDetails;
@Repository
public interface IBookingRepository extends JpaRepository<BookingDetails,Long> {
	
	@Query("Select trainId from BookingDetails WHERE pnr=?1 ")
	Integer findTrainIdByPnr(Long pnr);

	@Query("Select phoneNumber from BookingDetails WHERE pnr=?1 ")
	Long findPhoneNumberByPnr(Long pnr);
	
	
}
