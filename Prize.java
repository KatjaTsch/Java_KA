import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prize {

  public ArrayList<Toy> getToys() {
    return toys;
  }

  public ArrayList<Toy> getPrizeToys() {
    return prizeToys;
  }

  public String getPrizeFile() {
    return prizeFile;
  }

  private final ArrayList<Toy> toys;
  private final ArrayList<Toy> prizeToys;
  private final String prizeFile;

  public Prize() {
    toys = new ArrayList<Toy>();
    prizeToys = new ArrayList<Toy>();
    prizeFile = "prize_toys.txt";
  }

  public void addToy(Toy toy) {
    toys.add(toy);
  }

  public void changeToyPeriode() {
    ArrayList<Double> freq = new ArrayList<Double>(toys.size());
    int index = 0;
    for (Toy toy : toys) {
      Scanner in = new Scanner(System.in);
      System.out.printf(
        "Введите частоту выпадения игрушки %s\n",
        toy.getName()
      );
      freq.add(in.nextDouble());
    }
    int freq_sum = freq.stream().mapToInt(Double::intValue).sum();
    for (int i = 0; i < toys.size(); i++) {
      freq.set(i, freq.get(i) / freq_sum);
    }
    for (Toy toy : toys) {
      toy.setPeriode((Double) freq.get(index++));
    }
  }

  public int organizeRaffle() {
    ArrayList<Double> chance = new ArrayList<Double>(toys.size());
    prizeToys.clear();

    for (Toy toy : toys) {
      double random = Math.random() * 100;
      chance.add(random * toy.getPeriode());
    }

    Double max_chance = Collections.max(chance);
    System.out.println(chance);
    System.out.println(max_chance);
    for (Toy toy : toys) {
      if (toy.getId() == chance.indexOf(max_chance)) {
        System.out.printf("Выпала игрушка: %s\n", toy.getName());
        return toy.getId();
      }
    }
    return 0;
  }

  public void getPrizeToy(int toy_id) {
    if (toys.get(toy_id).getValue() != 0) {
      toys.get(toy_id).setValue(toys.get(toy_id).getValue() - 1);
      try {
        FileWriter writer = new FileWriter(prizeFile, true);
        writer.write(toys.get(toy_id).getName() + "\n");
        writer.close();
      } catch (IOException e) {
        System.out.println("Ошибка при записи в файл игрушки");
      }
    } else {
      System.out.println("Игрушки закончились");
    }
  }

  public void current_toys_in_store() {
    System.out.println("Информация по игрушкам: ");
    for (Toy toy : toys) System.out.println(toy.toString());
  }
}
