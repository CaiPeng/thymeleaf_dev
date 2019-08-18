package org.professor.blog.controller;

import org.professor.blog.model.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.professor.blog.repository.EsBlogRepository;

import java.util.List;

/**
 * EsBlog 控制器
 */
@RestController
@RequestMapping("/blogs")
public class EsBlogController {

    @Autowired
    private EsBlogRepository mEsBlogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title") String title,
                             @RequestParam(value = "summery") String summery,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<EsBlog> byTitleLikeOrContentLikePage = mEsBlogRepository.findByTitleLikeOrContentLike(title, summery, content, pageable);
        return byTitleLikeOrContentLikePage.getContent();
    }
}
