package com.twilio.voice.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PhoneCallBody(
    @JsonProperty("to")
    val to: String
)