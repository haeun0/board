package com.green.board7.board;


import com.green.board7.board.model.BoardDetailVo;
import com.green.board7.board.model.BoardDto;
import com.green.board7.board.model.BoardInsDto;
import com.green.board7.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);//int를 넣으면 자신이 영향을 미친 행의 수만큼의 값을 리턴해준다
    List<BoardVo>selBoardAll(BoardDto dto);
    BoardDetailVo selBoardId(BoardDto dto);
    int updBoard(BoardDto dto);
    int delBoard(BoardDto dto);
}
