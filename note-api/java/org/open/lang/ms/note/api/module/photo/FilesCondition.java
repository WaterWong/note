package org.open.lang.ms.note.api.module.photo;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BasePagingModel;

import java.util.List;

@Getter
@Setter
public class FilesCondition extends BasePagingModel {

   private List<Long> tags;

   private List<Long> catalogs;

   public Long getOffset() {
      return Long.valueOf((pageNumber - 1) * pageSize);
   }

   private String createUserId;

}
