package org.example.model.entity;


public class JSONWorkInfo {
    private String date;
    private int cartridgeNameQR;
    private int jobsNameQR;
    private String workerFIO;
    private String serialNumber;
    private int isFinish;

    public int getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCartridgeNameQr() {
        return cartridgeNameQR;
    }

    public void setCartridgeNameQr(int cartridgeNameQr) {
        this.cartridgeNameQR = cartridgeNameQr;
    }

    public int getJobsNameQr() {
        return jobsNameQR;
    }

    public void setJobsNameQr(int jobsNameQr) {
        this.jobsNameQR = jobsNameQr;
    }

    public String getWorkerFIO() {
        return workerFIO;
    }

    public void setWorkerFIO(String workerFIO) {
        this.workerFIO = workerFIO;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "JSONWorkInfo{" +
                "date='" + date + '\'' +
                ", cartridgeNameQR=" + cartridgeNameQR +
                ", jobsNameQR=" + jobsNameQR +
                ", workerFIO='" + workerFIO + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", isFinish=" + isFinish +
                '}';
    }
}