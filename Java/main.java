package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Java.global.MyFileWriter;
import Java.model.Toy;

import static Java.global.Vars.allToys;
import static Java.global.Vars.winsToys;

public class main {

 public static void Main(String[] args) {

 Toy cat = new Toy(1, "cat", 10, 20);
 Toy dog = new Toy(2, "dog", 3, 5);
 Toy bird = new Toy(3, "bird", 4, 10);
 Toy fish = new Toy(4, "fish", 10, 30);
 Toy spiderman = new Toy(5, "spiderman", 6, 20);
 Toy superman = new Toy(6, "superman", 5, 8);

 addToListWithNewWeight(cat, 5);
 addToListWithNewWeight(dog, 10);
 addToListWithNewWeight(bird, 21);
 addToListWithNewWeight(fish, 7);
 addToListWithNewWeight(spiderman, 45);
 addToListWithNewWeight(superman, 67);

 System.out.println("all toys: ");
 showNewList(allToys);

 List<Toy> addedWinners = selectToyByMinWeight(allToys, 20);
 winsToys.addAll(addedWinners);

 System.out.println("winners list: ");
 showNewList(winsToys);

 Toy givedWinner = selectRandomToy(winsToys);

 winsToys.remove(givedWinner);

 System.out.println("winner for giving: " + givedWinner.info());

 MyFileWriter.writeToy(givedWinner);

    }

 private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
 List<Toy> result = new ArrayList<>();
 for (Toy currentToy : allToys) {
 if (currentToy.getWeight() <= minWeight) {
 result.add(currentToy);
            }
        }
 return result;
    }

 private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
 Random rand = new Random();
 int winnerElement = rand.nextInt(winsToys.size());
 return winsToys.get(winnerElement);
    }

 private static void addToListWithNewWeight(Toy newToy, int newWeight) {
 newToy.setWeight(newWeight);
 allToys.add(newToy);
    }

 private static void showNewList(ArrayList<Toy> myList) {
 int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("toy [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}