package com.misfat.qrqc.configuration;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class DozerMapperConfiguration.
 */
@Configuration
public class DozerMapperConfiguration {

	/**
	 * Gets the dozer mapper.
	 *
	 * @return the dozer mapper
	 */
	@Bean
	public Mapper getDozerMapper() {

		return new DozerBeanMapper(Arrays.asList("dozer-configration-mapping.xml"));
	}
}
