// С помощью метода выбора призовой игрушки –
//мы получаем эту призовую игрушку и записываем в список\массив.
// Это список призовых игрушек, которые ожидают выдачи.
// Еще у нас должен быть метод – получения призовой игрушки.
// После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив.
//А эту игрушку записываем в текстовый файл.
// Не забываем уменьшить количество игрушек

import java.util.Scanner;

public class Lottery {

  public static void main(String[] args) {
    Prize store = new Prize();

    Toy toy1 = new Toy("Игрушка 1", 15, 20);
    Toy toy2 = new Toy("Игрушка 2", 15, 25);
    Toy toy3 = new Toy("Игрушка 3", 15, 30);

    store.addToy(toy1);
    store.addToy(toy2);
    store.addToy(toy3);

    store.current_toys_in_store();
    store.changeToyPeriode();

    String continue_flag = "1";
    while (continue_flag.equals("1")) {
      int toy_id = store.organizeRaffle();
      store.getPrizeToy(toy_id);
      store.current_toys_in_store();
      System.out.println(
        "Ещё раз? 1 - да, иной символ - нет"
      );
      Scanner in = new Scanner(System.in);
      continue_flag = in.next();
    }
  }
}
