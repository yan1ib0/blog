package com.Excalibur.blog.controller;
import com.Excalibur.blog.entity.Tag;
import com.Excalibur.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/*
 *
 *      标签   控制器
 *
 */
@RequestMapping("/tag")
@Controller
public class TagController {
    @Autowired
    TagService tagService;


    //跳转        <标签   页面>
    @GetMapping("tagPage")
    public String tagPage(Model model) {
        model.addAttribute("pageInfo", tagService.getTagPaging(1));
        return "admin/tags";
    }

    //跳转        <增加 标签 页面>
    @GetMapping("tagAddPage")
    public String tagAddPage() {
        return "admin/tag_add";
    }

    @GetMapping("/editTag/{id}")
    public String editTagPage(@PathVariable Integer id, Model model) {
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag", tag);
        PageInfo<Tag> pageInfo = tagService.getTagPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/tag_edit";
    }

    //增加          标签
    @PostMapping("/tagAdd")
    public String tagAdd(Tag tag) {
        int code = tagService.addTag(tag);
        if (code < 1) {
            System.err.println("<<<< :: 添加标签失败 :: >>>>");
        }
        System.out.println("<<<< :: 插入标签成功 :: >>>>  " + code);

        return "redirect:/tag/tagPage";
    }


    //删除           标签
    @DeleteMapping("/delTag")
    public String DeleteTag(@RequestParam Integer id, Model model) {
        tagService.deleteTag(id);
        PageInfo<Tag> pageInfo = tagService.getTagPaging(1);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags::table_refresh";
    }


    //修改           标签
    @PostMapping("/tagUpdate")
    public String tagUpdate(Tag tag, Model model) {
        tagService.update(tag);
        PageInfo<Tag> pageInfo = tagService.getTagPaging(1);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/tags";

    }

    //按条件查 标签 findConditionByColumnist
    @GetMapping("/findConditionByTag")
    public String findConditionByTag(Integer pageNum, Tag tag, Model model) {
        PageInfo<Tag> pageInfo = tagService.findCondition(pageNum, tag);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags::table_refresh";
    }
}
