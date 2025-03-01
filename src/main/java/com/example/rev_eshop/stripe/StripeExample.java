package com.example.rev_eshop.stripe;

import java.util.HashMap;
import java.util.Map;

import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;

public class StripeExample {

    public static void main(String[] args) {
        StripeClient client = new StripeClient(System.getenv("stripe_key"));
        CustomerCreateParams params =
            CustomerCreateParams
                .builder()
                .setDescription("Example description")
                .setEmail("test@example.com")
                .setPaymentMethod("pm_card_visa")  // obtained via Stripe.js
                .build();

        try {
            Customer customer = client.customers().create(params);
            System.out.println(customer);
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}