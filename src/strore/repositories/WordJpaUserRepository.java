package strore.repositories;

import dto.UserDto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordJpaUserRepository implements CrudWordRepository {
//    private final WordRepository userRepository;
    /**
     * При проектировании можно предусмотреть дальнейшее расширение, например,
     * подключение какой-нибудь базы данных.
     * Если нужно будет то в этом классе инициализируем подключение
     */
    private static Map<String, Integer> storageScore = new HashMap<String, Integer>();
    private static Map<String, HashSet<String>> storageWord = new HashMap<String, HashSet<String>>();

    public WordJpaUserRepository() {
    }

    @Override
    public UserDto save(UserDto userDto) {
        storageScore.put(userDto.getUsername(), userDto.getScore());

        return userDto;
    }

    @Override
    public Map<String, Integer> getAllForStorageScore() {
        return storageScore;
    }

    @Override
    public Map<String, HashSet<String>> getAllForStorageWord() {
        return storageWord;
    }

    @Override
    public void saveAllForStorageWord(Map<String, HashSet<String>> newstorageWord) {
        storageWord = newstorageWord;
    }
}
