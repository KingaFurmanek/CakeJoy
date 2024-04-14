package org.cakejoy.backend.api.external;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderUserDTO {
    private Integer id;
    private Integer userId;
    private Integer orderId;
}
