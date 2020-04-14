package id.dondon.netty.entities;

import id.dondon.netty.entities.constant.BaseFields;
import java.io.Serializable;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@ToString
public class Base implements Serializable {

  @Id
  @Field(value = BaseFields.ID)
  private String id;

  @Version
  @Field(value = BaseFields.VERSION)
  private Long version;

  @CreatedDate
  @Field(value = BaseFields.CREATED_DATE)
  private Date createdDate;

  @LastModifiedDate
  @Field(value = BaseFields.UPDATED_DATE)
  private Date updatedDate;

  @Field(value = BaseFields.IS_DELETED)
  private Integer isDeleted = 0;
  
}
