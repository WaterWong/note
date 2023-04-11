package org.open.lang.ms.note.api.module.passport;

import org.soul.ability.security.spring.core.passport.IPassportListener;
import org.soul.base.bean.IEntity;
import org.soul.context.core.CommonContext;
import org.soul.context.core.ContextParam;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class PassportListener implements IPassportListener {

    @Override
    public void requestWithUser(UserDetails userDetails) {
        ContextParam contextParam = CommonContext.get();
        if (userDetails instanceof IEntity entity) {
            contextParam.setUserId(String.valueOf(entity.getId()));
        }
        contextParam.setUsername(userDetails.getUsername());
    }
}
