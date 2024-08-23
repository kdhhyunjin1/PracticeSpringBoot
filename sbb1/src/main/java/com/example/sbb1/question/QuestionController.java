package com.example.sbb1.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
//    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model){
//        List<Question> questionList=this.questionRepository.findAll();
        List<Question> questionList=this.questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }
}
