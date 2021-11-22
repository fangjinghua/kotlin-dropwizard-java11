package com.example.resources

import com.example.ExampleConfiguration
import com.example.core.Saying
import com.google.common.base.Optional
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ExampleResourceTest {
    private var configuration = ExampleConfiguration()
    @Before
    fun beforeEach() {
        configuration.template = "Hello, %s!"
        configuration.defaultName = "Stranger"
        configuration.customMap = mapOf(Pair("first", "later!"))
    }

    @Test
    fun testSayHello() {


        run {
            val resource=ExampleResource(configuration)
            val expected= Saying(id = 1, content = "Hello, later!!");
            assertEquals(resource.sayHello(Optional.absent()), expected)
        }
        run {
            val resource=ExampleResource(configuration)
            val expected= Saying(id = 1, content = "Hello, TEST!");
            assertEquals(resource.sayHello(Optional.of("TEST")), expected)
        }
    }


}