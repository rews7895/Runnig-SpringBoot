package com.insight.board.board.controller;

import com.insight.board.board.dto.BoardDto;
import com.insight.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RestBoardApiController {
    @Autowired
    private BoardService boardService;

    @RequestMapping(value="api/board", method = RequestMethod.GET)
    public List<BoardDto> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }

    @RequestMapping(value = "api/board/write", method = RequestMethod.POST)
    public void insertBoard(@RequestBody BoardDto board) throws Exception {
        boardService.insertBoard(board, null);
    }

    @RequestMapping(value = "api/board/{boardIdx}", method = RequestMethod.GET)
    public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{

        return boardService.selectBoardDetail(boardIdx);
    }

    @RequestMapping(value = "api/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(@RequestBody BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "api/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}
