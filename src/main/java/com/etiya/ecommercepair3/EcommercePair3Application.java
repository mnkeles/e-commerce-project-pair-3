package com.etiya.ecommercepair3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class EcommercePair3Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommercePair3Application.class, args);
	}

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		// Veritabanı
		// Dosya
		// API
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		// Clientden seçili dili hangi yöntemle almalıyız?
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

		// Dil gönderilmemişse hangi dili baz alayım?
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US); // (new Locale("tr")) şeklinde de kullanabilirsin.

		return acceptHeaderLocaleResolver;
	}

}
