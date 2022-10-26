package board.boardtest1.mapper;

import board.boardtest1.domain.Criteria;
import board.boardtest1.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    void insertBoard(BoardVO boardVO);

    @Select("SELECT * FROM t_board")
    List<BoardVO> findBoardList();

    List<BoardVO> findListWithPaging(Criteria criteria);

    @Select("SELECT * FROM t_board WHERE board_id = #{boardId}")
    BoardVO findBoardDetail(Long boardId);

    @Select("SELECT COUNT(*) FROM t_board")
    int findBoardCount();

    void updateBoard(@Param("boardId") Long boardId, @Param("boardVO") BoardVO boardVO);

    @Delete("DELETE FROM t_board WHERE board_id = #{boardId}")
    void deleteBoard(Long boardId);



}
