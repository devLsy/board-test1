package board.boardtest1.service;

import board.boardtest1.domain.Criteria;
import board.boardtest1.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("등록")
    @Commit
    public void 등록() throws Exception {
        //givin
//        BoardVO boardVO = BoardVO.createBoard("마블", "닥스", "닥터스트레인지");
//        boardService.insertBoard(boardVO);
        for (int i = 0; i < 500; i++) {
            BoardVO boardVO = BoardVO.createBoard(i + "title", i + "content", i + "name");
            boardService.insertBoard(boardVO);
        }
    }

    @Test
    @DisplayName("수정")
    @Commit
    public void 수정() throws Exception {
        BoardVO boardDetail = boardService.findBoardDetail(1L);
        boardDetail.updateBoard("제목_수정", "내용_수정", "이름_수정");
        boardService.updateBoard(boardDetail.getBoardId(), boardDetail);
    }

    @Test
    @DisplayName("삭제")
    @Commit
    public void 삭제() throws Exception {
        boardService.deleteBoard(1L);
    }

    @Test
    @DisplayName("목록")
    @Commit
    public void 목록() throws Exception {
        List<BoardVO> allBoard = boardService.findAllBoard();
        log.info("allBoard: {}", allBoard.toString());
    }

    @Test
    @DisplayName("카운트")
    @Commit
    public void 카운트() throws Exception {
        int boardCount = boardService.findBoardCount();
        log.info("boardCount: " + boardCount);
    }

    @Test
    @DisplayName("상세")
    @Commit
    public void 상세() throws Exception {
        //givin
        BoardVO boardDetail = boardService.findBoardDetail(2L);
        //when
        String title = boardDetail.getTitle();
        //then
        assertThat(title).isEqualTo("마블");
    }
    
    @Test
    @DisplayName("목록페이징")
    @Commit
    public void 목록페이징() throws Exception {
        //givin
        Criteria criteria = new Criteria();
        criteria.setPageNum(1);
        //when
        List<BoardVO> list = boardService.findListWithPaging(criteria);
        //then
    }
}