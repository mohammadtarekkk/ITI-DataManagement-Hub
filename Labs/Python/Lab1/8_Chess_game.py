def create_board():
    return [[0 for x in range(8)] for y in range(8)]

def print_chess_board(board):
    for row in board:
        print(" ".join(str(x) for x in row))
    print()

def get_user_input(queens_placed):
    while True:
        input_str = input(f"Enter the position of queen {queens_placed + 1} (row and column like '12'): ")
        
        if len(input_str) != 2 or not input_str.isdigit():
            print("Invalid input format. Please enter exactly two digits (e.g., '12').")
            continue

        row = int(input_str[0])
        column = int(input_str[1])
        
        if row < 0 or row >= 8 or column < 0 or column >= 8:
            print("Invalid position. Please enter numbers between 0 and 7.")
            continue
            
        return row, column

def mark_attacked_squares(board, row, column):
    # Mark the row
    for j in range(8):
        if board[row][j] == 0:
            board[row][j] = 1
            
    # Mark the column
    for j in range(8):
        if board[j][column] == 0:
            board[j][column] = 1
            
    # Mark the diagonals
    for step in range(8):
        if row + step < 8 and column + step < 8 and board[row + step][column + step] == 0:
            board[row + step][column + step] = 1
        if row - step >= 0 and column - step >= 0 and board[row - step][column - step] == 0:
            board[row - step][column - step] = 1
        if row + step < 8 and column - step >= 0 and board[row + step][column - step] == 0:
            board[row + step][column - step] = 1
        if row - step >= 0 and column + step < 8 and board[row - step][column + step] == 0:
            board[row - step][column + step] = 1

def play_game():
    board = create_board()
    queens_placed = 0

    while queens_placed < 8:
        row, column = get_user_input(queens_placed)

        if board[row][column] == 0:
            # Place the Queen
            board[row][column] = 'Q'
            
            # Mark the board
            mark_attacked_squares(board, row, column)

            # Update game state
            queens_placed += 1
            print_chess_board(board)
        else:
            print("This position is already occupied or under attack. Try another spot.")
            
    print("Congratulations! You successfully placed 8 queens!")

play_game()