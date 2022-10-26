package board.boardtest1.service;

import board.boardtest1.domain.Criteria;
import board.boardtest1.domain.vo.BoardVO;
import board.boardtest1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;

    public void insertBoard(BoardVO boardVO) {
        boardMapper.insertBoard(boardVO);
    }

    public void updateBoard(Long boardId, BoardVO boardVO) {
        boardMapper.updateBoard(boardId, boardVO);
    }

    public List<BoardVO> findAllBoard() {
        return boardMapper.findBoardList();
    }

    public List<BoardVO> findListWithPaging(Criteria criteria) {
        return boardMapper.findListWithPaging(criteria);
    }

    public int findBoardCount() {
        return boardMapper.findBoardCount();
    }

    public BoardVO findBoardDetail(Long boardId) {
        return boardMapper.findBoardDetail(boardId);
    }

    public void deleteBoard(Long boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
