package com.callor.memo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.memo.dao.MemoDao;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@Controller
public class HomeController {
    private final MemoDao memoDao;
    private final MemoService memoService;

    public HomeController(MemoDao memoDao, MemoService memoService) {
        this.memoDao = memoDao;
        this.memoService = memoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpSession httpSession, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        return "home";
    }

    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String write(HttpSession httpSession, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        model.addAttribute("action", "/view");
        return "write";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(HttpSession httpSession, Model model, @RequestParam int num) {
    	List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        MemoVO memoVO = memoService.findBySeq(num);
        model.addAttribute("MEMO", memoVO);
        return "view";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String saveMemo(HttpSession httpSession, Model model,
                           @RequestParam String m_title, 
                           @RequestParam String m_memo, 
                           @RequestParam String m_image) {
    	List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        MemoVO memoVO = new MemoVO();
        int lastSeq = memoDao.findLastSeq();
        memoVO.setM_seq(lastSeq + 1);
        memoVO.setM_title(m_title);
        memoVO.setM_author("doSMgochi.dev@gmail.com");
        memoVO.setM_memo(m_memo);
        memoVO.setM_image(m_image);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        memoVO.setM_date(currentDate.format(dateFormatter));
        memoVO.setM_time(currentTime.format(timeFormatter));

        memoDao.insert(memoVO);
        return "redirect:/view?num=" + memoVO.getM_seq();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(MemoVO memoVO, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        model.addAttribute("MV", memoVO);
        int result = memoDao.insert(memoVO);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(int num, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        MemoVO memoVO = memoService.findBySeq(num);
        model.addAttribute("MV", memoVO);
        model.addAttribute("action", "/update");
        return "write";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(MemoVO memoVO, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        if (memoVO.getM_author() == null || memoVO.getM_author().isEmpty()) {
            memoVO.setM_author("doSMgochi.dev@gmail.com"); 
        }
    	memoVO.setM_title(memoVO.getM_title());
        memoVO.setM_memo(memoVO.getM_memo());
        memoVO.setM_image(memoVO.getM_image());
        int result = memoDao.update(memoVO);
        return "redirect:view?num=" + memoVO.getM_seq();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int num, Model model) {
        List<MemoVO> memoList = memoService.selectAll();
        model.addAttribute("MEMO_LIST", memoList);
        int result = memoDao.delete(num);
        return "redirect:/";
    }
}