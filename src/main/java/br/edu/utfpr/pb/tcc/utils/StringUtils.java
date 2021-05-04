package br.edu.utfpr.pb.tcc.utils;

import java.text.Normalizer;

public class StringUtils {
	public String removerAcentos(String a1) {
		return Normalizer.normalize(a1, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
