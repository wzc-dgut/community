package dgut.wzc.community.mapper;

import dgut.wzc.community.model.Comment;
import dgut.wzc.community.model.CommentExample;
import dgut.wzc.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}