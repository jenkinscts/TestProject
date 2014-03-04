package com.cts.o2.domain;

/**
 * Created by cts1 on 4/3/14.
 */
public class BillingDetails {

    private int sms;
    private int calls;
    private double balance;

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingDetails that = (BillingDetails) o;

        if (Double.compare(that.balance, balance) != 0) return false;
        if (calls != that.calls) return false;
        if (sms != that.sms) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sms;
        result = 31 * result + calls;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BillingDetailsVO{" +
                "sms=" + sms +
                ", calls=" + calls +
                ", balance=" + balance +
                '}';
    }
}
