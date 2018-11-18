package com.hepexta.mappers;

import com.hepexta.model.PictureDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface DetailMapper {

	@Insert("INSERT INTO PIC_DETAIL(title, description) VALUES"
			+ "(#{title}, #{description})")
	@Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
	public void insertDetails( PictureDetail detail );

	@Select("SELECT ID as id, TITLE as title, DESCRIPTION as description" + "FROM PIC_DETAIL WHERE id = #{id}")
	public PictureDetail getDetailById( Long id );

	@Select("SELECT ID as id, TITLE as title, DESCRIPTION as description" + "FROM PIC_DETAIL WHERE title = #{title}")
	public PictureDetail getDetailByTitle( String title );

	@Select("select * from PIC_DETAIL ")
	@MapKey("id")
	Map<Long, PictureDetail> getAllDetails();

}