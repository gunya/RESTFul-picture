package com.hepexta.comments.service;

import com.hepexta.comments.mapper.CommentMapper;
import com.hepexta.comments.model.PictureComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PicCommentServiceImpl implements PicCommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean insertComment(PictureComment detail) {
        boolean result=false;
        if (detail.getPictureId() == null){
            throw new RuntimeException("PictureId() == null");
        }
        try{
            commentMapper.insertComments(detail);
            result = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteComment(Long id) {
        boolean result=false;
        try{
            commentMapper.deleteComments(id);
            result = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<PictureComment> getCommentsPage() {
        return new ArrayList<>(commentMapper.getAllComments().values());
    }

    @Override
    public List<PictureComment> getCommentByPictureId(Long pictureId) {
        return commentMapper.getCommentByPictureId(pictureId);
    }

    @Override
    public PictureComment getCommentById(Long id) {
        return commentMapper.getCommentById(id);
    }
}
