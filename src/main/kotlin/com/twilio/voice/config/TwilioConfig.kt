package com.twilio.voice.config

import com.twilio.Twilio
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class TwilioConfig(
    // retrieve the Twilio Account SID from application.properties
    @Value("\${twilio.account-sid}") val accountSid: String,
    // retrieve Twilio Auth token from application.properties
    @Value("\${twilio.auth-token}") val authToken: String,
    // retrieve the Twilio phone number from application.properties
    @Value("\${twilio.phone-number}") val phoneNumber: String
) {
    @PostConstruct
    fun twilioInit() {
        // initialize Twilio
        Twilio.init(
            accountSid,
            authToken
        )
    }
}