package board.boardtest1.mapper;

import board.boardtest1.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    void insertBoard(BoardVO boardVO);

    @Select("SELECT * FROM t_board")
    List<BoardVO> findBoardList();

    BoardVO findBoardDetail(Long boardId);

    int findBoardCount();

    void updateBoard(@Param("boardId") Long boardId, @Param("boardVO") BoardVO boardVO);

    void deleteBoard(Long boardId);




}
