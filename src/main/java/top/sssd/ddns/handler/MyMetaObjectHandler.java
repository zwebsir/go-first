package top.sssd.ddns.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static top.sssd.ddns.common.constant.DDNSConstant.*;

/**
 * @author sssd
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * FIXME: 2023/3/19 暂未支持用户功能,预留此填充接口
     *
     * @author sssd
     */


    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, CREATE_DATE, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_DATE, LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, CREATOR, Integer.class, 0);
        this.strictInsertFill(metaObject, UPDATER, Integer.class, 0);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,UPDATE_DATE,LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject,UPDATER,Integer.class, 0);
    }
}
