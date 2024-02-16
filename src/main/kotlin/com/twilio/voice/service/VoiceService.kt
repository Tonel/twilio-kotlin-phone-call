package com.twilio.voice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.twilio.voice.config.TwilioConfig
import com.twilio.rest.api.v2010.account.Call
import com.twilio.type.PhoneNumber
import java.net.URI

@Service
class VoiceService (
    @Autowired private val twilioConfig: TwilioConfig
)  {
    fun makePhoneCall(
        recipientNumber: String
    ) {
        // initialize the phone number objects
        // of the caller and recipient, respectively
        val to = PhoneNumber(recipientNumber)
        val from = PhoneNumber(twilioConfig.phoneNumber)

        // make a phone call to the specified "To" phone number
        // based on the TwiML instruction bin referenced by the URL
        Call.creator(
            to,
            from,
            URI.create("<URL_TO_YOUR_TWIML_BIN>")
        ).create()
    }
}