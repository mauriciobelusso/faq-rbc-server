package br.edu.utfpr.pb.tcc.util;

public class StringUtil {

	public static Boolean strIn(String str, String[] array) {
		for (String string : array) {
			if (string.equalsIgnoreCase(str))
				return true;
		}
		return false;
	}
}
