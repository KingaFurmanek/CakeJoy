package org.cakejoy.backend.api.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DecorationsOrderDTO {
    private Integer id;
    private Integer orderId;
    private Integer decorationId;
}

