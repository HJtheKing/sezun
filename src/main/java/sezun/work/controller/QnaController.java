package sezun.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import sezun.work.service.QnaService;

public class QnaController {

    private final QnaService qnaService;

    @Autowired
    public QnaController(QnaService qnaService){
        this.qnaService = qnaService;
    }
}
