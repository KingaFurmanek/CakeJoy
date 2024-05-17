package org.cakejoy.backend.api.external;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrdersDTO {
    private Integer id;
    private String occasion;
    private Double quantity;
    private Integer tiers;
    private String additionalInfo;
    private String colours;
    private String date;
    private String category;
    private String state;
    private Integer score;
    private Set<String> flavours = new HashSet<>();
    private Set<String> additionalOptions = new HashSet<>();
    private Set<String> glazes = new HashSet<>();
//    private Set<OrderUserDTO> orderUsers = new HashSet<>();
    private Set<String> decorations = new HashSet<>();
    private Set<String> sprinkles = new HashSet<>();

}


