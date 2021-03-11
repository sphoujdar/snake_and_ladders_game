package snake_and_ladders;


public class GameRunner {
		
		//Player class to maintain state of multiple players
	
		static class player{
			int current_position = 0;
			int turns_played = 0;
			public player(int current_position, int turns_played) {
				super();
				this.current_position = current_position;
				this.turns_played = turns_played;
			}
		}
		
		//Dice Function to generate Roll of Dice
		
		public static int roll_dice() {
			
			int dice_roll = (int) Math.floor(Math.random() * 10) % 6 + 1;
			return dice_roll;
		}
		
	
		//Constants
		public static final int WINNING_POSITION = 100;
		public static final int SNAKE_CONSTANT = 0;
		public static final int NO_PLAY_CONSTANT = 1;
		public static final int LADDER_CONSTANT = 2;
		
		
		public static void main(String[] args) {
			
			player player1 = new player(0,0);
			System.out.printf("Snake and ladders game :\nYou are at position %d.\n", player1.current_position);
			System.out.printf("Dice Roll 1 : %d\n", roll_dice());
			System.out.printf("Dice Roll 2 : %d\n", roll_dice());
			System.out.printf("Dice Roll 3 : %d\n", roll_dice());
			System.out.printf("Dice Roll 4 : %d\n", roll_dice());
			
		}
}
