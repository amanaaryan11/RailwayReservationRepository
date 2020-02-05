package com.capg.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.beans.AccountDetails;
import com.capg.beans.TrainDetails;
@Repository
public interface ITrainRepository extends JpaRepository<TrainDetails, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Trains_Details WHERE TRAIN_NO =?1 and DEPARTURE_STATION =?2 and ARRIVAL_STATION =?3",nativeQuery=true)
	TrainDetails deleteTrain(Integer trainNo, String departureStation, String arrivalStation);

	
	@Query(value = "FROM TrainDetails WHERE departureStation=?1 and arrivalStation=?2 and departureDate=?3")
	List<TrainDetails> findTrainDetails(String departureStation, String arrivalStation,Date departureDate);

    @Query(value = "FROM AccountDetails WHERE phoneNumber = ?1" )
	Double findAccountno(Long accountNumber);

    @Query(value = "FROM AccountDetails WHERE accountNumber = ?1 and poneNumber = ?2", nativeQuery = true)
	AccountDetails depositUpdate(Long accountNumber, Double balance);
    
    @Transactional
	 @Modifying 
    @Query(value = "UPDATE Trains_Details SET SEAT_AVAILABLE =?4 WHERE  TRAIN_NO =?1 and ARRIVAL_DATE =?3 and DEPARTUREDATE =?2", nativeQuery = true)
	void seatUpdate(Integer trainNo, Date departureDate, Date arrivalDate, int seats);

    @Query(value = "SELECT SEAT_AVAILABLE FROM Trains_Details WHERE TRAIN_NO=?1 and ARRIVAL_DATE=?3 and DEPARTUREDATE=?2",nativeQuery = true)
	Integer findSeatAvaiable(Integer trainNo, Date departureDate, Date arrivalDate);

    @Query(value = "SELECT TRAIN_ID FROM Trains_Details WHERE TRAIN_NO=?1 and ARRIVAL_DATE=?3 and DEPARTUREDATE=?2", nativeQuery = true)
	Integer findTrainId(Integer trainNo, Date departureDate, Date arrivalDate);

    @Query(value = "FROM TrainDetails WHERE TRAIN_ID=?1 ")
	TrainDetails findByTrainId(Integer trainId);

    @Query(value = "SELECT FARE FROM Trains_Details WHERE TRAIN_ID=?1",nativeQuery = true)
	int findFareById(int trainId);
    

   
	

}
