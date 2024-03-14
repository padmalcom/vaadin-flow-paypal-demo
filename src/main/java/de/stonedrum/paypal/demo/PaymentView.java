package de.stonedrum.paypal.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.stonedrum.vaadin.payment.paypal.payment.PaypalPayment;
import de.stonedrum.vaadin.payment.paypal.payment.event.PaymentEvent;

@Route("payment")
public class PaymentView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	private static final String paypalClientId = "AdslctAixBDAXc_ThrRmp3A_mu_Rgt2weiRE0-vObyfoGx-AWBFhDPYIsvgnnrP8oAz4Sliikq8t1o8C";
	private static final float paymentAmount = 2.0f;
	private static final String paymentCurrency = "EUR";
	private static final String sdkCurrency = "EUR";

	private void receivePayment(PaymentEvent paymentEvent) {
		System.out.println("Payment received!" + paymentEvent.getOrderData().getStatus());
	}
	
	public PaymentView() {
		PaypalPayment pp = new PaypalPayment(paypalClientId, paymentAmount, paymentCurrency, sdkCurrency);
		pp.addListener(PaymentEvent.class, this::receivePayment);
		this.add(pp);
	}
}
