package test;

import com.Excalibur.blog.App;
import com.Excalibur.blog.dao.*;
import com.Excalibur.blog.entity.*;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class DaoTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ColumnMapper columnMapper;
    @Autowired
    BlogMapper blogMapper;

    @Test
    public void userSelect(){
        User user=new User();
        user.setAdmin((byte) 0);        //条件查Admin用户
        UserExample ex = new UserExample();  
        UserExample.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(user.getAdmin().toString())){
            criteria.andAdminEqualTo(user.getAdmin());
        }
        List<User> userList = userMapper.selectByExample(ex);
        Iterator<User> it=userList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
    @Test  //测标签
    public void tagSelect(){
        Tag tag=new Tag();
        tag.setBlogCount("1");
        TagExample tagExample=new TagExample();
        TagExample.Criteria criteria=tagExample.createCriteria();
        if(StringUtils.isNotBlank(tag.getBlogCount())){
            criteria.andBlogCountEqualTo(tag.getBlogCount());
        }
        List<Tag> tagList = tagMapper.selectByExample(tagExample);
        Iterator<Tag> it=tagList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test   //测评论
    public void CommentSelect(){
        Comment comment=new Comment();
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        List<Comment> comments=commentMapper.selectByExample(commentExample);
        Iterator<Comment> it=comments.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void columnSelect(){
        Column column=new Column();
        ColumnExample columnExample=new ColumnExample();
        List<Column> columns=columnMapper.selectByExample(columnExample);
        Iterator<Column> it=columns.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void blogSelect(){
        Blog blog=new Blog();
        BlogExample blogExample=new BlogExample();
        List<Blog> blogList=blogMapper.selectByExample(blogExample);
        Iterator<Blog> it=blogList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void FindOneBlog(){
        Blog blog = new Blog();
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria=blogExample.createCriteria();
        criteria.andIdEqualTo(11);
        List<Blog> blogs= blogMapper.selectByExampleWithBLOBs(blogExample);
        System.out.println(new  String(blogs.get(0).getContent()));
    }
}



