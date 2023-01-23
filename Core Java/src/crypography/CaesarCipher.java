package crypography;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CaesarCipher {

	public static void main (String[] args) {
		
		//System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
		//System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21,8));
		//System.out.println(decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 14, 24));
		//String s = "Uybi Gfqgykii Jgziegv Uigeixdiex SmiizzinAal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
		
		//for (int i = 1; i <= 26; i++) {
		//	for (int j = 1; j <= 26; j++) {
		//		System.out.println(i + " " + j + " " + decryptTwoKeys(s,i,j));
				
				
				
				
		//	}
		//}
		countcodons("CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC");
		
	}
	
	static String decryptTwoKeys(String s, int a, int b) {
		return encryptTwoKeys(s, 26-a, 26-b);
	}
	
	static String decrypt (String s, int a) {
		return encrypt(s, 26-a);
	}
	
	
	static int mostCommonLength() {
		Scanner scan = new Scanner(System.in);
		String s;
		String [] line;
		int len;
		HashMap<Integer,Integer> hm_wl_cnt = new HashMap<>();
		while (true) {
			
			s = scan.nextLine();
			

			if (s.isBlank()) {continue;}
			if (s.isEmpty()) {continue;}
			if (s == "") {continue;}
			if (s.equals("-1")) {break;}
			
			line = s.split(" ");
			for(String word : line) {

				len = word.length();
				if (!Character.isAlphabetic(word.charAt(word.length()-1))){
					len --;
				}
				if (!Character.isAlphabetic(word.charAt(0))) {
					len --;
				}

				
				if (hm_wl_cnt.containsKey(len)) {
					hm_wl_cnt.put(len, hm_wl_cnt.get(len)+1);
				}else {
					hm_wl_cnt.put(len, 1);
				}
			}
		}
		
		len = 0;
		int ans = 0;
		
		for (int i:hm_wl_cnt.keySet()) {
			if (len < hm_wl_cnt.get(i)) {
				len = hm_wl_cnt.get(i);
				ans = i;
			}
		}
		return ans;
	}
	
	
	static int wordFrequencies() {
		Scanner scan = new Scanner(System.in);
		String s;
		String [] line;
		HashMap<String,Integer> hm_wl_cnt = new HashMap<>();
		while (true) {
			
			s = scan.nextLine().toLowerCase();
			

			if (s.isBlank()) {continue;}
			if (s.isEmpty()) {continue;}
			if (s == "") {continue;}
			if (s.equals("-1")) {break;}
			
			line = s.split(" ");
			for(String word : line) {
				
				if (hm_wl_cnt.containsKey(word)) {
					hm_wl_cnt.put(word, hm_wl_cnt.get(word)+1);
				}else {
					hm_wl_cnt.put(word, 1);
				}
			}
		}
		System.out.println(hm_wl_cnt.toString());
		
		int max = 0;
		String maxval = "";
		for (Map.Entry<String,Integer> entry : hm_wl_cnt.entrySet()) {
			String key;
			int value;
			key = entry.getKey();
			value = entry.getValue();
			if (max < value && key.length() > 0) {
				max = value;
				maxval = key;
			}
			
		}
		
		System.out.println(max + maxval);
		
		return hm_wl_cnt.size();
	}
	
	
	
	static String encrypt (String input, int key) {
		String ans = "";
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
				ans += String.valueOf((char)(((((int)c-65)+key)%26)+65));
				}else {
				ans += String.valueOf((char)(((((int)c-97)+key)%26)+97));
				}
			}else {
				ans += String.valueOf(c);
			}
		}
		return ans;
	}
	
	static String encryptTwoKeys(String input, int key1, int key2) {
		boolean alternate = true;
		String ans = "";
		
		for (char c : input.toCharArray()) {
			if (alternate) {
				ans += encrypt(String.valueOf(c), key1);
				alternate = false;
			}
			else {
				ans += encrypt(String.valueOf(c), key2);
				alternate = true;
			}
		}
		
		return ans;
		
		
	}
	
	
	static int countcodons (String s) {
		HashMap<String,Integer> hm = new HashMap<>();
		
		for (int i= 0; i<s.length()-2; i+=3) {
				
				if (hm.containsKey(s.substring(i,i+3))) {
					hm.put(s.substring(i,i+3), hm.get(s.substring(i,i+3))+1);
				}else {
					hm.put(s.substring(i,i+3), 1);
				}
			}	
			
			

		System.out.println(hm.toString());
		System.out.println(hm.size());
		
		return hm.size();
		
	}
	
	
	
}
