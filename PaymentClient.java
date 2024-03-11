//Common Payment Processor Interface
 interface PaymentProcessor {
    void processPayment(double amount);
}


//1
// Represents a hypothetical payment gateway with a specific payment method
class Gateway1 {
    public void processPayment(double amount) {
        System.out.println("Payment initiated through Gateway1 for amount: " + amount);
    }
}
//2
// Represents another payment gateway with a unique authentication step before payment
 class Gateway2 {
    public void authorizePayment() {
        System.out.println("Authentication successful with Gateway2.");
    }

    public void pay(double amount) {
        System.out.println("Payment made through Gateway2 for amount: " + amount);
    }
}
//3
// Represents a different payment gateway with its own method of completing transactions
 class Gateway3 {
    public void makeTransaction(double amount) {
        System.out.println("Transaction completed through Gateway3 for amount: " + amount);
    }
}




//Implement Gateway Adapters

 class Gateway1Adapter implements PaymentProcessor {
    private Gateway1 gateway1;

    public Gateway1Adapter(Gateway1 gateway1) {
        this.gateway1 = gateway1;
    }

    @Override
    public void processPayment(double amount) {
        gateway1.processPayment(amount);
    }
}
//2
 class Gateway2Adapter implements PaymentProcessor {
    private Gateway2 gateway2;

    public Gateway2Adapter(Gateway2 gateway2) {
        this.gateway2 = gateway2;
    }

    @Override
    public void processPayment(double amount) {
        gateway2.authorizePayment();
        gateway2.pay(amount);
    }
}
//3
 class Gateway3Adapter implements PaymentProcessor {
    private Gateway3 gateway3;

    public Gateway3Adapter(Gateway3 gateway3) {
        this.gateway3 = gateway3;
    }

    @Override
    public void processPayment(double amount) {
        gateway3.makeTransaction(amount);
    }
}


//Client Code
public class PaymentClient {
    public static void main(String[] args) {
        PaymentProcessor gatewayAProcessor = new Gateway1Adapter(new Gateway1());
        PaymentProcessor gatewayBProcessor = new Gateway2Adapter(new Gateway2());
        PaymentProcessor gatewayCProcessor = new Gateway3Adapter(new Gateway3());

        gatewayAProcessor.processPayment(100.0);
        gatewayBProcessor.processPayment(200.0);
        gatewayCProcessor.processPayment(300.0);
    }
}
