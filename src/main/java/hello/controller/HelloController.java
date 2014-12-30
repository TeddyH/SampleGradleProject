package hello.controller;

import hello.domain.BrainpubLogin;
import hello.repository.BrainpubRepository;
import hello.repository.mybatis.mapper.BrainpubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2014-12-29.
 */

@RestController
public class HelloController {

    @Autowired
    private BrainpubRepository brainpubRepository;

    @Autowired
    private BrainpubMapper brainpubMapper;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boots!";
    }

    @RequestMapping("/list")
    public List<BrainpubLogin> list() {

        return brainpubRepository.listDoodleLogins();
    }

    @RequestMapping("/list2")
    public List<BrainpubLogin> list2() {
        return brainpubMapper.listDoodleLogins();
    }
}
