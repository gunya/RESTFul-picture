package com.hepexta.mappers;

import com.hepexta.model.PictureDetail;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockDetailMapper implements DetailMapper {

    private static Map<Long, PictureDetail> map = new ConcurrentHashMap<>();
    static {
        map.put(1L, setPictureDetails(1L, "Pict 1", "Desc 1"));
        map.put(2L, setPictureDetails(2L, "Pict 2", "Desc 2"));
        map.put(3L, setPictureDetails(3L, "Pict 3", "Desc 3"));
    }

    private static PictureDetail setPictureDetails(Long id, String title, String desc) {
        PictureDetail pictureDetail = new PictureDetail();
        pictureDetail.setId(id);
        pictureDetail.setTitle(title);
        pictureDetail.setDescription(desc);
        return pictureDetail;
    }

    @Override
    public void insertDetails(PictureDetail detail) {
        map.put(detail.getId(), detail);
    }

    @Override
    public PictureDetail getDetailById(Long id) {
        return map.get(id);
    }

    @Override
    public PictureDetail getDetailByTitle(String title) {
        for (PictureDetail pictureDetail : map.values()) {
            if (pictureDetail.getDescription().equals(title)){
                return pictureDetail;
            }
        }
        return null;
    }

    @Override
    public Map<Long, PictureDetail> getAllDetails() {
        return map;
    }
}
