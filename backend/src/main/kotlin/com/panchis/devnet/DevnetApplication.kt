package com.panchis.devnet

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class DevnetApplication: CommandLineRunner {

	var logger: Logger = LoggerFactory.getLogger(DevnetApplication::class.java);

	@Autowired
	private lateinit var env: Environment;

	override fun run(vararg args: String?) {
		logger.debug("{}", env.getProperty("POSTGRES_DB"))
		logger.debug("{}", env.getProperty("POSTGRES_USER"))
		logger.debug("{}", env.getProperty("POSTGRES_PASSWORD"))
	}
}

fun main(args: Array<String>) {
	runApplication<DevnetApplication>(*args)
}
