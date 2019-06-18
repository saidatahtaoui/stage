package com.spring.step;

import org.springframework.batch.item.file.FlatFileItemReader;


import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.spring.model.Utilisateur;


public class Reader {
	public static FlatFileItemReader<Utilisateur> reader(String path) {
		FlatFileItemReader<Utilisateur> reader = new FlatFileItemReader<Utilisateur>();

		reader.setResource(new ClassPathResource(path));
		reader.setLineMapper(new DefaultLineMapper<Utilisateur>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "name" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Utilisateur>() {
					{
						setTargetType(Utilisateur.class);
					}
				});
			}
		});
		return reader;
	}
}
