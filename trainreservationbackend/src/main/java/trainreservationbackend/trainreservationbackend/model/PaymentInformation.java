package trainreservationbackend.trainreservationbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "paymentinfo")
public class PaymentInformation {

    private int paymentid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    private String cardholdername;
    private int paymentamount;

    public PaymentInformation(){};

    public PaymentInformation(int paymentid, String cardholdername, int paymentamount) {
        this.paymentid = paymentid;
        this.cardholdername = cardholdername;
        this.paymentamount = paymentamount;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public int getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(int paymentamount) {
        this.paymentamount = paymentamount;
    }
}
