package com.example

import com.google.inject.Inject
import com.google.inject.Provides
import com.google.inject.name.Named
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule

class ExampleModule : DropwizardAwareModule<ExampleConfiguration>() {
    override fun configure() {
        bootstrap()
    }

    @Provides
    @Inject
    @Named("customMap")
    fun customMap(configuration: ExampleConfiguration) : Map<String, Any>{
        return configuration.customMap
    }
}