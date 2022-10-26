package board.boardtest1.controller;

import board.boardtest1.domain.Criteria;
import board.boardtest1.domain.paging.PageMaker;
import board.boardtest1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    // 페이징 테스트
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        model.addAttribute("list", boardService.findListWithPaging(cri));
        model.addAttribute("pageMaker", new PageMaker(boardService.findBoardCount(), cri));
    }
}
