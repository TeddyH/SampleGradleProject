package hello.controller;

import hello.domain.BrainpubLogin;
import hello.service.BrainpubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2014-12-29.
 */

@RestController
public class BrainpubController {

    private static final Logger logger = LoggerFactory.getLogger(BrainpubController.class);

    @Autowired
    private BrainpubService brainpubService;

    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boots!";
    }

    @RequestMapping("/list")
    public List<BrainpubLogin> list() {
        try {
            return brainpubService.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/list2")
    public List<BrainpubLogin> list2() {
        try {
            return brainpubService.list2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/listmapper")
    public BrainpubLogin listmappper() {
        try {
            return brainpubService.listMapper("박하");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/tran")
    public BrainpubLogin tran() {

        BrainpubLogin brainpubLogin = new BrainpubLogin();
        brainpubLogin.setId("bbbbbb");
        brainpubLogin.setName("브레인펍");
        brainpubLogin.setThumb("https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/4252rscbv5M/photo.jpg?sz=50");
        brainpubLogin.setThumb_sec("");
        brainpubLogin.setPtr(0);

        try {
            brainpubService.tran(brainpubLogin);
        } catch (Exception e) {
            logger.info("exception error");
        }
        return brainpubLogin;
    }
}
