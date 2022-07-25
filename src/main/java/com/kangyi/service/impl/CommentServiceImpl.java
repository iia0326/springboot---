package com.kangyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.mapper.CommentMapper;
import com.kangyi.pojo.Comment;
import com.kangyi.pojo.CommentExample;
import com.kangyi.service.CommentService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Map<String, Object> getPageByOrderId(Long orderId, Integer pno, Integer psize) {
        List<Comment>  commentList=null;
        Page<Comment> page = PageHelper.startPage( pno, psize );

//        String key="commentOId:"+orderId;
//        if (redisUtil.exists( key )){
//             commentList = (List<Comment> )redisUtil.get( key );
//             redisUtil.expire( key,24*60*60 );
//        }else {
            CommentExample oe = new CommentExample();
            CommentExample.Criteria criteria = oe.createCriteria();

            criteria.andOrderIdEqualTo( orderId );
            criteria.andMessageTypeNotEqualTo( (byte) 0 );
            oe.setOrderByClause("level desc,"+ChangeChar.camelToUnderline( "createTime", 2 ) + " " + "desc" );
//            oe.setOrderByClause( ChangeChar.camelToUnderline( "createTime", 2 ) + " " + "desc,level desc" );
//            oe.setOrderByClause( ChangeChar.camelToUnderline( "createTime", 2 ) + " " + "desc","level asc " );
             commentList = commentMapper.selectByExample( oe );
//             redisUtil.set( key,commentList,24*60*60 );
//        }

            Map<String, Object> map = new HashMap<>( 3 );

            map.put( "commentList", commentList );
            map.put( "pno", pno );
            map.put( "psize", psize );
            map.put( "count", page.getTotal() );



        return map;
    }

    @Override
    public int insertOne(Comment comment) {

        if (comment.getOrderId()==null){
            return 0;
        }
        int i = commentMapper.insert( comment );

//        String key="commentOId:"+comment.getOrderId();
//        if (redisUtil.exists( key )){
//            List<Comment> commentList = (List<Comment> )redisUtil.get( key );
//            commentList.add( comment );
//            redisUtil.set( key,commentList );
////            System.out.println("list"+commentList);
//
//        }
//        System.out.println("one "+comment);

        return i;
    }

    @Override
    public int delectOne(Long commentId) {

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdEqualTo( commentId );
//        commentMapper.
        Comment comment = selectOneById( commentId );
        int i = commentMapper.deleteByExample( commentExample );
        String key="commentId:"+commentId;
        if (redisUtil.exists( key )){
            redisUtil.del( key );
        }
//        String key="commentOId:"+comment.getOrderId();
//        if (redisUtil.exists( key )){
//            List<Comment> commentList = (List<Comment> )redisUtil.get( key );
//            commentList.remove( comment );
//            redisUtil.set( key,commentList );
//            redisUtil.del( "commentId:"+commentId);
////            System.out.println("list"+commentList);
//
//        }
//        System.out.println("one "+comment);

        return i;
//        return 0;
    }

    @Override
    public Comment selectOneById(Long commentId) {

        String key="commentId:"+commentId;

        if(redisUtil.exists( key )){
            Comment o = (Comment)redisUtil.get( key );
            return o;
        }else {

            CommentExample commentExample = new CommentExample();
            CommentExample.Criteria criteria = commentExample.createCriteria();
            criteria.andCommentIdEqualTo( commentId );
            List<Comment> commentList = commentMapper.selectByExample( commentExample );
            Comment comment = commentList.get( 0 );
            redisUtil.set( key,comment,24*60*60 );
            return comment;
        }
    }

    @Override
    public int updataOneById(Long commentId, Comment comment) {

        Comment comment1 = selectOneById( commentId );
//        comment.setLevel( (byte) level.intValue() );
//        comment.setLevel( new Byte( String.valueOf( level ) ) );
//        String Okey="commentOId:"+comment1.getOrderId();
        String Idkey="commentId:"+commentId;
        if (redisUtil.exists( Idkey )){
            redisUtil.del( Idkey );
        }
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdEqualTo( commentId );


//        if (redisUtil.exists( Okey )){
//            redisUtil.del( Okey );
//        }

        int i = commentMapper.updateByExampleSelective( comment, commentExample );

        return i;
    }

    @Override
    public List<Comment> getMessageByOrserIdList(List<Long> orderIdList, Integer parentRead, String sortField, String sortType, Integer type) {

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();

        if (orderIdList==null||orderIdList.size()<=0){
           return new ArrayList<Comment>( );
        }
        criteria.andOrderIdIn( orderIdList );
        if (parentRead!=-1){
            criteria.andParentReadEqualTo( String.valueOf( parentRead ) );
        }
        if(sortField!=null&&sortField.trim().length()>0){
            commentExample.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

        }

        if (type>1&&type<5){
            criteria.andTypeEqualTo( (byte) type.intValue() );
//            criteria.andTypeEqualTo( new Byte( String.valueOf( type ) ) );
        }
        List<Comment> commentList = commentMapper.selectByExample( commentExample );
        return commentList;
    }

    @Override
    public List<Comment> getMessageByParetId(Long parentId, Integer parentRead, String sortField, String sortType, Integer type, Integer messageType) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();



        if (parentId==null){
          return new ArrayList<Comment>(  );
        }
        criteria.andParentIdEqualTo( parentId );

        if (messageType!=null&&messageType>=0){
            criteria.andMessageTypeEqualTo( (byte) messageType.intValue() );
        }
        if (parentRead!=-1){
            criteria.andParentReadEqualTo( String.valueOf( parentRead ) );
        }
        if (type>1&&type<5){
            criteria.andTypeEqualTo( (byte) type.intValue() );
        }
        if(sortField!=null&&sortField.trim().length()>0){
            commentExample.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType  );

        }
        List<Comment> commentList = commentMapper.selectByExample( commentExample );
        return commentList;
    }

    @Override
    public int insertList(List<Comment> commentList) {
        if(commentList==null){
            return 0;
        }
        int i=commentMapper.insertList(commentList);
        return i;
    }


}
