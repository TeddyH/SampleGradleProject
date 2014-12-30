package hello.repository.jdbc;

import hello.domain.BrainpubLogin;
import hello.domain.Member;
import hello.repository.BrainpubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2014-12-29.
 */

@Transactional
@Repository
public class BrainpubJdbcRepository implements BrainpubRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BrainpubLogin> listDoodleLogins() {
        // TODO : teddy : BeanPropertyRowMapper 은 성능이 떨어진다고 함.
        // ROWMAPPER 를 구현하여 성능을 올려 준다.
        String query = "SELECT num, id, name, thumb, thumb_sec, ptr FROM doodle_login LIMIT 100 ";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<BrainpubLogin>(BrainpubLogin.class));
    }

    public void createMember(Member member) {

    }
}
