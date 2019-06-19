package com.controller;

import com.pojo.Paper;
import com.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program:lunwen
 * @description:
 * @author:Mr.Chen
 * @create:2019-06-15 22:10
 **/

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

//    @RequestMapping("allPaper")
//    public String list(Model model){
//        List<Paper> list = paperService.queryAllPaper();
//        model.addAttribute("list",list);
//        return "allPaper";//allPaper.jsp
//    }

    @RequestMapping("allPaper")
    public ModelAndView list(){
        List<Paper> list = paperService.queryAllPaper();
        ModelAndView view = new ModelAndView("allPaper");//设置url -> allPaper.jsp  相当于view.setViewName("allPaper");
        view.addObject("list",list);
        return view;
    }

//    @RequestMapping("queryById")
//    public String queryById(Model model,long id){
//        Paper paperId = paperService.queryById(id);
//        model.addAttribute("paper01",paperId);
//        return "queryById";
//    }

    @RequestMapping("queryById")
    public ModelAndView queryById(long id){
        Paper paper01 = paperService.queryById(id);
        ModelAndView view = new ModelAndView("queryById");
        view.addObject("paper01",paper01);
        return view;
    }

    //页面跳转，当在列表页中选择 -> 添加时，会跳转addPaper.jsp页面.
    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        return "addPaper";
    }

    //当提交添加的数据时会调用此方法
    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaperById(id);
        return "redirect:/paper/allPaper";
    }

//    @RequestMapping("toUpdatePaper")
//    public String toUpdatePaper(Model model, Long id) {
//        model.addAttribute("paper", paperService.queryById(id));
//        return "updatePaper";
//    }

    @RequestMapping("toUpdatePaper")
    public ModelAndView toUpdatePaper(Long id){
        Paper paper = paperService.queryById(id);
        ModelAndView view = new ModelAndView("updatePaper");
        view.addObject("paper",paper);
        return view;
    }


//    @RequestMapping("/updatePaper")
//    public String updatePaper(Model model, Paper paper) {
//        paperService.updatePaper(paper);
//        paper = paperService.queryById(paper.getPaperId());
//        model.addAttribute("paper", paper);
//        return "redirect:/paper/allPaper";
//    }

    @RequestMapping("/updatePaper")
    public ModelAndView updatePaper(Paper paper){
        paperService.updatePaper(paper);
        ModelAndView view = new ModelAndView("redirect:/paper/allPaper");
        return  view;
    }


}
