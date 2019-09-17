package com.metacube.metaparking.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {

	public static ModelMapper mapper;

	@Autowired
	public DtoUtils(ModelMapper modelMapper) {
		mapper = modelMapper;
	}

	public static <S, T> T map(S source, Class<T> targetClass) {
		return mapper.map(source, targetClass);
	}

	public static <S, T> void mapTo(S source, T dist) {
		mapper.map(source, dist);
	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		List<T> list = new ArrayList<>();
		for (S s : source) {
			list.add(mapper.map(s, targetClass));
		}
		return list;
	}
}
