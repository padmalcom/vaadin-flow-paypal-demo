package de.stonedrum.paypal.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.stonedrum.vaadin.payment.paypal.donation.PaypalDonation;
import de.stonedrum.vaadin.payment.paypal.donation.event.DonationEvent;
import de.stonedrum.vaadin.payment.paypal.donation.model.DonationEnvironment;

@Route("donation")
public class DonationView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private void receiveDonation(DonationEvent donationEvent) {
		System.out.println("Donation received!" + donationEvent.getDonationData().getStatus());
	}
	
	public DonationView() {
		PaypalDonation pd = new PaypalDonation("8EP5HGXBJDSPA", DonationEnvironment.SANDBOX);
		pd.addListener(DonationEvent.class, this::receiveDonation);
		this.add(pd);
	}
}
