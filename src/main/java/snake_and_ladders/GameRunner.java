package snake_and_ladders;


public class GameRunner {
		
		//Player class to maintain state of multiple players
	
		static class player{
			int current_position = 0;
			int turns_played = 0;
			String player_name = "Default";
			public player(int current_position, int turns_played, String player_name) {
				super();
				this.current_position = current_position;
				this.turns_played = turns_played;
				this.player_name = player_name;
			}
		}
		
		//Dice Function to generate Roll of Dice
		
		public static int roll_dice() {
			
			int dice_roll = (int) Math.floor(Math.random() * 10) % 6 + 1;
			return dice_roll;
		}
		
		public static void player_move(player player_1) {
			
			int dice_roll = 0;
			int move_type = 3;
			System.out.printf("%s is at position %d.\n",player_1.player_name, player_1.current_position);
			dice_roll=roll_dice();
			move_type = (int) Math.floor(Math.random() * 10) % 3;
			String move_type_string = "Default";
			
			
			//Print What Happened in this move
			switch(move_type) {
					case SNAKE_CONSTANT:
					move_type_string = "Snake";
					break;
					case NO_PLAY_CONSTANT:
					move_type_string = "No Play";
					break;
					case LADDER_CONSTANT:
					move_type_string = "Ladder";
					break;
					
			}
			System.out.printf("%s rolled %d and got a %s move.\n",player_1.player_name , dice_roll, move_type_string);
			
			
			//Update Player Object for what happened during move
			if(move_type == SNAKE_CONSTANT && player_1.current_position - dice_roll > 0)
					player_1.current_position -= dice_roll;
			else if(move_type == SNAKE_CONSTANT && player_1.current_position - dice_roll < 0)
					player_1.current_position = 0 ;
			else if(move_type == LADDER_CONSTANT && player_1.current_position + dice_roll < WINNING_POSITION)
					player_1.current_position += dice_roll;
			
			player_1.turns_played += 1;
			
			//Final Print of player Position
			System.out.printf("%s is at position %d.\n",player_1.player_name , player_1.current_position);
			System.out.printf("%s has played %d times. \n",player_1.player_name , player_1.turns_played);
		}
		
	
		//Constants
		public static final int WINNING_POSITION = 100;
		public static final int SNAKE_CONSTANT = 0;
		public static final int NO_PLAY_CONSTANT = 1;
		public static final int LADDER_CONSTANT = 2;
		
		
		public static void main(String[] args) {
			
			player player1 = new player(0,0,"Shubham");
			System.out.printf("Snake and ladders game :\n\n");
		
			//Now Program will terminate after a player reaches 1 million moves
			while(player1.current_position != WINNING_POSITION && player1.turns_played < 1000000) {
				player_move(player1);
			}
			
			
		}
}
