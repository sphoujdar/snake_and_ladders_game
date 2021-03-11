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
		
		public static int player_move(player player_1) {
			
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
			System.out.printf("%s has played %d times. \n\n",player_1.player_name , player_1.turns_played);
			return move_type;
		}
		
	
		//Constants
		public static final int WINNING_POSITION = 100;
		public static final int SNAKE_CONSTANT = 0;
		public static final int NO_PLAY_CONSTANT = 1;
		public static final int LADDER_CONSTANT = 2;
		public static final int MAX_MOVES = 20000;
		
		
		public static void main(String[] args) {
			
			
			// 2 Players playing the game turn by turn
			
			player player1 = new player(0,0,"Shubham");
			player player2 = new player(0,0,"Prince");
			System.out.printf("Snake and ladders game :\n\n");
			
			int which_player_plays = 1;
			
			while(player1.current_position != WINNING_POSITION 
					&& player2.current_position != WINNING_POSITION 
					&& player1.turns_played + player2.turns_played < MAX_MOVES) {
				
					int previous_move_ladder_or_no = 0;
					
					switch(which_player_plays) {
					case 1:
						previous_move_ladder_or_no = player_move(player1);
						break;
					case 2:
						previous_move_ladder_or_no = player_move(player2);
						break;
					
					}
					
					if (previous_move_ladder_or_no != LADDER_CONSTANT && which_player_plays == 1)
						which_player_plays = 2;
					else if (previous_move_ladder_or_no != LADDER_CONSTANT && which_player_plays == 2)
						which_player_plays = 1;
			}
			
			if (player1.turns_played + player2.turns_played == MAX_MOVES) 
					System.out.printf("No player won the Game. Max Moves completed.");
			
		}
}
