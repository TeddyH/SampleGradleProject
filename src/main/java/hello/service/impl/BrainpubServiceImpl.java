package hello.service.impl;

import hello.domain.BrainpubLogin;
import hello.repository.mybatis.mapper.BrainpubMapper;
import hello.repository.mybatis.mapper.TeddyMapper;
import hello.service.BrainpubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015-01-02.
 */
@Transactional
@Service
public class BrainpubServiceImpl implements BrainpubService {

    private static final Logger logger = LoggerFactory.getLogger(BrainpubServiceImpl.class);

    @Autowired
    private BrainpubMapper brainpubMapper;

    @Autowired
    private TeddyMapper teddyMapper;

    @Override
    public List<BrainpubLogin> list() throws Exception {
        return brainpubMapper.listDoodleLogins();
    }

    @Override
    public List<BrainpubLogin> list2() throws Exception {
        return brainpubMapper.listDoodleLogins();
    }

    @Override
    public BrainpubLogin listMapper(String name) throws Exception {
        return teddyMapper.selectDoodleLogin(name);
    }

    @Override
    public void tran(BrainpubLogin brainpubLogin) throws Exception {
        try {
            int i = teddyMapper.insertLogin(brainpubLogin);
            logger.info("insertLogin : {}", i);

            i = teddyMapper.insertLogin(brainpubLogin);
            logger.info("insertLogin : {}", i);

            brainpubLogin.setThumb_sec(null);

            i = teddyMapper.insertLogin(brainpubLogin);
            logger.info("insertLogin : {}", i);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
