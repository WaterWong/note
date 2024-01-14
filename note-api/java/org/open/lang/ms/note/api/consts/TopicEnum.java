package org.open.lang.ms.note.api.consts;


/**
 * 消息主题
 */
public interface TopicEnum {

    //topic root
    String TOPIC = "/topic";

    String DEST = "/app";

    String USER_SIGNUP = "/user/signup"; // 用户注册
    String USER_LOGIN = "/user/login"; // 用户登录
    String ITEM_ADDED = "/item/added"; // 新的词条
    String ITEM_DELETED = "/item/deleted";

}
