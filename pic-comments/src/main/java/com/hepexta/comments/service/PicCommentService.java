package com.hepexta.comments.service;

import com.hepexta.comments.model.PictureComment;
import java.util.List;

public interface PicCommentService {
	public boolean insertComment(PictureComment detail);
	public boolean deleteComment(Long id);
	public List<PictureComment> getCommentsPage();
	public List<PictureComment> getCommentByPictureId(Long pictureId);
	public PictureComment getCommentById(Long id);
}
