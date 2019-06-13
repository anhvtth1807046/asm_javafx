package model;

import entity.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionModel {

    public boolean insertTransaction(Transaction transaction){
        try {
            PreparedStatement stt = DbHelper.getConnection()
                    .prepareStatement("insert into `transactions` (`id`, `type`, `amount`, " +
                            "`content`, `senderAccountNumber`, `receiverAccountNumber`, `createdAt`, `updatedAt`, `status`) values " +
                            "(?,?,?,?,?,?,?,?,?)");
            stt.setLong(1, transaction.getId());
            stt.setInt(2, Transaction.TransactionType.findByType(transaction.getType()).getType());
            stt.setDouble(3, transaction.getAmount());
            stt.setString(4, transaction.getContent());
            stt.setLong(5, transaction.getSenderAccountNumber());
            stt.setLong(6, transaction.getReceiverAccountNumber());
            stt.setLong(7, transaction.getCreatedAt());
            stt.setLong(8, transaction.getUpdatedAt());
            stt.setInt(9, Transaction.Status.findByType(transaction.getStatus()).getStatus());
            stt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
