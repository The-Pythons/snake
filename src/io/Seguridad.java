package io;

public class Seguridad {
	
	public static String cifra(String cadena){
		String aux="";
		for(int i=0; i < cadena.length(); i++){
			if(cadena.charAt(i) == 'z')
				aux+='a';
			else if(cadena.charAt(i) == 'Z')
					aux+='A';
			else
				aux+=(char)(cadena.charAt(i)+1);
		}
		return aux;
	}

	public static String descifra(String cadena){
		String aux="";
		for(int i=0; i < cadena.length(); i++){
			if(cadena.charAt(i) == 'a')
				aux+='z';
			else if(cadena.charAt(i) == 'A')
					aux+='Z';
			else
				aux+=(char)(cadena.charAt(i)-1);
		}
		return aux;
	}
}
