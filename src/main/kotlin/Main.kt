/**
 * Four In A Row Console Code -- Main Class
 * @author Jordan Mayo
 * @date 2/2/2023
 */

val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
    var currentState: Int = GameConstants.PLAYING
    var userInput = ""
    // Game loop
    FIR_board.printBoard()
    do {
        // Accept user move
        println("       Your Move:")
        println("Enter a column number (0 - 5) to make your move")
        userInput = readLine()!!
        FIR_board.setMove(GameConstants.RED, userInput.toInt())
        FIR_board.printBoard()

        // Call getComputerMove
        println("   Computer's Move:")
        val compMove = FIR_board.computerMove
        FIR_board.setMove(GameConstants.BLUE, compMove)
        FIR_board.printBoard()

        // Check for winner
        var winner = FIR_board.checkForWinner()
        if (winner != 0) {
            if (winner == GameConstants.RED) {
                currentState = GameConstants.RED_WON
            } else if (winner == GameConstants.BLUE) {
                currentState = GameConstants.BLUE_WON
            }
        } else {
            var isTie = FIR_board.checkForTie()
            if (isTie == GameConstants.TIE) {
                currentState = GameConstants.TIE
            }
        }

    } while (currentState == GameConstants.PLAYING && userInput != "q")
// Repeat if not game-over

    // Print game end messages in case of Win , Lose or Tie !
    if (currentState == GameConstants.RED_WON) {
        println("Red Player Won!")
    } else if (currentState == GameConstants.BLUE_WON) {
        println("Blue Player Won!")
    } else if (currentState == GameConstants.TIE) {
        println("Tie Game!")
    }
}