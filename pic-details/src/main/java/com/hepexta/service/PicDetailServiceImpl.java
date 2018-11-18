package com.hepexta.service;

import com.hepexta.mappers.DetailMapper;
import com.hepexta.model.PictureDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PicDetailServiceImpl implements PicDetailService {

	@Autowired
	private DetailMapper detailMapper;

	@Override
	@Transactional
	public boolean insertDetail(PictureDetail detail) {
		boolean result=false;
		try{
			detailMapper.insertDetails(detail);
			result = true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PictureDetail> getDetailsPage() {
		return new ArrayList<>(detailMapper.getAllDetails().values());
	}

	@Override
	public PictureDetail getDetailById(Long id) {
		return detailMapper.getDetailById(id);
	}

	@Override
	public PictureDetail getDetailByTitle(String title) {
		return detailMapper.getDetailByTitle(title);
	}
}
