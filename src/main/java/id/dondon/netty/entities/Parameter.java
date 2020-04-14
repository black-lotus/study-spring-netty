package id.dondon.netty.entities;

import id.dondon.netty.entities.constant.CollectionName;
import id.dondon.netty.entities.constant.ParameterFields;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
@Document(collection = CollectionName.PARAMETER)
public class Parameter extends Base {

  private static final long serialVersionUID = 1L;

  @Indexed
  @Field(value = ParameterFields.KEY)
  private String key;

  @Field(value = ParameterFields.VALUE)
  private String value;

  @Field(value = ParameterFields.DESCRIPTION)
  private String description;

}
