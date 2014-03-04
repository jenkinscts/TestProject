package com.cts.o2.billing;

/**
 * Created by cts1 on 26/2/14.
 */
public class BillingDetailsVO {

    private int customerId;
    private int sms;
    private double balance;
    private int calls;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCalls() {
        return calls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingDetailsVO that = (BillingDetailsVO) o;

        if (Double.compare(that.balance, balance) != 0) return false;
        if (calls != that.calls) return false;
        if (customerId != that.customerId) return false;
        if (sms != that.sms) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = customerId;
        result = 31 * result + sms;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + calls;
        return result;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }



    @Override
    public String toString() {
        return "BillingDetailsVO{" +
                "customerId=" + customerId +
                ", sms=" + sms +
                ", balance=" + balance +
                ", calls=" + calls +
                '}';
    }
}
