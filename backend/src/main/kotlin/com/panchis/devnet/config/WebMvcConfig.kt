package com.panchis.devnet.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        super.addCorsMappings(registry)
        registry.addMapping("/*")
            .allowedOrigins("*")
            // .allowedOriginPatterns("")
            .allowCredentials(false)
            .allowedHeaders("*")
            .exposedHeaders("*")
            .maxAge(60 *30)
            .allowedMethods("*")
    }
}