package com.hepexta.service;

import com.hepexta.model.PictureDetail;

import java.util.List;

public interface PicDetailService {
	public boolean insertDetail(PictureDetail detail);
	public List<PictureDetail> getDetailsPage();
	public PictureDetail getDetailById(Long id);
	public PictureDetail getDetailByTitle(String title);
}
