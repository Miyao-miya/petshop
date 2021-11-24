package com.msyq.psetshop.controller;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.PostToVO;
import com.msyq.psetshop.pojo.PaLike;
import com.msyq.psetshop.pojo.Post;
import com.msyq.psetshop.pojo.PostAnswer;
import com.msyq.psetshop.pojo.PostLike;
import com.msyq.psetshop.service.PaLikeService;
import com.msyq.psetshop.service.PostAnswerService;
import com.msyq.psetshop.service.PostLikeService;
import com.msyq.psetshop.service.PostService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/post")
public class PostContrller {

    @Autowired
    private PostService postService;

    @Autowired
    private PostLikeService postLikeService;

    @Autowired
    private PostAnswerService postAnswerService;

    @Autowired
    private PaLikeService paLikeService;

    //    添加帖子
    @PostMapping("/insert")
    @LogAnnotation(module = "帖子", operator = "添加帖子")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Post post) {
        return postService.insertSelective(post);
    }

    //    修改帖子
    @PostMapping("/updata")
    @LogAnnotation(module = "帖子", operator = "修改帖子")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Post post) {
        return postService.updateByPrimaryKeySelective(post);
    }

    //    删除帖子
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "帖子", operator = "删除帖子")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {

//        删除帖子同步
        if (postService.deleteByPrimaryKey(integer) == 1) {

//            帖子浏览信息同步
            List<PostLike> postLikes = postLikeService.selectAllByFkPId(integer);

            //            帖子评论同步
            postLikeService.deleteByFkPId(integer);
//            帖子评论相关同步
            for (PostLike postLike : postLikes) {
                paLikeService.selectAllByFkPaId(postLike.getPlId());
            }

        }

        return 1;
    }

    //    根据ID查询帖子
    @GetMapping("/select/{i}")
    public PostVO select(@PathVariable("i") Integer integer) {
        return PostToVO.postToVO.postVO(postService.selectByPrimaryKey(integer));
    }

    //    根据标题名查帖子
    @GetMapping("/findall/pname/{i}/{j}/{z}")
    public PageInfo<PostVO> findallName(@PathVariable("i") String str,
                                        @PathVariable("j") Integer page,
                                        @PathVariable("z") Integer size) {
        Post post = new Post();
        post.setPName(str);
        return PostToVO.postToVO.postVOPage(postService.findByAll(post, page, size));
    }


    //    根据话题查询帖子
    @GetMapping("/findall/topic/{i}/{j}/{z}")
    public PageInfo<PostVO> findallTopic(@PathVariable("i") String str,
                                         @PathVariable("j") Integer page,
                                         @PathVariable("z") Integer size) {
        Post post = new Post();
        post.setFkTId(str);
        return PostToVO.postToVO.postVOPage(postService.findByAll(post, page, size));
    }

    //    根据type查询帖子
    @GetMapping("/findall/type/{i}/{j}/{z}")
    public PageInfo<PostVO> findallType(@PathVariable("i") String str,
                                        @PathVariable("j") Integer page,
                                        @PathVariable("z") Integer size) {
        Post post = new Post();
        post.setFkTypeId(str);
        return PostToVO.postToVO.postVOPage(postService.findByAll(post, page, size));
    }

    //    默认分页查询
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<PostVO> listByAll(@PathVariable("i") Integer page,
                                      @PathVariable("j") Integer size) {
        return PostToVO.postToVO.postVOPage(postService.listByAll(page, size));
    }

    //    根据用户 id 查找
    @GetMapping("/findAllByFkUId/{uid}/{i}/{j}")
    public PageInfo<PostVO> findAllByFkUId(@PathVariable("uid") Integer fkUId,
                                           @PathVariable("i") Integer page,
                                           @PathVariable("j") Integer size) {
        return PostToVO.postToVO.postVOPage(postService.findAllByFkUId(fkUId, page, size));
    }

    //    根据发布者 id 以点击数对帖子排序
    @GetMapping("/findAllByFkUIdOrderLike/{uid}/{i}/{j}")
    public PageInfo<PostVO> findAllByFkUIdOrderLike(@PathVariable("uid") Integer fkUId,
                                                    @PathVariable("i") Integer page,
                                                    @PathVariable("j") Integer size) {

        return PostToVO.postToVO.postVOPage(postService.findAllByFkUIdOrderLike(fkUId, page, size));
    }

    //    根据发布者 id 以收藏数对帖子排序
    @GetMapping("/findAllByFkUIdOrderCollect/{uid}/{i}/{j}")
    public PageInfo<PostVO> findAllByFkUIdOrderCollect(@PathVariable("uid") Integer fkUId,
                                                       @PathVariable("i") Integer page,
                                                       @PathVariable("j") Integer size) {
        return PostToVO.postToVO.postVOPage(postService.findAllByFkUIdOrderCollect(fkUId, page, size));

    }


    //    以收藏数对帖子排序
    @GetMapping("/findByAllOrderLike/{i}/{j}")
    public PageInfo<PostVO> findByAllOrderLike(@PathVariable("i") Integer page,
                                               @PathVariable("j") Integer size) {
        return PostToVO.postToVO.postVOPage(postService.findByAllOrderLike(page, size));

    }


}
