package com.zero.demo.entity.common;

import com.zero.demo.common.util.EnumUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zero
 * @created 2020/04/13
 */
public enum ErrorCode implements HasIntValue {

    CODE_FOR_TEST(-1), //
    UNKNOWN_CODE(0), //

    // 1-2000，兼容主app主要errorcode
    // 参见kuaishou-common-definition/com.kuaishou.constant.ErrorCode
    SUCCESS(1), //

    OPERATE_TOO_FAST(2), //
    NEED_UPDATE_TO_NEW_CLIENT_VERSION(3), //
    IP_OPERATE_TIMES_OVER_LIMIT(4), //
    FAKE_SUCCESS(5), //

    SERVER_BUSY(10), // 业务层不要直接抛这个异常
    SERVER_ERROR(11), // 业务层不要直接抛这个异常
    REQUEST_METHOD_MUST_POST(12), //
    REQUEST_THROTTLED(13), //

    PARAM_MISSING(20), //
    PARAM_INVALID(21), //
    PARAM_TOO_LONG(24, "输入长度超限"), //

    // user
    USER_NAME_INVALID(100, "名字有不合法字符"), // 字符中有不支持的
    USER_NAME_TOO_LONG(101, "名字太长"), //
    USER_NOT_LOGIN(109, "需要登录才能访问"), //
    USER_NOT_EXIST(110), //
    USER_NAME_ALREADY_EXIST(114, "昵称重复了，换一个吧"), // 重名，或中了敏感词

    FILE_UPLOAD_ERROR(161), // cp from ErrorCode

    // file (ringtone or avatar)
    FILE_IS_EMPTY(200), //
    FILE_TYPE_INVALID(201), //
    FILE_TOO_LARGE(202), //
    FILE_EXT_NULL(203), //
    FILE_EXT_INVALID(204), //
    RINGTONE_NOT_EXIST(205), //
    RINGTONE_CANNOT_DELETE(206), //
    TITLE_INVALID(216, "标题不合法"), //
    DESC_INVALID(228, "描述不合法"), //

    // relation
    RELATION_FOLLOW_SELF(302), //

    // sniff
    VIDEO_URL_NOT_FOUND(2001), //
    VIDEO_URL_EMPTY(2002), //
    INIT_RSA_CRYPTO_HELPER_FAILED(2003), //

    // musicSheet
    MUSIC_SHEET_NOT_EXIST(2021), //
    MUSIC_SHEET_NOT_AUTHOR(2022), //
    MUSIC_SHEET_LIST_MAX_COUNT(2023, "收藏失败，该歌单的歌曲数量已达上限"), //

    // 中台
    CALL_RPC_FAILED(2101), //

    // 其他，一些零散的
    AD_TRACK_FAILED(2201), //
    AD_TRACK_BAD_APP_ID(2202), //

    //activity
    ACTIVITY_PHOTO_NOT_EXIST(3001, "报名失败，您提交的视频已经被删除或隐私"),
    ACTIVITY_PHOTO_URL_INVALID(3002, "您填写的视频链接有误"),
    ACTIVITY_PHOTO_AUTHOR_INVALID(3003, "当前视频作者与您绑定的快手账号不一致"),
    ACTIVITY_PHOTO_CREATE_TIME_INVALID(3004, "任务视频仅支持3天内拍摄的视频"),
    ACTIVITY_PHOTO_COMMIT_REPEATED(3005, "您更换的视频与当前报名所用视频一致，请勿重复提交"),
    ACTIVITY_PHOTO_UPDATE_FAILED(3006, "更新视频失败请重试"),
    ACTIVITY_NOT_BINDING_KWAI(3007, "未绑定快手账号，无法参与活动"),
    ACTIVITY_PHOTO_ALREADY_SETTLE(3008, "任务已经结算，不能修改视频"),
    ACTIVITY_PHOTO_ALREADY_COMMIT(3009, "视频已经提交过，不能再提交"),
    ACTIVITY_NOT_INVITE_JOIN(3010, "未被邀请参加活动"),
    ;

    private int value;
    private String message;

    ErrorCode(int value) {
        this(value, null);
    }

    /**
     *
     * @param value
     * @param message 客户端直接吐给用户的，注意措辞
     */
    ErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    static {
        EnumUtils.checkDuplicate(values(), ErrorCode::getValue);
    }

    @Override
    public int getValue() {
        return value;
    }

    public boolean hasMessage() {
        return StringUtils.isNotEmpty(message);
    }

    public String getMessage() {
        return message;
    }
}
