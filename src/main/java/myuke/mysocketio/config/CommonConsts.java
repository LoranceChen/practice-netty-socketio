package myuke.mysocketio.config;

public class CommonConsts {

    public static final int DEFAULT_REDIS_EXPIRE = 72;  // 单位：小时

    /** 最大可提前进入课堂的时间 */
    public static final int LESSON_MAX_ADVANCE = 21;  // 单位：分钟
    public static final int LESSON_TRANSCRIBE_MAX_ADVANCE = 6;  // 单位：分钟

    /** 超时强制讲师结课 */
    public static final int LESSON_COMPEL_END_EFFECT = 40;  // 单位：分钟 40
    public static final int LESSON_TRANSCRIBE_COMPEL_END_EFFECT = 90;  // 单位：分钟 90
    /** 超时强制讲师切换至班主任 */
    public static final int LESSON_COMPEL_SWITCH_TUTOR_EFFECT = 30;  // 单位：分钟 30
    /** 超时强制班主任关闭房间 */
    public static final int LESSON_COMPEL_CLOSE_ROOM_EFFECT = 60;  // 单位：分钟 60
    /** 录播课直播强制操作时间偏移 */
    public static final int TRANSCRIBE_LIVE_COMPEL_EFFECT_OFFSET = 30;  // 单位：分钟 30

    public static final int LESSON_END_NOTICE_DELAY = 20;  // 分钟

    public static final int LESSON_DESTROY_DELAY = 3;  // 小时

    public static final int LESSON_RED_PACKET_HALT_DELAY = 62;  // 秒

    public static final int LESSON_SWITCH_TO_TUTOR_DELAY = 10;  // 秒

    /** 准时签到时间 */
    public static final int SIGN_ON_DURATION = 5 * 60 * 1000;  // 5分钟

    public static final int CLAZZ_GOING_STATUS = 2;
    public static final int CLAZZ_END_STATUS = 3;
    public static final int LESSON_GOING_STATUS = 2;
    public static final int LESSON_END_STATUS = 3;

    public static final int EXAM_CORRECT_COIN = 3;
    public static final int EXAM_WRONG_COIN = 1;
    public static final int SIGN_ON_COIN = 5;
    public static final int SIGN_ON_LATE_COIN = 2;

    public static final String DIFF_SEPARATOR = "_";

    public static final String TEST_TOKEN = "zhangmen-bs-token-we##ujjjjs$wefew*&fewf112@@pplsGTE$5";

    public static class ResultCode {
        public final static String SUCCESS = "0";
    }

    public static final int CHAT_CONTENT_LENGTH_LIMIT = 300;  // 聊天消息内容长度限制

    // 即构直播地址
    public static final String ZEGO_RTMP_PUSH_URL = "rtmp://zegopush.zmyouke.com/live/s-windows-{channel}";
    public static final String ZEGO_RTMP_PLAY_URL = "rtmp:///zegoplay.zmyouke.com/live/s-windows-{channel}";
    public static final String ZEGO_HLS_PLAY_URL = "http://zegoplay.zmyouke.com/live/s-windows-{channel}/index.m3u8";
    public static final String ZEGO_FLV_PLAY_URL = "http://zegoplay.zmyouke.com/live/s-windows-{channel}.flv";

    public static final String SERVICE_UNAVAILABLE_MSG = "ZM-UKE-FEIGN-INVOKE_服务接口不可用";

    // 红包发放间隔时间
    public static final int RED_PACKET_GIVE_INTERVAL = 65 * 1000;  // 单位：毫秒

    // 通用掌门用户头像
    public static final String COMMON_AVATAR = "https://web-data.zmlearn.com/image/67fd9a36-b762-456e-aa58-1975e29e28c6.png";

    // 学生聊天消息限流
    public static final int STUDENT_CHAT_LIMIT_PERMIT = 2;

    // 访问痕迹记录限流
    public static final int TRACE_RECORD_LIMIT_PERMIT = 25;

    public static class BuyType {
        public final static int NORMAL = 0;
        public final static int AUDITION = 1;  // 试听
        public final static int BUY_ALL = 2;  // 全部购买
    }

    public static final String BACKGROUND_NAMESPACE = "/mgmt";

    public static int COURSE_LIVE_PLAY_TYPE = 0;
    public static int COURSE_TRANSCRIBE_PLAY_TYPE = 1;

    public static int COURSE_TRANSCRIBE_NOT_FINISH = 0;
    public static int COURSE_TRANSCRIBE_FINISH = 1;

    public static String LOAD_SLIDES_TEMPLET = "[0, 0, -1, \"!load-slides\", [1, 1, 1, \"{docId}\"]]";
    public static String SWITCH_SLIDE_TEMPLET = "[0, 0, -1, \"zmlMessage\", [\"showPage\", {page}]]";

    public static final int LESSON_TRANSCRIBE_LATEST_TIME = 50;

    public static final int LESSON_TRANSCRIBE_DEFAULT_SEQ = 0;

    public static final int TRANSCRIBE_LIVE_PRE_LESSON_INTERVAL = 5 * 60 * 1000;  // 单位：毫秒

    public static final int TRANSCRIBE_LIVE_AFTER_LESSON_INTERVAL = 5 * 60 * 1000;  // 单位：毫秒
}
