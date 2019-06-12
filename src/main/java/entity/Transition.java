package entity;

public class Transition {
    private long id;
    private int type; // TransactionType (kiểu giao dịch) : 1 Deposit(gửi tiền), 2 Withdraw(rút tiền), 3 Transfer(Chuyển khoản)
    private double amount; // Số tiền
    private String content; // nội dung
    private long senderAccountNumber; // số tài khoản người gửi
    private long receiverAccountNumber; // Số tài khoản người nhận
    private long createdAt; // Ngày tạo transaction
    private long updatedAt; // Ngày update transaction VD: khi chuyển trạng thái transaction;
    private int status; // Trạng thái:  1 PROCESSING(Chờ sử lý), 2 DONE(Hoàn thành), 0 REJECT(Từ chối),-1 DELETED(đã xóa)

    public Transition() {
    }

    public Transition(int type, double amount, String content, long senderAccountNumber, long receiverAccountNumber) {
        long now = System.currentTimeMillis(); // Millisecond hiện tại;
        this.id = now;
        this.type = type;
        this.amount = amount;
        this.content = content;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.createdAt = now;
        this.updatedAt = now;
        this.status = Status.PROCESSING.getStatus();
    }


    public enum TransactionType {
        DEPOSIT(1), WITHDRAW(2), TRANSFER(3);
        int code;

        TransactionType(int code) {
            this.code = code;
        }

        public int getType(){
            return code;
        }

        public static TransactionType findByType(int code){
            for (TransactionType type : TransactionType.values()) {
                if (type.getType() == code) return type;
            }
            return null;
        }
    }


    public enum Status{
        PROCESSING(1), DONE(2), REJECT(0), DELETED(-1);
        int code;

        Status(int code) {
            this.code = code;
        }

        public int getStatus(){
            return code;
        }

        public static Status findByType(int code){
            for (Status status : Status.values()) {
                if (status.getStatus() == code) return status;
            }
            return null;
        }
    }

    public void setStatus(Status status){
        if (status == null) status = Status.DELETED;
        this.status = status.getStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(long senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
