package com.example.resources

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.codahale.metrics.annotation.Timed
import com.example.ExampleConfiguration
import com.example.core.Saying
import javax.ws.rs.GET
import com.google.common.base.Optional
import javax.ws.rs.QueryParam
import javax.inject.Inject

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class ExampleResource @Inject constructor(private val configuration: ExampleConfiguration) {

    var counter = AtomicLong()

    @Timed
    @GET
    fun sayHello(@QueryParam("name") name: Optional<String>): Saying {
        val value = java.lang.String.format(configuration.template, name.or(configuration.customMap["first"] as String))
        return Saying(counter.incrementAndGet(), value)
    }
}