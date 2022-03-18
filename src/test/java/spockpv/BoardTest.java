package spockpv;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private BoardProvider provider = new BoardProvider() {
        public Board createBoard() {
            Integer[][] boardState = {
                    { 0, 1 },
                    { 2, 0 }
            };
            return new Board(boardState);
        };
    };
    private final Board underTest = provider.createBoard();

    @Test
    public void testGetCellValue() {
        assertThat(underTest.getCellValue(new Coordinates(0, 0))).isEqualTo(0);
        assertThat(underTest.getCellValue(new Coordinates(1, 0))).isEqualTo(2);
        assertThat(underTest.getCellValue(new Coordinates(0, 1))).isEqualTo(1);
        assertThat(underTest.getCellValue(new Coordinates(1, 1))).isEqualTo(0);
    }

    @Test
    public void testIsCellModifiable() {
        assertThat(underTest.isCellModifiable(new Coordinates(0, 0))).isTrue();
    }

    @Test
    public void testIsNotCellModifiable() {
        assertThat(underTest.isCellModifiable(new Coordinates(1, 0))).isFalse();
    }

    @Test
    public void testSetCellValue() {
        // given
        Coordinates coords = new Coordinates(0, 0);
        Board modifiableBoard = provider.createBoard();
        
        assertThat(modifiableBoard.getCellValue(coords)).isEqualTo(0);
        
        // when
        modifiableBoard.setCellValue(4, coords);
        
        // then
        assertThat(modifiableBoard.getCellValue(coords)).isEqualTo(4);
    }
}
