package dgut.wzc.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你所查找的主题不存在，请确认后再次尝试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何主题或评论进行回复"),
    NO_LOGIN(2003,"未登录，请登录后重试"),
    SYS_ERROR(2004,"出现未知错误，请稍后重试"),
    TYPE_PARAM_WRONG(2005,"回复类型错误，或回复不存在"),
    COMMENT_NOT_FOUND(2006,"你回复的评论已不存在"),
    CONTENT_IS_EMPTY(2007,"回复不可为空"),
    READ_NOTIFICATION_FAIL(2008,"错误2008"),
    NOTIFICATION_NOT_FOUND(2009,"错误2009"),
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
