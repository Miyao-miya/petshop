package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.PhotosToVO;
import com.msyq.psetshop.pojo.Photos;
import com.msyq.psetshop.service.PhotosService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.PhotosVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/photos")
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    //    添加相册
    @PostMapping("/insert")
    @LogAnnotation(module = "相册", operator = "添加相册")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Photos photos) {
        return photosService.insertSelective(photos);
    }

    //    修改相册内容
    @PostMapping("/updata")
    @LogAnnotation(module = "相册", operator = "修改相册")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Photos photos) {
        return photosService.updateByPrimaryKeySelective(photos);
    }

    //    删除相册
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "相册", operator = "删除相册")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return photosService.deleteByPrimaryKey(integer);
    }


    //    更据ID查询相册
    @GetMapping("/select/{i}")
    public PhotosVO select(@PathVariable("i") Integer integer) {
        return PhotosToVO.photosToVO.photosVo(photosService.selectByPrimaryKey(integer));
    }

    //   更据相册名查找相册
    @GetMapping("/fiandallname/{name}/{i}/{j}")
    public PageInfo<PhotosVO> findallName(@PathVariable("name") String name,
                                          @PathVariable("i") Integer page,
                                          @PathVariable("j") Integer size) {
        Photos photos = new Photos();
        photos.setPName(name);
        return PhotosToVO.photosToVO.photosVOPage(photosService.findByAll(photos, page, size));
    }

    //    更据相册标签查找相册
    @GetMapping("/findalltype/{type}/{i}/{j}")
    public PageInfo<PhotosVO> findallType(@PathVariable("type") String type,
                                          @PathVariable("i") Integer page,
                                          @PathVariable("j") Integer size) {
        Photos photos = new Photos();
        photos.setPType(type);
        return PhotosToVO.photosToVO.photosVOPage(photosService.findByAll(photos, page, size));
    }


    //    默认分页查找相册
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<PhotosVO> findall(@PathVariable("i") Integer page,
                                      @PathVariable("j") Integer size) {
        return PhotosToVO.photosToVO.photosVOPage(photosService.listByAll(page, size));
    }

//    根据用户id 查询相册  按发布时间排序
    @GetMapping("/findAllByFkUId/{fkUId}/{i}/{j}")
    public PageInfo<PhotosVO> findAllByFkUId(@PathVariable("fkUId")Integer fkUId,
                                             @PathVariable("i") Integer page,
                                             @PathVariable("j") Integer size){
        return PhotosToVO.photosToVO.photosVOPage(photosService.findAllByFkUId(fkUId, page, size));
    }

    //    根据用户id 查询相册  按收藏数量排序
    @GetMapping("/findAllByFkUIdGroupCollect/{fkUId}/{i}/{j}")
    public PageInfo<PhotosVO> findAllByFkUIdGroupCollect(@PathVariable("fkUId")Integer fkUId,
                                             @PathVariable("i") Integer page,
                                             @PathVariable("j") Integer size){
        return PhotosToVO.photosToVO.photosVOPage(photosService.findAllByFkUIdGroupCollect(fkUId, page, size));
    }

    //    根据用户id 查询相册  按点赞数量排序
    @GetMapping("/findAllByFkUIdGroupLike/{fkUId}/{i}/{j}")
    public PageInfo<PhotosVO> findAllByFkUIdGroupLike(@PathVariable("fkUId")Integer fkUId,
                                                         @PathVariable("i") Integer page,
                                                         @PathVariable("j") Integer size){
        return PhotosToVO.photosToVO.photosVOPage(photosService.findAllByFkUIdGroupLike(fkUId, page, size));
    }

}
