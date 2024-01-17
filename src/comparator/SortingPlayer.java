package comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player implements Comparable<Player>{
    private String name;
    private int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    @Override
    public int compareTo(Player player){
        return (int) ((Integer.compare(player.score, this.score) == 0 ? this.name.compareTo(player.name) : Integer.compare(player.score, this.score)));
    }
    
    @Override
    public String toString() {
    	return this.name + " " + this.score;
    }
    
}
public class SortingPlayer {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        List<Player> players = new ArrayList<>();
	        for(int i=0; i < n; i++){
	            players.add(new Player(sc.next(), sc.nextInt()));
	        }
	        
	        players.stream().sorted().forEach(p -> System.out.println(p.toString()));
	}
}
