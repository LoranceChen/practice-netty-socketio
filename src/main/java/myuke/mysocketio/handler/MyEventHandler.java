package myuke.mysocketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventHandler {
    @OnEvent("GET_LOGIN_EVENT")
    public void iminSwitchToTeacherEvent(SocketIOClient client, AckRequest ackSender, ChatObject chatObject) {
//        Param param = SocketContext.getParam();
//        LessonRoleEnum role = param.getRole();
//        if (role != LessonRoleEnum.TUTOR) return;
//        String userId = param.getUserId();
//        String lessonUID = param.getLessonUID();
//        log.info("录播课助教进入正式课. lessonUID: {}; userId: {}", lessonUID, userId);
//
//        Date currTime = new Date();
//        lessonImitationAssist.scheduleLessonForward(lessonUID, currTime);

        System.out.println("get event: " + ackSender);
        System.out.println("get client: " + client);
        System.out.println("get chatObject: " + chatObject);
        System.out.println("complete");
    }
}
