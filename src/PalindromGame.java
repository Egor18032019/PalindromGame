import dto.UserDto;
import service.GameService;
import utils.Utils;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class PalindromGame {

    public static void main(String[] args) throws IOException {
        GameService gameService = new GameService();
        //Игра длится бесконечно
        while (true) {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String name = "";
            while (name.equals("")) {
                System.out.println("Имя участника :");
                name = r.readLine();
            }
            String word = "";
            while (word.equals("")) {
                System.out.println("Ведите палиндром");
                word = r.readLine().trim().replaceAll(" ", "").toLowerCase();
            }

            boolean isPalindrom = Utils.isPalindrom(word);
            if (isPalindrom) {
                // считаем очки(прошлые и новые)
                int score = Utils.getScore(name, word, gameService);
                UserDto userDto = new UserDto(name, score);
                // передаем в сервис.
                // уже в сервисе мы можем прописать логику сохранения в БД
                gameService.save(userDto);
            }
            // тащим из БД всех
            System.out.println("Список участников");
            Map<String, Integer> storageFromUsers = gameService.getStorageScore();

//            на которой бы хранились 5 пользователей с наибольшим количеством очков
//           TODO  хранилось или выводилось бы ? неясно
            // если хранилось то отдельную storage для только 5 ?
            // или вывести просто 5 ?


            Iterator<Map.Entry<String, Integer>> columnIterator = storageFromUsers.entrySet().iterator();
            int numbersOfLeaders = 0;
            while (columnIterator.hasNext() && numbersOfLeaders < 5) {
                Map.Entry<String, Integer> entry = columnIterator.next();
                System.out.println(entry.getKey() + " = " + entry.getValue());
                numbersOfLeaders++;
            }
        }
    }
}
