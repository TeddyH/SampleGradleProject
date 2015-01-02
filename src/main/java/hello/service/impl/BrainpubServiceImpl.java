package hello.service.impl;

import hello.domain.BrainpubLogin;
import hello.repository.mybatis.mapper.TeddyMapper;
import hello.service.BrainpubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015-01-02.
 */
@Transactional
@Service
public class BrainpubServiceImpl implements BrainpubService {

    private static final Logger logger = LoggerFactory.getLogger(BrainpubServiceImpl.class);

    @Autowired
    private TeddyMapper teddyMapper;

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
