package com.lt.dao;

import java.sql.SQLException;

import com.lt.contants.ModeOfPayment;
import com.lt.contants.NotificationType;

public interface NotificationDao {
	
	/**
	 * Send Notification using SQL commands
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,String paymentMethod,double amount) throws SQLException;
}