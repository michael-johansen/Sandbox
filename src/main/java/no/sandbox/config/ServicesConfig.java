package no.sandbox.config;

import no.sandbox.services.ServicesMarker;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { ServicesMarker.class })
public class ServicesConfig {


}
