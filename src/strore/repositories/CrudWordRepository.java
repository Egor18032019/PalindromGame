package strore.repositories;

import dto.UserDto;

import java.util.HashSet;
import java.util.Map;

public interface CrudWordRepository {
    UserDto save(UserDto userDto);

    Map<String, Integer> getAllForStorageScore();

    Map<String, HashSet<String>> getAllForStorageWord();

   void saveAllForStorageWord(Map<String, HashSet<String>> storageWord);
}
