package com.hepexta.comments.mapper;

import com.hepexta.comments.model.PictureComment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {

	public void insertComments(PictureComment detail);
	public void deleteComments(Long id);
	public PictureComment getCommentById(Long id);
	Map<Long, PictureComment> getAllComments();
	List<PictureComment> getCommentByPictureId(Long id);

}