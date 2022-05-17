package utils;

import service.GameService;

import java.util.HashSet;

public class Utils {
//топот
//а роза упала на лапу Азора

    public static boolean isPalindrom(String word) {
        System.out.println(word);
        int lengthWord = word.length();
        for (int i = 0; i < (lengthWord / 2); ++i) {
            if (word.charAt(i) != word.charAt(lengthWord - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int getScore(String name, String word, GameService gameService) {
//        но один и тот же пользователь не должен получать очки за фразу, которую он уже использовал.
        HashSet<String> wordFromUser = gameService.getStorageWord().get(name);
        int score = 0;
        // есть ли такой юзер
        if (wordFromUser == null) {
            gameService.setStorageWord(name, word);
            score = word.length();
            return score;
        }
        // была эта фраза ?
        boolean isUnicWordFromThisUser = wordFromUser.add(word);
        Integer scoreFromStorageForThisUser = gameService.getStorageScore().get(name);
        if (isUnicWordFromThisUser) {
            score = scoreFromStorageForThisUser + word.length();
            return score;
        } else {
            return scoreFromStorageForThisUser;
        }
    }
}