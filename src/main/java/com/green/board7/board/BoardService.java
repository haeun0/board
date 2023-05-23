package com.green.board7.board;


import com.green.board7.board.model.BoardDetailVo;
import com.green.board7.board.model.BoardDto;
import com.green.board7.board.model.BoardInsDto;
import com.green.board7.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //빈등록하기위해 사용 등록하면 스프링이 자동 객체생성
public class BoardService {
    private final BoardMapper mapper;

    @Autowired//스프링에서 권장하는 DI방법
    public BoardService(BoardMapper mapper){
        this.mapper=mapper;
    }
    public int insBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }
    public int updBoard(BoardDto dto){
        return mapper.updBoard(dto);
    }
    public int delBoard(BoardDto dto){
        return mapper.delBoard(dto);
    }

    public List<BoardVo>selBoardAll(BoardDto dto){
        int num= dto.getPage()-1;
        dto.setStartIdx(num*dto.getRowLen());
        return mapper.selBoardAll(dto);
    }
    public BoardDetailVo selBoardId(BoardDto dto){
        return mapper.selBoardId(dto);
    }
}
