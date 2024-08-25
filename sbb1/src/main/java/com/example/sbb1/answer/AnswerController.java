package com.example.sbb1.answer;


import com.example.sbb1.question.Question;
import com.example.sbb1.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}") //POST 방식으로 매핑. GET방식은 URL(header)에 변수를 넣어 호출하기때문에 보안이 취약하지만 POST방식은 body에 변수를 넣어 호출하기 때문에 기본적인 보안이 설정되어있음.
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value = "content") String content) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
