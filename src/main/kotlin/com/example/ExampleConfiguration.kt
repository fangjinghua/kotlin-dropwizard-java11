package com.example

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class ExampleConfiguration() : Configuration() {
    @JsonProperty("template")
    var template: String=""

    @JsonProperty("defaultName")
    var defaultName: String="Stranger"

    @JsonProperty("customMap")
    var customMap: Map<String, Any> = emptyMap()
}
