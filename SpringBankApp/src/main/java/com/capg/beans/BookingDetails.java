package com.capg.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="BOOKING_DETAILS")
public class BookingDetails {
	
	
	
	
	    @SequenceGenerator(name = "PNR", sequenceName = "PNRSequence",allocationSize = 50)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PNR")
		@Id
		private Long pnr;
		private Integer trainId;
		private Long phoneNumber;
		
		
		public BookingDetails() {
			super();
		}
		
		
		public BookingDetails( Integer trainId, Long phoneNumber) {
			super();
			this.trainId = trainId;
			this.phoneNumber = phoneNumber;
		}


		public Long getPnr() {
			return pnr;
		}
		public void setPnr(Long pnr) {
			this.pnr = pnr;
		}
		public Integer getTrainId() {
			return trainId;
		}
		public void setTrainId(Integer trainId) {
			this.trainId = trainId;
		}
		public Long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		@Override
		public String toString() {
			return "BookingDetails [pnr=" + pnr + ", trainId=" + trainId + ", phoneNumber=" + phoneNumber + "]";
		}
		
		
		
		
		
		

}
