package spockpv;

/**
 * Class meant to provide static and easy-to-test sudoku board
 *
 * @author  Filip Wiśniewski
 * @see BoardProvider
 */
public class BasicBoardProvider implements BoardProvider {

  @Override
  public Board createBoard() {
    Character[][] initialBoardState = {
        {'1', '2', '3', '4', '5', '6', '0', '8', '9'},
        {'2', '3', '4', '5', '6', '7', '8', '9', '1'},
        {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
        {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
        {'5', '6', '7', '8', '9', '1', '2', '3', '4'},
        {'6', '7', '0', '9', '1', '2', '3', '4', '5'},
        {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
        {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
        {'9', '1', '2', '3', '4', '5', '6', '7', '8'}};
    return new Board(initialBoardState);
  }
}
