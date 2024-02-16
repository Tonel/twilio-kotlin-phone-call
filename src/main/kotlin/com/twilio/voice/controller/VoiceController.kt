package com.twilio.voice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.twilio.voice.service.VoiceService
import com.twilio.voice.data.PhoneCallBody

@RestController
@RequestMapping("/api/v1/voice")
class AlertController(
    @Autowired private val voiceService: VoiceService
) {
    @PostMapping("/make-phone-call")
    fun makePhoneCall(@RequestBody phoneCallBody: PhoneCallBody) {
        voiceService.makePhoneCall(
            phoneCallBody.to
        )
    }
}