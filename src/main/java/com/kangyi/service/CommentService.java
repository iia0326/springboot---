package com.kangyi.service;

import com.kangyi.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
//    Map<String, Object> selectManyByOrderId(Order order);

    Map<String, Object> getPageByOrderId(Long order, Integer pno, Integer psize);

    int insertOne(Comment comment);

    int delectOne(Long commentId);

    Comment selectOneById(Long commentId);

    int updataOneById(Long commentId, Comment comment);

    List<Comment> getMessageByOrserIdList(List<Long> orderIdList, Integer parentRead, String sortField, String sortType, Integer type);

    List<Comment> getMessageByParetId(Long parentId, Integer parentRead, String sortField, String sortType, Integer type, Integer messageType);

    int insertList(List<Comment> commentList);
}
