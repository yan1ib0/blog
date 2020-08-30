package test;

import com.Excalibur.blog.App;
import com.Excalibur.blog.dao.UserMapper;
import com.Excalibur.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class DaoTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void userselect(){
        User user=userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
