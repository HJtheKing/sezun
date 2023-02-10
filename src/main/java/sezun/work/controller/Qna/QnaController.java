package sezun.work.controller.Qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sezun.work.domain.Qna;
import sezun.work.service.QnaService;

import java.util.List;

@Controller
public class QnaController {

    private final QnaService qnaService;

    @Autowired
    public QnaController(QnaService qnaService){
        this.qnaService = qnaService;
    }

    @GetMapping(value = "/qna")
    public String createForm(){
        return "Qna/QnaForm";
    }
    @PostMapping(value = "/qna")
    public String register(QnaForm form){
        Qna qna = new Qna();
        qna.setCorpName(form.getCorpName());
        qna.setName(form.getName());
        qna.setEmail(form.getEmail());
        qna.setContactNum(form.getContactNum());
        qna.setCategory(form.getCategory());
        qna.setSubject(form.getSubject());
        qna.setObject(form.getObject());

        qnaService.register(qna);
        return "redirect:/";
    }
    @GetMapping(value = "/qna/list")
    public String list(Model model){
        List<Qna> list = qnaService.findQna();
        model.addAttribute("Qnas",list);
        return "Qna/QnaList";
    }
}
