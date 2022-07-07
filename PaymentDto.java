package com.cg.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.cg.entity.Booking;

@Component
public class PaymentDto {

	private int paymentId;
	
	private String paymentMode;

	private LocalDate paymentDate;

	private Booking booking;

	private String paymentStatus;
	
	public PaymentDto() {};
	public PaymentDto(int paymentId, String paymentMode, LocalDate paymentDate, Booking booking, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.booking = booking;
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentDate=" + paymentDate
				+ ", booking=" + booking + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
