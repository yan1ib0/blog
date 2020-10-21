package com.Excalibur.blog.controller;
import com.Excalibur.blog.entity.Comment;
import com.Excalibur.blog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/*
 *
 *      评论   控制器
 *
 */

@RequestMapping("/comment")
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;


    //跳转        <评论   页面>
    @GetMapping("/commentPage")
    public String tagPage(Model model) {
        model.addAttribute("pageInfo", commentService.getCommentPaging(1));
        return "admin/comments";
    }


    @GetMapping("/editTag/{id}")
    public String editTagPage(@PathVariable Integer id, Model model) {
        Comment tag = commentService.getCommentById(id);
        model.addAttribute("tag", tag);
        PageInfo<Comment> pageInfo = commentService.getCommentPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/tag_edit";
    }

    //增加          评论
    @PostMapping("/tagAdd")
    public String tagAdd(Comment tag) {
        int code = commentService.addComment(tag);
        if (code < 1) {
            System.err.println("<<<< :: 添加评论失败 :: >>>>");
        }
        System.out.println("<<<< :: 插入评论成功 :: >>>>  " + code);

        return "redirect:/comment/commentPage";
    }


    //删除           评论
    @DeleteMapping("/delete")
    public String DeleteTag(@RequestParam Integer id, Model model) {
        commentService.delete(id);
        PageInfo<Comment> pageInfo = commentService.getCommentPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/comments::table_refresh";
    }



    @GetMapping("/comments-details/{id}")
    public String Comment(@PathVariable Integer id){

        return  "admin/comments::table_refresh";
    }
    //按条件查 评论 findConditionByComment
    @GetMapping("/findConditionByComment")
    public String findConditionByComment(Integer pageNum, String name, Model model) {
        PageInfo<Comment> pageInfo = commentService.findCondition(pageNum, name);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/comments::table_refresh";
    }
}
