package com.hepexta.comments;

import com.hepexta.comments.mapper.CommentMapper;
import com.hepexta.comments.model.PictureComment;
import com.hepexta.comments.service.PicCommentService;
import com.hepexta.comments.service.PicCommentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PicCommentServiceTest  {

    private static final long ID = 1L;

    @InjectMocks
    private PicCommentService service = new PicCommentServiceImpl();
    @Mock
    private CommentMapper commentMapper;

    @Test(expected = RuntimeException.class)
    public void insert_null() {
        service.insertComment(null);
    }

    @Test(expected = RuntimeException.class)
    public void insert_empty() {
        service.insertComment(new PictureComment());
    }

    @Test
    public void insert_success() {
        Mockito.doNothing().when(commentMapper).insertComments(Mockito.any());
        PictureComment detail = getPictureComment();
        Assert.assertTrue(service.insertComment(detail));
    }

    @Test(expected = Exception.class)
    public void delete_empty() {
        Mockito.doThrow(Exception.class).when(commentMapper.getCommentById(null));
        service.deleteComment(null);
    }

    @Test
    public void delete_success() {
        Mockito.doNothing().when(commentMapper).deleteComments(Mockito.any());
        Assert.assertTrue(service.deleteComment(ID));
    }

    @Test
    public void getCommentByPictureId_success() {
        List<PictureComment> list = new ArrayList<>();
        list.add(getPictureComment());
        list.add(getPictureComment());
        Mockito.when(commentMapper.getCommentByPictureId(ID)).thenReturn(list);
        Assert.assertEquals(list, service.getCommentByPictureId(ID));
    }

    @Test
    public void getCommentById_success() {
        PictureComment expected = getPictureComment();
        Mockito.when(commentMapper.getCommentById(ID)).thenReturn(expected);
        PictureComment commentById = service.getCommentById(ID);
        Assert.assertNotNull(commentById);
        Assert.assertEquals(expected.getComment(), commentById.getComment());
        Assert.assertEquals(expected.getDate(), commentById.getDate());
        Assert.assertEquals(expected.getId(), commentById.getId());
        Assert.assertEquals(expected.getPictureId(), commentById.getPictureId());
        Assert.assertEquals(expected.getUser(), commentById.getUser());
    }

    @Test(expected = RuntimeException.class)
    public void getCommentById_exception() {
        Mockito.doThrow(RuntimeException.class).when(commentMapper.getCommentById(ID));
        service.getCommentById(ID);
    }

    @Test
    public void getCommentsPage_success() {
        Mockito.when(commentMapper.getAllComments()).thenReturn(new HashMap<>());
        Assert.assertNotNull(service.getCommentsPage());
    }

    private PictureComment getPictureComment() {
        PictureComment detail = new PictureComment();
        detail.setUser("user");
        detail.setPictureId(ID);
        detail.setComment("Comment");
        return detail;
    }
}
