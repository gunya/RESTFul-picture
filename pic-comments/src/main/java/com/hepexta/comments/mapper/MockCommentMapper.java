package com.hepexta.comments.mapper;

import com.hepexta.comments.model.PictureComment;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MockCommentMapper implements CommentMapper{

    private static Map<Long, PictureComment> map = new ConcurrentHashMap<>();
    static {
        map.put(1L, getPictureComment(1L, 1L, "Comment", new Date(), "User 1"));
        map.put(2L, getPictureComment(2L, 1L, "Comment2", new Date(), "User 1"));
        map.put(3L, getPictureComment(3L, 1L, "Comment3", new Date(), "User 3"));
        map.put(4L, getPictureComment(4L, 1L, "Comment4", new Date(), "User 1"));
        map.put(5L, getPictureComment(5L, 2L, "Comment5", new Date(), "User 2"));
        map.put(6L, getPictureComment(6L, 2L, "Comment6", new Date(), "User 2"));
    }

    @Override
    public void insertComments(PictureComment detail) {
        long key = (map.size() + 1);
        if (detail.getId()==null){
            detail.setId(key);
        }
        map.put(key, detail);
    }

    @Override
    public void deleteComments(Long id) {
        map.remove(id);
    }

    @Override
    public PictureComment getCommentById(Long id) {
        return map.get(id);
    }

    @Override
    public Map<Long, PictureComment> getAllComments() {
        return map;
    }

    @Override
    public List<PictureComment> getCommentByPictureId(Long id) {
        return map.values().stream()
                .filter(rec -> rec.getPictureId().equals(id))
                .collect(Collectors.toList());
    }

    private static PictureComment getPictureComment(long id, long pictureId, String commentText, Date date, String user) {
        PictureComment comment = new PictureComment();
        comment.setId(id);
        comment.setPictureId(pictureId);
        comment.setComment(commentText);
        comment.setDate(date);
        comment.setUser(user);
        return comment;
    }
}
