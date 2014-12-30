package hello.repository.mybatis.mapper;

import hello.domain.BrainpubLogin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2014-12-30.
 */
public interface BrainpubMapper {

    @Select("SELECT num, id, name, thumb, thumb_sec, ptr FROM doodle_login LIMIT 100 ")
    public List<BrainpubLogin> listDoodleLogins();


}
