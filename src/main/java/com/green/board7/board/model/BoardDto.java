package com.green.board7.board.model;


import lombok.Data;

@Data
public class BoardDto extends BoardEntity { //Entity 상속

   private int page;
   private int startIdx;
   private int rowLen;

}
