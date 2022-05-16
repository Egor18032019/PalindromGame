package service;

import dto.UserDto;
import strore.repositories.WordJpaUserRepository;

import java.util.HashSet;
import java.util.Map;

public class GameService {
    private final WordJpaUserRepository wordJpaUserRepository;

    public GameService() {
        this.wordJpaUserRepository = new WordJpaUserRepository();
    }

    public UserDto save(UserDto user) {
        return wordJpaUserRepository.save(user);
    }

    public Map<String, Integer> getStorageScore() {
        return wordJpaUserRepository.getAllForStorageScore();
    }

    public Map<String, HashSet<String>> getStorageWord() {
        return wordJpaUserRepository.getAllForStorageWord();
    }

    public void setStorageWord(String name, String word) {
        Map<String, HashSet<String>> storageWord = wordJpaUserRepository.getAllForStorageWord();
        HashSet<String> words = storageWord.get(name);
        if (words == null) {
            words = new HashSet<String>();
        }
        words.add(word);
        storageWord.put(name, words);
        wordJpaUserRepository.saveAllForStorageWord(storageWord);
    }
}
