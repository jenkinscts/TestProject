package com.cts.o2.customer;

/**
 * Created by cts1 on 26/2/14.
 */
public class CustomerVO {

    private int customerId;
    private String firstName;
    private String lastName;
    private String billingAddress;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerVO customerVO = (CustomerVO) o;

        if (customerId != customerVO.customerId) return false;
        if (billingAddress != null ? !billingAddress.equals(customerVO.billingAddress) : customerVO.billingAddress != null)
            return false;
        if (firstName != null ? !firstName.equals(customerVO.firstName) : customerVO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customerVO.lastName) : customerVO.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerVO{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}
