package com.concurrent.test.coding;

public class Anagram {

    public static void main(String[] args) {
        System.out.println('b' - 'a');
        System.out.println("Is Anagram " + isAnagram("are".toLowerCase(), "eAr".toLowerCase()));
//        System.out.println("Is Anagram " + isAnagram("ares", "eart"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    // Alternative solution using character sorting
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        java.util.Arrays.sort(sArr);
        java.util.Arrays.sort(tArr);
        return java.util.Arrays.equals(sArr, tArr);
    }

    // Alternative solution using HashMap
        public static boolean isAnagramMap(String s, String t) {
            if (s.length() != t.length()) return false;
            java.util.Map<Character, Integer> map = new java.util.HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c) || map.get(c) == 0) return false;
                map.put(c, map.get(c) - 1);
            }
            return true;
        }
}
