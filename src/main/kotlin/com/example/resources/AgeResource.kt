package com.example.resources

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.codahale.metrics.annotation.Timed
import com.example.core.Age
import javax.ws.rs.GET
import javax.ws.rs.QueryParam

@Path("/")
class AgeResource {

    var counter = AtomicLong()

    @Timed
    @Path("/age")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    fun getAge(@QueryParam("name") name: String?): Age {
        return Age(name = name!!, count= counter.toInt(), age = kotlin.math.abs(name.hashCode() % 50))
    }

    @Timed
    @Path("/simple_string")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    fun getString(@QueryParam("name") name: String?): String {
        return "Awesome!"
    }
}