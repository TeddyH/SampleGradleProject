package hello.service;

import hello.domain.BrainpubLogin;

import java.util.List;

/**
 * Created by Administrator on 2015-01-02.
 */
public interface BrainpubService {

    public List<BrainpubLogin> list() throws Exception;

    public List<BrainpubLogin> list2() throws Exception;

    public BrainpubLogin listMapper(String name) throws Exception;

    public void tran(BrainpubLogin brainpubLogin) throws Exception;
}
